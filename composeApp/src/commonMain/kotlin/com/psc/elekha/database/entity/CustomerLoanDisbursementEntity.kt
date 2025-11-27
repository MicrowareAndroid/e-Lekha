package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CustomerLoanDisbursement")
data class CustomerLoanDisbursementEntity(
    @PrimaryKey @ColumnInfo(name = "CustomerLoanDisbursementID") val CustomerLoanDisbursementID: Int,
    @ColumnInfo(name = "GUID") val GUID: String?,
    @ColumnInfo(name = "WorkingDate") val WorkingDate: String?,
    @ColumnInfo(name = "LoanAmount") val LoanAmount: Int?,
    @ColumnInfo(name = "LoanInsuranceFee") val LoanInsuranceFee: Int?,
    @ColumnInfo(name = "LoanFees") val LoanFees: Int?,
    @ColumnInfo(name = "ReceiptFlag") val ReceiptFlag: Boolean?,
    @ColumnInfo(name = "IsWorkingDayClosed") val IsWorkingDayClosed: Boolean?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?

)
