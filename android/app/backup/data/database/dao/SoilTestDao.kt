package com.makertest.app.data.database.dao

import androidx.room.*
import com.makertest.app.data.models.SoilTestData
import kotlinx.coroutines.flow.Flow

@Dao
interface SoilTestDao {
    
    @Query("SELECT * FROM soil_tests ORDER BY timestamp DESC")
    fun getAllTests(): Flow<List<SoilTestData>>
    
    @Query("SELECT * FROM soil_tests WHERE fieldId = :fieldId ORDER BY timestamp DESC")
    fun getTestsByField(fieldId: String): Flow<List<SoilTestData>>
    
    @Query("SELECT * FROM soil_tests WHERE id = :testId")
    suspend fun getTestById(testId: Long): SoilTestData?
    
    @Insert
    suspend fun insertTest(test: SoilTestData): Long
    
    @Update
    suspend fun updateTest(test: SoilTestData)
    
    @Delete
    suspend fun deleteTest(test: SoilTestData)
    
    @Query("DELETE FROM soil_tests WHERE id = :testId")
    suspend fun deleteTestById(testId: Long)
    
    @Query("SELECT COUNT(*) FROM soil_tests")
    suspend fun getTestCount(): Int
}
