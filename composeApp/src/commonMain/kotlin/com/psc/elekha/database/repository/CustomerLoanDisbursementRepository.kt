package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.CustomerLoanDisbursementDao
import com.psc.elekha.database.entity.CustomerLoanDisbursementEntity
import com.psc.elekha.model.CustomerLoanDataClass

class CustomerLoanDisbursementRepository (
    private val customerLoanDisbursementDao: CustomerLoanDisbursementDao
){
    //Insert signle of loan disbursements
    fun insertLoanDisbursement(loan: CustomerLoanDisbursementEntity){
        customerLoanDisbursementDao.insertLoanDisbursement(loan)
    }
    //Insert list of loan disbursements
    fun insertAllLoanDisbursement(loans:List<CustomerLoanDisbursementEntity>){
        customerLoanDisbursementDao.insertAllLoanDisbursement(loans)
    }
    //Get all loan disbursements
    fun getAllLoanDisbursement():List<CustomerLoanDisbursementEntity>? {
        return customerLoanDisbursementDao.getAllLoanDisbursement()
    }
    //get loan disbursement with status (2,3)
    fun getLoanDisbursementData(): List<CustomerLoanDataClass>? {
        return customerLoanDisbursementDao.getLoanDisbursementData()
    }
    //get loan disbursement by specific status Id
    fun getLoanDisbursementDataByStatus(customerStatusId: Int): List<CustomerLoanDataClass>? {
        return customerLoanDisbursementDao.getLoanDisbursementDataByStatus(customerStatusId)
    }
    // Delete all loan disbursement records
    fun deleteAllLoanDisbursement() {
        customerLoanDisbursementDao.deleteAllLoanDisbursement()
    }
}