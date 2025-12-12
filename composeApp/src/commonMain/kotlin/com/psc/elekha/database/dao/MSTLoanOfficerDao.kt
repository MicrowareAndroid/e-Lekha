package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTLoanOfficerEntity

@Dao
interface MSTLoanOfficerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLoanOfficer(mSTLoanOfficerEntity: MSTLoanOfficerEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertAllLoanOfficer(mSTLoanOfficerEntity: List<MSTLoanOfficerEntity>)

    @Query("Select * from MSTLoanOfficer")
    suspend fun getAllLoanOfficer(): List<MSTLoanOfficerEntity>

    @Query("Delete from MSTLoanOfficer")
    suspend  fun deleteAllLoanOfficer()

}