package com.makertest.app.data.database.dao

import androidx.room.*
import com.makertest.app.data.models.NGOPartner
import kotlinx.coroutines.flow.Flow

@Dao
interface NGOPartnerDao {
    
    @Query("SELECT * FROM ngo_partners WHERE isActive = 1 ORDER BY name ASC")
    fun getAllActiveNGOs(): Flow<List<NGOPartner>>
    
    @Query("SELECT * FROM ngo_partners ORDER BY name ASC")
    fun getAllNGOs(): Flow<List<NGOPartner>>
    
    @Query("SELECT * FROM ngo_partners WHERE id = :ngoId")
    suspend fun getNGOById(ngoId: Long): NGOPartner?
    
    @Query("SELECT * FROM ngo_partners WHERE location LIKE '%' || :location || '%' AND isActive = 1")
    fun getNGOsByLocation(location: String): Flow<List<NGOPartner>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNGO(ngo: NGOPartner): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNGOs(ngos: List<NGOPartner>)
    
    @Update
    suspend fun updateNGO(ngo: NGOPartner)
    
    @Delete
    suspend fun deleteNGO(ngo: NGOPartner)
    
    @Query("DELETE FROM ngo_partners WHERE id = :ngoId")
    suspend fun deleteNGOById(ngoId: Long)
}
