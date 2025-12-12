package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTBankBranchDao
import com.psc.elekha.database.entity.MSTBankBranchEntity

class MSTBankBranchRepository(
    private val bankBranchDao: MSTBankBranchDao
) {

    // Insert single branch
    suspend fun insertBankBranch(item: MSTBankBranchEntity) {
        bankBranchDao.insertBankBranch(item)
    }

    // Insert list
    suspend fun insertAllBankBranch(list: List<MSTBankBranchEntity>) {
        bankBranchDao.insertAllBankBranch(list)
    }

    // Get all branches
    suspend fun getAllBankBranch(): List<MSTBankBranchEntity> {
        return bankBranchDao.getAllBankBranch()
    }

    // Get branches by BankID
    suspend fun getBankBranchByBankID(BankID: Int): List<MSTBankBranchEntity> {
        return bankBranchDao.getBankBranchByBankID(BankID)
    }

    // Get IFSC Code
    suspend fun getIFSCCode(BankID: Int, BranchID: Int): String {
        return bankBranchDao.getIFSCCode(BankID, BranchID)
    }

    // Get BranchID using IFSC
    suspend fun getBranchID(BankID: Int, IFSCCode: String): Int {
        return bankBranchDao.getBranchID(BankID, IFSCCode)
    }

    // Delete all branch records
    suspend fun deleteAllBankBranch() {
        bankBranchDao.deleteAllBankBranch()
    }
}
