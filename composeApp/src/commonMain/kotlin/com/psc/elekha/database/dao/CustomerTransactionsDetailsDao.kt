package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.CustomerTransactionsDetailsEntity

@Dao
interface CustomerTransactionsDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCustomerTransactionData(customerTransactionsDetailsEntity: CustomerTransactionsDetailsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCustomerTransactionData(customerTransactionsDetailsEntity: List<CustomerTransactionsDetailsEntity>?)

    @Query("Delete from CustomerTransactionsDetails")
    fun deleteAllCustomerTransactionData()

    @Query("Select * from CustomerTransactionsDetails where CustomerGUID=:GUID order by date(trans_date) DESC")
    fun getAllCustomerTransactionData(GUID: String): List<CustomerTransactionsDetailsEntity>?

    @Query("Select Count(*) from CustomerTransactionsDetails where CustomerGUID=:GUID")
    fun getAllCustomerTransactionDataCount(GUID: String): Int
}