package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(tableName = "CustomerLoanSchedule",primaryKeys = ["GUID","CustomerLoanID"])
data class LoanScheduleEntity(
    @ColumnInfo(name = "GUID") val GUID: String,
    @ColumnInfo(name = "CustomerLoanID") val CustomerLoanID: Int,
    @ColumnInfo(name = "RowNumber") val RowNumber: Int?,
    @ColumnInfo(name = "LoanWeek") val LoanWeek: Int?,
    @ColumnInfo(name = "EMIDueDate") val EMIDueDate: String?,
    @ColumnInfo(name = "Principal") val Principal: Double?,
    @ColumnInfo(name = "Interest") val Interest: Double?,
    @ColumnInfo(name = "EMI") val EMI: Int?,
    @ColumnInfo(name = "Balance") val Balance: Double?,
    @ColumnInfo(name = "ReceiptFlag") val ReceiptFlag: Int?,
    @ColumnInfo(name = "PaidDate") val PaidDate: String?,
    @ColumnInfo(name = "SubmitDate") val SubmitDate: String?,
    @ColumnInfo(name = "ConfirmationDate") val ConfirmationDate: String?,
    @ColumnInfo(name = "CanceledBy") val CanceledBy: String?,
    @ColumnInfo(name = "CanceledDate") val CanceledDate: String?,
    @ColumnInfo(name = "IsWorkingDayClosed") val IsWorkingDayClosed: Boolean?,
    @ColumnInfo(name = "WorkingDate") val WorkingDate: String?,
    @ColumnInfo(name = "IsNotEdited") val IsNotEdited: Boolean?,
    @ColumnInfo(name = "Advance") val Advance: Double?,
    @ColumnInfo(name = "IsPaidFromWeb") val IsPaidFromWeb: Boolean?,
    @ColumnInfo(name = "LoanPlace") val LoanPlace: String?,
    @ColumnInfo(name = "LoanLat") val LoanLat: String?,
    @ColumnInfo(name = "LoanLong") val LoanLong: String?,
    @ColumnInfo(name = "UserID") val UserID: String?,
    @ColumnInfo(name = "InterestPart") val InterestPart: Double?,
    @ColumnInfo(name = "ContributionPart") val ContributionPart: Double?,
    @ColumnInfo(name = "PaymentType") val PaymentType: String?,
    @ColumnInfo(name = "GroupName") val GroupName: String?,
    @ColumnInfo(name = "Center") val Center: String?,
    @ColumnInfo(name = "balance_Amount") val balance_Amount: Double?,
    @ColumnInfo(name = "DayOfDelay") val DayOfDelay: Int?,
    @ColumnInfo(name = "LPaymentWeek") val LPaymentWeek: Int?,
    @ColumnInfo(name = "CutomerStatusID") val CutomerStatusID: Int?

)
