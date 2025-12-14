package com.makertest.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class Recommendation(
    val title: String,
    val description: String,
    val priority: Priority,
    val icon: ImageVector
)

enum class Priority {
    HIGH, MEDIUM, LOW
}

@Composable
fun RecommendationCard(
    title: String,
    description: String,
    priority: Priority,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = when (priority) {
                Priority.HIGH -> Color(0xFFFFF3E0)
                Priority.MEDIUM -> Color(0xFFE3F2FD)
                Priority.LOW -> Color(0xFFF3E5F5)
            }
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = when (priority) {
                    Priority.HIGH -> Color(0xFFFF9800)
                    Priority.MEDIUM -> Color(0xFF2196F3)
                    Priority.LOW -> Color(0xFF9C27B0)
                },
                modifier = Modifier.size(32.dp)
            )
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Surface(
                modifier = Modifier,
                shape = MaterialTheme.shapes.small,
                color = when (priority) {
                    Priority.HIGH -> Color(0xFFFF9800)
                    Priority.MEDIUM -> Color(0xFF2196F3)
                    Priority.LOW -> Color(0xFF9C27B0)
                }
            ) {
                Text(
                    text = priority.name,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun FertilizerRecommendationCard(
    nitrogen: Float,
    phosphorus: Float,
    potassium: Float,
    modifier: Modifier = Modifier
) {
    val recommendations = generateFertilizerRecommendations(nitrogen, phosphorus, potassium)
    
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Eco,
                    contentDescription = "Fertilizer",
                    tint = Color(0xFF4CAF50),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Fertilizer Recommendation",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            recommendations.forEach { recommendation ->
                RecommendationCard(
                    title = recommendation.title,
                    description = recommendation.description,
                    priority = recommendation.priority,
                    icon = recommendation.icon,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
            }
        }
    }
}

private fun generateFertilizerRecommendations(
    nitrogen: Float,
    phosphorus: Float,
    potassium: Float
): List<Recommendation> {
    val recommendations = mutableListOf<Recommendation>()
    
    if (nitrogen < 20) {
        recommendations.add(
            Recommendation(
                title = "Add Nitrogen",
                description = "Apply nitrogen-rich fertilizer (urea or ammonium nitrate) to improve leaf growth",
                priority = Priority.HIGH,
                icon = Icons.Default.TrendingUp
            )
        )
    }
    
    if (phosphorus < 20) {
        recommendations.add(
            Recommendation(
                title = "Add Phosphorus",
                description = "Apply phosphorus-rich fertilizer (super phosphate) to improve root development",
                priority = Priority.HIGH,
                icon = Icons.Default.Grass
            )
        )
    }
    
    if (potassium < 20) {
        recommendations.add(
            Recommendation(
                title = "Add Potassium",
                description = "Apply potassium-rich fertilizer (potash) to improve disease resistance",
                priority = Priority.MEDIUM,
                icon = Icons.Default.Yard
            )
        )
    }
    
    if (recommendations.isEmpty()) {
        recommendations.add(
            Recommendation(
                title = "Nutrients Balanced",
                description = "Soil nutrients are at optimal levels. Continue current fertilization practices.",
                priority = Priority.LOW,
                icon = Icons.Default.CheckCircle
            )
        )
    }
    
    return recommendations
}
