package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.KYCStatusConditionDao
import com.psc.elekha.database.entity.KYCStatusConditionEntity

class KYCStatusConditionRepository(
    private val dao: KYCStatusConditionDao
) {

    fun insertKYCStatusCondition(condition: KYCStatusConditionEntity) {
        dao.insertKYCStatusCondition(condition)
    }

    fun insertAllKYCStatusCondition(conditions: List<KYCStatusConditionEntity>) {
        dao.insertAllKYCStatusCondition(conditions)
    }

    fun getAllKYCStatusCondition(): List<KYCStatusConditionEntity>? {
        return dao.getAllKYCStatusCondition()
    }

    fun deleteAllKYCStatusCondition() {
        dao.deleteAllKYCStatusCondition()
    }
}
