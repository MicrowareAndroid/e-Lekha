package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.CustomerExistingLoanDetailEntity

@Dao
interface CustomerExistingLoanDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCustomerExistingLoan(customerExistingLoanDetailEntity: CustomerExistingLoanDetailEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCustomerExistingLoan(customerExistingLoanDetailEntity: List<CustomerExistingLoanDetailEntity>?)

    @Query("select a.* from CustomerExistingLoanDetail a left join Customer b on a.GUID = b.GUID where b.CutomerStatusID = 1 and a.GUID =:GUID")
    fun getAllCustomerExistingLoan(GUID: String): List<CustomerExistingLoanDetailEntity>?

    @Query("Delete from CustomerExistingLoanDetail")
    fun deleteAllCustomerExistingLoan()

    @Query("Select Count(*) from CustomerExistingLoanDetail where GUID=:GUID and length(LoanAmount) > 0")
    fun getMyLoanCount(GUID: String): Int?

    @Query("Update CustomerExistingLoanDetail set LoanAmount=:LoanAmount, LoanPurposeID=:LoanPurposeID where GUID=:GUID")
    fun updateMyLoan(
        LoanAmount: Int,
        LoanPurposeID: Int,
        GUID: String
    )

    @Query("Update CustomerExistingLoanDetail set LoanAmount=:LoanAmount, LoanPurposeID=:LoanPurposeID, MFIID=:MFIID, OutStandingAmount=:OutStandingAmount, MemberName=:MemberName, EMI=:EMI,IsEdited=:IsEdited where MFIGUID=:MFIGUID and GUID=:GUID")
    fun updateMFI(
        LoanAmount: Int,
        LoanPurposeID: Int,
        MFIID: Int,
        OutStandingAmount: Int,
        MemberName: String,
        EMI: Int,
        IsEdited: Int,
        MFIGUID: String,
        GUID: String
    )

    @Query("Select * from CustomerExistingLoanDetail where IsDeleted=0 and IsEdited=1")
    fun getAllCustomerExistingLoanUpload(): List<CustomerExistingLoanDetailEntity>?

    @Query("Update CustomerExistingLoanDetail set IsEdited=0, IsUpload=1 where IsEdited=1 and IsDeleted=0")
    fun updateUploaded()

    @Query("Select IsUpload from CustomerExistingLoanDetail where MFIGUID=:GUID")
    fun getIsUploaded(GUID: String): Int?

    @Query("Select Count(*) from CustomerExistingLoanDetail where IsDeleted=0 and IsEdited=1")
    fun getAllCustomerExistingLoanUploadCount(): Int
}