package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerEntity
import com.psc.elekha.database.entity.CustomerExistingLoanDetailEntity
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.database.entity.CustomerMovableAssetsEntity
import com.psc.elekha.database.repository.CustomerFamilyMemberDetailsRepository
import com.psc.elekha.database.repository.CustomerMovableAssestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CustomerMovableAssetsViewModel(
    private val repository: CustomerMovableAssestRepository
) : ViewModel() {

    private val _movalbleAssets = MutableStateFlow<List<CustomerMovableAssetsEntity>>(emptyList())
    val movalbleAssets: StateFlow<List<CustomerMovableAssetsEntity>> = _movalbleAssets


    fun insert(entity: CustomerMovableAssetsEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(entity)
        }
    }

    // INSERT list
    fun insertAll(members: List<CustomerMovableAssetsEntity>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAll(members)
        }
    }

    // GET all
    suspend fun getAll(): List<CustomerMovableAssetsEntity> {
        return repository.getAll()
    }

    // DELETE all
    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

    fun getAssetsByCustGuid(guId: String) {
        viewModelScope.launch {
            val result = repository.getAssetsByGuid(guId)
            _movalbleAssets.value = result
        }
    }

    suspend fun getAssetsDetailByGuid(guId: String): List<CustomerMovableAssetsEntity> {
        return repository.getAssestsDetailByGuid(guId)
    }

    fun deleteMovableAssets(item: CustomerMovableAssetsEntity) {
        viewModelScope.launch {
            repository.deleteMovableAssets(item)
            _movalbleAssets.value = _movalbleAssets.value.filter {
                it.VehicleID != item.VehicleID
            }
        }
    }

    suspend fun getUploadData():List<CustomerMovableAssetsEntity>{
        return repository.getUploadData()
    }


}
