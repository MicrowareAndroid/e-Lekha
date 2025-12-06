package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTStateEntity
import com.psc.elekha.database.repository.MSTStateRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTStateViewModel(
    private val repository: MSTStateRepository
) : ViewModel() {

    private val _stateList = MutableStateFlow<List<MSTStateEntity>>(emptyList())
    val stateList: StateFlow<List<MSTStateEntity>> = _stateList

    // Load all states
    fun loadAllStates() {
        viewModelScope.launch {
            val result = repository.getAllState()
            _stateList.value = result ?: emptyList()
        }
    }

    // Insert single state
    fun insertState(item: MSTStateEntity) {
        viewModelScope.launch {
            repository.insertState(item)
            loadAllStates() // Refresh list
        }
    }

    // Insert list of states
    fun insertAllState(list: List<MSTStateEntity>?) {
        viewModelScope.launch {
            repository.insertAllState(list)
            loadAllStates() // Refresh list
        }
    }

    // Delete all states
    fun deleteAllState() {
        viewModelScope.launch {
            repository.deleteAllState()
            _stateList.value = emptyList()
        }
    }
}
