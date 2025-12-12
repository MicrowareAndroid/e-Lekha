package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.LoanClosureEntity

@Dao
interface LoanClosureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertLoanClouser(loanClosureEntity: LoanClosureEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLoanClouser(loanClosureEntity: List<LoanClosureEntity>)

    @Query("Select * from LoanClouser")
    suspend fun getAllLoanClouser(): List<LoanClosureEntity>

    @Query("Select * from LoanClouser Where IsEdited = 1")
    suspend fun getLoanClouserUploadData(): List<LoanClosureEntity>

    @Query("Select Count(*) from LoanClouser Where IsEdited = 1")
    suspend fun getLoanClouserUploadDataCount(): Int

    @Query("Update LoanClouser set IsEdited=1,IsLoanClosed=1,PaidDate=:PaidDate,LoanLat=:LoanLat,LoanLong=:LoanLong,LoanPlace=:LoanPlace where GUID=:GUID")
    suspend fun updateLoanClouserData(
        PaidDate: String,
        LoanLat: Double,
        LoanLong: Double,
        LoanPlace: String,
        GUID: String
    )

    @Query("Update LoanClouser set IsUploaded=1,IsEdited=0 where IsEdited = 1")
    suspend fun updateLoanClouserDataUploaded(
    )

    @Query("Delete from LoanClouser")
    suspend fun deleteAllLoanClouser()

}