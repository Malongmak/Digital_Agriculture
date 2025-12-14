package com.makertest.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.makertest.app.bluetooth.BluetoothConnectionState
import com.makertest.app.ui.components.DeviceStatusCard
import com.makertest.app.viewmodel.DeviceConnectionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceConnectionScreen(
    viewModel: DeviceConnectionViewModel = hiltViewModel()
) {
    val connectionState by viewModel.connectionState.collectAsState()
    val pairedDevices by viewModel.pairedDevices.collectAsState()
    val isScanning by viewModel.isScanning.collectAsState()
    val deviceInfo by viewModel.deviceInfo.collectAsState()
    
    LaunchedEffect(Unit) {
        viewModel.loadPairedDevices()
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "Device Connection",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = "Connect your MakerTest soil testing device",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(top = 4.dp)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Connection Status Card
        deviceInfo?.let { device ->
            DeviceStatusCard(
                deviceInfo = device,
                onRefresh = { viewModel.refreshDeviceStatus() }
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Connection Actions
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = { viewModel.startScanning() },
                enabled = !isScanning && connectionState !is BluetoothConnectionState.Connected,
                modifier = Modifier.weight(1f)
            ) {
                if (isScanning) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        strokeWidth = 2.dp,
                        color = Color.White
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(if (isScanning) "Scanning..." else "Scan Devices")
            }
            
            if (connectionState is BluetoothConnectionState.Connected) {
                OutlinedButton(
                    onClick = { viewModel.disconnect() },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.BluetoothDisabled,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Disconnect")
                }
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Paired Devices Section
        Text(
            text = "Paired Devices",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        if (pairedDevices.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.BluetoothSearching,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "No paired devices found",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Make sure your MakerTest device is paired in Bluetooth settings",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(pairedDevices) { device ->
                    DeviceItemCard(
                        deviceName = device.name ?: "Unknown Device",
                        deviceAddress = device.address,
                        isConnected = connectionState is BluetoothConnectionState.Connected &&
                                     connectionState.toString().contains(device.address),
                        onConnect = { viewModel.connectToDevice(device.address) },
                        onDisconnect = { viewModel.disconnect() }
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Help Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Help,
                        contentDescription = "Help",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Connection Help",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
                
                Spacer(modifier = Modifier.height(12.dp))
                
                Text(
                    text = "1. Ensure Bluetooth is enabled on your device\n2. Make sure your MakerTest device is powered on\n3. Pair the device in your phone's Bluetooth settings\n4. Select the device from the list above to connect",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DeviceItemCard(
    deviceName: String,
    deviceAddress: String,
    isConnected: Boolean,
    onConnect: () -> Unit,
    onDisconnect: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = if (isConnected) Icons.Default.BluetoothConnected else Icons.Default.Bluetooth,
                    contentDescription = null,
                    tint = if (isConnected) Color(0xFF4CAF50) else MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = deviceName,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = deviceAddress,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            
            if (isConnected) {
                Surface(
                    shape = MaterialTheme.shapes.small,
                    color = Color(0xFF4CAF50)
                ) {
                    Text(
                        text = "Connected",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                }
            } else {
                Button(
                    onClick = onConnect,
                    modifier = Modifier.height(32.dp)
                ) {
                    Text(
                        text = "Connect",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
    }
}
