package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MSTLoanDetails")
data class MstLoanDetailsEntity(
    @PrimaryKey @ColumnInfo(name = "LoanProductID") val LoanProductID: Int,
    @ColumnInfo(name = "LoanProduct") val LoanProduct: Double?,
    @ColumnInfo(name = "Tenure") val Tenure: Int?,
    @ColumnInfo(name = "MonthlyInstallment") val MonthlyInstallment: Int?,
    @ColumnInfo(name = "TotalInterest") val TotalInterest: Int?,
    @ColumnInfo(name = "ProcessingFee") val ProcessingFee: Int?,
    @ColumnInfo(name = "ProcessingSaving") val ProcessingSaving: Int?,
    @ColumnInfo(name = "InsuranceFee") val InsuranceFee: Int?,
    @ColumnInfo(name = "InsuranceSaving") val InsuranceSaving: Int?,
    @ColumnInfo(name = "TotalInsurance") val TotalInsurance: Int?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?

)
