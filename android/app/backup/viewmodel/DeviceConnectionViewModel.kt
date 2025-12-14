package com.makertest.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makertest.app.bluetooth.BluetoothConnectionState
import com.makertest.app.bluetooth.BluetoothManager
import com.makertest.app.data.models.DeviceInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeviceConnectionViewModel @Inject constructor(
    private val bluetoothManager: BluetoothManager
) : ViewModel() {
    
    private val _connectionState = MutableStateFlow<BluetoothConnectionState>(BluetoothConnectionState.Disconnected)
    val connectionState: StateFlow<BluetoothConnectionState> = _connectionState.asStateFlow()
    
    private val _pairedDevices = MutableStateFlow<List<android.bluetooth.BluetoothDevice>>(emptyList())
    val pairedDevices: StateFlow<List<android.bluetooth.BluetoothDevice>> = _pairedDevices.asStateFlow()
    
    private val _isScanning = MutableStateFlow(false)
    val isScanning: StateFlow<Boolean> = _isScanning.asStateFlow()
    
    private val _deviceInfo = MutableStateFlow<DeviceInfo?>(null)
    val deviceInfo: StateFlow<DeviceInfo?> = _deviceInfo.asStateFlow()
    
    init {
        viewModelScope.launch {
            bluetoothManager.connectionState.collect { state ->
                _connectionState.value = state
                if (state is BluetoothConnectionState.Connected) {
                    updateDeviceInfo()
                } else {
                    _deviceInfo.value = null
                }
            }
        }
    }
    
    fun loadPairedDevices() {
        viewModelScope.launch {
            try {
                val devices = bluetoothManager.getPairedDevices()
                _pairedDevices.value = devices.toList()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
    
    fun startScanning() {
        viewModelScope.launch {
            try {
                _isScanning.value = true
                // In a real implementation, this would scan for new devices
                // For now, we'll just refresh the paired devices list
                loadPairedDevices()
                _isScanning.value = false
            } catch (e: Exception) {
                _isScanning.value = false
            }
        }
    }
    
    fun connectToDevice(deviceAddress: String) {
        viewModelScope.launch {
            try {
                val device = _pairedDevices.value.find { it.address == deviceAddress }
                device?.let {
                    bluetoothManager.connectToDevice(it)
                }
            } catch (e: Exception) {
                _connectionState.value = BluetoothConnectionState.Error("Failed to connect: ${e.message}")
            }
        }
    }
    
    fun disconnect() {
        bluetoothManager.disconnect()
    }
    
    fun refreshDeviceStatus() {
        updateDeviceInfo()
    }
    
    private fun updateDeviceInfo() {
        viewModelScope.launch {
            bluetoothManager.connectedDevice.value?.let { device ->
                val deviceInfo = DeviceInfo(
                    id = device.address,
                    name = device.name ?: "MakerTest Device",
                    batteryLevel = 85, // This would be read from the actual device
                    isConnected = true,
                    lastSync = System.currentTimeMillis()
                )
                _deviceInfo.value = deviceInfo
            }
        }
    }
}
