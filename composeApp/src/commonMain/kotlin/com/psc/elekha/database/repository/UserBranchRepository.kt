package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.UserBranchDao
import com.psc.elekha.database.entity.UserBranchEntity

class UserBranchRepository(
    private val userBranchDao: UserBranchDao
) {

    // Insert single user branch
    suspend fun insertUserBranch(item: UserBranchEntity) {
        userBranchDao.insertUserBranch(item)
    }

    // Insert list of user branches
    suspend fun insertAllUserBranch(list: List<UserBranchEntity>?) {
        userBranchDao.insertAllUserBranch(list)
    }

    // Get all user branches
    suspend fun getAllUserBranch(): List<UserBranchEntity>? {
        return userBranchDao.getAllUserBranch()
    }

    // Get BranchID by UserID
    suspend fun getBranchIDByUser(userID: String): Int? {
        return userBranchDao.getBranchIDbyUser(userID)
    }

    // Delete all user branches
    suspend fun deleteAllUserBranch() {
        userBranchDao.deleteAllUserBranch()
    }
}
