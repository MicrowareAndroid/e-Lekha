package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.UsersDao
import com.psc.elekha.database.entity.UsersEntity

class UsersRepository(
    private val usersDao: UsersDao
) {

    // Insert single user
    suspend fun insertUser(item: UsersEntity) {
        usersDao.insertUsers(item)
    }

    // Insert list of users
    suspend fun insertAllUsers(list: List<UsersEntity>?) {
        usersDao.insertAllUsers(list)
    }

    // Get all users
    suspend fun getAllUsers(): List<UsersEntity>? {
        return usersDao.getAllUsers()
    }

    // Get total users count
    suspend fun getAllUsersCount(): Int? {
        return usersDao.getAllUsersCount()
    }

    // Get user details by username and password
    suspend fun getUserDetails(userName: String, password: String): List<UsersEntity>? {
        return usersDao.getUserDetails(userName, password)
    }

    // Delete all users
    suspend fun deleteAllUsers() {
        usersDao.deleteAllUsers()
    }
}
