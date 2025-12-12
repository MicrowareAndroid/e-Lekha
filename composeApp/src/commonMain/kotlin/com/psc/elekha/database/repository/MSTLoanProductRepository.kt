package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTLoanProductDao
import com.psc.elekha.database.entity.MSTLoanProductEntity

class MSTLoanProductRepository(
    private val loanProductDao: MSTLoanProductDao
) {

    // Insert single loan product
    suspend fun insertLoanProduct(item: MSTLoanProductEntity) {
        loanProductDao.insertLoanProduct(item)
    }

    // Insert list of loan products
    suspend fun insertAllLoanProduct(list: List<MSTLoanProductEntity>) {
        loanProductDao.insertAllLoanProduct(list)
    }

    // Get loan products by LoanProductID
    suspend fun getAllLoanProduct(loanProductID: Int): List<MSTLoanProductEntity> {
        return loanProductDao.getAllLoanProduct(loanProductID)
    }

    // Get all active loan amounts
    suspend fun getLoanAmount(): List<MSTLoanProductEntity> {
        return loanProductDao.getLoanAmount()
    }

    // Get new loan amounts (LoanProductID in 25,31)
    suspend fun getNewLoanAmount(): List<MSTLoanProductEntity> {
        return loanProductDao.getNewLoanAmount()
    }

    // Get LoanProduct value by LoanProductID
    suspend fun getLoanProductByLoanID(loanProductID: Int): Double? {
        return loanProductDao.getLoanProductByLoanID(loanProductID)
    }

    // Delete all loan products
    suspend fun deleteAllLoanProduct() {
        loanProductDao.deleteAllLoanProduct()
    }
}
