// App Constants
export const APP_CONFIG = {
  NAME: 'MakerTest',
  VERSION: '1.0.0',
  SUPPORTED_PLATFORMS: ['ios', 'android', 'web'],
};

// Colors
export const COLORS = {
  primary: '#2E7D32',
  primaryDark: '#1a472a',
  primaryLight: '#43a047',
  secondary: '#FF6B35',
  background: '#f8fafc',
  surface: '#ffffff',
  text: '#1a202c',
  textSecondary: '#4a5568',
  border: '#e2e8f0',
  error: '#e53e3e',
  warning: '#dd6b20',
  success: '#38a169',
  info: '#3182ce',
};

// Typography
export const FONTS = {
  regular: 'Inter-Regular',
  medium: 'Inter-Medium',
  semibold: 'Inter-SemiBold',
  bold: 'Inter-Bold',
};

// Sizes
export const SIZES = {
  xs: 4,
  sm: 8,
  md: 16,
  lg: 24,
  xl: 32,
  xxl: 48,
};

// API Endpoints
export const API_ENDPOINTS = {
  BASE_URL: __DEV__ 
    ? 'http://localhost:3000/api' 
    : 'https://api.makertest.com',
  AUTH: {
    LOGIN: '/auth/login',
    REGISTER: '/auth/register',
    LOGOUT: '/auth/logout',
    REFRESH: '/auth/refresh',
    GOOGLE: '/auth/google',
    APPLE: '/auth/apple',
  },
  SOIL: {
    ANALYZE: '/soil/analyze',
    HISTORY: '/soil/history',
    RESULTS: '/soil/results',
  },
  WEATHER: {
    CURRENT: '/weather/current',
    FORECAST: '/weather/forecast',
  },
  MARKET: {
    PRICES: '/market/prices',
    TRENDS: '/market/trends',
  },
};

// Storage Keys
export const STORAGE_KEYS = {
  AUTH_TOKEN: '@auth_token',
  REFRESH_TOKEN: '@refresh_token',
  USER_DATA: '@user_data',
  SOIL_DATA: '@soil_data',
  APP_SETTINGS: '@app_settings',
};

// Animation Durations
export const ANIMATIONS = {
  FAST: 200,
  NORMAL: 300,
  SLOW: 500,
  EXTRA_SLOW: 800,
};

// Validation Rules
export const VALIDATION = {
  EMAIL: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
  PHONE: /^\+?[1-9]\d{1,14}$/,
  PASSWORD_MIN_LENGTH: 8,
  OTP_LENGTH: 6,
  NAME_MIN_LENGTH: 2,
  NAME_MAX_LENGTH: 50,
};

// Error Messages
export const ERROR_MESSAGES = {
  NETWORK_ERROR: 'Network error. Please check your connection.',
  INVALID_CREDENTIALS: 'Invalid email or password.',
  USER_NOT_FOUND: 'User not found.',
  TOKEN_EXPIRED: 'Session expired. Please login again.',
  INVALID_EMAIL: 'Please enter a valid email address.',
  INVALID_PHONE: 'Please enter a valid phone number.',
  PASSWORD_TOO_SHORT: 'Password must be at least 8 characters.',
  PASSWORDS_DONT_MATCH: 'Passwords do not match.',
  REQUIRED_FIELD: 'This field is required.',
  GENERIC_ERROR: 'Something went wrong. Please try again.',
};
