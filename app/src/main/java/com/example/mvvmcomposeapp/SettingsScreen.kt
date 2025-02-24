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
fun SettingsScreen(
    navController: NavController,
    viewModel: CounterViewModel = viewModel()
) {
    val stepSize by viewModel.stepSize.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Set Step Size", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = { viewModel.setStepSize(maxOf(1, stepSize - 1)) }) {
                Text("-")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text("Step: $stepSize", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.setStepSize(stepSize + 1) }) {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Save & Back")
        }
    }
}
