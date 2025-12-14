package com.makertest.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makertest.app.data.models.FarmField
import com.makertest.app.data.models.SoilTestData
import com.makertest.app.data.repository.SoilTestRepository
import com.makertest.app.data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val soilTestRepository: SoilTestRepository,
    private val profileRepository: ProfileRepository
) : ViewModel() {
    
    private val _testHistory = MutableStateFlow<List<SoilTestData>>(emptyList())
    val testHistory: StateFlow<List<SoilTestData>> = _testHistory.asStateFlow()
    
    private val _selectedField = MutableStateFlow<FarmField?>(null)
    val selectedField: StateFlow<FarmField?> = _selectedField.asStateFlow()
    
    private val _farmFields = MutableStateFlow<List<FarmField>>(emptyList())
    val farmFields: StateFlow<List<FarmField>> = _farmFields.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    init {
        loadTestHistory()
        loadFarmFields()
    }
    
    fun loadTestHistory() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val history = soilTestRepository.getTestHistory()
                _testHistory.value = history
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun loadFarmFields() {
        viewModelScope.launch {
            try {
                val fields = profileRepository.getFarmFields()
                _farmFields.value = fields
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
    
    fun selectField(field: FarmField?) {
        _selectedField.value = field
        loadFilteredHistory()
    }
    
    private fun loadFilteredHistory() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val history = if (_selectedField.value != null) {
                    soilTestRepository.getTestHistoryByField(_selectedField.value!!.id)
                } else {
                    soilTestRepository.getTestHistory()
                }
                _testHistory.value = history
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun viewTestDetails(testId: Long) {
        // Navigate to test details screen
    }
    
    fun deleteTest(testId: Long) {
        viewModelScope.launch {
            try {
                soilTestRepository.deleteTest(testId)
                loadTestHistory()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
