package com.makertest.app.data.database.dao

import androidx.room.*
import com.makertest.app.data.models.KnowledgeArticle
import kotlinx.coroutines.flow.Flow

@Dao
interface KnowledgeArticleDao {
    
    @Query("SELECT * FROM knowledge_articles ORDER BY updatedAt DESC")
    fun getAllArticles(): Flow<List<KnowledgeArticle>>
    
    @Query("SELECT * FROM knowledge_articles WHERE id = :articleId")
    suspend fun getArticleById(articleId: Long): KnowledgeArticle?
    
    @Query("SELECT * FROM knowledge_articles WHERE category = :category ORDER BY updatedAt DESC")
    fun getArticlesByCategory(category: String): Flow<List<KnowledgeArticle>>
    
    @Query("SELECT * FROM knowledge_articles WHERE title LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%' ORDER BY updatedAt DESC")
    fun searchArticles(query: String): Flow<List<KnowledgeArticle>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: KnowledgeArticle): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<KnowledgeArticle>)
    
    @Update
    suspend fun updateArticle(article: KnowledgeArticle)
    
    @Delete
    suspend fun deleteArticle(article: KnowledgeArticle)
    
    @Query("DELETE FROM knowledge_articles WHERE id = :articleId")
    suspend fun deleteArticleById(articleId: Long)
}
