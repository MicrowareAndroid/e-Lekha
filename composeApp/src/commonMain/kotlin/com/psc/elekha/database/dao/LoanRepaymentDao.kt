package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.LoanRepaymentEntity

@Dao
interface LoanRepaymentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLoanRepayment(loanRepaymentEntity: LoanRepaymentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLoanRepayment(loanRepaymentEntity: List<LoanRepaymentEntity>?)

    @Query("Select * from LoanRepayment")
    fun getAllLoanRepayment(): List<LoanRepaymentEntity>?

    @Query("Select * from LoanRepayment where GUID=:GUID")
    fun getLoanRepaymentByGUID(GUID: String): LoanRepaymentEntity?

    @Query("Select * from LoanRepayment Where IsEdited = 1")
    fun getLoanRepaymentUploadData(): List<LoanRepaymentEntity>?

    @Query("Select Count(*) from LoanRepayment Where IsEdited = 1")
    fun getLoanRepaymentUploadDataCount(): Int

    @Query("Update LoanRepayment set IsEdited=1,Total=:Total,PaidDate=:PaidDate,LoanLat=:LoanLat,LoanLong=:LoanLong,LoanPlace=:LoanPlace,PaymentType=:PaymentType where GUID=:GUID")
    fun updateLoanRepaymentData(
        Total: Double,
        PaidDate: String,
        LoanLat: Double,
        LoanLong: Double,
        LoanPlace: String,
        PaymentType: Int,
        GUID: String
    )

    @Query("Update LoanRepayment set IsUploaded=1,IsEdited=0 where IsEdited = 1")
    fun updateLoanRepaymentDataUploaded()

    @Query("Delete from LoanRepayment")
    fun deleteAllLoanRepayment()

}