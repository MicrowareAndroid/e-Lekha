package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "AdminDashbord")
data class AdminDashbordEntity(
    @ColumnInfo(name = "CurrentDue") val CurrentDue: Int?,
    @ColumnInfo(name = "AgainstCurrentDue") val AgainstCurrentDue: Int?,
    @ColumnInfo(name = "PastDue") val PastDue: Int?,
    @ColumnInfo(name = "AgainstPastDue") val AgainstPastDue: Int?,
    @ColumnInfo(name = "Total") val Total: Int?,
    @ColumnInfo(name = "AgainstTotal") val AgainstTotal: Int?,
    @ColumnInfo(name = "Advance") val Advance: Int?,
)
