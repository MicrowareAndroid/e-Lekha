package com.psc.elekha.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.psc.elekha.database.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    suspend fun getAllUser(): List<UserEntity>

    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()

}