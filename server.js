const express = require('express');
const sqlite3 = require('sqlite3').verbose();
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const cors = require('cors');
const path = require('path');
const http = require('http');
const WebSocket = require('ws');

const app = express();
const PORT = process.env.PORT || 3001;
const JWT_SECRET = process.env.JWT_SECRET || 'your-secret-key-change-in-production';

// Middleware
app.use(cors());
app.use(express.json());
app.use(express.static(path.join(__dirname, 'public')));

// Initialize SQLite database
const db = new sqlite3.Database('./soil_analysis.db', (err) => {
    if (err) {
        console.error('Error opening database:', err.message);
    } else {
        console.log('Connected to SQLite database.');
        initializeDatabase();
    }
});

// Initialize database tables
function initializeDatabase() {
    // Users table
    db.run(`CREATE TABLE IF NOT EXISTS users (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        email TEXT UNIQUE NOT NULL,
        password TEXT NOT NULL,
        farm_name TEXT,
        location TEXT,
        created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
        updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
    )`, (err) => {
        if (err) {
            console.error('Error creating users table:', err.message);
        } else {
            console.log('Users table created or already exists.');
        }
    });

    // Soil analysis history table
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

// Authentication middleware
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
        req.user = user;
        next();
    });
}

// Routes

// Register new user
app.post('/api/auth/register', async (req, res) => {
    try {
        const { name, email, password, farmName, location } = req.body;

        // Validate input
        if (!name || !email || !password) {
            return res.status(400).json({ message: 'Name, email, and password are required' });
        }

        if (password.length < 6) {
            return res.status(400).json({ message: 'Password must be at least 6 characters long' });
        }

        // Check if user already exists
        db.get('SELECT id FROM users WHERE email = ?', [email], async (err, row) => {
            if (err) {
                return res.status(500).json({ message: 'Database error' });
            }

            if (row) {
                return res.status(400).json({ message: 'User with this email already exists' });
            }

            // Hash password
            const hashedPassword = await bcrypt.hash(password, 10);

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

// Login user
app.post('/api/auth/login', async (req, res) => {
    try {
        const { email, password } = req.body;

        // Validate input
        if (!email || !password) {
            return res.status(400).json({ message: 'Email and password are required' });
        }

        // Find user
        db.get('SELECT * FROM users WHERE email = ?', [email], async (err, user) => {
            if (err) {
                return res.status(500).json({ message: 'Database error' });
            }

            if (!user) {
                return res.status(401).json({ message: 'Invalid email or password' });
            }

            // Check password
            const isValidPassword = await bcrypt.compare(password, user.password);
            if (!isValidPassword) {
                return res.status(401).json({ message: 'Invalid email or password' });
            }

            // Create JWT token
            const token = jwt.sign(
                { id: user.id, name: user.name, email: user.email },
                JWT_SECRET,
                { expiresIn: '24h' }
            );

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
    } catch (error) {
        console.error('Login error:', error);
        res.status(500).json({ message: 'Server error' });
    }
});

// Get user profile (protected route)
app.get('/api/user/profile', authenticateToken, (req, res) => {
    const userId = req.user.id;

    db.get(
        'SELECT id, name, email, farm_name, location, created_at FROM users WHERE id = ?',
        [userId],
        (err, user) => {
            if (err) {
                return res.status(500).json({ message: 'Database error' });
            }

            if (!user) {
                return res.status(404).json({ message: 'User not found' });
            }

            res.json({
                user: {
                    id: user.id,
                    name: user.name,
                    email: user.email,
                    farmName: user.farm_name,
                    location: user.location,
                    createdAt: user.created_at
                }
            });
        }
    );
});

// Save soil analysis (protected route)
app.post('/api/soil-analysis', authenticateToken, (req, res) => {
    const userId = req.user.id;
    const { ph, nitrogen, phosphorus, potassium, moisture, location, soilHealth, recommendations, suitableCrops, estimatedYield } = req.body;

    db.run(
        `INSERT INTO soil_analyses 
        (user_id, ph, nitrogen, phosphorus, potassium, moisture, location, soil_health, recommendations, suitable_crops, estimated_yield) 
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)`,
        [userId, ph, nitrogen, phosphorus, potassium, moisture, location, soilHealth, JSON.stringify(recommendations), JSON.stringify(suitableCrops), estimatedYield],
        function(err) {
            if (err) {
                console.error('Error saving soil analysis:', err.message);
                return res.status(500).json({ message: 'Error saving analysis' });
            }

            res.status(201).json({
                message: 'Soil analysis saved successfully',
                analysisId: this.lastID
            });
        }
    );
});

// Get user's soil analysis history (protected route)
app.get('/api/soil-analysis/history', authenticateToken, (req, res) => {
    const userId = req.user.id;

    db.all(
        'SELECT * FROM soil_analyses WHERE user_id = ? ORDER BY created_at DESC',
        [userId],
        (err, analyses) => {
            if (err) {
                return res.status(500).json({ message: 'Database error' });
            }

            // Parse JSON fields
            const formattedAnalyses = analyses.map(analysis => ({
                ...analysis,
                recommendations: JSON.parse(analysis.recommendations || '[]'),
                suitableCrops: JSON.parse(analysis.suitable_crops || '[]')
            }));

            res.json({ analyses: formattedAnalyses });
        }
    );
});

// Health check endpoint
app.get('/api/health', (req, res) => {
    res.json({ status: 'Server is running', timestamp: new Date().toISOString() });
});

// Serve the web app
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'web.html'));
});

// Error handling middleware
app.use((err, req, res, next) => {
    console.error(err.stack);
    res.status(500).json({ message: 'Something went wrong!' });
});

// Start server
const server = http.createServer(app);
const wss = new WebSocket.Server({ server });

// WebSocket connection for real-time weather updates
wss.on('connection', (ws) => {
    console.log('New WebSocket connection established');
    
    // Send initial weather data
    sendWeatherUpdate(ws);
    
    // Set up interval for periodic weather updates
    const weatherInterval = setInterval(() => {
        sendWeatherUpdate(ws);
    }, 30000); // Update every 30 seconds
    
    ws.on('close', () => {
        console.log('WebSocket connection closed');
        clearInterval(weatherInterval);
    });
    
    ws.on('error', (error) => {
        console.error('WebSocket error:', error);
        clearInterval(weatherInterval);
    });
});

function sendWeatherUpdate(ws) {
    // Generate mock weather data for South Sudan
    const weatherData = {
        location: 'Juba, South Sudan',
        temperature: Math.round(25 + Math.random() * 10),
        humidity: Math.round(60 + Math.random() * 30),
        windSpeed: Math.round(5 + Math.random() * 15),
        pressure: Math.round(1000 + Math.random() * 30),
        visibility: Math.round(8 + Math.random() * 4),
        uvIndex: Math.round(5 + Math.random() * 5),
        condition: ['Sunny', 'Partly Cloudy', 'Cloudy', 'Light Rain'][Math.floor(Math.random() * 4)],
        lastUpdate: new Date().toISOString()
    };
    
    if (ws.readyState === WebSocket.OPEN) {
        ws.send(JSON.stringify({
            type: 'weather_update',
            weatherData: weatherData
        }));
    }
}

server.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
    console.log(`Open http://localhost:${PORT} to view the application`);
});

// Close database connection on server shutdown
process.on('SIGINT', () => {
    console.log('Closing database connection...');
    db.close((err) => {
        if (err) {
            console.error('Error closing database:', err.message);
        } else {
            console.log('Database connection closed.');
        }
        process.exit(0);
    });
});
