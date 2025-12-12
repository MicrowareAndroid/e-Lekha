package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTPovertyStatusDao
import com.psc.elekha.database.entity.MSTPovertyStatusEntity

class MSTPovertyStatusRepository(
    private val povertyStatusDao: MSTPovertyStatusDao
) {

    // Insert single poverty status record
    suspend fun insertPovertyStatus(item: MSTPovertyStatusEntity) {
        povertyStatusDao.insertPovertyStatus(item)
    }

    // Insert list of poverty status records
    suspend fun insertAllPovertyStatus(list: List<MSTPovertyStatusEntity>) {
        povertyStatusDao.insertAllPovertyStatus(list)
    }

    // Get all poverty status records
    suspend fun getAllPovertyStatus(): List<MSTPovertyStatusEntity> {
        return povertyStatusDao.getAllPovertyStatus()
    }

    // Delete all poverty status records
    suspend fun deleteAllPovertyStatus() {
        povertyStatusDao.deleteAllPovertyStatus()
    }
}
