package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "UserContactDetails")
data class UserContactDetailEntity(
    @PrimaryKey @ColumnInfo(name = "UserId") val UserId: String,
    @ColumnInfo(name = "UserName") val UserName: String?,
    @ColumnInfo(name = "ContactNumber") val ContactNumber: String?,
    @ColumnInfo(name = "RoleId") val RoleId: String?

)

