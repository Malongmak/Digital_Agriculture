import { STORAGE_KEYS, VALIDATION } from './constants';

// Validation helpers
export const validateEmail = (email) => {
  return VALIDATION.EMAIL.test(email);
};

export const validatePhone = (phone) => {
  return VALIDATION.PHONE.test(phone);
};

export const validatePassword = (password) => {
  return password && password.length >= VALIDATION.PASSWORD_MIN_LENGTH;
};

export const validateOTP = (otp) => {
  return otp && otp.length === VALIDATION.OTP_LENGTH && /^\d+$/.test(otp);
};

// Storage helpers
export const storage = {
  async set(key, value) {
    try {
      const jsonValue = JSON.stringify(value);
      await AsyncStorage.setItem(key, jsonValue);
    } catch (error) {
      console.error('Storage set error:', error);
    }
  },

  async get(key) {
    try {
      const jsonValue = await AsyncStorage.getItem(key);
      return jsonValue != null ? JSON.parse(jsonValue) : null;
    } catch (error) {
      console.error('Storage get error:', error);
      return null;
    }
  },

  async remove(key) {
    try {
      await AsyncStorage.removeItem(key);
    } catch (error) {
      console.error('Storage remove error:', error);
    }
  },

  async clear() {
    try {
      await AsyncStorage.clear();
    } catch (error) {
      console.error('Storage clear error:', error);
    }
  },
};

// Format helpers
export const formatDate = (date, format = 'short') => {
  const options = {
    short: { year: 'numeric', month: 'short', day: 'numeric' },
    long: { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit' },
    time: { hour: '2-digit', minute: '2-digit' },
  };

  return new Date(date).toLocaleDateString('en-US', options[format] || options.short);
};

export const formatNumber = (num, decimals = 2) => {
  return Number(num).toFixed(decimals);
};

export const formatCurrency = (amount, currency = 'SSP') => {
  return new Intl.NumberFormat('en-SS', {
    style: 'currency',
    currency: currency,
  }).format(amount);
};

// Data transformation helpers
export const capitalize = (str) => {
  return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
};

export const truncate = (str, length = 50) => {
  return str.length > length ? `${str.substring(0, length)}...` : str;
};

export const slugify = (str) => {
  return str
    .toLowerCase()
    .replace(/[^\w\s-]/g, '')
    .replace(/[\s_-]+/g, '-')
    .replace(/^-+|-+$/g, '');
};

// Array helpers
export const groupBy = (array, key) => {
  return array.reduce((result, item) => {
    const group = item[key];
    if (!result[group]) {
      result[group] = [];
    }
    result[group].push(item);
    return result;
  }, {});
};

export const sortBy = (array, key, direction = 'asc') => {
  return [...array].sort((a, b) => {
    if (direction === 'desc') {
      return b[key] > a[key] ? 1 : -1;
    }
    return a[key] > b[key] ? 1 : -1;
  });
};

export const unique = (array, key) => {
  if (!key) return [...new Set(array)];
  
  const seen = new Set();
  return array.filter(item => {
    const value = item[key];
    if (seen.has(value)) {
      return false;
    }
    seen.add(value);
    return true;
  });
};

// Debounce helper
export const debounce = (func, wait) => {
  let timeout;
  return function executedFunction(...args) {
    const later = () => {
      clearTimeout(timeout);
      func(...args);
    };
    clearTimeout(timeout);
    timeout = setTimeout(later, wait);
  };
};

// Throttle helper
export const throttle = (func, limit) => {
  let inThrottle;
  return function(...args) {
    if (!inThrottle) {
      func.apply(this, args);
      inThrottle = true;
      setTimeout(() => inThrottle = false, limit);
    }
  };
};

// Random helpers
export const generateId = (length = 8) => {
  const chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
  let result = '';
  for (let i = 0; i < length; i++) {
    result += chars.charAt(Math.floor(Math.random() * chars.length));
  }
  return result;
};

export const generateOTP = () => {
  return Math.floor(100000 + Math.random() * 900000).toString();
};

// Error handling helper
export const handleError = (error, defaultMessage = 'An error occurred') => {
  if (error.response) {
    // Server responded with error status
    return error.response.data?.message || defaultMessage;
  } else if (error.request) {
    // Request was made but no response received
    return 'Network error. Please check your connection.';
  } else {
    // Something else happened
    return error.message || defaultMessage;
  }
};

// Permission helpers
export const requestPermissions = async (permissions) => {
  try {
    const results = await Promise.all(
      permissions.map(permission => 
        Permissions.askAsync(permission)
      )
    );
    return results.every(result => result.status === 'granted');
  } catch (error) {
    console.error('Permission request error:', error);
    return false;
  }
};

// Location helper
export const getCurrentLocation = async () => {
  try {
    const { status } = await Permissions.askAsync(Permissions.LOCATION);
    if (status !== 'granted') {
      throw new Error('Location permission denied');
    }

    const location = await Location.getCurrentPositionAsync({
      accuracy: Location.Accuracy.Balanced,
    });

    return {
      latitude: location.coords.latitude,
      longitude: location.coords.longitude,
      accuracy: location.coords.accuracy,
    };
  } catch (error) {
    console.error('Location error:', error);
    throw error;
  }
};
