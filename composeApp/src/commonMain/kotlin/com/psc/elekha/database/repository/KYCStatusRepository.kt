package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.KYCStatusDao
import com.psc.elekha.database.entity.KYCStatusEntity

class KYCStatusRepository(
    private val dao: KYCStatusDao
) {

    fun insertKYCStatus(status: KYCStatusEntity) {
        dao.insertKYCStatus(status)
    }

    fun insertAllKYCStatus(statusList: List<KYCStatusEntity>) {
        dao.insertAllKYCStatus(statusList)
    }

    fun getAllKYCStatus(): List<KYCStatusEntity>? {
        return dao.getAllKYCStatus()
    }

    fun deleteAllKYCStatus() {
        dao.deleteAllKYCStatus()
    }
}
