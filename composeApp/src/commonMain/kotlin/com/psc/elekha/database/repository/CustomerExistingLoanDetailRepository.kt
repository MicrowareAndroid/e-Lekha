package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.CustomerExistingLoanDetailDao
import com.psc.elekha.database.entity.CustomerExistingLoanDetailEntity

class CustomerExistingLoanDetailRepository(
    private val customerExistingLoanDetailDao: CustomerExistingLoanDetailDao
) {

    fun insertCustomerExistingLoan(customer: CustomerExistingLoanDetailEntity) {
        customerExistingLoanDetailDao.insertCustomerExistingLoan(customer)
    }

    fun insertAllCustomerExistingLoan(customers: List<CustomerExistingLoanDetailEntity>) {
        customerExistingLoanDetailDao.insertAllCustomerExistingLoan(customers)
    }

    fun getAllCustomerExistingLoan(guid: String): List<CustomerExistingLoanDetailEntity>? {
        return customerExistingLoanDetailDao.getAllCustomerExistingLoan(guid)
    }

    fun deleteAllCustomerExistingLoan() {
        customerExistingLoanDetailDao.deleteAllCustomerExistingLoan()
    }

    fun getMyLoanCount(guid: String): Int? {
        return customerExistingLoanDetailDao.getMyLoanCount(guid)
    }

    fun updateMyLoan(
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

    fun updateMFI(
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

    fun getAllCustomerExistingLoanUpload(): List<CustomerExistingLoanDetailEntity>? {
        return customerExistingLoanDetailDao.getAllCustomerExistingLoanUpload()
    }

    fun updateUploaded() {
        customerExistingLoanDetailDao.updateUploaded()
    }

    fun getIsUploaded(guid: String): Int? {
        return customerExistingLoanDetailDao.getIsUploaded(guid)
    }

    fun getUploadCount(): Int {
        return customerExistingLoanDetailDao.getAllCustomerExistingLoanUploadCount()
    }
}
