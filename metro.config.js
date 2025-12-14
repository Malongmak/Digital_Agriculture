const { getDefaultConfig } = require('expo/metro-config');

const config = getDefaultConfig(__dirname);

// Add support for SVG files
config.transformer.babelTransformerPath = require.resolve('react-native-svg-transformer');
config.resolver.assetExts.push('bin', 'txt', 'jpg', 'png', 'otf', 'ttf');
config.resolver.sourceExts.push('svg');

module.exports = config;
