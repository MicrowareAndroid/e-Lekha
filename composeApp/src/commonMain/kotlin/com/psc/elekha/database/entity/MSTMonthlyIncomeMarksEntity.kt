package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = "MstMonthlyIncomeMarks")
data class MSTMonthlyIncomeMarksEntity(
    @PrimaryKey @ColumnInfo(name = "MIMID") val MIMID: Int,
    @ColumnInfo(name = "MinIncome") val MinIncome: Int?,
    @ColumnInfo(name = "MaxIncome") val MaxIncome: Int?,
    @ColumnInfo(name = "Marks") val Marks: Int?

)
