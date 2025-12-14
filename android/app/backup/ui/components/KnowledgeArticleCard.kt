package com.makertest.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.makertest.app.data.models.ArticleCategory
import com.makertest.app.data.models.Difficulty
import com.makertest.app.data.models.KnowledgeArticle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KnowledgeArticleCard(
    article: KnowledgeArticle,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header with category and difficulty
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier,
                    shape = RoundedCornerShape(8.dp),
                    color = getCategoryColor(article.category).copy(alpha = 0.2f)
                ) {
                    Text(
                        text = article.category.name.replace("_", " "),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = getCategoryColor(article.category),
                        fontWeight = FontWeight.Medium
                    )
                }
                
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = getDifficultyIcon(article.difficulty),
                        contentDescription = article.difficulty.name,
                        tint = getDifficultyColor(article.difficulty),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = article.difficulty.name,
                        style = MaterialTheme.typography.labelSmall,
                        color = getDifficultyColor(article.difficulty)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Title
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Content preview
            Text(
                text = article.content,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Footer with tags and read time
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Tags
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    article.tags.take(2).forEach { tag ->
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant
                        ) {
                            Text(
                                text = tag,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                    if (article.tags.size > 2) {
                        Text(
                            text = "+${article.tags.size - 2}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                
                // Read time
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = "Read time",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${article.readTime} min",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            
            // Offline indicator
            if (article.isLocal) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.OfflinePin,
                        contentDescription = "Available offline",
                        tint = Color(0xFF4CAF50),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Available offline",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFF4CAF50)
                    )
                }
            }
        }
    }
}

private fun getCategoryColor(category: ArticleCategory): Color {
    return when (category) {
        ArticleCategory.SOIL_MANAGEMENT -> Color(0xFF8D6E63)
        ArticleCategory.CROP_CARE -> Color(0xFF4CAF50)
        ArticleCategory.PEST_CONTROL -> Color(0xFFFF5722)
        ArticleCategory.IRRIGATION -> Color(0xFF2196F3)
        ArticleCategory.FERTILIZATION -> Color(0xFF9C27B0)
        ArticleCategory.CLIMATE_ADAPTATION -> Color(0xFFFF9800)
        ArticleCategory.SUSTAINABLE_FARMING -> Color(0xFF009688)
        ArticleCategory.MARKET_INFO -> Color(0xFF3F51B5)
    }
}

private fun getDifficultyIcon(difficulty: Difficulty): ImageVector {
    return when (difficulty) {
        Difficulty.BEGINNER -> Icons.Default.School
        Difficulty.INTERMEDIATE -> Icons.Default.TrendingUp
        Difficulty.ADVANCED -> Icons.Default.Psychology
    }
}

private fun getDifficultyColor(difficulty: Difficulty): Color {
    return when (difficulty) {
        Difficulty.BEGINNER -> Color(0xFF4CAF50)
        Difficulty.INTERMEDIATE -> Color(0xFFFF9800)
        Difficulty.ADVANCED -> Color(0xFFF44336)
    }
}
