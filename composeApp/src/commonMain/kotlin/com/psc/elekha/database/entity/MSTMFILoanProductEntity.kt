package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mstMFILoanProduct")
data class MSTMFILoanProductEntity(
    @PrimaryKey @ColumnInfo(name = "MFILoanProductID") val MFILoanProductID: Int,
    @ColumnInfo(name = "MFIID") val MFIID: Int?,
    @ColumnInfo(name = "LoanProductAmount") val LoanProductAmount: Int?,
    @ColumnInfo(name = "LoanProduct") val LoanProduct: String?,
    @ColumnInfo(name = "Sequence") val Sequence: Int?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Int?

)
