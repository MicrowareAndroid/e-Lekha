package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.UserResponseEntity

@Dao
interface UserResponseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertUsers(userResponseEntity: UserResponseEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUsers(userResponseEntity: List<UserResponseEntity>)

    @Query("Select * from UserResponse")
    suspend fun getAllUsers(): List<UserResponseEntity>

    @Query("Select Count(*) from UserResponse")
    suspend fun getAllUsersCount(): Int?

    @Query("Select * from UserResponse where Contact=:Contact and IsDeleted=0")
    suspend  fun getUserDetails(Contact: String): List<UserResponseEntity>

    @Query("Delete from UserResponse")
    suspend  fun deleteAllUsers()

}