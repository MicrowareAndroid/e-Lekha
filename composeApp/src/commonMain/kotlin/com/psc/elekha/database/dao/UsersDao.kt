package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.UsersEntity

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(usersEntity: UsersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(usersEntity: List<UsersEntity>?)

    @Query("Select * from Users")
    fun getAllUsers(): List<UsersEntity>?

    @Query("Select Count(*) from Users")
    fun getAllUsersCount(): Int?

    @Query("Select * from Users where UserName=:UserName and Password=:Password and IsUserDisabled=0")
    fun getUserDetails(UserName: String, Password: String): List<UsersEntity>?

    @Query("Delete from Users")
    fun deleteAllUsers()

}