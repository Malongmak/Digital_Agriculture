import React from 'react';
import { StatusBar } from 'expo-status-bar';
import { SafeAreaProvider } from 'react-native-safe-area-context';
import { AuthProvider } from './src/context/AuthContext';
import { SoilDataProvider } from './src/context/SoilDataContext';
import AppNavigator from './src/navigation/AppNavigator';
import { useFonts } from 'expo-font';
import { ActivityIndicator, View } from 'react-native';

const AppContent = () => {
  const [fontsLoaded] = useFonts({
    'Inter-Regular': require('./assets/fonts/Inter-Regular.otf'),
    'Inter-Medium': require('./assets/fonts/Inter-Medium.otf'),
    'Inter-SemiBold': require('./assets/fonts/Inter-SemiBold.otf'),
    'Inter-Bold': require('./assets/fonts/Inter-Bold.otf'),
  });

  if (!fontsLoaded) {
    return (
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center', backgroundColor: '#f8fafc' }}>
        <ActivityIndicator size="large" color="#2E7D32" />
      </View>
    );
  }

  return (
    <SafeAreaProvider>
      <AuthProvider>
        <SoilDataProvider>
          <AppNavigator />
          <StatusBar style="auto" />
        </SoilDataProvider>
      </AuthProvider>
    </SafeAreaProvider>
  );
};

export default AppContent;
