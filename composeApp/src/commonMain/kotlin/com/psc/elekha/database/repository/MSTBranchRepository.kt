package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTBranchDao
import com.psc.elekha.database.entity.MSTBranchEntity

class MSTBranchRepository(
    private val branchDao: MSTBranchDao
) {

    // Insert single branch
    suspend fun insertBranch(item: MSTBranchEntity) {
        branchDao.insertBranch(item)
    }

    // Insert list of branches
    suspend fun insertAllBranch(list: List<MSTBranchEntity>) {
        branchDao.insertAllBranch(list)
    }

    // Get all branches
    suspend fun getAllBranch(): List<MSTBranchEntity> {
        return branchDao.getAllBranch()
    }

    // Delete all branches
    suspend fun deleteAllBranch() {
        branchDao.deleteAllBranch()
    }
}
