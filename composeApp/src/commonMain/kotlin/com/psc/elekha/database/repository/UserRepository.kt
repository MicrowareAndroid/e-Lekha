package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.UserDao
import com.psc.elekha.database.entity.UserEntity

class UserRepository(private val userDao: UserDao) {

    suspend fun getAllUser(): List<UserEntity>{
        return userDao.getAllUser()
    }

    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }

}