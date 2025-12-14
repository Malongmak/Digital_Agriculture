import React, { createContext, useContext, useState } from 'react';

const SoilDataContext = createContext();

export const useSoilData = () => {
  const context = useContext(SoilDataContext);
  if (!context) {
    throw new Error('useSoilData must be used within a SoilDataProvider');
  }
  return context;
};

export const SoilDataProvider = ({ children }) => {
  const [soilData, setSoilData] = useState({
    ph: 6.5,
    nitrogen: 45,
    phosphorus: 30,
    potassium: 25,
    moisture: 65,
    temperature: 22,
    lastTest: new Date().toISOString()
  });

  const updateSoilData = (newData) => {
    setSoilData(prev => ({
      ...prev,
      ...newData,
      lastTest: new Date().toISOString()
    }));
  };

  const value = {
    soilData,
    updateSoilData
  };

  return (
    <SoilDataContext.Provider value={value}>
      {children}
    </SoilDataContext.Provider>
  );
};
