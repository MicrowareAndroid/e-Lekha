package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.CustomerExistingLoanDetailDao
import com.psc.elekha.database.entity.CustomerExistingLoanDetailEntity

class CustomerExistingLoanDetailRepository(
    private val customerExistingLoanDetailDao: CustomerExistingLoanDetailDao
) {

    suspend fun insertCustomerExistingLoan(customer: CustomerExistingLoanDetailEntity) {
        customerExistingLoanDetailDao.insertCustomerExistingLoan(customer)
    }

    suspend fun insertAllCustomerExistingLoan(customers: List<CustomerExistingLoanDetailEntity>) {
        customerExistingLoanDetailDao.insertAllCustomerExistingLoan(customers)
    }

    suspend fun getAllCustomerExistingLoan(guid: String): List<CustomerExistingLoanDetailEntity> {
        return customerExistingLoanDetailDao.getAllCustomerExistingLoan(guid)
    }

    suspend  fun deleteAllCustomerExistingLoan() {
        customerExistingLoanDetailDao.deleteAllCustomerExistingLoan()
    }

    suspend  fun getMyLoanCount(guid: String): Int? {
        return customerExistingLoanDetailDao.getMyLoanCount(guid)
    }

    suspend  fun updateMyLoan(
        LoanAmount: Int,
        LoanPurposeID: Int,
        GUID: String
    ) {
        customerExistingLoanDetailDao.updateMyLoan(
            LoanAmount,
            LoanPurposeID,
            GUID
        )
    }

    suspend  fun updateMFI(
        LoanAmount: Int,
        LoanPurposeID: Int,
        MFIID: Int,
        OutStandingAmount: Int,
        MemberName: String,
        EMI: Int,
        IsEdited: Int,
        MFIGUID: String,
        GUID: String
    ) {
        customerExistingLoanDetailDao.updateMFI(
            LoanAmount,
            LoanPurposeID,
            MFIID,
            OutStandingAmount,
            MemberName,
            EMI,
            IsEdited,
            MFIGUID,
            GUID
        )
    }

    suspend fun getAllCustomerExistingLoanUpload(): List<CustomerExistingLoanDetailEntity> {
        return customerExistingLoanDetailDao.getAllCustomerExistingLoanUpload()
    }

    suspend fun updateUploaded() {
        customerExistingLoanDetailDao.updateUploaded()
    }

    suspend fun getIsUploaded(guid: String): Int? {
        return customerExistingLoanDetailDao.getIsUploaded(guid)
    }

    suspend fun getUploadCount(): Int {
        return customerExistingLoanDetailDao.getAllCustomerExistingLoanUploadCount()
    }
}
