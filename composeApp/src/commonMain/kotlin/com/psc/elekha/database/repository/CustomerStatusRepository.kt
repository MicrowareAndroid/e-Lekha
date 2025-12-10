package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.CustomerStatusDao
import com.psc.elekha.database.entity.CustomerStatusEntity

class CustomerStatusRepository(
    private val dao: CustomerStatusDao
) {

    // Insert single customer status
    suspend fun insertCustomerStatus(status: CustomerStatusEntity) {
        dao.insertCustomerStatus(status)
    }

    // Insert list of customer status
    suspend fun insertAllCustomerStatus(statusList: List<CustomerStatusEntity>) {
        dao.insertAllCustomerStatus(statusList)
    }

    // Get all customer statuses
    suspend fun getAllCustomerStatus(): List<CustomerStatusEntity>? {
        return dao.getAllCustomerStatus()
    }

    // Get customer status name by ID
    suspend  fun getCustomerStatus(customerStatusId: Int): String? {
        return dao.getCustomerStatus(customerStatusId)
    }

    // Get statuses where ID in (2,3) and IsDeleted = 0
    suspend fun getCustomerStatusData(): List<CustomerStatusEntity>? {
        return dao.getCustomerStatusData()
    }

    // Delete all customer status
    suspend fun deleteAllCustomerStatus() {
        dao.deleteAllCustomerStatus()
    }
}
