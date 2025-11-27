package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LoanRepayment")
data class LoanRepaymentEntity(
    @PrimaryKey @ColumnInfo(name = "GUID") val GUID: String,
    @ColumnInfo(name = "CenterID") val CenterID: Int?,
    @ColumnInfo(name = "CustomerID") val CustomerID: String?,
    @ColumnInfo(name = "CustomerName") val CustomerName: String?,
    @ColumnInfo(name = "SpouseName") val SpouseName: String?,
    @ColumnInfo(name = "DisbursementAmount") val DisbursementAmount: Double?,
    @ColumnInfo(name = "DisbursementDate") val DisbursementDate: String?,
    @ColumnInfo(name = "GroupName") val GroupName: String?,
    @ColumnInfo(name = "LW") val LW: Int?,
    @ColumnInfo(name = "LoanOutstandingAsOnDate") val LoanOutstandingAsOnDate: Double?,
    @ColumnInfo(name = "WeekInArrear") val WeekInArrear: Double?,
    @ColumnInfo(name = "PastDue") val PastDue: Double?,
    @ColumnInfo(name = "CurrentDue") val CurrentDue: Double?,
    @ColumnInfo(name = "Due") val Due: Double?,
    @ColumnInfo(name = "Advance") val Advance: Double?,
    @ColumnInfo(name = "Total") val Total: Double?,
    @ColumnInfo(name = "WorkingDate") val WorkingDate: String?,
    @ColumnInfo(name = "EMIDueDate") val EMIDueDate: String?,
    @ColumnInfo(name = "EMI") val EMI: Double?,
    @ColumnInfo(name = "MaxPayment") val MaxPayment: Double?,
    @ColumnInfo(name = "MandateApproved") val MandateApproved: Int?,
    @ColumnInfo(name = "LoanCollectionFrequency") val LoanCollectionFrequency: Int?,
    @ColumnInfo(name = "PaymentType") val PaymentType: Int?,
    @ColumnInfo(name = "NACHStatus") val NACHStatus: Int?,
    @ColumnInfo(name = "MobileNo") val MobileNo: String?,
    @ColumnInfo(name = "IsUploaded") val IsUploaded: Int?,
    @ColumnInfo(name = "IsEdited") val IsEdited: Int?,
    @ColumnInfo(name = "PaidDate") val PaidDate: String?,
    @ColumnInfo(name = "IsEmiReceived") val IsEmiReceived: Int?,
    @ColumnInfo(name = "LoanPlace") val LoanPlace: String?,
    @ColumnInfo(name = "LoanLat") val LoanLat: Double?,
    @ColumnInfo(name = "LoanLong") val LoanLong: Double?

)
