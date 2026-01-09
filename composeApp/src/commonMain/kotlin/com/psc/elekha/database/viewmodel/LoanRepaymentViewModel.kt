package com.psc.elekha.database.viewmodel

import LoanRepaymentUpload
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.LoanRepaymentEntity
import com.psc.elekha.database.repository.LoanRepaymentRepository
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.buildLoanRepaymentJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoanRepaymentViewModel(
    private val repository: LoanRepaymentRepository, val appPreferences: AppPreferences
) : ViewModel() {

    private val _allLoanRepayments = MutableStateFlow<List<LoanRepaymentEntity>>(emptyList())
    val allLoanRepayments: StateFlow<List<LoanRepaymentEntity>> = _allLoanRepayments

    private val _loanRepaymentUploadData = MutableStateFlow<List<LoanRepaymentEntity>>(emptyList())
    val loanRepaymentUploadData: StateFlow<List<LoanRepaymentEntity>> = _loanRepaymentUploadData

    private val _loanRepaymentUploadCount = MutableStateFlow(0)
    val loanRepaymentUploadCount: StateFlow<Int> = _loanRepaymentUploadCount


    fun loadAllLoanRepayment() {
        viewModelScope.launch(Dispatchers.IO) {
            val centerID = appPreferences.getInt(AppSP.filterCenterID)
            val custID = appPreferences.getString(AppSP.filterCustID)
            var flag = 0
            if (centerID > 0) {
                flag = 1
            }
            _allLoanRepayments.value =
                repository.getAllLoanRepayment(flag, centerID, custID) ?: emptyList()
        }
    }

    fun loadLoanRepaymentUploadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _loanRepaymentUploadData.value =
                repository.getLoanRepaymentUploadData() ?: emptyList()

            _loanRepaymentUploadCount.value =
                repository.getLoanRepaymentUploadDataCount()
        }
    }


    fun insertLoanRepayment(
        loanRepayment: LoanRepaymentEntity,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertLoanRepayment(loanRepayment)
            onComplete?.invoke()
        }
    }


    fun insertAllLoanRepayment(
        loanRepayments: List<LoanRepaymentEntity>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllLoanRepayment(loanRepayments)
        }
    }


    fun updateLoanRepaymentData(
        Total: Double,
        PaidDate: String,
        LoanLat: Double,
        LoanLong: Double,
        LoanPlace: String,
        PaymentType: Int,
        utrNo: String,
        GUID: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateLoanRepaymentData(
                Total,
                PaidDate,
                LoanLat,
                LoanLong,
                LoanPlace,
                PaymentType,utrNo,
                GUID
            )
        }
    }


    fun updateLoanRepaymentDataUploaded() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateLoanRepaymentDataUploaded()
        }
    }
    fun testLoanRepaymentJson() {
        println("estLoanRepaymentJson() CALLED")

        viewModelScope.launch(Dispatchers.IO) {

            //  Insert test data
            val testLoan = LoanRepaymentEntity(
                GUID = "GUID123",
                CenterID = 1,
                CustomerID = "CUST001",
                CustomerName = "John Doe",
                DisbursementAmount = 10000.0,
                PaidDate = "2026-01-09",
                IsEdited = 1
            )
            repository.insertLoanRepayment(testLoan)

            //  DB se fresh data load karo
            val loanList = repository.getLoanRepaymentUploadData() ?: emptyList()

            println(" Upload list size = ${loanList.size}")

            //  JSON banao
            if (loanList.isNotEmpty()) {
                val mapper = LoanRepaymentUpload(loanList)
                val json = buildLoanRepaymentJson(mapper)

                println(" LoanRepayment JSON:")
                println(json)
            } else {
                println(" No LoanRepayment data to build JSON")
            }
        }
    }


    fun deleteAllLoanRepayment() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllLoanRepayment()

            _allLoanRepayments.value = emptyList()
            _loanRepaymentUploadData.value = emptyList()
            _loanRepaymentUploadCount.value = 0
        }
    }
}
