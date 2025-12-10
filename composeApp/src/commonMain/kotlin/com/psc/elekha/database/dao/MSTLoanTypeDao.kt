package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTLoanTypeEntity

@Dao
interface MSTLoanTypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertLoanType(mSTLoanTypeEntity: MSTLoanTypeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertAllLoanType(mSTLoanTypeEntity: List<MSTLoanTypeEntity>?)

    @Query("Select * from MSTLoanType")
    suspend  fun getAllLoanType(): List<MSTLoanTypeEntity>?

    @Query("Delete from MSTLoanType")
    suspend fun deleteAllLoanType()

}