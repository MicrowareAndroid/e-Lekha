package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTBankEntity
import com.psc.elekha.database.repository.MSTBankRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTBankViewModel(
    private val repository: MSTBankRepository
) : ViewModel() {

    private val _bankList = MutableStateFlow<List<MSTBankEntity>>(emptyList())
    val bankList: StateFlow<List<MSTBankEntity>> = _bankList

    // Load all banks
    fun loadAllBanks() {
        viewModelScope.launch {
            val result = repository.getAllBank()
            _bankList.value = result ?: emptyList()
        }
    }

    // Insert single bank
    fun insertBank(item: MSTBankEntity) {
        viewModelScope.launch {
            repository.insertBank(item)
            loadAllBanks() // Refresh list
        }
    }

    // Insert list of banks
    fun insertAllBank(list: List<MSTBankEntity>?) {
        viewModelScope.launch {
            repository.insertAllBank(list)
            loadAllBanks() // Refresh list
        }
    }

    // Delete all banks
    fun deleteAllBank() {
        viewModelScope.launch {
            repository.deleteAllBank()
            _bankList.value = emptyList()
        }
    }
}
