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



