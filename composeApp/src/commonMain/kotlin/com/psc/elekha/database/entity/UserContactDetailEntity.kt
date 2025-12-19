package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserContactDetails")
data class UserContactDetailEntity(
    @PrimaryKey @ColumnInfo(name = "UserId") val UserId: String,
    @ColumnInfo(name = "Username") val Username: String?,
    @ColumnInfo(name = "Contact") val Contact: String?,
    @ColumnInfo(name = "RoleId") val RoleId: String?

)

