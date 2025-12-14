import React, { createContext, useContext, useState, useEffect } from 'react';
import toast from 'react-hot-toast';

const AuthContext = createContext();

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error('useAuth must be used within an AuthProvider');
  }
  return context;
};

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem('token');
    const userData = localStorage.getItem('user');
    
    if (token && userData) {
      setUser(JSON.parse(userData));
      setIsAuthenticated(true);
    }
    setLoading(false);
  }, []);

  const login = async (credentials) => {
    setLoading(true);
    try {
      // Simulate API call
      await new Promise(resolve => setTimeout(resolve, 1000));
      
      const userData = {
        id: '1',
        name: credentials.name || 'Test User',
        email: credentials.email || 'test@example.com',
        phone: credentials.phone || '+2111234567890',
        avatar: null
      };
      
      const token = 'mock-jwt-token-' + Date.now();
      
      localStorage.setItem('token', token);
      localStorage.setItem('user', JSON.stringify(userData));
      
      setUser(userData);
      setIsAuthenticated(true);
      toast.success('Login successful!');
      
      return { success: true, user: userData };
    } catch (error) {
      toast.error('Login failed. Please try again.');
      return { success: false, error: error.message };
    } finally {
      setLoading(false);
    }
  };

  const signup = async (userData) => {
    setLoading(true);
    try {
      // Simulate API call
      await new Promise(resolve => setTimeout(resolve, 1000));
      
      const newUser = {
        id: Date.now().toString(),
        name: userData.name,
        email: userData.email,
        phone: userData.phone,
        avatar: null
      };
      
      const token = 'mock-jwt-token-' + Date.now();
      
      localStorage.setItem('token', token);
      localStorage.setItem('user', JSON.stringify(newUser));
      
      setUser(newUser);
      setIsAuthenticated(true);
      toast.success('Account created successfully!');
      
      return { success: true, user: newUser };
    } catch (error) {
      toast.error('Signup failed. Please try again.');
      return { success: false, error: error.message };
    } finally {
      setLoading(false);
    }
  };

  const logout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    setUser(null);
    setIsAuthenticated(false);
    toast.success('Logged out successfully');
  };

  const verifyOTP = async (phone, otp) => {
    setLoading(true);
    try {
      // Simulate API call
      await new Promise(resolve => setTimeout(resolve, 1000));
      
      const userData = {
        id: '1',
        name: 'Phone User',
        email: '',
        phone: phone,
        avatar: null
      };
      
      const token = 'mock-jwt-token-' + Date.now();
      
      localStorage.setItem('token', token);
      localStorage.setItem('user', JSON.stringify(userData));
      
      setUser(userData);
      setIsAuthenticated(true);
      toast.success('OTP verified successfully!');
      
      return { success: true, user: userData };
    } catch (error) {
      toast.error('OTP verification failed. Please try again.');
      return { success: false, error: error.message };
    } finally {
      setLoading(false);
    }
  };

  const sendOTP = async (phone) => {
    try {
      // Simulate API call
      await new Promise(resolve => setTimeout(resolve, 500));
      toast.success('OTP sent successfully!');
      return { success: true };
    } catch (error) {
      toast.error('Failed to send OTP. Please try again.');
      return { success: false, error: error.message };
    }
  };

  const googleLogin = async () => {
    setLoading(true);
    try {
      // Simulate Google OAuth
      await new Promise(resolve => setTimeout(resolve, 1000));
      
      const userData = {
        id: 'google-' + Date.now(),
        name: 'Google User',
        email: 'user@gmail.com',
        phone: '',
        avatar: null,
        provider: 'google'
      };
      
      const token = 'mock-google-token-' + Date.now();
      
      localStorage.setItem('token', token);
      localStorage.setItem('user', JSON.stringify(userData));
      
      setUser(userData);
      setIsAuthenticated(true);
      toast.success('Google login successful!');
      
      return { success: true, user: userData };
    } catch (error) {
      toast.error('Google login failed. Please try again.');
      return { success: false, error: error.message };
    } finally {
      setLoading(false);
    }
  };

  const appleLogin = async () => {
    setLoading(true);
    try {
      // Simulate Apple OAuth
      await new Promise(resolve => setTimeout(resolve, 1000));
      
      const userData = {
        id: 'apple-' + Date.now(),
        name: 'Apple User',
        email: 'user@icloud.com',
        phone: '',
        avatar: null,
        provider: 'apple'
      };
      
      const token = 'mock-apple-token-' + Date.now();
      
      localStorage.setItem('token', token);
      localStorage.setItem('user', JSON.stringify(userData));
      
      setUser(userData);
      setIsAuthenticated(true);
      toast.success('Apple login successful!');
      
      return { success: true, user: userData };
    } catch (error) {
      toast.error('Apple login failed. Please try again.');
      return { success: false, error: error.message };
    } finally {
      setLoading(false);
    }
  };

  const value = {
    user,
    loading,
    isAuthenticated,
    login,
    signup,
    logout,
    verifyOTP,
    sendOTP,
    googleLogin,
    appleLogin
  };

  return (
    <AuthContext.Provider value={value}>
      {children}
    </AuthContext.Provider>
  );
};
