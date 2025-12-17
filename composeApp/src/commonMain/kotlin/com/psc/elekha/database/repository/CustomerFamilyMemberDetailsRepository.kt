package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.CustomerFamilyMemberDetailsDao
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class CustomerFamilyMemberDetailsRepository(
    private val dao: CustomerFamilyMemberDetailsDao
) {

    suspend fun insertCustomerFamilyMember(member: CustomerFamilyMemberDetailsEntity) {
        dao.insertCustomerFamilyMember(member)
    }

    suspend fun insertAllCustomerFamilyMember(members: List<CustomerFamilyMemberDetailsEntity>) {
        dao.insertAllCustomerFamilyMember(members)
    }

    suspend fun getAllCustomerFamilyMember(): List<CustomerFamilyMemberDetailsEntity> {
        return dao.getAllCustomerFamilyMember()
    }

    suspend fun deleteAllCustomer() {
        dao.deleteAllCustomerFamilyMember()
    }

    //  UPDATE — repository only delegates
    suspend fun updateCustomerFamilyMemberByGuid(
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
        dao.updateCustomerFamilyMemberByGuid(
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

