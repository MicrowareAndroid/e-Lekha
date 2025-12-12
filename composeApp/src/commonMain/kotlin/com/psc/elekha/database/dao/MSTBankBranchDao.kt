package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTBankBranchEntity

@Dao
interface MSTBankBranchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBankBranch(mSTBankBranchEntity: MSTBankBranchEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBankBranch(mSTBankBranchEntity: List<MSTBankBranchEntity>)

    @Query("Select * from MSTBankBranch")
    suspend fun getAllBankBranch(): List<MSTBankBranchEntity>

    @Query("select * from MSTBankBranch where BankID =:BankID order by BranchName")
    suspend fun getBankBranchByBankID(BankID: Int): List<MSTBankBranchEntity>

    @Query("select IFSCCode from MSTBankBranch where BankID=:BankID and BranchID=:BranchID")
    suspend  fun getIFSCCode(BankID: Int,BranchID:Int): String

    @Query("select BranchID from MSTBankBranch where BankID=:BankID and IFSCCode=:IFSCCode")
    suspend fun getBranchID(BankID: Int,IFSCCode:String): Int

    @Query("Delete from MSTBankBranch")
    suspend  fun deleteAllBankBranch()

}