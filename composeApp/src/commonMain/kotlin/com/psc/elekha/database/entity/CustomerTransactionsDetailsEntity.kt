package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CustomerTransactionsDetails")
data class CustomerTransactionsDetailsEntity(
    @PrimaryKey @ColumnInfo(name = "order_id") val order_id: String,
    @ColumnInfo(name = "CustomerGUID") val CustomerGUID: String?,
    @ColumnInfo(name = "tracking_id") val tracking_id: String?,
    @ColumnInfo(name = "bank_ref_no") val bank_ref_no: String?,
    @ColumnInfo(name = "order_status") val order_status: String?,
    @ColumnInfo(name = "failure_message") val failure_message: String?,
    @ColumnInfo(name = "payment_mode") val payment_mode: String?,
    @ColumnInfo(name = "card_name") val card_name: String?,
    @ColumnInfo(name = "status_code") val status_code: String?,
    @ColumnInfo(name = "status_message") val status_message: String?,
    @ColumnInfo(name = "currency") val currency: String?,
    @ColumnInfo(name = "amount") val amount: Double?,
    @ColumnInfo(name = "billing_name") val billing_name: String?,
    @ColumnInfo(name = "billing_address") val billing_address: String?,
    @ColumnInfo(name = "billing_city") val billing_city: String?,
    @ColumnInfo(name = "billing_state") val billing_state: String?,
    @ColumnInfo(name = "billing_zip") val billing_zip: String?,
    @ColumnInfo(name = "billing_country") val billing_country: String?,
    @ColumnInfo(name = "billing_tel") val billing_tel: String?,
    @ColumnInfo(name = "billing_email") val billing_email: String?,
    @ColumnInfo(name = "delivery_name") val delivery_name: String?,
    @ColumnInfo(name = "delivery_address") val delivery_address: String?,
    @ColumnInfo(name = "delivery_city") val delivery_city: String?,
    @ColumnInfo(name = "delivery_state") val delivery_state: String?,
    @ColumnInfo(name = "delivery_zip") val delivery_zip: String?,
    @ColumnInfo(name = "delivery_country") val delivery_country: String?,
    @ColumnInfo(name = "delivery_tel") val delivery_tel: String?,
    @ColumnInfo(name = "merchant_param1") val merchant_param1: String?,
    @ColumnInfo(name = "merchant_param2") val merchant_param2: String?,
    @ColumnInfo(name = "merchant_param3") val merchant_param3: String?,
    @ColumnInfo(name = "merchant_param4") val merchant_param4: String?,
    @ColumnInfo(name = "merchant_param5") val merchant_param5: String?,
    @ColumnInfo(name = "vault") val vault: String?,
    @ColumnInfo(name = "offer_type") val offer_type: String?,
    @ColumnInfo(name = "offer_code") val offer_code: String?,
    @ColumnInfo(name = "discount_value") val discount_value: Double?,
    @ColumnInfo(name = "mer_amount") val mer_amount: Double?,
    @ColumnInfo(name = "eci_value ") val eci_value : String?,
    @ColumnInfo(name = "retry ") val retry : String?,
    @ColumnInfo(name = "billing_notes") val billing_notes : String?,
    @ColumnInfo(name = "trans_date") val trans_date : String?,
    @ColumnInfo(name = "bin_country") val bin_country : String?,

)
