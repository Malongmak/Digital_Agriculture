package com.makertest.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.makertest.app.ui.components.FarmFieldCard
import com.makertest.app.ui.components.ProfileHeader
import com.makertest.app.viewmodel.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val userProfile by viewModel.userProfile.collectAsState()
    val farmFields by viewModel.farmFields.collectAsState()
    val showAddFieldDialog by viewModel.showAddFieldDialog.collectAsState()
    
    LaunchedEffect(Unit) {
        viewModel.loadUserProfile()
        viewModel.loadFarmFields()
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Profile Header
        userProfile?.let { profile ->
            ProfileHeader(
                profile = profile,
                onEditProfile = { viewModel.showEditProfileDialog() }
            )
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Farm Fields Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "My Farm Fields",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            
            FloatingActionButton(
                onClick = { viewModel.showAddFieldDialog() },
                modifier = Modifier.size(40.dp),
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Field",
                    tint = Color.White
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        if (farmFields.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Agriculture,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "No farm fields added",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Add your first farm field to track soil health",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(farmFields) { field ->
                    FarmFieldCard(
                        field = field,
                        onSelect = { viewModel.selectField(field.id) },
                        onEdit = { viewModel.editField(field.id) },
                        onDelete = { viewModel.deleteField(field.id) }
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Statistics Section
        userProfile?.let { profile ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Farming Statistics",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        StatisticItem(
                            icon = Icons.Default.Science,
                            label = "Total Tests",
                            value = profile.totalTests.toString(),
                            color = Color(0xFF2196F3)
                        )
                        
                        StatisticItem(
                            icon = Icons.Default.Agriculture,
                            label = "Fields",
                            value = farmFields.size.toString(),
                            color = Color(0xFF4CAF50)
                        )
                        
                        StatisticItem(
                            icon = Icons.Default.CalendarToday,
                            label = "Days Active",
                            value = profile.daysActive.toString(),
                            color = Color(0xFFFF9800)
                        )
                    }
                }
            }
        }
    }
    
    // Add Field Dialog
    if (showAddFieldDialog) {
        AddFieldDialog(
            onDismiss = { viewModel.hideAddFieldDialog() },
            onAddField = { name, cropType, size, location ->
                viewModel.addFarmField(name, cropType, size, location)
            }
        )
    }
}

@Composable
private fun StatisticItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    value: String,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = color,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = color
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddFieldDialog(
    onDismiss: () -> Unit,
    onAddField: (String, String, Float, String) -> Unit
) {
    var fieldName by remember { mutableStateOf("") }
    var cropType by remember { mutableStateOf("") }
    var fieldSize by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Add Farm Field",
                style = MaterialTheme.typography.titleLarge
            )
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = fieldName,
                    onValueChange = { fieldName = it },
                    label = { Text("Field Name") },
                    placeholder = { Text("e.g., South Field") }
                )
                
                OutlinedTextField(
                    value = cropType,
                    onValueChange = { cropType = it },
                    label = { Text("Crop Type") },
                    placeholder = { Text("e.g., Maize, Sorghum") }
                )
                
                OutlinedTextField(
                    value = fieldSize,
                    onValueChange = { fieldSize = it },
                    label = { Text("Field Size (hectares)") },
                    placeholder = { Text("e.g., 2.5") }
                )
                
                OutlinedTextField(
                    value = location,
                    onValueChange = { location = it },
                    label = { Text("Location") },
                    placeholder = { Text("e.g., Juba, Central Equatoria") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val size = fieldSize.toFloatOrNull() ?: 0f
                    if (fieldName.isNotEmpty() && cropType.isNotEmpty() && size > 0f && location.isNotEmpty()) {
                        onAddField(fieldName, cropType, size, location)
                    }
                },
                enabled = fieldName.isNotEmpty() && cropType.isNotEmpty() && 
                         fieldSize.isNotEmpty() && location.isNotEmpty()
            ) {
                Text("Add Field")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
