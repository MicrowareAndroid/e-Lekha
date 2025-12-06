package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.UserResponseDao
import com.psc.elekha.database.entity.UserResponseEntity

class UserResponseRepository(
    private val userResponseDao: UserResponseDao
) {

    // Insert single user
    suspend fun insertUser(item: UserResponseEntity) {
        userResponseDao.insertUsers(item)
    }

    // Insert list of users
    suspend fun insertAllUsers(list: List<UserResponseEntity>?) {
        userResponseDao.insertAllUsers(list)
    }

    // Get all users
    suspend fun getAllUsers(): List<UserResponseEntity>? {
        return userResponseDao.getAllUsers()
    }

    // Get total users count
    suspend fun getAllUsersCount(): Int? {
        return userResponseDao.getAllUsersCount()
    }

    // Get user details by contact
    suspend fun getUserDetails(contact: String): List<UserResponseEntity>? {
        return userResponseDao.getUserDetails(contact)
    }

    // Delete all users
    suspend fun deleteAllUsers() {
        userResponseDao.deleteAllUsers()
    }
}
