package com.psc.elekha.database.viewmodel

import CustomerRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CustomerViewModel(private val customerRepository: CustomerRepository) : ViewModel() {

    private val _customers = MutableStateFlow<List<CustomerEntity>>(emptyList())
    val customers: StateFlow<List<CustomerEntity>> = _customers
    private val _searchResults = MutableStateFlow<List<CustomerEntity>>(emptyList())
    val searchResults: StateFlow<List<CustomerEntity>> = _searchResults
    private val _customerByGuid = MutableStateFlow<List<CustomerEntity>>(emptyList())
    val customerByGuid: StateFlow<List<CustomerEntity>> = _customerByGuid

    // Load all customers
    fun loadCustomers() {
        viewModelScope.launch {
            val result = customerRepository.getAllCustomers()
            _customers.value = result
        }
    }

    // Insert single customer
    fun insertCustomer(customer: CustomerEntity) {
        viewModelScope.launch {
            customerRepository.insertCustomer(customer)
            loadCustomers() // refresh
        }
    }

    // Insert list of customers
    fun insertAllCustomers(customers: List<CustomerEntity>) {
        viewModelScope.launch {
            customerRepository.insertAllCustomers(customers)
            loadCustomers() // refresh
        }
    }

    // Fetch customer by contact number
    fun getCustomerByContact(contactNo: String, callback: (List<CustomerEntity>?) -> Unit) {
        viewModelScope.launch {
            val result = customerRepository.getCustomerByContact(contactNo)
            callback(result)
        }
    }

    // Fetch single customer by GUID
    fun getCustomerDetails(guid: String, callback: (CustomerEntity?) -> Unit) {
        viewModelScope.launch {
            val result = customerRepository.getCustomerDetails(guid)
            callback(result)
        }
    }

    // Update customer profile
    fun updateMyProfile(
        maritalStatusId: Int,
        firstName: String,
        middleName: String,
        lastName: String,
        customerImage: String,
        guarantorFName: String,
        guarantorMName: String,
        guarantorLName: String,
        guarantorImage: String,
        dob: String,
        age: Int,
        villageId: Int,
        pincode: String,
        guarantorAge: Int,
        guarantorDob: String,
        isEdited: Int,
        updatedBy: String,
        updatedOn: String,
        husbandFName: String,
        husbandMName: String,
        husbandLName: String,
        casteId: Int,
        educationId: Int,
        religionId: Int,
        guarantorId: Int,
        houseNo: String,
        mohalla: String,
        guid: String
    ) {
        viewModelScope.launch {
            customerRepository.updateMyProfile(
                maritalStatusId,
                firstName,
                middleName,
                lastName,
                customerImage,
                guarantorFName,
                guarantorMName,
                guarantorLName,
                guarantorImage,
                dob,
                age,
                villageId,
                pincode,
                guarantorAge,
                guarantorDob,
                isEdited,
                updatedBy,
                updatedOn,
                husbandFName,
                husbandMName,
                husbandLName,
                casteId,
                educationId,
                religionId,
                guarantorId,
                houseNo,
                mohalla,
                guid
            )
            loadCustomers() // refresh
        }
    }
    fun updateKyc(
        CKYC_UID: String,
        CKYC_UID_Image: String,
        CKYC_UID_Image2: String,
        CKYC_VoterCard: String,
        CKYC_VoterCardImage: String,
        CKYC_VoterCardImage2: String,
        CKYC_ElectricityBill: String,
        CKYC_ElectricityBill_Image: String,
        CKYC_ElectricityBillRelationID: Int,
        CKYC_ElectricityBill_Name: String,
        KElectricNumber: String,
        CKYC_JobCard: String,
        CKYC_JobCard_Image: String,
        CKYC_JobCardRelationID: Int,
        CKYC_JobCard_Name: String,
        CKYC_JobCard_Image2: String,
        GKYC_UID: String,
        GKYC_UID_Image: String,
        GKYC_UID_Image2: String,
        IsEdited: Int,
        UpdatedBy: String,
        UpdatedOn: String,
        CKYC_Bank: Int,
        CKYC_BankAccountNumber: String,
        CKYC_Bank_Image: String,
        CustomerBankIFSCCode: String,
        CustomerBankNameEditable: String,
        CKYC_RationCard: String,
        CKYC_RationCard_Image: String,
        CKYC_RationCard_Image2: String,
        RegPlace: String,
        RegLat: String,
        RegLong: String,
        GUID: String
    ) {
        viewModelScope.launch {
            customerRepository.updateKyc(
                CKYC_UID,
                CKYC_UID_Image,
                CKYC_UID_Image2,
                CKYC_VoterCard,
                CKYC_VoterCardImage,
                CKYC_VoterCardImage2,
                CKYC_ElectricityBill,
                CKYC_ElectricityBill_Image,
                CKYC_ElectricityBillRelationID,
                CKYC_ElectricityBill_Name,
                KElectricNumber,
                CKYC_JobCard,
                CKYC_JobCard_Image,
                CKYC_JobCardRelationID,
                CKYC_JobCard_Name,
                CKYC_JobCard_Image2,
                GKYC_UID,
                GKYC_UID_Image,
                GKYC_UID_Image2,
                IsEdited,
                UpdatedBy,
                UpdatedOn,
                CKYC_Bank,
                CKYC_BankAccountNumber,
                CKYC_Bank_Image,
                CustomerBankIFSCCode,
                CustomerBankNameEditable,
                CKYC_RationCard,
                CKYC_RationCard_Image,
                CKYC_RationCard_Image2,
                RegPlace,
                RegLat,
                RegLong,
                GUID
            )

            // Optional: refresh list if UI depends on it
            loadCustomers()
        }
    }
    fun searchCustomerByName(search: String) {
        viewModelScope.launch {
            val result = customerRepository.searchCustomerByName(search)
            _searchResults.value = result
        }
    }

    suspend fun getCustomerDetailGuid(guId: String): List<CustomerEntity> {
        return customerRepository.getCustomerByGuid(guId)
    }
    }



