# API Integration Guide for MakerTest Authentication

## 🔌 Backend Integration Overview

This guide shows you how to connect the MakerTest frontend to your backend API for real authentication.

---

## 📋 API Endpoints Required

### 1. **Email Authentication**

#### Register (Signup)
```
POST /api/auth/register
Content-Type: application/json

Request Body:
{
  "name": "John Doe",
  "email": "john@example.com",
  "phone": "1234567890",
  "password": "Password123"
}

Response (Success - 201):
{
  "success": true,
  "message": "Account created successfully",
  "user": {
    "id": "user_123",
    "name": "John Doe",
    "email": "john@example.com",
    "phone": "1234567890"
  },
  "token": "jwt_token_here"
}

Response (Error - 400):
{
  "success": false,
  "message": "Email already exists"
}
```

#### Login
```
POST /api/auth/login
Content-Type: application/json

Request Body:
{
  "email": "john@example.com",
  "password": "Password123"
}

Response (Success - 200):
{
  "success": true,
  "message": "Login successful",
  "user": {
    "id": "user_123",
    "name": "John Doe",
    "email": "john@example.com"
  },
  "token": "jwt_token_here"
}

Response (Error - 401):
{
  "success": false,
  "message": "Invalid credentials"
}
```

### 2. **Phone OTP Authentication**

#### Send OTP
```
POST /api/auth/send-otp
Content-Type: application/json

Request Body:
{
  "phone": "1234567890"
}

Response (Success - 200):
{
  "success": true,
  "message": "OTP sent to your phone",
  "expiresIn": 300  // 5 minutes
}

Response (Error - 400):
{
  "success": false,
  "message": "Invalid phone number"
}
```

#### Verify OTP
```
POST /api/auth/verify-otp
Content-Type: application/json

Request Body:
{
  "phone": "1234567890",
  "otp": "123456"
}

Response (Success - 200):
{
  "success": true,
  "message": "OTP verified",
  "user": {
    "id": "user_456",
    "phone": "1234567890"
  },
  "token": "jwt_token_here"
}

Response (Error - 400):
{
  "success": false,
  "message": "Invalid or expired OTP"
}
```

### 3. **OAuth Integration** (Third-party)

#### Google OAuth Verification
```
POST /api/auth/google
Content-Type: application/json

Request Body:
{
  "idToken": "google_id_token_from_frontend"
}

Response (Success - 200):
{
  "success": true,
  "user": {
    "id": "google_user_123",
    "email": "user@gmail.com",
    "name": "Google User"
  },
  "token": "jwt_token_here"
}
```

#### Apple OAuth Verification
```
POST /api/auth/apple
Content-Type: application/json

Request Body:
{
  "identityToken": "apple_token_from_frontend",
  "user": {
    "name": { "firstName": "John", "lastName": "Doe" },
    "email": "user@icloud.com"
  }
}

Response (Success - 200):
{
  "success": true,
  "user": {
    "id": "apple_user_456",
    "email": "user@icloud.com",
    "name": "John Doe"
  },
  "token": "jwt_token_here"
}
```

### 4. **User Info**

#### Get Current User
```
GET /api/auth/me
Authorization: Bearer jwt_token_here

Response (Success - 200):
{
  "success": true,
  "user": {
    "id": "user_123",
    "name": "John Doe",
    "email": "john@example.com",
    "phone": "1234567890",
    "createdAt": "2024-01-15T10:30:00Z"
  }
}

Response (Error - 401):
{
  "success": false,
  "message": "Unauthorized"
}
```

### 5. **Logout**

```
POST /api/auth/logout
Authorization: Bearer jwt_token_here

Response (Success - 200):
{
  "success": true,
  "message": "Logged out successfully"
}
```

---

## 🔧 Frontend Implementation

### Step 1: Update AuthContext.jsx

Replace the simulated login methods with real API calls:

```javascript
// Before (simulated):
const loginWithEmail = async (email, password) => {
  setIsLoading(true);
  setTimeout(() => {
    setUser({ email, name: email.split('@')[0] });
    setIsAuthenticated(true);
  }, 1500);
};

// After (real API):
const loginWithEmail = async (email, password) => {
  try {
    setIsLoading(true);
    
    const response = await axios.post('/api/auth/login', {
      email,
      password
    });
    
    if (response.data.success) {
      setUser(response.data.user);
      setAuthToken(response.data.token);
      setAuthMethod('email');
      setIsAuthenticated(true);
      
      localStorage.setItem('user', JSON.stringify(response.data.user));
      localStorage.setItem('authToken', response.data.token);
      localStorage.setItem('authMethod', 'email');
      
      return { success: true, user: response.data.user };
    }
  } catch (error) {
    return { 
      success: false, 
      error: error.response?.data?.message || error.message 
    };
  } finally {
    setIsLoading(false);
  }
};
```

### Step 2: Update Phone OTP Flow

```javascript
// In LoginPage.jsx
const handlePhoneSubmit = async (e) => {
  e.preventDefault();
  
  try {
    setLoading(true);
    toast.loading('Sending OTP...');
    
    const response = await axios.post('/api/auth/send-otp', {
      phone: phoneNumber
    });
    
    if (response.data.success) {
      toast.dismiss();
      toast.success('OTP sent to your phone!');
      setStep('otp');
    }
  } catch (error) {
    toast.dismiss();
    toast.error(error.response?.data?.message || 'Failed to send OTP');
  } finally {
    setLoading(false);
  }
};

// OTP verification
const handleOTPSubmit = async (otp) => {
  try {
    setLoading(true);
    toast.loading('Verifying OTP...');
    
    const response = await axios.post('/api/auth/verify-otp', {
      phone: phoneNumber,
      otp: otp  // 6-digit code
    });
    
    if (response.data.success) {
      loginWithPhone(phoneNumber, otp);
      toast.dismiss();
      toast.success('Verified successfully!');
      navigate('/dashboard');
    }
  } catch (error) {
    toast.dismiss();
    toast.error(error.response?.data?.message || 'OTP verification failed');
  } finally {
    setLoading(false);
  }
};
```

### Step 3: Set Up Axios Interceptor

Create `src/utils/axiosConfig.js`:

```javascript
import axios from 'axios';

// Create axios instance
const apiClient = axios.create({
  baseURL: process.env.REACT_APP_API_URL || 'http://localhost:5000',
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Request interceptor - add auth token
apiClient.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('authToken');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

// Response interceptor - handle token refresh
apiClient.interceptors.response.use(
  (response) => response,
  async (error) => {
    const originalRequest = error.config;
    
    // If token expired and we have a refresh token
    if (error.response?.status === 401 && !originalRequest._retry) {
      originalRequest._retry = true;
      
      try {
        // Call refresh token endpoint
        const response = await axios.post(
          `${process.env.REACT_APP_API_URL}/api/auth/refresh-token`,
          { refreshToken: localStorage.getItem('refreshToken') }
        );
        
        localStorage.setItem('authToken', response.data.token);
        originalRequest.headers.Authorization = `Bearer ${response.data.token}`;
        return apiClient(originalRequest);
      } catch (refreshError) {
        // Refresh failed, redirect to login
        localStorage.removeItem('authToken');
        localStorage.removeItem('user');
        window.location.href = '/login';
        return Promise.reject(refreshError);
      }
    }
    
    return Promise.reject(error);
  }
);

export default apiClient;
```

### Step 4: Use Axios in Auth Context

```javascript
import apiClient from '../utils/axiosConfig';

// In AuthContext.jsx
const loginWithEmail = async (email, password) => {
  try {
    setIsLoading(true);
    const response = await apiClient.post('/api/auth/login', {
      email,
      password
    });
    
    // ... handle response ...
  } catch (error) {
    return { success: false, error: error.message };
  }
};
```

---

## 🔐 Security Best Practices

### 1. **JWT Token Handling**
```javascript
// ✅ GOOD: Store token safely
localStorage.setItem('authToken', response.data.token);

// ❌ AVOID: Don't log tokens
console.log(token);  // Never do this!

// ✅ GOOD: Use in Authorization header
headers: { Authorization: `Bearer ${token}` }
```

### 2. **HTTPS Only**
```javascript
// In production, ensure:
- API calls use HTTPS
- Cookies marked as secure
- Environment variables for API URL
```

### 3. **CORS Configuration**
Backend should allow:
```javascript
{
  origin: ['http://localhost:3000', 'https://yourdomain.com'],
  credentials: true,
  methods: ['GET', 'POST', 'PUT', 'DELETE'],
  allowedHeaders: ['Content-Type', 'Authorization']
}
```

### 4. **Rate Limiting**
```javascript
// Backend should implement:
- OTP attempts: Max 5 per hour
- Login attempts: Max 10 per hour
- Registration: Max 3 per IP per day
```

### 5. **Input Validation**
```javascript
// Frontend validation (already done):
✅ Email format
✅ Password strength
✅ Phone length
✅ OTP format

// Backend validation (implement):
✅ Re-validate all inputs
✅ Sanitize inputs
✅ Check for SQL injection
✅ Verify data types
```

---

## 🚀 Environment Variables

Create `.env` file in project root:

```env
REACT_APP_API_URL=http://localhost:5000
REACT_APP_GOOGLE_CLIENT_ID=your_google_client_id_here
REACT_APP_APPLE_CLIENT_ID=your_apple_client_id_here
REACT_APP_ENV=development
```

Use in code:
```javascript
const apiUrl = process.env.REACT_APP_API_URL;
const googleClientId = process.env.REACT_APP_GOOGLE_CLIENT_ID;
```

---

## 🧪 Testing the Integration

### 1. Test Email Login
```bash
curl -X POST http://localhost:5000/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com","password":"Password123"}'
```

### 2. Test Phone OTP
```bash
# Send OTP
curl -X POST http://localhost:5000/api/auth/send-otp \
  -H "Content-Type: application/json" \
  -d '{"phone":"1234567890"}'

# Verify OTP
curl -X POST http://localhost:5000/api/auth/verify-otp \
  -H "Content-Type: application/json" \
  -d '{"phone":"1234567890","otp":"123456"}'
```

### 3. Test Protected Route
```bash
curl -X GET http://localhost:5000/api/auth/me \
  -H "Authorization: Bearer your_jwt_token_here"
```

---

## 🔄 OAuth Integration Steps

### Google OAuth
1. Go to Google Cloud Console
2. Create OAuth 2.0 credentials
3. Add `http://localhost:3000` to authorized origins
4. Copy Client ID
5. Set `REACT_APP_GOOGLE_CLIENT_ID` in `.env`
6. Install: `npm install @react-oauth/google`
7. Wrap app with GoogleOAuthProvider
8. Send token to backend for verification

### Apple Sign-In
1. Go to Apple Developer
2. Create Apple Sign In configuration
3. Get Service ID and Team ID
4. Configure redirect URIs
5. Set environment variables
6. Implement Apple Sign-In flow
7. Send response to backend

---

## 📊 Error Handling

```javascript
// Good error handling pattern
try {
  const response = await apiClient.post('/api/auth/login', credentials);
  // Success path
} catch (error) {
  if (error.response?.status === 400) {
    // Validation error
    toast.error('Email or password is incorrect');
  } else if (error.response?.status === 401) {
    // Unauthorized
    toast.error('Not authenticated');
  } else if (error.response?.status === 500) {
    // Server error
    toast.error('Server error. Please try again later');
  } else {
    // Network error
    toast.error('Network error. Check your connection');
  }
}
```

---

## 🔗 Database Schema Example

```sql
-- Users table
CREATE TABLE users (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  phone VARCHAR(20),
  password_hash VARCHAR(255),
  provider VARCHAR(50), -- 'email', 'google', 'apple', 'phone'
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  INDEX idx_email (email),
  INDEX idx_phone (phone)
);

-- OTP table
CREATE TABLE otps (
  id VARCHAR(36) PRIMARY KEY,
  phone VARCHAR(20) NOT NULL,
  code VARCHAR(6) NOT NULL,
  attempts INT DEFAULT 0,
  expires_at TIMESTAMP NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  INDEX idx_phone (phone),
  INDEX idx_expires (expires_at)
);

-- Sessions/Tokens table (optional)
CREATE TABLE sessions (
  id VARCHAR(36) PRIMARY KEY,
  user_id VARCHAR(36) NOT NULL,
  token VARCHAR(500) NOT NULL UNIQUE,
  refresh_token VARCHAR(500),
  expires_at TIMESTAMP NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
  INDEX idx_user_id (user_id)
);
```

---

## 🎯 Implementation Checklist

- [ ] Backend API endpoints created
- [ ] Database schema set up
- [ ] JWT token generation implemented
- [ ] OTP service integrated (Twilio/AWS)
- [ ] Google OAuth configured
- [ ] Apple OAuth configured
- [ ] CORS enabled
- [ ] Rate limiting implemented
- [ ] Input validation on backend
- [ ] Error handling set up
- [ ] Environment variables configured
- [ ] Axios interceptors added
- [ ] Token refresh logic implemented
- [ ] Tests written and passing
- [ ] Security audit completed

---

## 📚 Additional Resources

- [JWT.io](https://jwt.io) - JWT information
- [OWASP Auth Cheatsheet](https://cheatsheetseries.owasp.org/cheatsheets/Authentication_Cheat_Sheet.html)
- [Axios Documentation](https://axios-http.com/)
- [React Security Best Practices](https://snyk.io/blog/10-react-security-best-practices/)

---

**Your frontend is ready! Now build the backend and integrate it. Good luck! 🚀**
