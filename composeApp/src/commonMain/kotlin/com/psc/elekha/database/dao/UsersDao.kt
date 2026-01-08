package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.UsersEntity

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(usersEntity: UsersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUsers(usersEntity: List<UsersEntity>)

    @Query("Select * from Users where lower(UserName)=lower(:userName) and Password=:pwd")
    suspend fun getAllUsers(userName: String, pwd: String): List<UsersEntity>

    @Query("Select ContactNumber from UserContactDetails where lower(UserId)=lower(:userID)")
    suspend fun getUserContact(userID: String): String?

    @Query("Select UserId from Users where lower(UserName)=lower(:userName)")
    suspend fun getUserID(userName: String): String

    @Query("Select Count(*) from Users")
    suspend fun getAllUsersCount(): Int?

    @Query("Select * from Users where lower(UserName)=lower(:UserName) and Password=:Password and IsUserDisabled=0")
    suspend fun getUserDetails(UserName: String, Password: String): List<UsersEntity>

    @Query("Delete from Users")
    suspend fun deleteAllUsers()

}