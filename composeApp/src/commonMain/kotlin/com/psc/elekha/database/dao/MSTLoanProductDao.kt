package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTLoanProductEntity

@Dao
interface MSTLoanProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLoanProduct(mSTLoanProductEntity: MSTLoanProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLoanProduct(mSTLoanProductEntity: List<MSTLoanProductEntity>?)

    @Query("Select * from MSTLoanProduct where  IsDeleted = 0 and IsActive=1 and LoanProductID=:LoanProductID")
    fun getAllLoanProduct(LoanProductID: Int): List<MSTLoanProductEntity>?

    @Query("Select * from MSTLoanProduct where IsDeleted = 0 and IsActive=1 Order By LoanProduct")
    fun getLoanAmount(): List<MSTLoanProductEntity>?

    /*@Query("Select * from MSTLoanProduct where LoanProductID in(25,27,29,31) and IsDeleted = 0 and IsActive=1 Order By LoanProduct")
    fun getLoanAmount(): List<MSTLoanProductEntity>?*/

    @Query("Select * from MSTLoanProduct where LoanProductID in(25,31) and IsDeleted = 0 and IsActive=1 Order By LoanProduct")
    fun getNewLoanAmount(): List<MSTLoanProductEntity>?

    @Query("Select LoanProduct from MSTLoanProduct where LoanProductID=:LoanProductID")
    fun getLoanProductByLoanID(LoanProductID: Int): Double?

    @Query("Delete from MSTLoanProduct")
    fun deleteAllLoanProduct()

}