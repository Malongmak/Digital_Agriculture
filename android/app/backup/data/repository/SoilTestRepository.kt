package com.makertest.app.data.repository

import com.makertest.app.data.models.SoilTestData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SoilTestRepository @Inject constructor() {
    
    private val testHistory = mutableListOf<SoilTestData>()
    
    suspend fun saveSoilTest(testData: SoilTestData) {
        // In a real app, this would save to a local database
        testHistory.add(testData)
        testHistory.sortByDescending { it.timestamp }
    }
    
    fun getTestHistory(): Flow<List<SoilTestData>> = flow {
        emit(testHistory.toList())
    }
    
    fun getTestHistoryByField(fieldId: String): Flow<List<SoilTestData>> = flow {
        val fieldTests = testHistory.filter { it.fieldId == fieldId }
        emit(fieldTests)
    }
    
    suspend fun deleteTest(testId: Long) {
        testHistory.removeAll { it.id == testId }
    }
    
    suspend fun getTestById(testId: Long): SoilTestData? {
        return testHistory.find { it.id == testId }
    }
}
