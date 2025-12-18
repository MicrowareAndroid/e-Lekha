package com.psc.elekha.ui.screen.repayment.model

data class RepaymentItem(
    val customerId: String,
    val customerName: String,
    val loanAmount: String,
    val emiAmount: String,
    val totalDue: String,
    val weeksInArrear: String,
    val hasQrScanner: Boolean = true,
    val emiNumber: String,
    val distributeDate:String,
    val preClosureAmount:String,
    val pastDue:String,
    val currentDue:String,
    val mobileNumber:String
)
