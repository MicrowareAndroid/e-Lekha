package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CustomerTransactionData")
data class CustomerTransactionDataEntity(
    @PrimaryKey @ColumnInfo(name = "CTGUID") val CTGUID: String,
    @ColumnInfo(name = "GUID") val GUID: String?,
    @ColumnInfo(name = "ID") val ID: Int?,
    @ColumnInfo(name = "CustomerID") val CustomerID: String?,
    @ColumnInfo(name = "ContactNo") val ContactNo: String?,
    @ColumnInfo(name = "TransactionOn") val TransactionOn: String?,
    @ColumnInfo(name = "Success") val Success: String?,
    @ColumnInfo(name = "Code") val Code: String?,
    @ColumnInfo(name = "Message") val Message: String?,
    @ColumnInfo(name = "MerchantID") val MerchantID: String?,
    @ColumnInfo(name = "MerchantTransactionID") val MerchantTransactionID: String?,
    @ColumnInfo(name = "TransactionID") val TransactionID: String?,
    @ColumnInfo(name = "Amount") val Amount: String?,
    @ColumnInfo(name = "PaymentState") val PaymentState: String?,
    @ColumnInfo(name = "PayResponseCode") val PayResponseCode: String?,
    @ColumnInfo(name = "PaymentInstrumentType") val PaymentInstrumentType: String?,
    @ColumnInfo(name = "PaymentInstrumentUtr") val PaymentInstrumentUtr: String?,
    @ColumnInfo(name = "CreatedBy") val CreatedBy: String?,
    @ColumnInfo(name = "CreatedOn") val CreatedOn: String?,
    @ColumnInfo(name = "IsEdited") val IsEdited: Int?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?,
    @ColumnInfo(name = "IsUpload") val IsUpload: Int?,
    @ColumnInfo(name = "upiTransactionId") val upiTransactionId: String?,
    @ColumnInfo(name = "AccountHolderName") val AccountHolderName: String?,
    @ColumnInfo(name = "FlagAPI") val FlagAPI: String?


)
