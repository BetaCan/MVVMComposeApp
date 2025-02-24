package com.example.mvvmcomposeapp

sealed class Screen(val route: String) {
    object CounterScreen : Screen("counter_screen")
    object SettingsScreen : Screen("settings_screen")
    object HistoryScreen : Screen("history_screen")
}