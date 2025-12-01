package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RegistrationStatus")
data class RegistrationStatusEntity(
    @PrimaryKey @ColumnInfo(name = "RegistrationStatusID") val RegistrationStatusID: Int,
    @ColumnInfo(name = "RegistrationStatus") val RegistrationStatus: String?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?

)
