package com.makertest.app.data.database.dao

import androidx.room.*
import com.makertest.app.data.models.FarmField
import kotlinx.coroutines.flow.Flow

@Dao
interface FarmFieldDao {
    
    @Query("SELECT * FROM farm_fields ORDER BY name ASC")
    fun getAllFields(): Flow<List<FarmField>>
    
    @Query("SELECT * FROM farm_fields WHERE id = :fieldId")
    suspend fun getFieldById(fieldId: String): FarmField?
    
    @Insert
    suspend fun insertField(field: FarmField)
    
    @Update
    suspend fun updateField(field: FarmField)
    
    @Delete
    suspend fun deleteField(field: FarmField)
    
    @Query("DELETE FROM farm_fields WHERE id = :fieldId")
    suspend fun deleteFieldById(fieldId: String)
    
    @Query("SELECT COUNT(*) FROM farm_fields")
    suspend fun getFieldCount(): Int
}
