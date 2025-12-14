module.exports = function (api) {
  api.cache(true);
  return {
    presets: ['babel-preset-expo'],
    plugins: [
      // Required for expo-linear-gradient
      'react-native-reanimated/plugin',
    ],
  };
};
