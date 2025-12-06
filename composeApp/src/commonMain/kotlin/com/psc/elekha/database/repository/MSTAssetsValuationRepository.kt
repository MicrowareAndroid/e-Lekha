package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTAssetsValuationDao
import com.psc.elekha.database.entity.MSTAssetsValuationEntity

class MSTAssetsValuationRepository(
    private val assetsValuationDao: MSTAssetsValuationDao
) {

    // Insert single ite
    suspend fun insertAssetsValuation(item: MSTAssetsValuationEntity) {
        assetsValuationDao.insertAssetsValuation(item)
    }

    // Insert list
    suspend fun insertAllAssetsValuation(list: List<MSTAssetsValuationEntity>?) {
        assetsValuationDao.insertAllAssetsValuation(list)
    }

    // Get all records
    suspend fun getAllAssetsValuation(): List<MSTAssetsValuationEntity>? {
        return assetsValuationDao.getAllAssetsValuation()
    }

    // Delete all
    suspend fun deleteAllAssetsValuation() {
        assetsValuationDao.deleteAllAssetsValuation()
    }
}
