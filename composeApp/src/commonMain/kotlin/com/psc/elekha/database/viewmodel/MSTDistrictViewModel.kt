package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTDistrictEntity
import com.psc.elekha.database.repository.MSTDistrictRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTDistrictViewModel(
    private val repository: MSTDistrictRepository
) : ViewModel() {

    private val _districtList = MutableStateFlow<List<MSTDistrictEntity>>(emptyList())
    val districtList: StateFlow<List<MSTDistrictEntity>> = _districtList

    // Load all districts
    fun loadAllDistricts() {
        viewModelScope.launch {
            val result = repository.getAllDistrict()
            _districtList.value = result
        }
    }

    // Insert single district
    fun insertDistrict(item: MSTDistrictEntity) {
        viewModelScope.launch {
            repository.insertDistrict(item)
            loadAllDistricts() // Refresh list
        }
    }

    // Insert list of districts
    fun insertAllDistrict(list: List<MSTDistrictEntity>) {
        viewModelScope.launch {
            repository.insertAllDistrict(list)
            loadAllDistricts() // Refresh list
        }
    }

    // Delete all districts
    fun deleteAllDistrict() {
        viewModelScope.launch {
            repository.deleteAllDistrict()
            _districtList.value = emptyList()
        }
    }
}
