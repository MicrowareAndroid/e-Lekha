package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.LoanRepaymentDao
import com.psc.elekha.database.entity.LoanRepaymentEntity

class LoanRepaymentRepository(
    private val dao: LoanRepaymentDao
) {

    // Insert single loan repayment
    fun insertLoanRepayment(loanRepayment: LoanRepaymentEntity) {
        dao.insertLoanRepayment(loanRepayment)
    }

    // Insert multiple loan repayments
    fun insertAllLoanRepayment(loanRepayments: List<LoanRepaymentEntity>) {
        dao.insertAllLoanRepayment(loanRepayments)
    }

    // Get all loan repayments
    fun getAllLoanRepayment(): List<LoanRepaymentEntity>? {
        return dao.getAllLoanRepayment()
    }

    // Get loan repayment by GUID
    fun getLoanRepaymentByGUID(GUID: String): LoanRepaymentEntity? {
        return dao.getLoanRepaymentByGUID(GUID)
    }

    // Get loan repayments to upload
    fun getLoanRepaymentUploadData(): List<LoanRepaymentEntity>? {
        return dao.getLoanRepaymentUploadData()
    }

    // Get count of loan repayments to upload
    fun getLoanRepaymentUploadDataCount(): Int {
        return dao.getLoanRepaymentUploadDataCount()
    }

    // Update loan repayment data
    fun updateLoanRepaymentData(
        Total: Double,
        PaidDate: String,
        LoanLat: Double,
        LoanLong: Double,
        LoanPlace: String,
        PaymentType: Int,
        GUID: String
    ) {
        dao.updateLoanRepaymentData(Total, PaidDate, LoanLat, LoanLong, LoanPlace, PaymentType, GUID)
    }

    // Mark uploaded
    fun updateLoanRepaymentDataUploaded() {
        dao.updateLoanRepaymentDataUploaded()
    }

    // Delete all loan repayments
    fun deleteAllLoanRepayment() {
        dao.deleteAllLoanRepayment()
    }
}
