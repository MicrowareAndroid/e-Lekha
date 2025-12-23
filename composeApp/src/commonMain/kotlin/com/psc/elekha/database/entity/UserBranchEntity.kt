package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = "UserBranch")
data class UserBranchEntity(
    @PrimaryKey @ColumnInfo(name = "UserBranchID") val UserBranchID: String,
    @ColumnInfo(name = "UserID") val UserID: String?,
    @ColumnInfo(name = "BranchID") val BranchID: Int?

)
