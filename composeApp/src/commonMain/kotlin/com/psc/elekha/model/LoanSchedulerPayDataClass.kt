package com.psc.elekha.model


data class LoanSchedulerPayDataClass(

    var EMIDueDate2: String?,
    var GUID: String,
    var CustomerLoanID: Int,
    var RowNumber: Int?,
    var LoanWeek: Int?,
    var EMIDueDate: String?,
    var Principal: Double?,
    var Interest: Double?,
    var EMI: Int?,
    var Balance: Double?,
    var ReceiptFlag: Int?,
    var PaidDate: String?,
    var SubmitDate: String?,
    var ConfirmationDate: String?,
    var CanceledBy: String?,
    var CanceledDate: String?,
    var IsWorkingDayClosed: Boolean?,
    var WorkingDate: String?,
    var IsNotEdited: Boolean?,
    var Advance: Double?,
    var IsPaidFromWeb: Boolean?,
    var LoanPlace: String?,
    var LoanLat: String?,
    var LoanLong: String?,
    var UserID: String?,
    var InterestPart: Double?,
    var ContributionPart: Double?,
    var PaymentType: String?,
    var GroupName: String?,
    var Center: String?,
    var balance_Amount: Double?,
    var DayOfDelay: Int?,
    var LPaymentWeek: Int?,
    var CutomerStatusID: Int?,
    var checkStatus: Boolean = false

)
