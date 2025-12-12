package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTMFILoanProductDao
import com.psc.elekha.database.entity.MSTMFILoanProductEntity

class MSTMFILoanProductRepository(
    private val mfiLoanProductDao: MSTMFILoanProductDao
) {

    // Insert single MFI loan product
    suspend fun insertMFILoanProduct(item: MSTMFILoanProductEntity) {
        mfiLoanProductDao.insertMFILoanProduct(item)
    }

    // Insert list of MFI loan products
    suspend fun insertAllMFILoanProduct(list: List<MSTMFILoanProductEntity>) {
        mfiLoanProductDao.insertAllMFILoanProduct(list)
    }

    // Get all MFI loan products
    suspend fun getAllMFILoanProduct(): List<MSTMFILoanProductEntity> {
        return mfiLoanProductDao.getAllMFILoanProduct()
    }

    // Get MFI loan products by MFIID
    suspend fun getMFILoanProductByMFIID(MFIID: Int): List<MSTMFILoanProductEntity> {
        return mfiLoanProductDao.getMFILoanProductBYMFIID(MFIID)
    }

    // Get LoanProductAmount by MFILoanProductID
    suspend fun getLoanProductAmount(MFILoanProductID: Int): Int? {
        return mfiLoanProductDao.getLoanProductAmount(MFILoanProductID)
    }

    // Delete all MFI loan products
    suspend fun deleteAllMFILoanProduct() {
        mfiLoanProductDao.deleteAllMFILoanProduct()
    }
}
