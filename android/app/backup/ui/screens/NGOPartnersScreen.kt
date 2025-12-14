package com.makertest.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.makertest.app.ui.components.NGOPartnerCard
import com.makertest.app.ui.components.NGOWorkshopCard
import com.makertest.app.viewmodel.NGOPartnersViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NGOPartnersScreen(
    viewModel: NGOPartnersViewModel = hiltViewModel()
) {
    val ngoPartners by viewModel.ngoPartners.collectAsState()
    val workshops by viewModel.workshops.collectAsState()
    val selectedTab by viewModel.selectedTab.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    
    LaunchedEffect(Unit) {
        viewModel.loadNGOPartners()
        viewModel.loadWorkshops()
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "NGO Partners",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = "Connect with agricultural organizations in South Sudan",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(top = 4.dp)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Tab Selection
        TabRow(selectedTabIndex = selectedTab) {
            Tab(
                selected = selectedTab == 0,
                onClick = { viewModel.selectTab(0) },
                text = { Text("Partners") }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { viewModel.selectTab(1) },
                text = { Text("Workshops") }
            )
            Tab(
                selected = selectedTab == 2,
                onClick = { viewModel.selectTab(2) },
                text = { Text("Resources") }
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Content based on selected tab
        when (selectedTab) {
            0 -> PartnersTab(ngoPartners, isLoading, viewModel)
            1 -> WorkshopsTab(workshops, isLoading, viewModel)
            2 -> ResourcesTab(isLoading, viewModel)
        }
    }
}

@Composable
private fun PartnersTab(
    partners: List<com.makertest.app.data.models.NGOPartner>,
    isLoading: Boolean,
    viewModel: NGOPartnersViewModel
) {
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (partners.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Business,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "No NGO partners available",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Gray
                )
            }
        }
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(partners) { partner ->
                NGOPartnerCard(
                    partner = partner,
                    onContact = { viewModel.contactNGO(partner.id) },
                    onViewDetails = { viewModel.viewNGODetails(partner.id) }
                )
            }
        }
    }
}

@Composable
private fun WorkshopsTab(
    workshops: List<com.makertest.app.data.models.NGOWorkshop>,
    isLoading: Boolean,
    viewModel: NGOPartnersViewModel
) {
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (workshops.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Event,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "No workshops scheduled",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Gray
                )
            }
        }
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(workshops) { workshop ->
                NGOWorkshopCard(
                    workshop = workshop,
                    onRegister = { viewModel.registerForWorkshop(workshop.id) },
                    onViewDetails = { viewModel.viewWorkshopDetails(workshop.id) }
                )
            }
        }
    }
}

@Composable
private fun ResourcesTab(
    isLoading: Boolean,
    viewModel: NGOPartnersViewModel
) {
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.LibraryBooks,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Resources coming soon",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "NGO-provided resources will be available here",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
    }
}
