package com.makertest.app.data.repository

import com.makertest.app.data.models.FarmField
import com.makertest.app.data.models.UserProfile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileRepository @Inject constructor() {
    
    private var userProfile: UserProfile? = null
    private val farmFields = mutableListOf<FarmField>()
    
    suspend fun saveUserProfile(profile: UserProfile) {
        userProfile = profile
    }
    
    suspend fun updateUserProfile(profile: UserProfile) {
        userProfile = profile
    }
    
    fun getUserProfile(): Flow<UserProfile?> = flow {
        emit(userProfile)
    }
    
    suspend fun addFarmField(field: FarmField) {
        farmFields.add(field)
    }
    
    suspend fun updateFarmField(field: FarmField) {
        val index = farmFields.indexOfFirst { it.id == field.id }
        if (index != -1) {
            farmFields[index] = field
        }
    }
    
    suspend fun deleteFarmField(fieldId: String) {
        farmFields.removeAll { it.id == fieldId }
    }
    
    fun getFarmFields(): Flow<List<FarmField>> = flow {
        emit(farmFields.toList())
    }
    
    fun getFarmFieldById(fieldId: String): Flow<FarmField?> = flow {
        emit(farmFields.find { it.id == fieldId })
    }
}
