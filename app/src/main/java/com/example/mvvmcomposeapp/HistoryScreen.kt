package com.example.mvvmcomposeapp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
@Composable
fun HistoryScreen(
    navController: NavController,
    viewModel: CounterViewModel = viewModel()
) {
    val historyList by viewModel.historyList.collectAsState() //

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Counter History", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        if (historyList.isEmpty()) {
            Text("No history yet!", style = MaterialTheme.typography.bodyLarge) // ✅ Show message if empty
        } else {
            LazyColumn {
                items(historyList) { item ->
                    Text(text = item, style = MaterialTheme.typography.bodyLarge)
                    Divider()
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back")
        }
    }
}
