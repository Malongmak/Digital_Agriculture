// Environment configuration
const ENVIRONMENT = {
  development: {
    API_BASE_URL: 'http://localhost:3000/api',
    WEBSOCKET_URL: 'ws://localhost:3000',
    GOOGLE_CLIENT_ID: 'your-google-client-id-dev',
    APPLE_CLIENT_ID: 'your-apple-client-id-dev',
    SENTRY_DSN: null,
    ENABLE_LOGGING: true,
    ENABLE_ANALYTICS: false,
    API_TIMEOUT: 10000,
  },
  staging: {
    API_BASE_URL: 'https://staging-api.makertest.com/api',
    WEBSOCKET_URL: 'wss://staging-api.makertest.com',
    GOOGLE_CLIENT_ID: 'your-google-client-id-staging',
    APPLE_CLIENT_ID: 'your-apple-client-id-staging',
    SENTRY_DSN: 'https://your-sentry-dsn-staging',
    ENABLE_LOGGING: true,
    ENABLE_ANALYTICS: true,
    API_TIMEOUT: 8000,
  },
  production: {
    API_BASE_URL: 'https://api.makertest.com/api',
    WEBSOCKET_URL: 'wss://api.makertest.com',
    GOOGLE_CLIENT_ID: 'your-google-client-id-prod',
    APPLE_CLIENT_ID: 'your-apple-client-id-prod',
    SENTRY_DSN: 'https://your-sentry-dsn-prod',
    ENABLE_LOGGING: false,
    ENABLE_ANALYTICS: true,
    API_TIMEOUT: 5000,
  },
};

// Get current environment
const getCurrentEnvironment = () => {
  if (__DEV__) return 'development';
  
  // In production, you might want to detect environment differently
  // This could be based on bundle ID, URL, or other factors
  return 'production';
};

// Export current environment config
export const ENV = ENVIRONMENT[getCurrentEnvironment()];

// Export helper to check environment
export const isDevelopment = () => getCurrentEnvironment() === 'development';
export const isStaging = () => getCurrentEnvironment() === 'staging';
export const isProduction = () => getCurrentEnvironment() === 'production';
