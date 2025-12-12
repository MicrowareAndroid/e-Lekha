package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.CustomerTransactionsDetailsDao
import com.psc.elekha.database.entity.CustomerTransactionsDetailsEntity

class CustomerTransactionsDetailsRepository(
    private val dao: CustomerTransactionsDetailsDao
) {

    // Insert single transaction
    suspend  fun insertCustomerTransaction(transactiondetails: CustomerTransactionsDetailsEntity) {
        dao.insertCustomerTransactionData(transactiondetails)
    }

    // Insert multiple transactions
    suspend   fun insertAllCustomerTransaction(transactionsdetails: List<CustomerTransactionsDetailsEntity>) {
        dao.insertAllCustomerTransactionData(transactionsdetails)
    }

    // Get all transactions for a customer
    suspend fun getAllCustomerTransaction(GUID: String): List<CustomerTransactionsDetailsEntity>? {
        return dao.getAllCustomerTransactionData(GUID)
    }

    // Get count of transactions for a customer
    suspend fun getTransactionCount(GUID: String): Int {
        return dao.getAllCustomerTransactionDataCount(GUID)
    }

    // Delete all transactions
    suspend fun deleteAllCustomerTransaction() {
        dao.deleteAllCustomerTransactionData()
    }
}
