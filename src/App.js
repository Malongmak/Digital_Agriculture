import React from "react";
import { AuthProvider } from "./context/AuthContext";
import { SoilDataProvider } from "./context/SoilDataContext";
import AppContent from "./components/AppContent";

const App = () => {
  return (
    <AuthProvider>
      <SoilDataProvider>
        <AppContent />
      </SoilDataProvider>
    </AuthProvider>
  );
};

export default App;
