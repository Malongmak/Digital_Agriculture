package com.makertest.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "farm_fields")
data class FarmField(
    @PrimaryKey
    val id: String,
    val name: String,
    val cropType: String,
    val size: Float,
    val location: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
