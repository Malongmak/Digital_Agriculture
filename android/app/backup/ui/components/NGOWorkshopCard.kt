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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.makertest.app.data.models.NGOWorkshop

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NGOWorkshopCard(
    workshop: NGOWorkshop,
    onRegister: () -> Unit,
    onViewDetails: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header with title and status
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = workshop.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Instructor",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = workshop.instructor,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                
                // Registration status
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = if (workshop.isRegistered) 
                        Color(0xFF4CAF50).copy(alpha = 0.2f) 
                    else 
                        MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Text(
                        text = if (workshop.isRegistered) "Registered" else "Available",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = if (workshop.isRegistered) Color(0xFF4CAF50) else MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Description
            Text(
                text = workshop.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Workshop details
            WorkshopDetailRow(
                icon = Icons.Default.Event,
                label = "Date",
                value = formatDate(workshop.date)
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            WorkshopDetailRow(
                icon = Icons.Default.Schedule,
                label = "Duration",
                value = "${workshop.duration} hours"
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            WorkshopDetailRow(
                icon = Icons.Default.LocationOn,
                label = "Location",
                value = workshop.location
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            WorkshopDetailRow(
                icon = Icons.Default.Group,
                label = "Participants",
                value = "${workshop.currentParticipants}/${workshop.maxParticipants}"
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            WorkshopDetailRow(
                icon = Icons.Default.AttachMoney,
                label = "Cost",
                value = if (workshop.cost == 0.0) "Free" else "$${workshop.cost}"
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Topics
            if (workshop.topics.isNotEmpty()) {
                Text(
                    text = "Topics:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(4.dp))
                
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    workshop.topics.take(3).forEach { topic ->
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = MaterialTheme.colorScheme.primaryContainer
                        ) {
                            Text(
                                text = topic,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }
                    if (workshop.topics.size > 3) {
                        Text(
                            text = "+${workshop.topics.size - 3}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(12.dp))
            }
            
            // Action buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = onViewDetails,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Details")
                }
                
                Button(
                    onClick = onRegister,
                    enabled = !workshop.isRegistered && workshop.currentParticipants < workshop.maxParticipants,
                    modifier = Modifier.weight(1f)
                ) {
                    if (workshop.isRegistered) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Registered")
                    } else if (workshop.currentParticipants >= workshop.maxParticipants) {
                        Icon(
                            imageVector = Icons.Default.Block,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Full")
                    } else {
                        Icon(
                            imageVector = Icons.Default.HowToReg,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Register")
                    }
                }
            }
        }
    }
}

@Composable
private fun WorkshopDetailRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    value: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "$label: $value",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

private fun formatDate(timestamp: Long): String {
    val date = java.util.Date(timestamp)
    val formatter = java.text.SimpleDateFormat("MMM dd, yyyy", java.util.Locale.getDefault())
    return formatter.format(date)
}
