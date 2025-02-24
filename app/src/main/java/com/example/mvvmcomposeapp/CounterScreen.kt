package com.example.mvvmcomposeapp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CounterScreen(
    navController: NavController,
    viewModel: CounterViewModel = viewModel()
) {
    val count by viewModel.count.collectAsStateWithLifecycle()
    val stepSize by viewModel.stepSize.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Counter: $count", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Step Size: $stepSize", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = { viewModel.incrementCounter() }) {
                Text(text = "Increment by $stepSize")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.decrementCounter() }) {
                Text(text = "Decrement by $stepSize")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.resetCounter() }) {
                Text(text = "Reset")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row {
            Button(onClick = { navController.navigate(Screen.SettingsScreen.route) }) {
                Text(text = "Settings")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { navController.navigate(Screen.HistoryScreen.route) }) {
                Text(text = "History")
            }
        }
    }
}
