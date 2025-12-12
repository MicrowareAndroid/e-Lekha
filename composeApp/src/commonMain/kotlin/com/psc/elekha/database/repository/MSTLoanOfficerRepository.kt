package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTLoanOfficerDao
import com.psc.elekha.database.entity.MSTLoanOfficerEntity

class MSTLoanOfficerRepository(
    private val loanOfficerDao: MSTLoanOfficerDao
) {

    // Insert single loan officer
    suspend fun insertLoanOfficer(item: MSTLoanOfficerEntity) {
        loanOfficerDao.insertLoanOfficer(item)
    }

    // Insert list of loan officers
    suspend fun insertAllLoanOfficer(list: List<MSTLoanOfficerEntity>) {
        loanOfficerDao.insertAllLoanOfficer(list)
    }

    // Get all loan officers
    suspend fun getAllLoanOfficer(): List<MSTLoanOfficerEntity> {
        return loanOfficerDao.getAllLoanOfficer()
    }

    // Delete all loan officers
    suspend fun deleteAllLoanOfficer() {
        loanOfficerDao.deleteAllLoanOfficer()
    }
}
