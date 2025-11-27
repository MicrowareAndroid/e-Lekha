package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTLoanOfficerEntity

@Dao
interface MSTLoanOfficerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLoanOfficer(mSTLoanOfficerEntity: MSTLoanOfficerEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLoanOfficer(mSTLoanOfficerEntity: List<MSTLoanOfficerEntity>?)

    @Query("Select * from MSTLoanOfficer")
    fun getAllLoanOfficer(): List<MSTLoanOfficerEntity>?

    @Query("Delete from MSTLoanOfficer")
    fun deleteAllLoanOfficer()

}