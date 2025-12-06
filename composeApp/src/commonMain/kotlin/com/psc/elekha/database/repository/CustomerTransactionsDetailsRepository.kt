package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.CustomerTransactionsDetailsDao
import com.psc.elekha.database.entity.CustomerTransactionsDetailsEntity

class CustomerTransactionsDetailsRepository(
    private val dao: CustomerTransactionsDetailsDao
) {

    // Insert single transaction
    fun insertCustomerTransaction(transactiondetails: CustomerTransactionsDetailsEntity) {
        dao.insertCustomerTransactionData(transactiondetails)
    }

    // Insert multiple transactions
    fun insertAllCustomerTransaction(transactionsdetails: List<CustomerTransactionsDetailsEntity>) {
        dao.insertAllCustomerTransactionData(transactionsdetails)
    }

    // Get all transactions for a customer
    fun getAllCustomerTransaction(GUID: String): List<CustomerTransactionsDetailsEntity>? {
        return dao.getAllCustomerTransactionData(GUID)
    }

    // Get count of transactions for a customer
    fun getTransactionCount(GUID: String): Int {
        return dao.getAllCustomerTransactionDataCount(GUID)
    }

    // Delete all transactions
    fun deleteAllCustomerTransaction() {
        dao.deleteAllCustomerTransactionData()
    }
}
