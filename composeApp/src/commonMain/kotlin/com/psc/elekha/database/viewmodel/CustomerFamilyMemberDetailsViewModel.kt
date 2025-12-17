package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.database.repository.CustomerFamilyMemberDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class CustomerFamilyMemberDetailsViewModel(
    private val repository: CustomerFamilyMemberDetailsRepository
) : ViewModel() {

    // INSERT single
    fun insertCustomerFamilyMember(member: CustomerFamilyMemberDetailsEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCustomerFamilyMember(member)
        }
    }

    // INSERT list
    fun insertAllCustomerFamilyMember(members: List<CustomerFamilyMemberDetailsEntity>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllCustomerFamilyMember(members)
        }
    }

    // GET all
    suspend fun getAllCustomerFamilyMember(): List<CustomerFamilyMemberDetailsEntity> {
        return repository.getAllCustomerFamilyMember()
    }

    // DELETE all
    fun deleteAllCustomerFamilyMembers() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCustomer()
        }
    }

    //  UPDATE by GUID
    fun updateCustomerFamilyMemberByGuid(
        guid: String,
        firstName: String,
        middleName: String,
        lastName: String,
        relationId: Int,
        age: Int,
        gender: String,
        educationId: Int,
        occupationId: Int
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCustomerFamilyMemberByGuid(
                guid,
                firstName,
                middleName,
                lastName,
                relationId,
                age,
                gender,
                educationId,
                occupationId
            )
        }
    }
}
