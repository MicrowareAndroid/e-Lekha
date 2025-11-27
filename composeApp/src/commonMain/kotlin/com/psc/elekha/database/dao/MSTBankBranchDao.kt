package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTBankBranchEntity

@Dao
interface MSTBankBranchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBankBranch(mSTBankBranchEntity: MSTBankBranchEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllBankBranch(mSTBankBranchEntity: List<MSTBankBranchEntity>?)

    @Query("Select * from MSTBankBranch")
    fun getAllBankBranch(): List<MSTBankBranchEntity>?

    @Query("select * from MSTBankBranch where BankID =:BankID order by BranchName")
    fun getBankBranchByBankID(BankID: Int): List<MSTBankBranchEntity>?

    @Query("select IFSCCode from MSTBankBranch where BankID=:BankID and BranchID=:BranchID")
    fun getIFSCCode(BankID: Int,BranchID:Int): String

    @Query("select BranchID from MSTBankBranch where BankID=:BankID and IFSCCode=:IFSCCode")
    fun getBranchID(BankID: Int,IFSCCode:String): Int

    @Query("Delete from MSTBankBranch")
    fun deleteAllBankBranch()

}