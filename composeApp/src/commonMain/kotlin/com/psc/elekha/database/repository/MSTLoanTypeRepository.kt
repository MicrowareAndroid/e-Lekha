package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTLoanTypeDao
import com.psc.elekha.database.entity.MSTLoanTypeEntity

class MSTLoanTypeRepository(
    private val loanTypeDao: MSTLoanTypeDao
) {

    // Insert single loan type
    suspend fun insertLoanType(item: MSTLoanTypeEntity) {
        loanTypeDao.insertLoanType(item)
    }

    // Insert list of loan types
    suspend fun insertAllLoanType(list: List<MSTLoanTypeEntity>) {
        loanTypeDao.insertAllLoanType(list)
    }

    // Get all loan types
    suspend fun getAllLoanType(): List<MSTLoanTypeEntity> {
        return loanTypeDao.getAllLoanType()
    }

    // Delete all loan types
    suspend fun deleteAllLoanType() {
        loanTypeDao.deleteAllLoanType()
    }
}
