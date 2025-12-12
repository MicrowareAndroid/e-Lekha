package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.CustomerStatusEntity

@Dao
interface CustomerStatusDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomerStatus(customerStatusEntity: CustomerStatusEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCustomerStatus(customerStatusEntity: List<CustomerStatusEntity>)

    @Query("Select * from CustomerStatus")
    suspend  fun getAllCustomerStatus(): List<CustomerStatusEntity>

    @Query("Select CustomerStatus from CustomerStatus where CustomerStatusID=:CustomerStatusID and IsDeleted= 0")
    suspend fun getCustomerStatus(CustomerStatusID: Int): String?

    @Query("Select * from CustomerStatus where CustomerStatusID In (2,3) and IsDeleted= 0")
    suspend fun getCustomerStatusData(): List<CustomerStatusEntity>

    @Query("Delete from CustomerStatus")
    suspend  fun deleteAllCustomerStatus()

}