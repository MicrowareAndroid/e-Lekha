package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BranchManagerDashboard")
data class BranchManagerDashbordEntity(
    @PrimaryKey @ColumnInfo(name = "GUID") val GUID: String,
    @ColumnInfo(name = "Customers") val Customers: Int?,
    @ColumnInfo(name = "CustomersCollected") val CustomersCollected: Int?,
    @ColumnInfo(name = "Meetings") val Meetings: Int?,
    @ColumnInfo(name = "MeetingsAttended") val MeetingsAttended: Int?,
    @ColumnInfo(name = "CustomersArrear") val CustomersArrear: Int?,
    @ColumnInfo(name = "ArrearCleared") val ArrearCleared: Int?,
    @ColumnInfo(name = "CustomerPar") val CustomerPar: Int?,
    @ColumnInfo(name = "ParCleared") val ParCleared: Int?,
    @ColumnInfo(name = "CurrentDue") val CurrentDue: Int?,
    @ColumnInfo(name = "AgainstCurrentDue") val AgainstCurrentDue: Int?,
    @ColumnInfo(name = "PastDue") val PastDue: Int?,
    @ColumnInfo(name = "AgainstPastDue") val AgainstPastDue: Int?,
    @ColumnInfo(name = "Total") val Total: Int?,
    @ColumnInfo(name = "AgainstTotal") val AgainstTotal: Int?,
    @ColumnInfo(name = "Advance") val Advance: Int?,
)
