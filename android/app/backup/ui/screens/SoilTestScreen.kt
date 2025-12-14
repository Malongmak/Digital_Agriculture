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
import com.makertest.app.data.models.PHStatus
import com.makertest.app.data.models.MoistureStatus
import com.makertest.app.data.models.NutrientStatus
import com.makertest.app.ui.components.SoilAnalysisGrid
import com.makertest.app.ui.components.DeviceStatusCard
import com.makertest.app.ui.components.RecommendationCard
import com.makertest.app.viewmodel.SoilTestViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SoilTestScreen(
    viewModel: SoilTestViewModel = hiltViewModel()
) {
    val connectionState by viewModel.connectionState.collectAsState()
    val soilTestData by viewModel.soilTestData.collectAsState()
    val recommendations by viewModel.recommendations.collectAsState()
    val deviceInfo by viewModel.deviceInfo.collectAsState()
    
    LaunchedEffect(connectionState) {
        if (connectionState is BluetoothConnectionState.Connected) {
            viewModel.startSoilAnalysis()
        }
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Soil Analysis",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            
            when (connectionState) {
                is BluetoothConnectionState.Connected -> {
                    Icon(
                        imageVector = Icons.Default.BluetoothConnected,
                        contentDescription = "Connected",
                        tint = Color(0xFF4CAF50)
                    )
                }
                is BluetoothConnectionState.Connecting -> {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        strokeWidth = 2.dp
                    )
                }
                else -> {
                    Icon(
                        imageVector = Icons.Default.BluetoothDisabled,
                        contentDescription = "Disconnected",
                        tint = Color.Gray
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Device Status Card
        deviceInfo?.let { device ->
            DeviceStatusCard(
                deviceInfo = device,
                onRefresh = { viewModel.refreshDeviceStatus() }
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Main Content
        when (connectionState) {
            is BluetoothConnectionState.Connected -> {
                if (soilTestData != null) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        item {
                            SoilAnalysisGrid(
                                phValue = soilTestData!!.ph,
                                phStatus = getPHStatus(soilTestData!!.ph),
                                moistureValue = soilTestData!!.moisture,
                                moistureStatus = getMoistureStatus(soilTestData!!.moisture),
                                nitrogenValue = soilTestData!!.nitrogen,
                                nitrogenStatus = getNutrientStatus(soilTestData!!.nitrogen),
                                phosphorusValue = soilTestData!!.phosphorus,
                                phosphorusStatus = getNutrientStatus(soilTestData!!.phosphorus),
                                potassiumValue = soilTestData!!.potassium,
                                potassiumStatus = getNutrientStatus(soilTestData!!.potassium)
                            )
                        }
                        
                        items(recommendations) { recommendation ->
                            RecommendationCard(
                                title = recommendation.title,
                                description = recommendation.description,
                                priority = recommendation.priority,
                                icon = recommendation.icon
                            )
                        }
                        
                        item {
                            Button(
                                onClick = { viewModel.saveTestResult() },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Save,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Save Test Result")
                            }
                        }
                        
                        item {
                            Button(
                                onClick = { viewModel.startNewTest() },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.secondary
                                )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Refresh,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Start New Test")
                            }
                        }
                    }
                } else {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator()
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "Analyzing soil...",
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            }
            
            is BluetoothConnectionState.Connecting -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator()
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Connecting to device...",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
            
            is BluetoothConnectionState.Disconnected -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.BluetoothDisabled,
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            tint = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "No device connected",
                            style = MaterialTheme.typography.headlineSmall,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Please connect your MakerTest device",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }
            }
            
            is BluetoothConnectionState.PermissionDenied -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Security,
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            tint = Color(0xFFFF9800)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Bluetooth Permission Required",
                            style = MaterialTheme.typography.headlineSmall,
                            color = Color(0xFFFF9800)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Please grant Bluetooth permissions to use the soil testing device",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }
            }
            
            is BluetoothConnectionState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Error,
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            tint = Color(0xFFF44336)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Connection Error",
                            style = MaterialTheme.typography.headlineSmall,
                            color = Color(0xFFF44336)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = (connectionState as BluetoothConnectionState.Error).message,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}

private fun getPHStatus(ph: Float): PHStatus {
    return when {
        ph < 6.5 -> PHStatus.ACIDIC
        ph <= 7.5 -> PHStatus.NEUTRAL
        else -> PHStatus.ALKALINE
    }
}

private fun getMoistureStatus(moisture: Float): MoistureStatus {
    return when {
        moisture < 30 -> MoistureStatus.LOW
        moisture <= 60 -> MoistureStatus.OPTIMAL
        else -> MoistureStatus.HIGH
    }
}

private fun getNutrientStatus(value: Float): NutrientStatus {
    return when {
        value < 20 -> NutrientStatus.LOW
        value <= 40 -> NutrientStatus.OPTIMAL
        else -> NutrientStatus.HIGH
    }
}
