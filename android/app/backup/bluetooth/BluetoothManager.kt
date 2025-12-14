package com.makertest.app.bluetooth

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import java.io.IOException
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BluetoothManager @Inject constructor(
    private val context: Context
) {
    private val bluetoothManager: BluetoothManager? = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    private val bluetoothAdapter: BluetoothAdapter? = bluetoothManager?.adapter
    
    private val _connectionState = MutableStateFlow<BluetoothConnectionState>(BluetoothConnectionState.Disconnected)
    val connectionState: StateFlow<BluetoothConnectionState> = _connectionState
    
    private val _connectedDevice = MutableStateFlow<BluetoothDevice?>(null)
    val connectedDevice: StateFlow<BluetoothDevice?> = _connectedDevice
    
    private var bluetoothSocket: BluetoothSocket? = null
    
    companion object {
        private const val MAKERTEST_UUID = "00001101-0000-1000-8000-00805F9B34FB"
    }
    
    fun isBluetoothEnabled(): Boolean {
        return bluetoothAdapter?.isEnabled == true
    }
    
    fun hasBluetoothPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.BLUETOOTH_CONNECT
        ) == PackageManager.PERMISSION_GRANTED
    }
    
    @SuppressLint("MissingPermission")
    fun getPairedDevices(): Set<BluetoothDevice> {
        return if (hasBluetoothPermission()) {
            bluetoothAdapter?.bondedDevices ?: emptySet()
        } else {
            emptySet()
        }
    }
    
    suspend fun connectToDevice(device: BluetoothDevice): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                if (!hasBluetoothPermission()) {
                    _connectionState.value = BluetoothConnectionState.PermissionDenied
                    return@withContext false
                }
                
                _connectionState.value = BluetoothConnectionState.Connecting
                
                bluetoothSocket = device.createRfcommSocketToServiceRecord(UUID.fromString(MAKERTEST_UUID))
                bluetoothSocket?.connect()
                
                _connectedDevice.value = device
                _connectionState.value = BluetoothConnectionState.Connected
                
                true
            } catch (e: IOException) {
                _connectionState.value = BluetoothConnectionState.Error(e.message ?: "Connection failed")
                false
            }
        }
    }
    
    fun disconnect() {
        try {
            bluetoothSocket?.close()
            bluetoothSocket = null
            _connectedDevice.value = null
            _connectionState.value = BluetoothConnectionState.Disconnected
        } catch (e: IOException) {
            _connectionState.value = BluetoothConnectionState.Error(e.message ?: "Disconnect failed")
        }
    }
    
    suspend fun sendCommand(command: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                bluetoothSocket?.outputStream?.let { outputStream ->
                    outputStream.write(command.toByteArray())
                    outputStream.flush()
                    true
                } ?: false
            } catch (e: IOException) {
                _connectionState.value = BluetoothConnectionState.Error(e.message ?: "Send command failed")
                false
            }
        }
    }
    
    suspend fun readData(): String? {
        return withContext(Dispatchers.IO) {
            try {
                bluetoothSocket?.inputStream?.let { inputStream ->
                    val buffer = ByteArray(1024)
                    val bytes = inputStream.read(buffer)
                    String(buffer, 0, bytes)
                }
            } catch (e: IOException) {
                _connectionState.value = BluetoothConnectionState.Error(e.message ?: "Read data failed")
                null
            }
        }
    }
}

sealed class BluetoothConnectionState {
    object Disconnected : BluetoothConnectionState()
    object Connecting : BluetoothConnectionState()
    object Connected : BluetoothConnectionState()
    object PermissionDenied : BluetoothConnectionState()
    data class Error(val message: String) : BluetoothConnectionState()
}
