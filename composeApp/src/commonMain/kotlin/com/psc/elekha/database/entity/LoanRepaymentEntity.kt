package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "LoanRepayment")
data class LoanRepaymentEntity(
    @PrimaryKey @ColumnInfo(name = "GUID") val GUID: String,
    @ColumnInfo(name = "CenterID") val CenterID: Int? = 0,
    @ColumnInfo(name = "CustomerID") val CustomerID: String? = "",
    @ColumnInfo(name = "CustomerName") val CustomerName: String? = "",
    @ColumnInfo(name = "SpouseName") val SpouseName: String? = "",
    @ColumnInfo(name = "DisbursementAmount") val DisbursementAmount: Double? = 0.0,
    @ColumnInfo(name = "DisbursementDate") val DisbursementDate: String? = "",
    @ColumnInfo(name = "GroupName") val GroupName: String? = "",
    @ColumnInfo(name = "LW") val LW: Int? = 0,
    @ColumnInfo(name = "LoanOutstandingAsOnDate") val LoanOutstandingAsOnDate: Double? = 0.0,
    @ColumnInfo(name = "WeekInArrear") val WeekInArrear: Double? = 0.0,
    @ColumnInfo(name = "PastDue") val PastDue: Double? = 0.0,
    @ColumnInfo(name = "CurrentDue") val CurrentDue: Double? = 0.0,
    @ColumnInfo(name = "Due") val Due: Double? = 0.0,
    @ColumnInfo(name = "Advance") val Advance: Double? = 0.0,
    @ColumnInfo(name = "Total") val Total: Double? = 0.0,
    @ColumnInfo(name = "WorkingDate") val WorkingDate: String? = "",
    @ColumnInfo(name = "EMIDueDate") val EMIDueDate: String? = "",
    @ColumnInfo(name = "EMI") val EMI: Double? = 0.0,
    @ColumnInfo(name = "MaxPayment") val MaxPayment: Double? = 0.0,
    @ColumnInfo(name = "MandateApproved") val MandateApproved: Int? = 0,
    @ColumnInfo(name = "LoanCollectionFrequency") val LoanCollectionFrequency: Int? = 0,
    @ColumnInfo(name = "PaymentType") val PaymentType: Int? = 0,
    @ColumnInfo(name = "NACHStatus") val NACHStatus: Int? = 0,
    @ColumnInfo(name = "MobileNo") val MobileNo: String? = "",
    @ColumnInfo(name = "IsUploaded") val IsUploaded: Int? = 0,
    @ColumnInfo(name = "IsEdited") val IsEdited: Int? = 0,
    @ColumnInfo(name = "PaidDate") val PaidDate: String? = "",
    @ColumnInfo(name = "IsEmiReceived") val IsEmiReceived: Int? = 0,
    @ColumnInfo(name = "LoanPlace") val LoanPlace: String? = "",
    @ColumnInfo(name = "LoanLat") val LoanLat: Double? = 0.0,
    @ColumnInfo(name = "LoanLong") val LoanLong: Double? = 0.0

)
