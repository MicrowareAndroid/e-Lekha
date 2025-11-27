package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTBranchEntity

@Dao
interface MSTBranchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBranch(mSTBranchEntity: MSTBranchEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllBranch(mSTBranchEntity: List<MSTBranchEntity>?)

    @Query("Select * from MSTBranch")
    fun getAllBranch(): List<MSTBranchEntity>?

    @Query("Delete from MSTBranch")
    fun deleteAllBranch()

}