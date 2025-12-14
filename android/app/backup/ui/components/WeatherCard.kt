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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makertest.app.data.models.CurrentWeather
import com.makertest.app.data.models.WeatherCondition

@Composable
fun WeatherCard(
    current: CurrentWeather,
    location: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // Location and Time
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Text(
                        text = location,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Current Conditions",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                
                Icon(
                    imageVector = getWeatherIcon(current.condition),
                    contentDescription = current.condition.name,
                    tint = getWeatherColor(current.condition),
                    modifier = Modifier.size(48.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Temperature Display
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${current.temperature.toInt()}°C",
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 64.sp
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = current.condition.name.replace("_", " "),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "Feels like ${current.temperature.toInt()}°C",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(20.dp))
            
            // Weather Details Grid
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WeatherDetailItem(
                    icon = Icons.Default.WaterDrop,
                    label = "Humidity",
                    value = "${current.humidity}%",
                    color = Color(0xFF2196F3)
                )
                
                WeatherDetailItem(
                    icon = Icons.Default.Air,
                    label = "Wind",
                    value = "${current.windSpeed.toInt()} km/h",
                    color = Color(0xFF4CAF50)
                )
                
                WeatherDetailItem(
                    icon = Icons.Default.WbSunny,
                    label = "UV Index",
                    value = current.uvIndex.toString(),
                    color = getUVColor(current.uvIndex)
                )
                
                WeatherDetailItem(
                    icon = Icons.Default.Speed,
                    label = "Pressure",
                    value = "${current.pressure.toInt()} hPa",
                    color = Color(0xFF9C27B0)
                )
            }
        }
    }
}

@Composable
private fun WeatherDetailItem(
    icon: ImageVector,
    label: String,
    value: String,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = color,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun ForecastCard(
    forecast: com.makertest.app.data.models.DailyForecast,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Date
            Text(
                text = forecast.date,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.width(80.dp)
            )
            
            // Weather Icon and Condition
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(120.dp)
            ) {
                Icon(
                    imageVector = getWeatherIcon(forecast.condition),
                    contentDescription = forecast.condition.name,
                    tint = getWeatherColor(forecast.condition),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = forecast.condition.name.replace("_", " "),
                    style = MaterialTheme.typography.bodySmall
                )
            }
            
            // Temperature Range
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${forecast.maxTemp.toInt()}°",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "/",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${forecast.minTemp.toInt()}°",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            // Precipitation
            if (forecast.precipitationChance > 0) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Water,
                        contentDescription = "Precipitation",
                        tint = Color(0xFF2196F3),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${forecast.precipitationChance}%",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF2196F3)
                    )
                }
            }
        }
    }
}

@Composable
fun WeatherAlertCard(
    alert: com.makertest.app.data.models.WeatherAlert,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = getAlertColor(alert.severity).copy(alpha = 0.1f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = getAlertIcon(alert.severity),
                contentDescription = alert.severity.name,
                tint = getAlertColor(alert.severity),
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = alert.title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = getAlertColor(alert.severity)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = alert.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = formatAlertTime(alert.startTime, alert.endTime),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

private fun getWeatherIcon(condition: WeatherCondition): ImageVector {
    return when (condition) {
        WeatherCondition.CLEAR -> Icons.Default.WbSunny
        WeatherCondition.PARTLY_CLOUDY -> Icons.Default.CloudQueue
        WeatherCondition.CLOUDY -> Icons.Default.Cloud
        WeatherCondition.RAINY -> Icons.Default.Graining
        WeatherCondition.STORMY -> Icons.Default.Thunderstorm
        WeatherCondition.FOGGY -> Icons.Default.Foggy
        WeatherCondition.WINDY -> Icons.Default.Air
    }
}

private fun getWeatherColor(condition: WeatherCondition): Color {
    return when (condition) {
        WeatherCondition.CLEAR -> Color(0xFFFF9800)
        WeatherCondition.PARTLY_CLOUDY -> Color(0xFF9E9E9E)
        WeatherCondition.CLOUDY -> Color(0xFF616161)
        WeatherCondition.RAINY -> Color(0xFF2196F3)
        WeatherCondition.STORMY -> Color(0xFF424242)
        WeatherCondition.FOGGY -> Color(0xFFBDBDBD)
        WeatherCondition.WINDY -> Color(0xFF4CAF50)
    }
}

private fun getUVColor(uvIndex: Float): Color {
    return when {
        uvIndex <= 2 -> Color(0xFF4CAF50)
        uvIndex <= 5 -> Color(0xFFFF9800)
        uvIndex <= 7 -> Color(0xFFFF5722)
        uvIndex <= 10 -> Color(0xFFF44336)
        else -> Color(0xFF9C27B0)
    }
}

private fun getAlertIcon(severity: com.makertest.app.data.models.AlertSeverity): ImageVector {
    return when (severity) {
        com.makertest.app.data.models.AlertSeverity.LOW -> Icons.Default.Info
        com.makertest.app.data.models.AlertSeverity.MEDIUM -> Icons.Default.Warning
        com.makertest.app.data.models.AlertSeverity.HIGH -> Icons.Default.Report
        com.makertest.app.data.models.AlertSeverity.EXTREME -> Icons.Default.Dangerous
    }
}

private fun getAlertColor(severity: com.makertest.app.data.models.AlertSeverity): Color {
    return when (severity) {
        com.makertest.app.data.models.AlertSeverity.LOW -> Color(0xFF2196F3)
        com.makertest.app.data.models.AlertSeverity.MEDIUM -> Color(0xFFFF9800)
        com.makertest.app.data.models.AlertSeverity.HIGH -> Color(0xFFFF5722)
        com.makertest.app.data.models.AlertSeverity.EXTREME -> Color(0xFFF44336)
    }
}

private fun formatAlertTime(startTime: Long, endTime: Long): String {
    val start = java.text.SimpleDateFormat("MMM dd, HH:mm", java.util.Locale.getDefault())
        .format(java.util.Date(startTime))
    val end = java.text.SimpleDateFormat("HH:mm", java.util.Locale.getDefault())
        .format(java.util.Date(endTime))
    return "$start - $end"
}
