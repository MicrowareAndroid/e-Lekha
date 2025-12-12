package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTVillageEntity
import com.psc.elekha.database.repository.MSTVillageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTVillageViewModel(
    private val repository: MSTVillageRepository
) : ViewModel() {

    private val _villageList = MutableStateFlow<List<MSTVillageEntity>>(emptyList())
    val villageList: StateFlow<List<MSTVillageEntity>> = _villageList

    // Load all villages
    fun loadAllVillages() {
        viewModelScope.launch {
            val result = repository.getAllVillage()
            _villageList.value = result
        }
    }

    // Load villages by BranchID
    fun loadVillagesByBranchID(branchID: Int) {
        viewModelScope.launch {
            val result = repository.getAllVillageByBranchID(branchID)
            _villageList.value = result
        }
    }

    // Load villages by Pincode (with union query)
    fun loadVillagesByPincode(pinCode: String) {
        viewModelScope.launch {
            val result = repository.getAllVillageByPincode(pinCode)
            _villageList.value = result
        }
    }

    // Load villages by exact Pincode
    fun loadVillagesByCode(pinCode: String) {
        viewModelScope.launch {
            val result = repository.getAllVillageByCode(pinCode)
            _villageList.value = result
        }
    }

    // Get Pincode for a specific VillageID
    val pincode = MutableStateFlow<String?>(null)
    fun fetchPincode(villageID: Int) {
        viewModelScope.launch {
            pincode.value = repository.getPincode(villageID)
        }
    }

    // Get count of villages for a Pincode
    val villageCount = MutableStateFlow(0)
    fun fetchVillageCount(pinCode: String) {
        viewModelScope.launch {
            villageCount.value = repository.getCountVillageByCode(pinCode)
        }
    }

    // Insert single village
    fun insertVillage(item: MSTVillageEntity) {
        viewModelScope.launch {
            repository.insertVillage(item)
            loadAllVillages() // Refresh list
        }
    }

    // Insert list of villages
    fun insertAllVillage(list: List<MSTVillageEntity>) {
        viewModelScope.launch {
            repository.insertAllVillage(list)
            loadAllVillages() // Refresh list
        }
    }

    // Delete all villages
    fun deleteAllVillage() {
        viewModelScope.launch {
            repository.deleteAllVillage()
            _villageList.value = emptyList()
            pincode.value = null
            villageCount.value = 0
        }
    }
}
