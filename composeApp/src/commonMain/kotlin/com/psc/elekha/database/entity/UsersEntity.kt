package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class UsersEntity(
    @PrimaryKey @ColumnInfo(name = "UserId") val UserId: String,
    @ColumnInfo(name = "UserName") val UserName: String?,
    @ColumnInfo(name = "Password") val Password: String?,
    @ColumnInfo(name = "RoleId") val RoleId: String?,
    @ColumnInfo(name = "Name") val Name: String?,
    @ColumnInfo(name = "IsUserDisabled") val IsUserDisabled: Int?

)
