package com.makertest.app.data.models

data class WeatherData(
    val location: String,
    val current: CurrentWeather,
    val forecast: List<DailyForecast>,
    val alerts: List<WeatherAlert>
)

data class CurrentWeather(
    val temperature: Float,
    val humidity: Int,
    val windSpeed: Float,
    val windDirection: String,
    val condition: WeatherCondition,
    val uvIndex: Float,
    val pressure: Float,
    val visibility: Float,
    val timestamp: Long
)

data class DailyForecast(
    val date: String,
    val maxTemp: Float,
    val minTemp: Float,
    val condition: WeatherCondition,
    val humidity: Int,
    val windSpeed: Float,
    val precipitationChance: Int,
    val precipitationAmount: Float
)

data class WeatherAlert(
    val id: String,
    val title: String,
    val description: String,
    val severity: AlertSeverity,
    val startTime: Long,
    val endTime: Long
)

enum class WeatherCondition {
    CLEAR, PARTLY_CLOUDY, CLOUDY, RAINY, STORMY, FOGGY, WINDY
}

enum class AlertSeverity {
    LOW, MEDIUM, HIGH, EXTREME
}
