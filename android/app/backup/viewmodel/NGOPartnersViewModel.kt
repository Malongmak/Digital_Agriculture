package com.makertest.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makertest.app.data.models.NGOPartner
import com.makertest.app.data.models.NGOWorkshop
import com.makertest.app.data.repository.NGORepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NGOPartnersViewModel @Inject constructor(
    private val ngoRepository: NGORepository
) : ViewModel() {
    
    private val _ngoPartners = MutableStateFlow<List<NGOPartner>>(emptyList())
    val ngoPartners: StateFlow<List<NGOPartner>> = _ngoPartners.asStateFlow()
    
    private val _workshops = MutableStateFlow<List<NGOWorkshop>>(emptyList())
    val workshops: StateFlow<List<NGOWorkshop>> = _workshops.asStateFlow()
    
    private val _selectedTab = MutableStateFlow(0)
    val selectedTab: StateFlow<Int> = _selectedTab.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    init {
        loadNGOPartners()
        loadWorkshops()
    }
    
    fun loadNGOPartners() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val partners = ngoRepository.getNGOPartners()
                _ngoPartners.value = partners
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun loadWorkshops() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val workshops = ngoRepository.getWorkshops()
                _workshops.value = workshops
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun selectTab(index: Int) {
        _selectedTab.value = index
    }
    
    fun contactNGO(ngoId: Long) {
        // Navigate to NGO contact screen or open contact options
    }
    
    fun viewNGODetails(ngoId: Long) {
        // Navigate to NGO details screen
    }
    
    fun registerForWorkshop(workshopId: String) {
        viewModelScope.launch {
            try {
                ngoRepository.registerForWorkshop(workshopId)
                loadWorkshops() // Refresh to update registration status
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
    
    fun viewWorkshopDetails(workshopId: String) {
        // Navigate to workshop details screen
    }
}
