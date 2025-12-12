package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTAssetsValuationEntity
import com.psc.elekha.database.repository.MSTAssetsValuationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTAssetsValuationViewModel(
    private val repository: MSTAssetsValuationRepository
) : ViewModel() {

    private val _assetsValuationList = MutableStateFlow<List<MSTAssetsValuationEntity>>(emptyList())
    val assetsValuationList: StateFlow<List<MSTAssetsValuationEntity>> = _assetsValuationList

    // Load data
    fun loadAssetsValuation() {
        viewModelScope.launch {
            val result = repository.getAllAssetsValuation()
            _assetsValuationList.value = result
        }
    }

    // Insert single item
    fun insertAssetsValuation(item: MSTAssetsValuationEntity) {
        viewModelScope.launch {
            repository.insertAssetsValuation(item)
            loadAssetsValuation() // refresh list
        }
    }

    // Insert list
    fun insertAllAssetsValuation(list: List<MSTAssetsValuationEntity>) {
        viewModelScope.launch {
            repository.insertAllAssetsValuation(list)
            loadAssetsValuation() // refresh list
        }
    }

    // Delete all
    fun deleteAllAssetsValuation() {
        viewModelScope.launch {
            repository.deleteAllAssetsValuation()
            _assetsValuationList.value = emptyList()
        }
    }
}
