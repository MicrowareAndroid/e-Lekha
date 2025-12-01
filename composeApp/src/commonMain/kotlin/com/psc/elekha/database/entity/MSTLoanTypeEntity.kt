package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MSTLoanType")
data class MSTLoanTypeEntity(
    @PrimaryKey @ColumnInfo(name = "LoanTypeID") val LoanTypeID: Int,
    @ColumnInfo(name = "LoanType") val LoanType: String?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?

)
