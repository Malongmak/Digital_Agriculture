const express = require('express');
const sqlite3 = require('sqlite3').verbose();
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const cors = require('cors');
const path = require('path');
const http = require('http');
const WebSocket = require('ws');
const rateLimit = require('express-rate-limit');
const helmet = require('helmet');
const validator = require('validator');

const app = express();
const PORT = process.env.PORT || 3002;
const JWT_SECRET = process.env.JWT_SECRET || 'your-secret-key-change-in-production-use-strong-random-string';

// Security middleware
app.use(helmet({
    contentSecurityPolicy: {
        directives: {
            defaultSrc: ["'self'"],
            styleSrc: ["'self'", "'unsafe-inline'", "https://fonts.googleapis.com"],
            fontSrc: ["'self'", "https://fonts.gstatic.com"],
            scriptSrc: ["'self'", "https://unpkg.com"],
            imgSrc: ["'self'", "data:", "https:"],
        },
    },
}));

// Rate limiting for login attempts
const loginLimiter = rateLimit({
    windowMs: 15 * 60 * 1000, // 15 minutes
    max: 5, // limit each IP to 5 login attempts per windowMs
    message: 'Too many login attempts, please try again after 15 minutes',
    standardHeaders: true,
    legacyHeaders: false,
});

// General rate limiting
const generalLimiter = rateLimit({
    windowMs: 15 * 60 * 1000, // 15 minutes
    max: 100, // limit each IP to 100 requests per windowMs
    standardHeaders: true,
    legacyHeaders: false,
});

app.use(generalLimiter);
app.use(cors({
    origin: ['http://localhost:3000', 'http://127.0.0.1:3000', 'http://localhost:3001', 'http://127.0.0.1:3001', 'file://', 'null'],
    credentials: true,
    methods: ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'],
    allowedHeaders: ['Content-Type', 'Authorization']
}));
app.use(express.json({ limit: '10mb' }));
app.use(express.static(path.join(__dirname, 'public')));

// Initialize SQLite database with better security
const db = new sqlite3.Database('./secure_soil_analysis.db', (err) => {
    if (err) {
        console.error('Error opening database:', err.message);
    } else {
        console.log('Connected to secure SQLite database.');
        initializeDatabase();
    }
});

// Enhanced database schema with security features
function initializeDatabase() {
    // Enhanced users table with security fields
    db.run(`CREATE TABLE IF NOT EXISTS users (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        email TEXT UNIQUE NOT NULL,
        password TEXT NOT NULL,
        farm_name TEXT,
        location TEXT,
        is_active BOOLEAN DEFAULT 1,
        email_verified BOOLEAN DEFAULT 0,
        last_login DATETIME,
        login_attempts INTEGER DEFAULT 0,
        locked_until DATETIME,
        password_reset_token TEXT,
        password_reset_expires DATETIME,
        created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
        updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
    )`, (err) => {
        if (err) {
            console.error('Error creating users table:', err.message);
        } else {
            console.log('Enhanced users table created or already exists.');
        }
    });

    // Login attempts tracking table
    db.run(`CREATE TABLE IF NOT EXISTS login_attempts (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        email TEXT NOT NULL,
        ip_address TEXT NOT NULL,
        user_agent TEXT,
        success BOOLEAN NOT NULL,
        attempt_time DATETIME DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (email) REFERENCES users (email)
    )`, (err) => {
        if (err) {
            console.error('Error creating login_attempts table:', err.message);
        } else {
            console.log('Login attempts table created or already exists.');
        }
    });

    // User sessions table for enhanced security
    db.run(`CREATE TABLE IF NOT EXISTS user_sessions (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        user_id INTEGER NOT NULL,
        token_hash TEXT NOT NULL,
        ip_address TEXT NOT NULL,
        user_agent TEXT,
        created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
        expires_at DATETIME NOT NULL,
        is_active BOOLEAN DEFAULT 1,
        FOREIGN KEY (user_id) REFERENCES users (id)
    )`, (err) => {
        if (err) {
            console.error('Error creating user_sessions table:', err.message);
        } else {
            console.log('User sessions table created or already exists.');
        }
    });

    // Soil analysis history table (existing)
    db.run(`CREATE TABLE IF NOT EXISTS soil_analyses (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        user_id INTEGER NOT NULL,
        ph REAL,
        nitrogen REAL,
        phosphorus REAL,
        potassium REAL,
        moisture REAL,
        location TEXT,
        soil_health TEXT,
        recommendations TEXT,
        suitable_crops TEXT,
        estimated_yield TEXT,
        created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (user_id) REFERENCES users (id)
    )`, (err) => {
        if (err) {
            console.error('Error creating soil_analyses table:', err.message);
        } else {
            console.log('Soil analyses table created or already exists.');
        }
    });
}

// Enhanced authentication middleware
function authenticateToken(req, res, next) {
    const authHeader = req.headers['authorization'];
    const token = authHeader && authHeader.split(' ')[1];

    if (!token) {
        return res.status(401).json({ message: 'Authentication token required' });
    }

    jwt.verify(token, JWT_SECRET, (err, user) => {
        if (err) {
            return res.status(403).json({ message: 'Invalid or expired token' });
        }

        // Check if token is in active sessions
        db.get(
            'SELECT * FROM user_sessions WHERE user_id = ? AND token_hash = ? AND is_active = 1 AND expires_at > datetime("now")',
            [user.id, require('crypto').createHash('sha256').update(token).digest('hex')],
            (err, session) => {
                if (err || !session) {
                    return res.status(403).json({ message: 'Token is no longer valid' });
                }
                req.user = user;
                req.session = session;
                next();
            }
        );
    });
}

// Enhanced input validation
function validateInput(data, rules) {
    const errors = [];
    
    for (const [field, rule] of Object.entries(rules)) {
        const value = data[field];
        
        if (rule.required && (!value || value.trim() === '')) {
            errors.push(`${field} is required`);
            continue;
        }
        
        if (value && rule.type === 'email' && !validator.isEmail(value)) {
            errors.push(`${field} must be a valid email`);
        }
        
        if (value && rule.minLength && value.length < rule.minLength) {
            errors.push(`${field} must be at least ${rule.minLength} characters`);
        }
        
        if (value && rule.maxLength && value.length > rule.maxLength) {
            errors.push(`${field} must not exceed ${rule.maxLength} characters`);
        }
        
        if (value && rule.pattern && !rule.pattern.test(value)) {
            errors.push(`${field} format is invalid`);
        }
    }
    
    return errors;
}

// Log login attempts
function logLoginAttempt(email, ip, userAgent, success) {
    db.run(
        'INSERT INTO login_attempts (email, ip_address, user_agent, success) VALUES (?, ?, ?, ?)',
        [email, ip, userAgent, success],
        (err) => {
            if (err) console.error('Error logging login attempt:', err.message);
        }
    );
}

// Check if account is locked
function isAccountLocked(email, callback) {
    db.get(
        'SELECT locked_until FROM users WHERE email = ?',
        [email],
        (err, row) => {
            if (err || !row) {
                callback(false);
                return;
            }
            
            if (row.locked_until && new Date(row.locked_until) > new Date()) {
                callback(true, row.locked_until);
            } else {
                callback(false);
            }
        }
    );
}

// Lock account after failed attempts
function lockAccount(email, callback) {
    const lockUntil = new Date(Date.now() + 30 * 60 * 1000); // Lock for 30 minutes
    db.run(
        'UPDATE users SET login_attempts = login_attempts + 1, locked_until = ? WHERE email = ?',
        [lockUntil.toISOString(), email],
        callback
    );
}

// Reset login attempts on successful login
function resetLoginAttempts(email, callback) {
    db.run(
        'UPDATE users SET login_attempts = 0, locked_until = NULL, last_login = datetime("now") WHERE email = ?',
        [email],
        callback
    );
}

// Store session in database
function storeSession(userId, token, ip, userAgent, callback) {
    const tokenHash = require('crypto').createHash('sha256').update(token).digest('hex');
    const expiresAt = new Date(Date.now() + 24 * 60 * 60 * 1000); // 24 hours
    
    db.run(
        'INSERT INTO user_sessions (user_id, token_hash, ip_address, user_agent, expires_at) VALUES (?, ?, ?, ?, ?)',
        [userId, tokenHash, ip, userAgent, expiresAt.toISOString()],
        callback
    );
}

// Routes

// Check if email exists endpoint
app.post('/api/auth/check-email', async (req, res) => {
    try {
        const { email } = req.body;
        
        if (!email) {
            return res.status(400).json({ message: 'Email is required' });
        }
        
        // Check if user exists
        db.get('SELECT id, email FROM users WHERE email = ?', [email], (err, row) => {
            if (err) {
                console.error('Error checking email:', err);
                return res.status(500).json({ message: 'Server error' });
            }
            
            res.json({ exists: !!row });
        });
    } catch (error) {
        console.error('Error in check-email:', error);
        res.status(500).json({ message: 'Server error' });
    }
});

// Register new user with enhanced security
app.post('/api/auth/register', async (req, res) => {
    try {
        const { name, email, password, farmName, location } = req.body;
        const clientIP = req.ip || req.connection.remoteAddress;
        const userAgent = req.get('User-Agent');

        // Enhanced input validation
        const validationErrors = validateInput(req.body, {
            name: { required: true, minLength: 2, maxLength: 100 },
            email: { required: true, type: 'email', maxLength: 255 },
            password: { required: true, minLength: 8, maxLength: 128 },
            farmName: { maxLength: 100 },
            location: { maxLength: 255 }
        });

        if (validationErrors.length > 0) {
            return res.status(400).json({ 
                message: 'Validation failed', 
                errors: validationErrors 
            });
        }

        // Password strength validation
        const passwordErrors = [];
        if (!/(?=.*[a-z])/.test(password)) passwordErrors.push('Password must contain at least one lowercase letter');
        if (!/(?=.*[A-Z])/.test(password)) passwordErrors.push('Password must contain at least one uppercase letter');
        if (!/(?=.*\d)/.test(password)) passwordErrors.push('Password must contain at least one number');
        if (!/(?=.*[@$!%*?&])/.test(password)) passwordErrors.push('Password must contain at least one special character');

        if (passwordErrors.length > 0) {
            return res.status(400).json({ 
                message: 'Password does not meet security requirements', 
                errors: passwordErrors 
            });
        }

        // Check if user already exists
        db.get('SELECT id FROM users WHERE email = ?', [email], async (err, row) => {
            if (err) {
                return res.status(500).json({ message: 'Database error' });
            }

            if (row) {
                logLoginAttempt(email, clientIP, userAgent, false);
                return res.status(400).json({ message: 'User with this email already exists' });
            }

            // Hash password with higher salt rounds
            const hashedPassword = await bcrypt.hash(password, 12);

            // Insert new user
            db.run(
                'INSERT INTO users (name, email, password, farm_name, location) VALUES (?, ?, ?, ?, ?)',
                [name, email, hashedPassword, farmName || null, location || null],
                function(err) {
                    if (err) {
                        console.error('Error inserting user:', err.message);
                        return res.status(500).json({ message: 'Error creating user' });
                    }

                    // Create JWT token
                    const token = jwt.sign(
                        { id: this.lastID, name, email },
                        JWT_SECRET,
                        { expiresIn: '24h' }
                    );

                    // Store session
                    storeSession(this.lastID, token, clientIP, userAgent, (err) => {
                        if (err) console.error('Error storing session:', err.message);
                    });

                    logLoginAttempt(email, clientIP, userAgent, true);

                    res.status(201).json({
                        message: 'User created successfully',
                        token,
                        user: { id: this.lastID, name, email, farmName, location }
                    });
                }
            );
        });
    } catch (error) {
        console.error('Registration error:', error);
        res.status(500).json({ message: 'Server error' });
    }
});

// Check if email exists endpoint
app.post('/api/auth/check-email', async (req, res) => {
    try {
        const { email } = req.body;
        
        if (!email) {
            return res.status(400).json({ message: 'Email is required' });
        }
        
        // Check if user exists
        db.get('SELECT id, email FROM users WHERE email = ?', [email], (err, row) => {
            if (err) {
                console.error('Error checking email:', err);
                return res.status(500).json({ message: 'Server error' });
            }
            
            res.json({ exists: !!row });
        });
    } catch (error) {
        console.error('Error in check-email:', error);
        res.status(500).json({ message: 'Server error' });
    }
});

// Enhanced login with security features
app.post('/api/auth/login', loginLimiter, async (req, res) => {
    try {
        const { email, password } = req.body;
        const clientIP = req.ip || req.connection.remoteAddress;
        const userAgent = req.get('User-Agent');

        // Input validation
        const validationErrors = validateInput(req.body, {
            email: { required: true, type: 'email' },
            password: { required: true }
        });

        if (validationErrors.length > 0) {
            return res.status(400).json({ 
                message: 'Validation failed', 
                errors: validationErrors 
            });
        }

        // Check if account is locked
        isAccountLocked(email, (locked, lockUntil) => {
            if (locked) {
                logLoginAttempt(email, clientIP, userAgent, false);
                return res.status(423).json({ 
                    message: 'Account is temporarily locked',
                    lockedUntil: lockUntil
                });
            }

            // Get user from database
            db.get('SELECT * FROM users WHERE email = ? AND is_active = 1', [email], async (err, user) => {
                if (err) {
                    return res.status(500).json({ message: 'Database error' });
                }

                if (!user) {
                    logLoginAttempt(email, clientIP, userAgent, false);
                    return res.status(401).json({ message: 'Invalid email or password' });
                }

                // Check password
                const isValidPassword = await bcrypt.compare(password, user.password);
                
                if (!isValidPassword) {
                    logLoginAttempt(email, clientIP, userAgent, false);
                    
                    // Increment login attempts and potentially lock account
                    db.get('SELECT login_attempts FROM users WHERE email = ?', [email], (err, row) => {
                        if (!err && row) {
                            const attempts = row.login_attempts + 1;
                            if (attempts >= 5) {
                                lockAccount(email, () => {
                                    console.log(`Account locked: ${email}`);
                                });
                            } else {
                                db.run('UPDATE users SET login_attempts = ? WHERE email = ?', [attempts, email]);
                            }
                        }
                    });
                    
                    return res.status(401).json({ message: 'Invalid email or password' });
                }

                // Successful login
                logLoginAttempt(email, clientIP, userAgent, true);
                resetLoginAttempts(email, () => {
                    console.log(`Login successful: ${email}`);
                });

                // Create JWT token
                const token = jwt.sign(
                    { id: user.id, name: user.name, email: user.email },
                    JWT_SECRET,
                    { expiresIn: '24h' }
                );

                // Store session
                storeSession(user.id, token, clientIP, userAgent, (err) => {
                    if (err) console.error('Error storing session:', err.message);
                });

                res.json({
                    message: 'Login successful',
                    token,
                    user: { 
                        id: user.id, 
                        name: user.name, 
                        email: user.email, 
                        farmName: user.farm_name, 
                        location: user.location 
                    }
                });
            });
        });
    } catch (error) {
        console.error('Login error:', error);
        res.status(500).json({ message: 'Server error' });
    }
});

// Logout endpoint
app.post('/api/auth/logout', authenticateToken, (req, res) => {
    const token = req.headers.authorization.split(' ')[1];
    const tokenHash = require('crypto').createHash('sha256').update(token).digest('hex');
    
    db.run(
        'UPDATE user_sessions SET is_active = 0 WHERE user_id = ? AND token_hash = ?',
        [req.user.id, tokenHash],
        (err) => {
            if (err) {
                console.error('Error logging out:', err.message);
                return res.status(500).json({ message: 'Error during logout' });
            }
            
            res.json({ message: 'Logout successful' });
        }
    );
});

// Get user profile
app.get('/api/user/profile', authenticateToken, (req, res) => {
    db.get(
        'SELECT id, name, email, farm_name, location, created_at, last_login FROM users WHERE id = ?',
        [req.user.id],
        (err, user) => {
            if (err) {
                return res.status(500).json({ message: 'Database error' });
            }
            
            if (!user) {
                return res.status(404).json({ message: 'User not found' });
            }
            
            res.json({ user });
        }
    );
});

// Change password
app.post('/api/user/change-password', authenticateToken, async (req, res) => {
    try {
        const { currentPassword, newPassword } = req.body;
        
        // Validation
        const validationErrors = validateInput(req.body, {
            currentPassword: { required: true },
            newPassword: { required: true, minLength: 8, maxLength: 128 }
        });

        if (validationErrors.length > 0) {
            return res.status(400).json({ 
                message: 'Validation failed', 
                errors: validationErrors 
            });
        }

        // Get current user
        db.get('SELECT password FROM users WHERE id = ?', [req.user.id], async (err, user) => {
            if (err || !user) {
                return res.status(500).json({ message: 'Database error' });
            }

            // Verify current password
            const isValidPassword = await bcrypt.compare(currentPassword, user.password);
            if (!isValidPassword) {
                return res.status(401).json({ message: 'Current password is incorrect' });
            }

            // Hash new password
            const hashedNewPassword = await bcrypt.hash(newPassword, 12);

            // Update password
            db.run(
                'UPDATE users SET password = ?, updated_at = datetime("now") WHERE id = ?',
                [hashedNewPassword, req.user.id],
                (err) => {
                    if (err) {
                        return res.status(500).json({ message: 'Error updating password' });
                    }

                    // Invalidate all sessions except current
                    const currentToken = req.headers.authorization.split(' ')[1];
                    const currentTokenHash = require('crypto').createHash('sha256').update(currentToken).digest('hex');
                    
                    db.run(
                        'UPDATE user_sessions SET is_active = 0 WHERE user_id = ? AND token_hash != ?',
                        [req.user.id, currentTokenHash],
                        (err) => {
                            if (err) console.error('Error invalidating sessions:', err.message);
                        }
                    );

                    res.json({ message: 'Password changed successfully' });
                }
            );
        });
    } catch (error) {
        console.error('Password change error:', error);
        res.status(500).json({ message: 'Server error' });
    }
});

// Protected route example
app.get('/api/protected', authenticateToken, (req, res) => {
    res.json({ 
        message: 'This is a protected route', 
        user: req.user,
        sessionInfo: {
            ipAddress: req.session.ip_address,
            userAgent: req.session.user_agent,
            expiresAt: req.session.expires_at
        }
    });
});

// Start server
const server = http.createServer(app);
server.listen(PORT, () => {
    console.log(`Secure server running on port ${PORT}`);
    console.log(`Open http://localhost:${PORT} to view the application`);
});

// WebSocket for real-time features (optional enhancement)
const wss = new WebSocket.Server({ server });

wss.on('connection', (ws, req) => {
    console.log('WebSocket connection established');
    
    ws.on('message', (message) => {
        console.log('Received:', message);
    });
    
    ws.on('close', () => {
        console.log('WebSocket connection closed');
    });
});

module.exports = app;
