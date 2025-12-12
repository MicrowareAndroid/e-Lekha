package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTCenterDao
import com.psc.elekha.database.entity.MSTCenterEntity

class MSTCenterRepository(
    private val centerDao: MSTCenterDao
) {

    // Insert single center
    suspend fun insertCenter(item: MSTCenterEntity) {
        centerDao.insertCenter(item)
    }

    // Insert list of centers
    suspend fun insertAllCenter(list: List<MSTCenterEntity>) {
        centerDao.insertAllCenter(list)
    }

    // Get all centers
    suspend fun getAllCenter(): List<MSTCenterEntity> {
        return centerDao.getAllCenter()
    }

    // Delete all centers
    suspend fun deleteAllCenter() {
        centerDao.deleteAllCenter()
    }
}
