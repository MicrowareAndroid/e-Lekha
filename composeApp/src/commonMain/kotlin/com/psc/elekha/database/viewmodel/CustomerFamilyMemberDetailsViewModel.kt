package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.database.repository.CustomerFamilyMemberDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class CustomerFamilyMemberDetailsViewModel (
    private val repository: CustomerFamilyMemberDetailsRepository
) : ViewModel(){


    //insert Single Family Member
    fun insertCustomerFamilyMember(member: CustomerFamilyMemberDetailsEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCustomerFamilyMember(member)
        }
    }
    //insert list of family member
    fun insertAllCustomerFamilyMember(members:List<CustomerFamilyMemberDetailsEntity>){
        viewModelScope.launch (Dispatchers.IO) {
            repository.insertAllCustomerFamilyMember(members)
        }

    }
    //get all Family members
    suspend fun getAllCustomerFamilyMember():List<CustomerFamilyMemberDetailsEntity>?{
        return  repository.getAllCustomerFamilyMember()
    }

    //Delete All

    suspend fun deleteAllCustomerFamilyMembers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCustomer()
        }
    }
}