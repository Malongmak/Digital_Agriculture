package com.makertest.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "knowledge_articles")
data class KnowledgeArticle(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val content: String,
    val category: ArticleCategory,
    val difficulty: Difficulty,
    val readTime: Int, // in minutes
    val imageUrl: String? = null,
    val tags: List<String>,
    val isLocal: Boolean = true, // for offline access
    val language: String = "en",
    val region: String = "South Sudan",
    val createdAt: Long,
    val updatedAt: Long
)

enum class ArticleCategory {
    SOIL_MANAGEMENT,
    CROP_CARE,
    PEST_CONTROL,
    IRRIGATION,
    FERTILIZATION,
    CLIMATE_ADAPTATION,
    SUSTAINABLE_FARMING,
    MARKET_INFO
}

enum class Difficulty {
    BEGINNER, INTERMEDIATE, ADVANCED
}

data class SearchFilter(
    val category: ArticleCategory? = null,
    val difficulty: Difficulty? = null,
    val tags: List<String> = emptyList(),
    val query: String = ""
)
