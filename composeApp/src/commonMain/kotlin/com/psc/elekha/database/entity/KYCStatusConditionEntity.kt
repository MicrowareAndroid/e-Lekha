package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = "KYCStatusCondition")
data class KYCStatusConditionEntity(
    @PrimaryKey @ColumnInfo(name = "KYCStatusConditionID") val KYCStatusConditionID: Int,
    @ColumnInfo(name = "KYCStatusID") val KYCStatusID: Int?,
    @ColumnInfo(name = "POI") val POI: Int?,
    @ColumnInfo(name = "POA") val POA: Int?,
    @ColumnInfo(name = "RC") val RC: Int?,
    @ColumnInfo(name = "BD") val BD: Int?

)
