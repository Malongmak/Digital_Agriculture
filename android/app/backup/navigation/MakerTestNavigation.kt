package com.makertest.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.makertest.app.ui.screens.SoilTestScreen
import com.makertest.app.ui.screens.WeatherScreen
import com.makertest.app.ui.screens.KnowledgeBankScreen
import com.makertest.app.ui.screens.ProfileScreen
import com.makertest.app.ui.screens.DeviceConnectionScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MakerTestNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Science, contentDescription = "Soil Test") },
                    label = { Text("Soil Test") },
                    selected = currentRoute == "soil_test",
                    onClick = {
                        navController.navigate("soil_test") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Cloud, contentDescription = "Weather") },
                    label = { Text("Weather") },
                    selected = currentRoute == "weather",
                    onClick = {
                        navController.navigate("weather") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                
                NavigationBarItem(
                    icon = { Icon(Icons.Default.MenuBook, contentDescription = "Knowledge") },
                    label = { Text("Knowledge") },
                    selected = currentRoute == "knowledge",
                    onClick = {
                        navController.navigate("knowledge") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = currentRoute == "profile",
                    onClick = {
                        navController.navigate("profile") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "soil_test",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("soil_test") {
                SoilTestScreen()
            }
            
            composable("weather") {
                WeatherScreen()
            }
            
            composable("knowledge") {
                KnowledgeBankScreen()
            }
            
            composable("profile") {
                ProfileScreen()
            }
            
            composable("device_connection") {
                DeviceConnectionScreen()
            }
        }
    }
}
