import { InteractionManager, Platform } from 'react-native';

// Performance optimization utilities

// Run expensive operations after interactions complete
export const runAfterInteractions = (callback) => {
  return new Promise((resolve) => {
    InteractionManager.runAfterInteractions(() => {
      const result = callback();
      resolve(result);
    });
  });
};

// Memoization helper
export const memoize = (fn) => {
  const cache = new Map();
  return (...args) => {
    const key = JSON.stringify(args);
    if (cache.has(key)) {
      return cache.get(key);
    }
    const result = fn(...args);
    cache.set(key, result);
    return result;
  };
};

// Lazy loading helper
export const lazyLoad = (importFn) => {
  let module = null;
  let loading = false;
  let error = null;

  return async () => {
    if (module) return module;
    if (loading) {
      // Wait for loading to complete
      await new Promise(resolve => {
        const checkLoading = () => {
          if (!loading) resolve();
          else setTimeout(checkLoading, 50);
        };
        checkLoading();
      });
      return module;
    }
    if (error) throw error;

    loading = true;
    try {
      module = await importFn();
      loading = false;
      return module;
    } catch (err) {
      error = err;
      loading = false;
      throw err;
    }
  };
};

// Image optimization
export const optimizeImage = (uri, width, height) => {
  if (Platform.OS === 'web') {
    return uri; // Web handles image optimization differently
  }
  
  // For React Native, you might use ImageManipulator
  // This is a placeholder for image optimization logic
  return uri;
};

// Debounced search
export const createDebouncedSearch = (searchFunction, delay = 300) => {
  let timeoutId;
  
  return (...args) => {
    clearTimeout(timeoutId);
    timeoutId = setTimeout(() => {
      searchFunction(...args);
    }, delay);
  };
};

// Virtual list optimization
export const getItemLayout = (data, index) => ({
  length: 70, // Approximate item height
  offset: 70 * index,
  index,
});

// Performance monitoring
export const measurePerformance = (name, fn) => {
  return async (...args) => {
    const start = performance.now();
    const result = await fn(...args);
    const end = performance.now();
    console.log(`${name} took ${end - start} milliseconds`);
    return result;
  };
};

// Batch state updates
export const batchUpdates = (updates) => {
  // Use unstable_batchedUpdates from react-dom/react-native
  // This is a simplified version
  return Promise.all(updates.map(update => update()));
};

// Memory cleanup
export const cleanup = () => {
  // Clear any caches, timers, or subscriptions
  if (typeof gc !== 'undefined') {
    gc(); // Force garbage collection if available
  }
};

// Reduce re-renders with stable callbacks
export const useStableCallback = (fn) => {
  const ref = React.useRef(fn);
  ref.current = fn;
  return React.useCallback((...args) => ref.current(...args), []);
};

// Optimize flat list data
export const optimizeListData = (data) => {
  // Remove duplicates, sort, and prepare data for virtualized lists
  return Array.from(new Set(data)).sort();
};

// Network request optimization
export const optimizeNetworkRequest = async (requestFn, maxRetries = 3) => {
  let lastError;
  
  for (let i = 0; i <= maxRetries; i++) {
    try {
      return await requestFn();
    } catch (error) {
      lastError = error;
      if (i < maxRetries) {
        // Exponential backoff
        await new Promise(resolve => 
          setTimeout(resolve, Math.pow(2, i) * 1000)
        );
      }
    }
  }
  
  throw lastError;
};

// Cache management
class SimpleCache {
  constructor(maxSize = 100) {
    this.cache = new Map();
    this.maxSize = maxSize;
  }

  get(key) {
    if (this.cache.has(key)) {
      // Move to end (LRU)
      const value = this.cache.get(key);
      this.cache.delete(key);
      this.cache.set(key, value);
      return value;
    }
    return null;
  }

  set(key, value) {
    if (this.cache.has(key)) {
      this.cache.delete(key);
    } else if (this.cache.size >= this.maxSize) {
      // Remove oldest item
      const firstKey = this.cache.keys().next().value;
      this.cache.delete(firstKey);
    }
    this.cache.set(key, value);
  }

  clear() {
    this.cache.clear();
  }

  size() {
    return this.cache.size;
  }
}

export const cache = new SimpleCache();

// Performance metrics
export const getPerformanceMetrics = () => {
  if (typeof performance !== 'undefined' && performance.memory) {
    return {
      usedJSHeapSize: performance.memory.usedJSHeapSize,
      totalJSHeapSize: performance.memory.totalJSHeapSize,
      jsHeapSizeLimit: performance.memory.jsHeapSizeLimit,
    };
  }
  return null;
};
