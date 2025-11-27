package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserResponse")
data class UserResponseEntity(
    @PrimaryKey @ColumnInfo(name = "CreatedBy", defaultValue = "") val CreatedBy: String,
    @ColumnInfo(name = "UserID") val UserID: String?,
    @ColumnInfo(name = "Username") val Username: String?,
    @ColumnInfo(name = "RoleId") val RoleId: String?,
    @ColumnInfo(name = "Contact") val Contact: String?,
    @ColumnInfo(name = "OTP") val OTP: String?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?


)
