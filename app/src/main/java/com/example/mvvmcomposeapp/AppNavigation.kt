package com.example.mvvmcomposeapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.CounterScreen.route // Default screen
    ) {
        composable(Screen.CounterScreen.route) {
            CounterScreen(navController)
        }
        composable(Screen.SettingsScreen.route) {
            SettingsScreen(navController)
        }
        composable(Screen.HistoryScreen.route) {
            HistoryScreen(navController)
        }
    }
}