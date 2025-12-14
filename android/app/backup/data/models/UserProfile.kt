package com.makertest.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profiles")
data class UserProfile(
    @PrimaryKey
    val userId: String,
    val name: String,
    val email: String? = null,
    val phone: String? = null,
    val location: String,
    val memberSince: Int, // Year
    val totalTests: Int = 0,
    val fieldCount: Int = 0,
    val yieldImprovement: Int = 0, // Percentage
    val preferredLanguage: String = "en",
    val isNGOMember: Boolean = false,
    val ngoName: String? = null,
    val profileImage: String? = null,
    val createdAt: Long,
    val updatedAt: Long
)
