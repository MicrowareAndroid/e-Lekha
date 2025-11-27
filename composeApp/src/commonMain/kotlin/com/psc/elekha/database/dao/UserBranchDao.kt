package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.UserBranchEntity

@Dao
interface UserBranchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserBranch(userBranchEntity: UserBranchEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUserBranch(userBranchEntity: List<UserBranchEntity>?)

    @Query("Select * from UserBranch")
    fun getAllUserBranch(): List<UserBranchEntity>?

    @Query("Select BranchID from UserBranch where UserID=:UserID")
    fun getBranchIDbyUser(UserID: String): Int?

    @Query("Delete from UserBranch")
    fun deleteAllUserBranch()

}