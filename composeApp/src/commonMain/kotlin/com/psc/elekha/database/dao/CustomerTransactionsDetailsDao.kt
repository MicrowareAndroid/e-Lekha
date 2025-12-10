package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.CustomerTransactionsDetailsEntity

@Dao
interface CustomerTransactionsDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomerTransactionData(customerTransactionsDetailsEntity: CustomerTransactionsDetailsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCustomerTransactionData(customerTransactionsDetailsEntity: List<CustomerTransactionsDetailsEntity>?)

    @Query("Delete from CustomerTransactionsDetails")
    suspend fun deleteAllCustomerTransactionData()

    @Query("Select * from CustomerTransactionsDetails where CustomerGUID=:GUID order by date(trans_date) DESC")
    suspend fun getAllCustomerTransactionData(GUID: String): List<CustomerTransactionsDetailsEntity>?

    @Query("Select Count(*) from CustomerTransactionsDetails where CustomerGUID=:GUID")
    suspend fun getAllCustomerTransactionDataCount(GUID: String): Int
}