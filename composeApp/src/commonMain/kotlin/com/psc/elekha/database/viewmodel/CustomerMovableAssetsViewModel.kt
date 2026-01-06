package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerEntity
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.database.entity.CustomerMovableAssetsEntity
import com.psc.elekha.database.repository.CustomerFamilyMemberDetailsRepository
import com.psc.elekha.database.repository.CustomerMovableAssestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class CustomerMovableAssetsViewModel(
    private val repository: CustomerMovableAssestRepository
) : ViewModel() {

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


}
