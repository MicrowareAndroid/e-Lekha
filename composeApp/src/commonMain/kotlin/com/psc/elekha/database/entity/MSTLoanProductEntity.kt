package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "MSTLoanProduct")
data class MSTLoanProductEntity(
    @PrimaryKey @ColumnInfo(name = "LoanProductID") val LoanProductID: Int,
    @ColumnInfo(name = "LoanProduct") val LoanProduct: Double?,
    @ColumnInfo(name = "LoanTypeID") val LoanTypeID: Int?,
    @ColumnInfo(name = "InterestRate") val InterestRate: Double?,
    @ColumnInfo(name = "InsuranceAmount") val InsuranceAmount: Double?,
    @ColumnInfo(name = "LoanPaymentWeeks") val LoanPaymentWeeks: Int?,
    @ColumnInfo(name = "LoanCloserMinWeek") val LoanCloserMinWeek: Int?,
    @ColumnInfo(name = "UpdateBy") val UpdateBy: String?,
    @ColumnInfo(name = "UpdatedDate") val UpdatedDate: String?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?,
    @ColumnInfo(name = "Tenure") val Tenure: Int?,
    @ColumnInfo(name = "MonthlyInstallment") val MonthlyInstallment: Int?,
    @ColumnInfo(name = "TotalInterest") val TotalInterest: Int?,
    @ColumnInfo(name = "ProcessingFee") val ProcessingFee: Int?,
    @ColumnInfo(name = "ProcessingSaving") val ProcessingSaving: Int?,
    @ColumnInfo(name = "InsuranceFee") val InsuranceFee: Int?,
    @ColumnInfo(name = "InsuranceSaving") val InsuranceSaving: Int?,
    @ColumnInfo(name = "TotalInsurance") val TotalInsurance: Int?,
    @ColumnInfo(name = "IsActive") val IsActive: Boolean?

)
