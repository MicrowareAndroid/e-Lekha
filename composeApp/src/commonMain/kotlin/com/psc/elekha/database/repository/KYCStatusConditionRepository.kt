package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.KYCStatusConditionDao
import com.psc.elekha.database.entity.KYCStatusConditionEntity

class KYCStatusConditionRepository(
    private val dao: KYCStatusConditionDao
) {

    suspend fun insertKYCStatusCondition(condition: KYCStatusConditionEntity) {
        dao.insertKYCStatusCondition(condition)
    }

    suspend fun insertAllKYCStatusCondition(conditions: List<KYCStatusConditionEntity>) {
        dao.insertAllKYCStatusCondition(conditions)
    }

    suspend fun getAllKYCStatusCondition(): List<KYCStatusConditionEntity>? {
        return dao.getAllKYCStatusCondition()
    }

    suspend fun deleteAllKYCStatusCondition() {
        dao.deleteAllKYCStatusCondition()
    }
}
