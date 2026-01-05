package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.CustomerEntity
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity

@Dao
interface CustomerFamilyMemberDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomerFamilyMember(customerFamilyMemberDetailsEntity: CustomerFamilyMemberDetailsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCustomerFamilyMember(customerFamilyMemberDetailsEntity: List<CustomerFamilyMemberDetailsEntity>)

    @Query("Select * from CustomerFamilyMemberDetails")
    suspend fun getAllCustomerFamilyMember(): List<CustomerFamilyMemberDetailsEntity>

    @Query("Delete from CustomerFamilyMemberDetails")
    suspend  fun deleteAllCustomerFamilyMember()

    @Query("""
        UPDATE CustomerFamilyMemberDetails 
        SET 
            MFirstName = :firstName,
            MMiddleName = :middleName,
            MLastName = :lastName,
            RelationID = :relationId,
            Age = :age,
            Gender = :gender,
            EducationID = :educationId,
            OccupationID = :occupationId
        WHERE GUID = :guid
    """)
    suspend fun updateCustomerFamilyMemberByGuid(
        guid: String,
        firstName: String?,
        middleName: String?,
        lastName: String?,
        relationId: Int?,
        age: Int?,
        gender: String?,
        educationId: Int?,
        occupationId: Int?
    )

    @Query(" SELECT * FROM CustomerFamilyMemberDetails WHERE GUID =:guId")
    suspend fun getCustomerByGuid(guId: String): List<CustomerFamilyMemberDetailsEntity>


     @Query("SELECT * FROM CustomerFamilyMemberDetails WHERE MemberGuid =:guId")
    suspend fun getCustomerDetailByGuid(guId: String): List<CustomerFamilyMemberDetailsEntity>

    @Delete
    suspend fun deleteFamilyMember(
        item: CustomerFamilyMemberDetailsEntity
    )



}