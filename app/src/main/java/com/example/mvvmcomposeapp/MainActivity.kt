package com.example.mvvmcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mvvmcomposeapp.ui.theme.MVVMComposeAppTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMComposeAppTheme {
                    AppNavigation() // No Scaffold needed, handled in individual screens
            }
        }
    }
}