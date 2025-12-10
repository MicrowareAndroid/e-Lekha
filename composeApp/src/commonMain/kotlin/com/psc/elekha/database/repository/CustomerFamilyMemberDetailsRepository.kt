package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.CustomerFamilyMemberDetailsDao
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity

class CustomerFamilyMemberDetailsRepository (
    private val dao: CustomerFamilyMemberDetailsDao
){
     //Insert Single Family member
     suspend fun insertCustomerFamilyMember(member: CustomerFamilyMemberDetailsEntity){
        dao.insertCustomerFamilyMember(member)
    }
    //Insert List of Family members
    suspend fun insertAllCustomerFamilyMember(members:List<CustomerFamilyMemberDetailsEntity>){
        dao.insertAllCustomerFamilyMember(members)
    }
    //Get All Family Members
    suspend fun getAllCustomerFamilyMember():List<CustomerFamilyMemberDetailsEntity>?{
        return dao.getAllCustomerFamilyMember()
    }
    suspend fun deleteAllCustomer(){
        dao.deleteAllCustomerFamilyMember()
    }
}