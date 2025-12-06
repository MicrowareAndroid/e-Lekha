package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTBankDao
import com.psc.elekha.database.entity.MSTBankEntity

class MSTBankRepository(
    private val bankDao: MSTBankDao
) {

    // Insert single bank
    suspend fun insertBank(item: MSTBankEntity) {
        bankDao.insertBank(item)
    }

    // Insert list of banks
    suspend fun insertAllBank(list: List<MSTBankEntity>?) {
        bankDao.insertAllBank(list)
    }

    // Get all banks (IsDeleted = 0)
    suspend fun getAllBank(): List<MSTBankEntity>? {
        return bankDao.getAllBank()
    }

    // Delete all banks
    suspend fun deleteAllBank() {
        bankDao.deleteAllBank()
    }
}
