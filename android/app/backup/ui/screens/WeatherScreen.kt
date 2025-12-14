package com.makertest.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.makertest.app.data.models.AlertSeverity
import com.makertest.app.data.models.WeatherCondition
import com.makertest.app.ui.components.WeatherCard
import com.makertest.app.ui.components.WeatherAlertCard
import com.makertest.app.ui.components.ForecastCard
import com.makertest.app.viewmodel.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val weatherData by viewModel.weatherData.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    
    LaunchedEffect(Unit) {
        viewModel.refreshWeatherData()
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
                text = "Weather Monitor",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            
            IconButton(
                onClick = { viewModel.refreshWeatherData() }
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        strokeWidth = 2.dp
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Refresh"
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        weatherData?.let { weather ->
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Current Weather Card
                item {
                    WeatherCard(
                        current = weather.current,
                        location = weather.location,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                
                // Weather Alerts
                if (weather.alerts.isNotEmpty()) {
                    item {
                        Text(
                            text = "Weather Alerts",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                    
                    items(weather.alerts) { alert ->
                        WeatherAlertCard(
                            alert = alert,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                
                // 7-Day Forecast
                item {
                    Text(
                        text = "7-Day Forecast",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                
                items(weather.forecast) { forecast ->
                    ForecastCard(
                        forecast = forecast,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                
                // Agricultural Recommendations
                item {
                    AgriculturalRecommendationsCard(
                        weather = weather,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        } ?: run {
            if (isLoading) {
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
                            text = "Loading weather data...",
                            style = MaterialTheme.typography.bodyLarge
                        )
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
                        Icon(
                            imageVector = Icons.Default.CloudOff,
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            tint = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Unable to load weather data",
                            style = MaterialTheme.typography.headlineSmall,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = { viewModel.refreshWeatherData() }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Retry")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AgriculturalRecommendationsCard(
    weather: com.makertest.app.data.models.WeatherData,
    modifier: Modifier = Modifier
) {
    val recommendations = generateAgriculturalRecommendations(weather)
    
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Agriculture,
                    contentDescription = "Agriculture",
                    tint = Color(0xFF4CAF50),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Farming Recommendations",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            recommendations.forEach { recommendation ->
                Row(
                    modifier = Modifier.padding(vertical = 4.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        imageVector = recommendation.icon,
                        contentDescription = null,
                        tint = recommendation.color,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = recommendation.title,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = recommendation.description,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

private data class AgriculturalRecommendation(
    val title: String,
    val description: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val color: Color
)

private fun generateAgriculturalRecommendations(
    weather: com.makertest.app.data.models.WeatherData
): List<AgriculturalRecommendation> {
    val recommendations = mutableListOf<AgriculturalRecommendation>()
    
    // Temperature-based recommendations
    when {
        weather.current.temperature > 35f -> {
            recommendations.add(
                AgriculturalRecommendation(
                    title = "Heat Stress Warning",
                    description = "High temperatures can stress crops. Consider irrigation during cooler hours.",
                    icon = Icons.Default.Warning,
                    color = Color(0xFFFF9800)
                )
            )
        }
        weather.current.temperature < 15f -> {
            recommendations.add(
                AgriculturalRecommendation(
                    title = "Low Temperature",
                    description = "Cool temperatures may slow crop growth. Monitor for frost damage.",
                    icon = Icons.Default.AcUnit,
                    color = Color(0xFF2196F3)
                )
            )
        }
    }
    
    // Rain-based recommendations
    val nextDayPrecipitation = weather.forecast.getOrNull(0)?.precipitationChance ?: 0
    when {
        nextDayPrecipitation > 70 -> {
            recommendations.add(
                AgriculturalRecommendation(
                    title = "Heavy Rain Expected",
                    description = "Postpone fertilizer application. Ensure proper drainage to prevent waterlogging.",
                    icon = Icons.Default.Water,
                    color = Color(0xFF2196F3)
                )
            )
        }
        nextDayPrecipitation < 10 && weather.current.humidity < 40 -> {
            recommendations.add(
                AgriculturalRecommendation(
                    title = "Dry Conditions",
                    description = "Low humidity and no rain expected. Consider irrigation to maintain soil moisture.",
                    icon = Icons.Default.WaterDrop,
                    color = Color(0xFFFF9800)
                )
            )
        }
    }
    
    // Wind-based recommendations
    if (weather.current.windSpeed > 20f) {
        recommendations.add(
            AgriculturalRecommendation(
                title = "Strong Winds",
                description = "High winds may damage crops. Consider windbreaks or postpone spraying operations.",
                icon = Icons.Default.Air,
                color = Color(0xFFF44336)
            )
        )
    }
    
    // UV-based recommendations
    if (weather.current.uvIndex > 8) {
        recommendations.add(
            AgriculturalRecommendation(
                title = "High UV Index",
                description = "Intense sunlight can increase water evaporation. Increase irrigation frequency.",
                icon = Icons.Default.WbSunny,
                color = Color(0xFFFF9800)
            )
        )
    }
    
    if (recommendations.isEmpty()) {
        recommendations.add(
            AgriculturalRecommendation(
                title = "Favorable Conditions",
                description = "Weather conditions are good for farming activities. Continue with regular practices.",
                icon = Icons.Default.CheckCircle,
                color = Color(0xFF4CAF50)
            )
        )
    }
    
    return recommendations
}
