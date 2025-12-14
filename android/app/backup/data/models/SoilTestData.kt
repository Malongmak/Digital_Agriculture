package com.makertest.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "soil_tests")
data class SoilTestData(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val fieldId: String,
    val timestamp: Long,
    val ph: Float,
    val moisture: Float,
    val nitrogen: Float,
    val phosphorus: Float,
    val potassium: Float,
    val deviceId: String,
    val location: String? = null
)

data class SoilTestResult(
    val ph: Float,
    val phStatus: PHStatus,
    val moisture: Float,
    val moistureStatus: MoistureStatus,
    val nitrogen: Float,
    val nitrogenStatus: NutrientStatus,
    val phosphorus: Float,
    val phosphorusStatus: NutrientStatus,
    val potassium: Float,
    val potassiumStatus: NutrientStatus
)

enum class PHStatus {
    ACIDIC, NEUTRAL, ALKALINE
}

enum class MoistureStatus {
    LOW, OPTIMAL, HIGH
}

enum class NutrientStatus {
    LOW, OPTIMAL, HIGH
}

data class DeviceInfo(
    val id: String,
    val name: String,
    val batteryLevel: Int,
    val isConnected: Boolean,
    val lastSync: Long
)

data class FarmField(
    val id: String,
    val name: String,
    val cropType: String,
    val size: Float,
    val location: String
)
