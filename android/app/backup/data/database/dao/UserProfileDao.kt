package com.makertest.app.data.database.dao

import androidx.room.*
import com.makertest.app.data.models.UserProfile
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProfileDao {
    
    @Query("SELECT * FROM user_profiles WHERE userId = :userId")
    suspend fun getUserById(userId: String): UserProfile?
    
    @Query("SELECT * FROM user_profiles WHERE userId = :userId")
    fun observeUser(userId: String): Flow<UserProfile?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserProfile)
    
    @Update
    suspend fun updateUser(user: UserProfile)
    
    @Delete
    suspend fun deleteUser(user: UserProfile)
}
