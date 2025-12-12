package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTBranchEntity

@Dao
interface MSTBranchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBranch(mSTBranchEntity: MSTBranchEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertAllBranch(mSTBranchEntity: List<MSTBranchEntity>)

    @Query("Select * from MSTBranch")
    suspend fun getAllBranch(): List<MSTBranchEntity>

    @Query("Delete from MSTBranch")
    suspend  fun deleteAllBranch()

}