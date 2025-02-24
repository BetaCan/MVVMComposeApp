package com.example.mvvmcomposeapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CounterViewModel(application: Application) : AndroidViewModel(application) {

    private val dataStore = DataStoreManager(application)

    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count

    private val _stepSize = MutableStateFlow(1)
    val stepSize: StateFlow<Int> = _stepSize

    private val _historyList = MutableStateFlow<List<String>>(emptyList())
    val historyList: StateFlow<List<String>> = _historyList

    init {
        viewModelScope.launch {
            dataStore.stepSize.collect { savedStep ->
                _stepSize.value = savedStep
            }
        }

        viewModelScope.launch {
            dataStore.historyList.collect { savedHistory ->
                _historyList.value = savedHistory
            }
        }
    }

    fun incrementCounter() {
        _count.value += _stepSize.value
        addToHistory("Incremented to ${_count.value}")
    }

    fun decrementCounter() {
        _count.value -= _stepSize.value
        addToHistory("Decremented to ${_count.value}")
    }

    fun resetCounter() {
        _count.value = 0
        addToHistory("Counter Reset to 0")
    }

    fun setStepSize(newStep: Int) {
        _stepSize.value = newStep
        viewModelScope.launch {
            dataStore.setStepSize(newStep)
        }
    }

    private fun addToHistory(message: String) {
        val updatedHistory = listOf(message) + _historyList.value
        _historyList.value = updatedHistory

        viewModelScope.launch {
            dataStore.saveHistory(updatedHistory) //
        }
    }
}
