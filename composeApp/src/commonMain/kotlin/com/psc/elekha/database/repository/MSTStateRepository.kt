package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTStateDao
import com.psc.elekha.database.entity.MSTStateEntity

class MSTStateRepository(
    private val stateDao: MSTStateDao
) {

    // Insert single state
    suspend fun insertState(item: MSTStateEntity) {
        stateDao.insertState(item)
    }

    // Insert list of states
    suspend fun insertAllState(list: List<MSTStateEntity>?) {
        stateDao.insertAllState(list)
    }

    // Get all states
    suspend fun getAllState(): List<MSTStateEntity>? {
        return stateDao.getAllState()
    }

    // Delete all states
    suspend fun deleteAllState() {
        stateDao.deleteAllState()
    }
}
