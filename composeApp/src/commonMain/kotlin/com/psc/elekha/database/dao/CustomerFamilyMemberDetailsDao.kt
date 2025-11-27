package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity

@Dao
interface CustomerFamilyMemberDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCustomerFamilyMember(customerFamilyMemberDetailsEntity: CustomerFamilyMemberDetailsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCustomerFamilyMember(customerFamilyMemberDetailsEntity: List<CustomerFamilyMemberDetailsEntity>?)

    @Query("Select * from CustomerFamilyMemberDetails")
    fun getAllCustomerFamilyMember(): List<CustomerFamilyMemberDetailsEntity>?

    @Query("Delete from CustomerFamilyMemberDetails")
    fun deleteAllCustomerFamilyMember()

}