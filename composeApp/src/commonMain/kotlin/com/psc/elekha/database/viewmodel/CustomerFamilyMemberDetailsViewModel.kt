package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerEntity
import com.psc.elekha.database.entity.CustomerExistingLoanDetailEntity
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.database.repository.CustomerFamilyMemberDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CustomerFamilyMemberDetailsViewModel(
    private val repository: CustomerFamilyMemberDetailsRepository
) : ViewModel() {

    private val _familyMemebers = MutableStateFlow<List<CustomerFamilyMemberDetailsEntity>>(emptyList())
    val familyMemebers: StateFlow<List<CustomerFamilyMemberDetailsEntity>> = _familyMemebers

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
        firstName: String?,
        middleName: String?,
        lastName: String?,
        relationId: Int?,
        age: Int?,
        gender: String?,
        educationId: Int?,
        occupationId: Int?
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



    fun getCustomerByGuid(guId: String) {
        viewModelScope.launch {
            val result = repository.getCustomerByGuid(guId)
            _familyMemebers.value = result
        }
    }

    suspend fun getCustomerDetailByGuid(guId: String): List<CustomerFamilyMemberDetailsEntity> {
        return repository.getCustomerDetailByGuid(guId)
    }

    fun deleteFamilyMember(item: CustomerFamilyMemberDetailsEntity) {
        viewModelScope.launch {
            repository.deleteFamilyMember(item)
            _familyMemebers.value = _familyMemebers.value.filter {
                it.MemberID != item.MemberID
            }
        }
    }

    suspend fun getUploadData():List<CustomerFamilyMemberDetailsEntity>{
        return repository.getUploadData()
    }

}
