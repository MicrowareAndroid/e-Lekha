package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.UserBranchEntity

@Dao
interface UserBranchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertUserBranch(userBranchEntity: UserBranchEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertAllUserBranch(userBranchEntity: List<UserBranchEntity>?)

    @Query("Select * from UserBranch")
    suspend fun getAllUserBranch(): List<UserBranchEntity>?

    @Query("Select BranchID from UserBranch where UserID=:UserID")
    suspend  fun getBranchIDbyUser(UserID: String): Int?

    @Query("Delete from UserBranch")
    suspend fun deleteAllUserBranch()

}