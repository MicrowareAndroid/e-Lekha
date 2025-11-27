package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "KYCStatus")
data class KYCStatusEntity(
    @PrimaryKey @ColumnInfo(name = "KYCStatusID") val KYCStatusID: Int,
    @ColumnInfo(name = "KYCStatus") val KYCStatus: String?,
    @ColumnInfo(name = "ColorCode") val ColorCode: String?,
    @ColumnInfo(name = "KYCCode") val KYCCode: String?

)
