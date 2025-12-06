package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.CustomerTransactionDataDao
import com.psc.elekha.database.entity.CustomerTransactionDataEntity

class CustomerTransactionDataRepository(
    private val dao: CustomerTransactionDataDao
) {

    // Insert single transaction
    fun insertCustomerTransactionData(transaction: CustomerTransactionDataEntity) {
        dao.insertCustomerTransactionData(transaction)
    }

    // Insert list of transactions
    fun insertAllCustomerTransactionData(transactions: List<CustomerTransactionDataEntity>) {
        dao.insertAllCustomerTransactionData(transactions)
    }

    // Delete all transaction data
    fun deleteAllCustomerTransactionData() {
        dao.deleteAllCustomerTransactionData()
    }

    // Get all transactions to upload
    fun getAllCustomerTransactionDataUpload(): List<CustomerTransactionDataEntity>? {
        return dao.getAllCustomerTransactionDataUpload()
    }

    // Get all transaction data by GUID
    fun getAllCustomerTransactionData(GUID: String): List<CustomerTransactionDataEntity>? {
        return dao.getAllCustomerTransactionData(GUID)
    }

    // Count of all transaction data by GUID
    fun getAllCustomerTransactionDataCount(GUID: String): Int {
        return dao.getAllCustomerTransactionDataCount(GUID)
    }

    // Count of all transaction data for upload
    fun getAllCustomerTransactionDataCount(): Int {
        return dao.getAllCustomerTransactionDataCount()
    }

    // Get transaction by MerchantTransactionID
    fun getDatabyMerchantTransID(MerchantTransactionID: String, GUID: String): CustomerTransactionDataEntity {
        return dao.getDatabyMerchantTransID(MerchantTransactionID, GUID)
    }

    // Update uploaded transactions
    fun updateUploaded() {
        dao.updateUploaded()
    }
}
