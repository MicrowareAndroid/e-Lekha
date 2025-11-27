package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MSTBank")
data class MSTBankEntity(
    @PrimaryKey @ColumnInfo(name = "BankID") val BankID: Int,
    @ColumnInfo(name = "Bank") val Bank: String?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?

)
