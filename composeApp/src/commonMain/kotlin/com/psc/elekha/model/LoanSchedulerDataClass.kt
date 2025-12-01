package com.psc.elekha.model


data class LoanSchedulerDataClass(
    var GUID: String,
    var CustomerLoanID: Int,
    var LoanWeek: Int?,
    var EMIDueDate: String?,
    var Principal: Double?,
    var Interest: Double?,
    var EMI: Double?,
    var ReceiptFlag: Int?,
    var PaidDate: String?,
    var WorkingDate: String?,
    var Principal_Balance_Amount: Double?,
    var Balance: Double?,
    var Installment_Number: Int?,
    var checkStatus: Boolean = false

)
