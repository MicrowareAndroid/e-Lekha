package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.LoanRepaymentDao
import com.psc.elekha.database.entity.LoanRepaymentEntity

class LoanRepaymentRepository(
    private val dao: LoanRepaymentDao
) {

    // Insert single loan data_reports
    suspend fun insertLoanRepayment(loanRepayment: LoanRepaymentEntity) {
        dao.insertLoanRepayment(loanRepayment)
    }

    // Insert multiple loan repayments
    suspend fun insertAllLoanRepayment(loanRepayments: List<LoanRepaymentEntity>) {
        dao.insertAllLoanRepayment(loanRepayments)
    }

    // Get all loan repayments
    suspend fun getAllLoanRepayment(): List<LoanRepaymentEntity> {
        return dao.getAllLoanRepayment()
    }

    // Get loan data_reports by GUID
    suspend fun getLoanRepaymentByGUID(GUID: String): LoanRepaymentEntity {
        return dao.getLoanRepaymentByGUID(GUID)
    }

    // Get loan repayments to upload
    suspend fun getLoanRepaymentUploadData(): List<LoanRepaymentEntity> {
        return dao.getLoanRepaymentUploadData()
    }

    // Get count of loan repayments to upload
    suspend fun getLoanRepaymentUploadDataCount(): Int {
        return dao.getLoanRepaymentUploadDataCount()
    }

    // Update loan data_reports data
    suspend fun updateLoanRepaymentData(
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
    suspend fun updateLoanRepaymentDataUploaded() {
        dao.updateLoanRepaymentDataUploaded()
    }

    // Delete all loan repayments
    suspend fun deleteAllLoanRepayment() {
        dao.deleteAllLoanRepayment()
    }
}
