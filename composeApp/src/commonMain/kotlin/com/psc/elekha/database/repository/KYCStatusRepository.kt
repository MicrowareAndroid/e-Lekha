package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.KYCStatusDao
import com.psc.elekha.database.entity.KYCStatusEntity

class KYCStatusRepository(
    private val dao: KYCStatusDao
) {

    suspend fun insertKYCStatus(status: KYCStatusEntity) {
        dao.insertKYCStatus(status)
    }

    suspend fun insertAllKYCStatus(statusList: List<KYCStatusEntity>) {
        dao.insertAllKYCStatus(statusList)
    }

    suspend fun getAllKYCStatus(): List<KYCStatusEntity> {
        return dao.getAllKYCStatus()
    }

    suspend fun deleteAllKYCStatus() {
        dao.deleteAllKYCStatus()
    }
}
