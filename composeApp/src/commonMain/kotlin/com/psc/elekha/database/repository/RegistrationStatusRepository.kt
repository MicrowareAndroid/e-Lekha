package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.RegistrationStatusDao
import com.psc.elekha.database.entity.RegistrationStatusEntity

class RegistrationStatusRepository(
    private val registrationStatusDao: RegistrationStatusDao
) {

    // Insert single registration status
    suspend fun insertRegistrationStatus(item: RegistrationStatusEntity) {
        registrationStatusDao.insertRegistrationStatus(item)
    }

    // Insert list of registration statuses
    suspend fun insertAllRegistrationStatus(list: List<RegistrationStatusEntity>) {
        registrationStatusDao.insertAllRegistrationStatus(list)
    }

    // Get all registration statuses
    suspend fun getAllRegistrationStatus(): List<RegistrationStatusEntity> {
        return registrationStatusDao.getAllRegistrationStatus()
    }

    // Get RegistrationStatus by ID
    suspend fun getRegistrationStatusByID(registrationStatusID: Int): String {
        return registrationStatusDao.getRegistrationStatusbyID(registrationStatusID)
    }

    // Delete all registration statuses
    suspend fun deleteAllRegistrationStatus() {
        registrationStatusDao.deleteAllRegistrationStatus()
    }
}
