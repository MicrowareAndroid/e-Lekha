package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.CustomerTransactionDataEntity

@Dao
interface CustomerTransactionDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomerTransactionData(customerTransactionDataEntity: CustomerTransactionDataEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCustomerTransactionData(customerTransactionDataEntity: List<CustomerTransactionDataEntity>?)

    @Query("Delete from CustomerTransactionData")
    suspend fun deleteAllCustomerTransactionData()

    @Query("Select * from CustomerTransactionData where IsDeleted=0 and IsEdited=1")
    suspend fun getAllCustomerTransactionDataUpload(): List<CustomerTransactionDataEntity>?

    @Query("Select * from CustomerTransactionData where IsDeleted=0 and GUID=:GUID order by date(TransactionOn) DESC")
    suspend fun getAllCustomerTransactionData(GUID: String): List<CustomerTransactionDataEntity>?

    @Query("Select Count(*) from CustomerTransactionData where IsDeleted=0 and GUID=:GUID")
    suspend fun getAllCustomerTransactionDataCount(GUID: String): Int

    @Query("Select Count(*) from CustomerTransactionData where IsDeleted=0 and IsEdited=1")
    suspend fun getAllCustomerTransactionDataCount(): Int

    @Query("Select * from CustomerTransactionData where IsDeleted=0 and MerchantTransactionID=:MerchantTransactionID and GUID=:GUID")
    suspend fun getDatabyMerchantTransID(
        MerchantTransactionID: String,
        GUID: String
    ): CustomerTransactionDataEntity

    @Query("Update CustomerTransactionData set IsEdited=0, IsUpload=1 where IsEdited=1 and IsDeleted=0")
    suspend fun updateUploaded()
}