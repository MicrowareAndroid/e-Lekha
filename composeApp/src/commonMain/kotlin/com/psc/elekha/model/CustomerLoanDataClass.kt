package com.psc.elekha.model

data class CustomerLoanDataClass(
    var CustomerLoanDisbursementID: Int,
    var GUID: String,
    var WorkingDate: String,
    var LoanAmount: Int?,
    var LoanInsuranceFee: Int?,
    var LoanFees: Int?,
    var ReceiptFlag: Boolean?,
    var IsWorkingDayClosed: Boolean?,
    var IsDeleted: Boolean?,
    var CutomerStatusID: Int?
    )