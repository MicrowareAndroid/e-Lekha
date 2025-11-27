package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTMFILoanProductEntity

@Dao
interface MSTMFILoanProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMFILoanProduct(mSTMFILoanProductEntity: MSTMFILoanProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMFILoanProduct(mSTMFILoanProductEntity: List<MSTMFILoanProductEntity>?)

    @Query("Select * from mstMFILoanProduct")
    fun getAllMFILoanProduct(): List<MSTMFILoanProductEntity>?

    @Query("Select * from mstMFILoanProduct where MFIID=:MFIID")
    fun getMFILoanProductBYMFIID(MFIID: Int): List<MSTMFILoanProductEntity>?

    @Query("Select LoanProductAmount from mstMFILoanProduct where MFILoanProductID=:MFILoanProductID")
    fun getLoanProductAmount(MFILoanProductID: Int): Int?

    @Query("Delete from mstMFILoanProduct")
    fun deleteAllMFILoanProduct()

}