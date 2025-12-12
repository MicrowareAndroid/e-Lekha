package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.UsersEntity

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertUsers(usersEntity: UsersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertAllUsers(usersEntity: List<UsersEntity>)

    @Query("Select * from Users")
    suspend fun getAllUsers(): List<UsersEntity>

    @Query("Select Count(*) from Users")
    suspend  fun getAllUsersCount(): Int?

    @Query("Select * from Users where UserName=:UserName and Password=:Password and IsUserDisabled=0")
    suspend fun getUserDetails(UserName: String, Password: String): List<UsersEntity>

    @Query("Delete from Users")
    suspend fun deleteAllUsers()

}