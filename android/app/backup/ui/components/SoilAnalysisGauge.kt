package com.makertest.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makertest.app.data.models.NutrientStatus
import com.makertest.app.data.models.MoistureStatus
import com.makertest.app.data.models.PHStatus

@Composable
fun SoilAnalysisCard(
    title: String,
    value: String,
    status: String,
    statusColor: Color,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = statusColor,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                modifier = Modifier.clip(RoundedCornerShape(12.dp)),
                color = statusColor.copy(alpha = 0.2f)
            ) {
                Text(
                    text = status,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = statusColor,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun CircularGauge(
    value: Float,
    maxValue: Float,
    title: String,
    status: String,
    statusColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(120.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier.size(100.dp)
            ) {
                drawCircularGauge(value, maxValue, statusColor)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = value.toInt().toString(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

private fun DrawScope.drawCircularGauge(value: Float, maxValue: Float, color: Color) {
    val strokeWidth = 8.dp.toPx()
    val center = Offset(size.width / 2, size.height / 2)
    val radius = (size.minDimension - strokeWidth) / 2
    
    // Background circle
    drawCircle(
        color = Color.Gray.copy(alpha = 0.3f),
        radius = radius,
        center = center,
        style = androidx.compose.ui.graphics.drawscope.Stroke(width = strokeWidth)
    )
    
    // Progress arc
    val sweepAngle = (value / maxValue) * 360f
    drawArc(
        color = color,
        startAngle = -90f,
        sweepAngle = sweepAngle,
        useCenter = false,
        topLeft = Offset(center.x - radius, center.y - radius),
        size = Size(radius * 2, radius * 2),
        style = androidx.compose.ui.graphics.drawscope.Stroke(width = strokeWidth)
    )
}

@Composable
fun SoilAnalysisGrid(
    phValue: Float,
    phStatus: PHStatus,
    moistureValue: Float,
    moistureStatus: MoistureStatus,
    nitrogenValue: Float,
    nitrogenStatus: NutrientStatus,
    phosphorusValue: Float,
    phosphorusStatus: NutrientStatus,
    potassiumValue: Float,
    potassiumStatus: NutrientStatus
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // pH Gauge
        CircularGauge(
            value = phValue,
            maxValue = 14f,
            title = "pH",
            status = phStatus.name,
            statusColor = getStatusColor(phStatus.name),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Nutrient and Moisture Cards
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SoilAnalysisCard(
                title = "Moisture",
                value = "${moistureValue.toInt()}%",
                status = moistureStatus.name,
                statusColor = getStatusColor(moistureStatus.name),
                icon = androidx.compose.material.icons.Icons.Filled.WaterDrop,
                modifier = Modifier.weight(1f)
            )
            
            SoilAnalysisCard(
                title = "Nitrogen",
                value = "${nitrogenValue.toInt()}",
                status = nitrogenStatus.name,
                statusColor = getStatusColor(nitrogenStatus.name),
                icon = androidx.compose.material.icons.Icons.Filled.Eco,
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SoilAnalysisCard(
                title = "Phosphorus",
                value = "${phosphorusValue.toInt()}",
                status = phosphorusStatus.name,
                statusColor = getStatusColor(phosphorusStatus.name),
                icon = androidx.compose.material.icons.Icons.Filled.Grass,
                modifier = Modifier.weight(1f)
            )
            
            SoilAnalysisCard(
                title = "Potassium",
                value = "${potassiumValue.toInt()}",
                status = potassiumStatus.name,
                statusColor = getStatusColor(potassiumStatus.name),
                icon = androidx.compose.material.icons.Icons.Filled.Yard,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

private fun getStatusColor(status: String): Color {
    return when (status.uppercase()) {
        "OPTIMAL" -> Color(0xFF4CAF50)
        "LOW" -> Color(0xFFFF9800)
        "HIGH" -> Color(0xFFF44336)
        "ACIDIC" -> Color(0xFFFF9800)
        "NEUTRAL" -> Color(0xFF4CAF50)
        "ALKALINE" -> Color(0xFFFF5722)
        else -> Color.Gray
    }
}
