package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "KYCDocConfiguration")
data class KYCDocConfigurationEntity(
    @PrimaryKey @ColumnInfo(name = "KYCDocConfigID") val KYCDocConfigID: Int,
    @ColumnInfo(name = "KYCDocID") val KYCDocID: Int?,
    @ColumnInfo(name = "POI") val POI: Int?,
    @ColumnInfo(name = "POA") val POA: Int?,
    @ColumnInfo(name = "RC") val RC: Int?,
    @ColumnInfo(name = "BD") val BD: Int?

)
