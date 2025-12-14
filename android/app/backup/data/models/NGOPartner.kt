package com.makertest.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ngo_partners")
data class NGOPartner(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String,
    val contactPerson: String,
    val phone: String,
    val email: String,
    val location: String,
    val services: List<NGOService>,
    val website: String? = null,
    val logoUrl: String? = null,
    val isActive: Boolean = true,
    val establishedYear: Int,
    val region: String = "South Sudan"
)

enum class NGOService {
    TRAINING,
    EQUIPMENT_DISTRIBUTION,
    TECHNICAL_SUPPORT,
    MARKET_ACCESS,
    FINANCIAL_SUPPORT,
    SEED_DISTRIBUTION,
    EDUCATION,
    EMERGENCY_RELIEF
}

data class NGOWorkshop(
    val id: String,
    val ngoId: Long,
    val title: String,
    val description: String,
    val date: Long,
    val location: String,
    val duration: Int, // in hours
    val maxParticipants: Int,
    val currentParticipants: Int,
    val topics: List<String>,
    val instructor: String,
    val cost: Double,
    val isRegistered: Boolean = false
)

data class NGOResource(
    val id: String,
    val ngoId: Long,
    val title: String,
    val description: String,
    val type: ResourceType,
    val downloadUrl: String? = null,
    val isAvailable: Boolean = true,
    val location: String? = null // For physical resources
)

enum class ResourceType {
    PDF_GUIDE,
    VIDEO_TUTORIAL,
    EQUIPMENT,
    SEEDS,
    FERTILIZER,
    TOOL
}
