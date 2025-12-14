package com.makertest.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makertest.app.data.models.WeatherData
import com.makertest.app.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    
    private val _weatherData = MutableStateFlow<WeatherData?>(null)
    val weatherData: StateFlow<WeatherData?> = _weatherData.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    init {
        loadWeatherData()
    }
    
    fun refreshWeatherData() {
        loadWeatherData()
    }
    
    private fun loadWeatherData() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null
                
                // For South Sudan, we'll use Juba as default location
                val weather = weatherRepository.getCurrentWeather("Juba")
                _weatherData.value = weather
            } catch (e: Exception) {
                _error.value = "Failed to load weather data: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
