package com.makertest.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makertest.app.bluetooth.BluetoothConnectionState
import com.makertest.app.bluetooth.BluetoothManager
import com.makertest.app.data.models.DeviceInfo
import com.makertest.app.data.models.SoilTestData
import com.makertest.app.data.models.SoilTestResult
import com.makertest.app.data.repository.SoilTestRepository
import com.makertest.app.ui.components.Recommendation
import com.makertest.app.ui.components.Priority
import com.makertest.app.ui.components.generateFertilizerRecommendations
import com.makertest.app.ui.components.getPHStatus
import com.makertest.app.ui.components.getMoistureStatus
import com.makertest.app.ui.components.getNutrientStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SoilTestViewModel @Inject constructor(
    private val bluetoothManager: BluetoothManager,
    private val repository: SoilTestRepository
) : ViewModel() {
    
    private val _connectionState = MutableStateFlow<BluetoothConnectionState>(BluetoothConnectionState.Disconnected)
    val connectionState: StateFlow<BluetoothConnectionState> = _connectionState.asStateFlow()
    
    private val _soilTestData = MutableStateFlow<SoilTestResult?>(null)
    val soilTestData: StateFlow<SoilTestResult?> = _soilTestData.asStateFlow()
    
    private val _recommendations = MutableStateFlow<List<Recommendation>>(emptyList())
    val recommendations: StateFlow<List<Recommendation>> = _recommendations.asStateFlow()
    
    private val _deviceInfo = MutableStateFlow<DeviceInfo?>(null)
    val deviceInfo: StateFlow<DeviceInfo?> = _deviceInfo.asStateFlow()
    
    private val _selectedFieldId = MutableStateFlow<String>("default_field")
    val selectedFieldId: StateFlow<String> = _selectedFieldId.asStateFlow()
    
    init {
        viewModelScope.launch {
            bluetoothManager.connectionState.collect { state ->
                _connectionState.value = state
                when (state) {
                    is BluetoothConnectionState.Connected -> {
                        updateDeviceInfo()
                    }
                    else -> {
                        _deviceInfo.value = null
                    }
                }
            }
        }
    }
    
    fun startSoilAnalysis() {
        viewModelScope.launch {
            try {
                // Send command to device to start soil analysis
                val success = bluetoothManager.sendCommand("START_ANALYSIS")
                if (success) {
                    // Wait for and parse response
                    readSoilData()
                }
            } catch (e: Exception) {
                _connectionState.value = BluetoothConnectionState.Error("Failed to start analysis: ${e.message}")
            }
        }
    }
    
    private suspend fun readSoilData() {
        try {
            val response = bluetoothManager.readData()
            response?.let { data ->
                val parsedData = parseSoilData(data)
                _soilTestData.value = parsedData
                generateRecommendations(parsedData)
            }
        } catch (e: Exception) {
            _connectionState.value = BluetoothConnectionState.Error("Failed to read data: ${e.message}")
        }
    }
    
    private fun parseSoilData(data: String): SoilTestResult {
        // Parse the data from the soil testing device
        // Expected format: "PH:6.8,MOISTURE:35,N:25,P:30,K:40"
        val parts = data.split(",")
        
        var ph = 7.0f
        var moisture = 50.0f
        var nitrogen = 30.0f
        var phosphorus = 30.0f
        var potassium = 30.0f
        
        parts.forEach { part ->
            when {
                part.startsWith("PH:") -> ph = part.substring(3).toFloatOrNull() ?: 7.0f
                part.startsWith("MOISTURE:") -> moisture = part.substring(9).toFloatOrNull() ?: 50.0f
                part.startsWith("N:") -> nitrogen = part.substring(2).toFloatOrNull() ?: 30.0f
                part.startsWith("P:") -> phosphorus = part.substring(2).toFloatOrNull() ?: 30.0f
                part.startsWith("K:") -> potassium = part.substring(2).toFloatOrNull() ?: 30.0f
            }
        }
        
        return SoilTestResult(
            ph = ph,
            phStatus = getPHStatus(ph),
            moisture = moisture,
            moistureStatus = getMoistureStatus(moisture),
            nitrogen = nitrogen,
            nitrogenStatus = getNutrientStatus(nitrogen),
            phosphorus = phosphorus,
            phosphorusStatus = getNutrientStatus(phosphorus),
            potassium = potassium,
            potassiumStatus = getNutrientStatus(potassium)
        )
    }
    
    private fun generateRecommendations(soilData: SoilTestResult) {
        val recommendations = mutableListOf<Recommendation>()
        
        // Moisture recommendations
        if (soilData.moistureStatus.name == "LOW") {
            recommendations.add(
                Recommendation(
                    title = "Irrigation Needed",
                    description = "Consider irrigation to reach optimal moisture levels (45-60%)",
                    priority = Priority.HIGH,
                    icon = androidx.compose.material.icons.Icons.Filled.WaterDrop
                )
            )
        } else if (soilData.moistureStatus.name == "HIGH") {
            recommendations.add(
                Recommendation(
                    title = "Reduce Watering",
                    description = "Soil moisture is high. Reduce irrigation to prevent waterlogging",
                    priority = Priority.MEDIUM,
                    icon = androidx.compose.material.icons.Icons.Filled.Warning
                )
            )
        }
        
        // pH recommendations
        when (soilData.phStatus.name) {
            "ACIDIC" -> {
                recommendations.add(
                    Recommendation(
                        title = "Add Lime",
                        description = "Soil is acidic. Apply agricultural lime to raise pH to optimal range (6.5-7.5)",
                        priority = Priority.MEDIUM,
                        icon = androidx.compose.material.icons.Icons.Filled.Science
                    )
                )
            }
            "ALKALINE" -> {
                recommendations.add(
                    Recommendation(
                        title = "Add Sulfur",
                        description = "Soil is alkaline. Apply elemental sulfur to lower pH to optimal range (6.5-7.5)",
                        priority = Priority.MEDIUM,
                        icon = androidx.compose.material.icons.Icons.Filled.Science
                    )
                )
            }
        }
        
        // Nutrient recommendations
        recommendations.addAll(
            generateFertilizerRecommendations(
                soilData.nitrogen,
                soilData.phosphorus,
                soilData.potassium
            )
        )
        
        _recommendations.value = recommendations
    }
    
    private fun updateDeviceInfo() {
        viewModelScope.launch {
            bluetoothManager.connectedDevice.value?.let { device ->
                val deviceInfo = DeviceInfo(
                    id = device.address,
                    name = device.name ?: "Unknown Device",
                    batteryLevel = 85, // This would be read from device
                    isConnected = true,
                    lastSync = System.currentTimeMillis()
                )
                _deviceInfo.value = deviceInfo
            }
        }
    }
    
    fun refreshDeviceStatus() {
        updateDeviceInfo()
    }
    
    fun saveTestResult() {
        viewModelScope.launch {
            _soilTestData.value?.let { soilData ->
                val testData = SoilTestData(
                    fieldId = _selectedFieldId.value,
                    timestamp = System.currentTimeMillis(),
                    ph = soilData.ph,
                    moisture = soilData.moisture,
                    nitrogen = soilData.nitrogen,
                    phosphorus = soilData.phosphorus,
                    potassium = soilData.potassium,
                    deviceId = _deviceInfo.value?.id ?: "unknown",
                    location = null
                )
                repository.saveSoilTest(testData)
            }
        }
    }
    
    fun startNewTest() {
        _soilTestData.value = null
        _recommendations.value = emptyList()
        startSoilAnalysis()
    }
    
    fun setSelectedField(fieldId: String) {
        _selectedFieldId.value = fieldId
    }
}
