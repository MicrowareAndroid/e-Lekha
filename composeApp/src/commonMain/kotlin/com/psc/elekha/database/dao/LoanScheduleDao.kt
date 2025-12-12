package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.LoanScheduleEntity

@Dao
interface LoanScheduleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLoanSchedule(loanScheduleEntity: LoanScheduleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertAllLoanSchedule(loanScheduleEntity: List<LoanScheduleEntity>)

    @Query("Select * from CustomerLoanSchedule")
    suspend fun getAllLoanSchedule(): List<LoanScheduleEntity>

    @Query("Select * from CustomerLoanSchedule where GUID=:GUID")
    suspend fun getLoanScheduleByGUID(GUID: String): List<LoanScheduleEntity>

    @Query("Select * from CustomerLoanSchedule where GUID=:GUID and PaidDate is NULL")
    suspend  fun getLoanScheduleByGUIDAndPaidDate(GUID: String): List<LoanScheduleEntity>

    /*@Query("Select * from CustomerLoanSchedule where GUID=:GUID and (PaidDate is NULL or length(PaidDate) <= 0) LIMIT 1")
    fun getLoanScheduleByGUIDAndPaidDateWithLimit(GUID: String): List<LoanScheduleEntity>?*/

    @Query("Select * from CustomerLoanSchedule where GUID=:GUID and ReceiptFlag == 0 LIMIT 1")
    suspend fun getLoanScheduleByGUIDAndPaidDateWithLimit(GUID: String): List<LoanScheduleEntity>

    @Query("Select * from CustomerLoanSchedule where GUID=:GUID and ReceiptFlag == 0 LIMIT 4")
    suspend fun getLoanScheduleByGUIDAndPaidDateWithLimit4(GUID: String): List<LoanScheduleEntity>

    @Query("select WorkingDate from CustomerLoanSchedule where GUID=:GUID and CutomerStatusID = 3 and (length(WorkingDate) > 0 or WorkingDate is Not NULL) Order by LoanWeek DESC LIMIT 1")
    suspend fun getWorkingDateByGUID(GUID: String): String?

    @Query("select EMIDueDate from CustomerLoanSchedule where GUID=:GUID order By LoanWeek DESC LIMIT 1")
    suspend fun getEMIDueDateByGUID(GUID: String): String?

    @Query("Select * from CustomerLoanSchedule where GUID=:GUID and (LoanWeek % 4 = 1)")
    suspend fun getLoanScheduleModulus(GUID: String): List<LoanScheduleEntity>

    /*@Query("Select * from CustomerLoanSchedule where GUID=:GUID and (LoanWeek % 4 = 0)")
    fun getLoanScheduleModulus(GUID: String): List<LoanScheduleEntity>?*/

    @Query("Select Count(*) from CustomerLoanSchedule where GUID=:GUID")
    suspend fun getLoanScheduleCountByGUID(GUID: String): Int

    @Query("Delete from CustomerLoanSchedule")
    suspend fun deleteAllLoanSchedule()

    @Query("select max(CustomerLoanID) from CustomerLoanSchedule where GUID =:GUID")
    suspend  fun getMaxCustomerLoanID(GUID: String): Int

    @Query("select PaidDate from CustomerLoanSchedule where GUID =:GUID and CustomerLoanID =:CustomerLoanID")
    suspend fun getCloseDate(GUID: String, CustomerLoanID: Int): String

    /*@Query("Select * from CustomerLoanSchedule where GUID=:GUID and (LoanWeek % 4 = 1) AND substr(EMIDueDate, 7) || \"-\" || substr(EMIDueDate,4,2)  || \"-\" || substr(EMIDueDate, 1,2) <=:sCurrentDate")
    fun getLoanScheduleModulusPay(
        GUID: String,
        sCurrentDate: String
    ): List<LoanScheduleEntity>?*/

    @Query("Select * from CustomerLoanSchedule where GUID=:GUID and (LoanWeek % 4 = 1) AND EMIDueDate<=:sCurrentDate")
    suspend  fun getLoanScheduleModulusPay(
        GUID: String,
        sCurrentDate: String
    ): List<LoanScheduleEntity>

    /*@Query("Select * from CustomerLoanSchedule where GUID=:GUID and (LoanWeek % 4 = 1) AND substr(EMIDueDate, 7) || \"-\" || substr(EMIDueDate,4,2)  || \"-\" || substr(EMIDueDate, 1,2) BETWEEN :sLastPaidDate and :sCurrentDate")
    fun getLoanScheduleModulusPayTwoDate(
        GUID: String,
        sLastPaidDate: String,
        sCurrentDate: String
    ): List<LoanScheduleEntity>?*/

    @Query("Select * from CustomerLoanSchedule where GUID=:GUID and (LoanWeek % 4 = 1) AND EMIDueDate BETWEEN :sLastPaidDate and :sCurrentDate")
    suspend  fun getLoanScheduleModulusPayTwoDate(
        GUID: String,
        sLastPaidDate: String,
        sCurrentDate: String
    ): List<LoanScheduleEntity>

    /*@Query("select max(substr(PaidDate, 7) || \"-\" || substr(PaidDate,4,2)  || \"-\" || substr(PaidDate, 1,2)) as 'PaidDate' from CustomerLoanSchedule where GUID =:GUID and (LoanWeek % 4 = 1)")
    fun getLastPaidDate(
        GUID: String
    ): String*/

    @Query("select max(PaidDate) from CustomerLoanSchedule where GUID =:GUID and (LoanWeek % 4 = 1)")
    suspend fun getLastPaidDate(
        GUID: String
    ): String

    @Query("SELECT sum(EMI) from CustomerLoanSchedule where GUID =:GUID and (length(PaidDate) = 0 OR PaidDate is NULL)")
    suspend fun getUnpaidEMISum(
        GUID: String
    ): Int

    @Query("select max(CustomerLoanID) from CustomerLoanSchedule where GUID=:GUID and CustomerLoanID >(:CustomerLoanID)")
    suspend fun getMaxCustomerLoanIDBYEMI(GUID: String, CustomerLoanID: Int): Int

    @Query("select EMIDueDate from CustomerLoanSchedule where GUID=:GUID and (LoanWeek % 4 = 1) and PaidDate =:PaidDate order By LoanWeek DESC LIMIT 1")
    suspend fun getEMIDueDateByPaidDate(GUID: String, PaidDate: String): String

}