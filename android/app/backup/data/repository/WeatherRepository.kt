package com.makertest.app.data.repository

import com.makertest.app.data.models.WeatherData
import com.makertest.app.data.models.CurrentWeather
import com.makertest.app.data.models.DailyForecast
import com.makertest.app.data.models.WeatherCondition
import com.makertest.app.data.models.WeatherAlert
import com.makertest.app.data.models.AlertSeverity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor() {
    
    fun getCurrentWeather(location: String): Flow<WeatherData> = flow {
        // In a real app, this would fetch from a weather API like OpenWeatherMap
        // For now, we'll provide sample weather data for South Sudan
        val sampleWeatherData = generateSampleWeatherData(location)
        emit(sampleWeatherData)
    }
    
    private fun generateSampleWeatherData(location: String): WeatherData {
        val current = CurrentWeather(
            temperature = 28.5f,
            humidity = 65,
            windSpeed = 12.3f,
            windDirection = "NE",
            condition = WeatherCondition.PARTLY_CLOUDY,
            uvIndex = 7.2f,
            pressure = 1013.2f,
            visibility = 10.0f,
            timestamp = System.currentTimeMillis()
        )
        
        val forecast = listOf(
            DailyForecast(
                date = "Tomorrow",
                maxTemp = 32.0f,
                minTemp = 22.0f,
                condition = WeatherCondition.PARTLY_CLOUDY,
                humidity = 70,
                windSpeed = 15.0f,
                precipitationChance = 20,
                precipitationAmount = 0.5f
            ),
            DailyForecast(
                date = "Day 3",
                maxTemp = 30.0f,
                minTemp = 21.0f,
                condition = WeatherCondition.RAINY,
                humidity = 80,
                windSpeed = 18.0f,
                precipitationChance = 60,
                precipitationAmount = 8.2f
            ),
            DailyForecast(
                date = "Day 4",
                maxTemp = 29.0f,
                minTemp = 20.0f,
                condition = WeatherCondition.CLOUDY,
                humidity = 75,
                windSpeed = 14.0f,
                precipitationChance = 40,
                precipitationAmount = 3.1f
            ),
            DailyForecast(
                date = "Day 5",
                maxTemp = 31.0f,
                minTemp = 23.0f,
                condition = WeatherCondition.CLEAR,
                humidity = 60,
                windSpeed = 10.0f,
                precipitationChance = 10,
                precipitationAmount = 0.0f
            ),
            DailyForecast(
                date = "Day 6",
                maxTemp = 33.0f,
                minTemp = 24.0f,
                condition = WeatherCondition.CLEAR,
                humidity = 55,
                windSpeed = 8.0f,
                precipitationChance = 5,
                precipitationAmount = 0.0f
            ),
            DailyForecast(
                date = "Day 7",
                maxTemp = 32.0f,
                minTemp = 23.0f,
                condition = WeatherCondition.PARTLY_CLOUDY,
                humidity = 65,
                windSpeed = 12.0f,
                precipitationChance = 25,
                precipitationAmount = 1.2f
            )
        )
        
        val alerts = listOf(
            WeatherAlert(
                id = "alert_1",
                title = "High UV Index Warning",
                description = "UV index will be very high tomorrow. Take precautions when working outdoors.",
                severity = AlertSeverity.MEDIUM,
                startTime = System.currentTimeMillis() + 86400000,
                endTime = System.currentTimeMillis() + 86400000 + 43200000
            ),
            WeatherAlert(
                id = "alert_2",
                title = "Rain Expected",
                description = "Heavy rain expected in 2 days. Consider adjusting farming activities.",
                severity = AlertSeverity.LOW,
                startTime = System.currentTimeMillis() + 86400000 * 2,
                endTime = System.currentTimeMillis() + 86400000 * 3
            )
        )
        
        return WeatherData(
            location = location,
            current = current,
            forecast = forecast,
            alerts = alerts
        )
    }
}
