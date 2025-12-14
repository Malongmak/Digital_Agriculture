package com.makertest.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.makertest.app.data.models.SoilTestData
import com.makertest.app.data.models.PHStatus
import com.makertest.app.data.models.MoistureStatus
import com.makertest.app.data.models.NutrientStatus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SoilTestHistoryCard(
    test: SoilTestData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header with date and field
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Text(
                        text = formatDate(test.timestamp),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = test.fieldId,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                
                Icon(
                    imageVector = Icons.Default.Science,
                    contentDescription = "Test Details",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Soil Metrics Grid
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MetricIndicator(
                    label = "pH",
                    value = test.ph.toString(),
                    status = getPHStatus(test.ph).name,
                    color = getPHColor(test.ph)
                )
                
                MetricIndicator(
                    label = "Moisture",
                    value = "${test.moisture.toInt()}%",
                    status = getMoistureStatus(test.moisture).name,
                    color = getMoistureColor(test.moisture)
                )
                
                MetricIndicator(
                    label = "NPK",
                    value = "${test.nitrogen.toInt()}-${test.phosphorus.toInt()}-${test.potassium.toInt()}",
                    status = "Balanced",
                    color = getNPKColor(test.nitrogen, test.phosphorus, test.potassium)
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Device info
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Bluetooth,
                    contentDescription = "Device",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Device: ${test.deviceId}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                if (test.location != null) {
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Location",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = test.location,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun MetricIndicator(
    label: String,
    value: String,
    status: String,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = color.copy(alpha = 0.2f)
        ) {
            Text(
                text = value,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = color
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = status,
            style = MaterialTheme.typography.labelSmall,
            color = color
        )
    }
}

private fun formatDate(timestamp: Long): String {
    val date = java.util.Date(timestamp)
    val formatter = java.text.SimpleDateFormat("MMM dd, yyyy", java.util.Locale.getDefault())
    return formatter.format(date)
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

private fun getPHColor(ph: Float): Color {
    return when {
        ph < 6.5 -> Color(0xFFFF9800)
        ph <= 7.5 -> Color(0xFF4CAF50)
        else -> Color(0xFFFF5722)
    }
}

private fun getMoistureColor(moisture: Float): Color {
    return when {
        moisture < 30 -> Color(0xFFFF9800)
        moisture <= 60 -> Color(0xFF4CAF50)
        else -> Color(0xFF2196F3)
    }
}

private fun getNPKColor(nitrogen: Float, phosphorus: Float, potassium: Float): Color {
    val average = (nitrogen + phosphorus + potassium) / 3
    return when {
        average < 20 -> Color(0xFFFF9800)
        average <= 40 -> Color(0xFF4CAF50)
        else -> Color(0xFF2196F3)
    }
}
