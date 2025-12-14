package com.makertest.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makertest.app.data.models.ArticleCategory
import com.makertest.app.data.models.KnowledgeArticle
import com.makertest.app.data.repository.KnowledgeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KnowledgeBankViewModel @Inject constructor(
    private val knowledgeRepository: KnowledgeRepository
) : ViewModel() {
    
    private val _articles = MutableStateFlow<List<KnowledgeArticle>>(emptyList())
    val articles: StateFlow<List<KnowledgeArticle>> = _articles.asStateFlow()
    
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()
    
    private val _selectedCategory = MutableStateFlow<ArticleCategory?>(null)
    val selectedCategory: StateFlow<ArticleCategory?> = _selectedCategory.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    init {
        loadArticles()
    }
    
    fun loadArticles() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val allArticles = knowledgeRepository.getAllArticles()
                applyFilters(allArticles)
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        searchArticles()
    }
    
    fun clearSearch() {
        _searchQuery.value = ""
        searchArticles()
    }
    
    fun selectCategory(category: ArticleCategory?) {
        _selectedCategory.value = category
        searchArticles()
    }
    
    private fun searchArticles() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val allArticles = knowledgeRepository.getAllArticles()
                applyFilters(allArticles)
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    private fun applyFilters(allArticles: List<KnowledgeArticle>) {
        val filtered = allArticles.filter { article ->
            val matchesSearch = _searchQuery.value.isEmpty() ||
                    article.title.contains(_searchQuery.value, ignoreCase = true) ||
                    article.content.contains(_searchQuery.value, ignoreCase = true) ||
                    article.tags.any { tag.contains(_searchQuery.value, ignoreCase = true) }
            
            val matchesCategory = _selectedCategory.value == null ||
                    article.category == _selectedCategory.value
            
            matchesSearch && matchesCategory
        }
        
        _articles.value = filtered
    }
}
