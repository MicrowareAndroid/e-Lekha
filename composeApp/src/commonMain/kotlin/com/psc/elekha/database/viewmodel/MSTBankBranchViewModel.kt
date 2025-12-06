package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTBankBranchEntity
import com.psc.elekha.database.repository.MSTBankBranchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTBankBranchViewModel(
    private val repository: MSTBankBranchRepository
) : ViewModel() {

    private val _bankBranchList = MutableStateFlow<List<MSTBankBranchEntity>>(emptyList())
    val bankBranchList: StateFlow<List<MSTBankBranchEntity>> = _bankBranchList

    private val _filteredBranches = MutableStateFlow<List<MSTBankBranchEntity>>(emptyList())
    val filteredBranches: StateFlow<List<MSTBankBranchEntity>> = _filteredBranches

    private val _ifscCode = MutableStateFlow<String?>(null)
    val ifscCode: StateFlow<String?> = _ifscCode

    private val _branchID = MutableStateFlow<Int?>(null)
    val branchID: StateFlow<Int?> = _branchID

    // Load all branches
    fun loadAllBankBranches() {
        viewModelScope.launch {
            val result = repository.getAllBankBranch()
            _bankBranchList.value = result ?: emptyList()
        }
    }

    // Load branches by BankID
    fun loadBranchesByBankID(bankID: Int) {
        viewModelScope.launch {
            val result = repository.getBankBranchByBankID(bankID)
            _filteredBranches.value = result ?: emptyList()
        }
    }

    // Get IFSC code
    fun fetchIFSCCode(bankID: Int, branchID: Int) {
        viewModelScope.launch {
            val result = repository.getIFSCCode(bankID, branchID)
            _ifscCode.value = result
        }
    }

    // Get BranchID using IFSC
    fun fetchBranchID(bankID: Int, ifscCode: String) {
        viewModelScope.launch {
            val result = repository.getBranchID(bankID, ifscCode)
            _branchID.value = result
        }
    }

    // Insert single
    fun insertBankBranch(item: MSTBankBranchEntity) {
        viewModelScope.launch {
            repository.insertBankBranch(item)
            loadAllBankBranches()  // refresh list
        }
    }

    // Insert list
    fun insertAllBankBranch(list: List<MSTBankBranchEntity>?) {
        viewModelScope.launch {
            repository.insertAllBankBranch(list)
            loadAllBankBranches()  // refresh list
        }
    }

    // Delete all
    fun deleteAllBankBranch() {
        viewModelScope.launch {
            repository.deleteAllBankBranch()
            _bankBranchList.value = emptyList()
            _filteredBranches.value = emptyList()
        }
    }
}
