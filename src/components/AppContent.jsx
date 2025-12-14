import React, { Suspense, lazy } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { Navigation } from './Navigation';
import { useAuth } from '../context/AuthContext';
import './App.css';

// Lazy load pages for better performance
const LoginPage = lazy(() => import('../pages/LoginPage'));
const Dashboard = lazy(() => import('../pages/Dashboard'));
const SoilTesting = lazy(() => import('../pages/SoilTesting'));
const Weather = lazy(() => import('../pages/Weather'));
const MarketInfo = lazy(() => import('../pages/MarketInfo'));
const Settings = lazy(() => import('../pages/Settings'));

// Loading component
const PageLoader = () => (
  <div className="flex items-center justify-center min-h-screen bg-gradient-to-br from-green-50 to-green-100">
    <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-green-600"></div>
  </div>
);

const ProtectedRoute = ({ children }) => {
  const { user, loading } = useAuth();
  
  if (loading) {
    return <PageLoader />;
  }
  
  return user ? children : <Navigate to="/login" replace />;
};

const AppContent = () => {
  return (
    <Router>
      <div className="App">
        <Navigation />
        <main className="main-content">
          <Suspense fallback={<PageLoader />}>
            <Routes>
              <Route path="/login" element={<LoginPage />} />
              <Route path="/" element={
                <ProtectedRoute>
                  <Dashboard />
                </ProtectedRoute>
              } />
              <Route path="/dashboard" element={
                <ProtectedRoute>
                  <Dashboard />
                </ProtectedRoute>
              } />
              <Route path="/soil-testing" element={
                <ProtectedRoute>
                  <SoilTesting />
                </ProtectedRoute>
              } />
              <Route path="/weather" element={
                <ProtectedRoute>
                  <Weather />
                </ProtectedRoute>
              } />
              <Route path="/market" element={
                <ProtectedRoute>
                  <MarketInfo />
                </ProtectedRoute>
              } />
              <Route path="/settings" element={
                <ProtectedRoute>
                  <Settings />
                </ProtectedRoute>
              } />
              <Route path="*" element={<Navigate to="/" replace />} />
            </Routes>
          </Suspense>
        </main>
      </div>
    </Router>
  );
};

export default AppContent;
