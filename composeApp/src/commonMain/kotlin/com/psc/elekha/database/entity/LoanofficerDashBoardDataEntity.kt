package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "LoanofficerDashBoardData")
data class LoanofficerDashBoardDataEntity(

    @PrimaryKey @ColumnInfo(name = "LoanofficerID") val LoanofficerID: String,
    @ColumnInfo(name = "Disbursed_ThisMonth") val Disbursed_ThisMonth: Int?,
    @ColumnInfo(name = "Disbursed_PastMonth") val Disbursed_PastMonth: Int?,
    @ColumnInfo(name = "NewCustomer_ThisMonth") val NewCustomer_ThisMonth: Int?,
    @ColumnInfo(name = "NewCustomer_PastMonth") val NewCustomer_PastMonth: Int?,
    @ColumnInfo(name = "OldCustomer_ThisMonth") val OldCustomer_ThisMonth: Int?,
    @ColumnInfo(name = "OldCustomer_PastMonth") val OldCustomer_PastMonth: Int?,
    @ColumnInfo(name = "CustomerInArrear_ThisMonth") val CustomerInArrear_ThisMonth: Int?,
    @ColumnInfo(name = "CustomerInArrear_PastMonth") val CustomerInArrear_PastMonth: Int?,
    @ColumnInfo(name = "CustomerInPAR_PastMonth") val CustomerInPAR_PastMonth: Int?,
    @ColumnInfo(name = "CustomerInCGT") val CustomerInCGT: Int?,
    @ColumnInfo(name = "RegisteredCustomer") val RegisteredCustomer: Int?,
    @ColumnInfo(name = "OtherCustomer") val OtherCustomer: Int?,
    @ColumnInfo(name = "LOCaseLoad") val LOCaseLoad: Int?,
    @ColumnInfo(name = "LOOutstanding") val LOOutstanding: Int?,
    @ColumnInfo(name = "LORegCustomer") val LORegCustomer: Int?,
    @ColumnInfo(name = "LOGTR") val LOGTR: Int?,
    @ColumnInfo(name = "LODisbursement") val LODisbursement: Int?,
    @ColumnInfo(name = "Meetings") val Meetings: Int?,
    @ColumnInfo(name = "ActiveCustomer") val ActiveCustomer: Int?,
    @ColumnInfo(name = "Due") val Due: Int?,
    @ColumnInfo(name = "PastDue") val PastDue: Int?,
    @ColumnInfo(name = "AmountCollected") val AmountCollected: Int?,
    @ColumnInfo(name = "Customer") val Customer: Int?

)
