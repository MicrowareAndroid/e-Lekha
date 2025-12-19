package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.ImageDetailDao
import com.psc.elekha.database.dao.UserContactDetailDao
import com.psc.elekha.database.entity.ImageDetailEntity
import com.psc.elekha.database.entity.UserContactDetailEntity

class UserContactDetailRepository(
    private val dao: UserContactDetailDao
) {

    suspend fun insertUserContactDetail(user: UserContactDetailEntity) {
        dao.insertUserContactDetail(user)
    }


    suspend fun insertAllUserContactDetail(users: List<UserContactDetailEntity>) {
        dao.insertAllUserContactDetail(users)
    }

    suspend fun deleteAllUserContactDetail() {
        dao.deleteAllUserContactDetail()
    }
}
