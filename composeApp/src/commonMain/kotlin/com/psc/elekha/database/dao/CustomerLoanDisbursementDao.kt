package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.model.CustomerLoanDataClass
import com.psc.elekha.database.entity.CustomerLoanDisbursementEntity

@Dao
interface CustomerLoanDisbursementDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLoanDisbursement(customerLoanDisbursementEntity: CustomerLoanDisbursementEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLoanDisbursement(customerLoanDisbursementEntity: List<CustomerLoanDisbursementEntity>?)

    @Query("Select * from CustomerLoanDisbursement where IsDeleted = 0")
    suspend fun getAllLoanDisbursement(): List<CustomerLoanDisbursementEntity>?

    @Query("select A.*,B.CutomerStatusID from CustomerLoanDisbursement A INNER join CustomerLoanSchedule B on A.GUID=B.GUID Where B.CutomerStatusID IN (2,3) and A.IsDeleted = 0 GROUP by A.GUID ORDER by B.CutomerStatusID")
    suspend fun getLoanDisbursementData(): List<CustomerLoanDataClass>?

    @Query("select A.*,B.CutomerStatusID from CustomerLoanDisbursement A INNER join CustomerLoanSchedule B on A.GUID=B.GUID Where B.CutomerStatusID=:CutomerStatusID and A.IsDeleted = 0 GROUP by A.GUID")
    suspend fun getLoanDisbursementDataByStatus(CutomerStatusID: Int): List<CustomerLoanDataClass>?

    @Query("Delete from CustomerLoanDisbursement")
    suspend fun deleteAllLoanDisbursement()

}