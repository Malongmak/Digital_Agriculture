package com.makertest.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makertest.app.data.models.FarmField
import com.makertest.app.data.models.UserProfile
import com.makertest.app.data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import java.util.UUID

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {
    
    private val _userProfile = MutableStateFlow<UserProfile?>(null)
    val userProfile: StateFlow<UserProfile?> = _userProfile.asStateFlow()
    
    private val _farmFields = MutableStateFlow<List<FarmField>>(emptyList())
    val farmFields: StateFlow<List<FarmField>> = _farmFields.asStateFlow()
    
    private val _showAddFieldDialog = MutableStateFlow(false)
    val showAddFieldDialog: StateFlow<Boolean> = _showAddFieldDialog.asStateFlow()
    
    private val _selectedFieldId = MutableStateFlow<String?>(null)
    val selectedFieldId: StateFlow<String?> = _selectedFieldId.asStateFlow()
    
    init {
        loadUserProfile()
        loadFarmFields()
    }
    
    fun loadUserProfile() {
        viewModelScope.launch {
            try {
                val profile = profileRepository.getUserProfile()
                if (profile == null) {
                    // Create default profile if none exists
                    val defaultProfile = UserProfile(
                        userId = UUID.randomUUID().toString(),
                        name = "South Sudan Farmer",
                        location = "Juba, South Sudan",
                        memberSince = 2024,
                        totalTests = 0,
                        fieldCount = 0,
                        yieldImprovement = 0,
                        createdAt = System.currentTimeMillis(),
                        updatedAt = System.currentTimeMillis()
                    )
                    profileRepository.saveUserProfile(defaultProfile)
                    _userProfile.value = defaultProfile
                } else {
                    _userProfile.value = profile
                }
            } catch (e: Exception) {
                // Handle error
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
    
    fun showAddFieldDialog() {
        _showAddFieldDialog.value = true
    }
    
    fun hideAddFieldDialog() {
        _showAddFieldDialog.value = false
    }
    
    fun addFarmField(name: String, cropType: String, size: Float, location: String) {
        viewModelScope.launch {
            try {
                val newField = FarmField(
                    id = UUID.randomUUID().toString(),
                    name = name,
                    cropType = cropType,
                    size = size,
                    location = location
                )
                
                profileRepository.addFarmField(newField)
                
                // Update field count in user profile
                _userProfile.value?.let { profile ->
                    val updatedProfile = profile.copy(
                        fieldCount = profile.fieldCount + 1,
                        updatedAt = System.currentTimeMillis()
                    )
                    profileRepository.updateUserProfile(updatedProfile)
                    _userProfile.value = updatedProfile
                }
                
                loadFarmFields()
                hideAddFieldDialog()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
    
    fun editField(fieldId: String) {
        // Navigate to edit field screen
        _selectedFieldId.value = fieldId
    }
    
    fun deleteField(fieldId: String) {
        viewModelScope.launch {
            try {
                profileRepository.deleteFarmField(fieldId)
                
                // Update field count in user profile
                _userProfile.value?.let { profile ->
                    val updatedProfile = profile.copy(
                        fieldCount = maxOf(0, profile.fieldCount - 1),
                        updatedAt = System.currentTimeMillis()
                    )
                    profileRepository.updateUserProfile(updatedProfile)
                    _userProfile.value = updatedProfile
                }
                
                loadFarmFields()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
    
    fun selectField(fieldId: String) {
        _selectedFieldId.value = fieldId
    }
    
    fun showEditProfileDialog() {
        // Navigate to edit profile screen
    }
    
    fun updateTestCount() {
        viewModelScope.launch {
            _userProfile.value?.let { profile ->
                val updatedProfile = profile.copy(
                    totalTests = profile.totalTests + 1,
                    updatedAt = System.currentTimeMillis()
                )
                profileRepository.updateUserProfile(updatedProfile)
                _userProfile.value = updatedProfile
            }
        }
    }
}
