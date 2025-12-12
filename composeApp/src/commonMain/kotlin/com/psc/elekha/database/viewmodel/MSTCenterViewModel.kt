package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTCenterEntity
import com.psc.elekha.database.repository.MSTCenterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTCenterViewModel(
    private val repository: MSTCenterRepository
) : ViewModel() {

    private val _centerList = MutableStateFlow<List<MSTCenterEntity>>(emptyList())
    val centerList: StateFlow<List<MSTCenterEntity>> = _centerList

    // Load all centers
    fun loadAllCenters() {
        viewModelScope.launch {
            val result = repository.getAllCenter()
            _centerList.value = result
        }
    }

    // Insert single center
    fun insertCenter(item: MSTCenterEntity) {
        viewModelScope.launch {
            repository.insertCenter(item)
            loadAllCenters() // Refresh list
        }
    }

    // Insert list of centers
    fun insertAllCenter(list: List<MSTCenterEntity>) {
        viewModelScope.launch {
            repository.insertAllCenter(list)
            loadAllCenters() // Refresh list
        }
    }

    // Delete all centers
    fun deleteAllCenter() {
        viewModelScope.launch {
            repository.deleteAllCenter()
            _centerList.value = emptyList()
        }
    }
}
