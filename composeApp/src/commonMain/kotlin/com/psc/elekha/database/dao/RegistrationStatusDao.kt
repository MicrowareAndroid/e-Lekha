package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.RegistrationStatusEntity

@Dao
interface RegistrationStatusDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRegistrationStatus(registrationStatusEntity: RegistrationStatusEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllRegistrationStatus(registrationStatusEntity: List<RegistrationStatusEntity>?)

    @Query("Select * from RegistrationStatus")
    fun getAllRegistrationStatus(): List<RegistrationStatusEntity>?

    @Query("Select RegistrationStatus from RegistrationStatus where RegistrationStatusID=:RegistrationStatusID")
    fun getRegistrationStatusbyID(RegistrationStatusID: Int): String

    @Query("Delete from RegistrationStatus")
    fun deleteAllRegistrationStatus()

}