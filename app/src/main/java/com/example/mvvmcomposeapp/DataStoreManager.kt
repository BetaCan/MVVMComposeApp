package com.example.mvvmcomposeapp

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

class DataStoreManager(private val context: Context) {

    companion object {
        val STEP_SIZE_KEY = intPreferencesKey("step_size")
        val HISTORY_KEY = stringSetPreferencesKey("history_list")
    }

    val stepSize: Flow<Int> = context.dataStore.data
        .map { preferences -> preferences[STEP_SIZE_KEY] ?: 1 }

    val historyList: Flow<List<String>> = context.dataStore.data
        .map { preferences -> preferences[HISTORY_KEY]?.toList() ?: emptyList() }

    suspend fun setStepSize(step: Int) {
        context.dataStore.edit { preferences ->
            preferences[STEP_SIZE_KEY] = step
        }
    }

    suspend fun saveHistory(history: List<String>) {
        context.dataStore.edit { preferences ->
            preferences[HISTORY_KEY] = history.toSet()
        }
    }
}
