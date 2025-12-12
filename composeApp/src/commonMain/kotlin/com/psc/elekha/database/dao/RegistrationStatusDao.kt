package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.RegistrationStatusEntity

@Dao
interface RegistrationStatusDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRegistrationStatus(registrationStatusEntity: RegistrationStatusEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRegistrationStatus(registrationStatusEntity: List<RegistrationStatusEntity>)

    @Query("Select * from RegistrationStatus")
    suspend fun getAllRegistrationStatus(): List<RegistrationStatusEntity>

    @Query("Select RegistrationStatus from RegistrationStatus where RegistrationStatusID=:RegistrationStatusID")
    suspend  fun getRegistrationStatusbyID(RegistrationStatusID: Int): String

    @Query("Delete from RegistrationStatus")
    suspend fun deleteAllRegistrationStatus()

}