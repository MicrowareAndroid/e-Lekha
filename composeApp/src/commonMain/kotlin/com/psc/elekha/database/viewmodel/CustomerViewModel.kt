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


    fun updateMyKyc(
        // CKYC
        CKYC_Aadhar_Name: String?,
        CKYC_UID: String?,
        CKYC_UID_Image: String?,
        CKYC_ElectricityBill: String?,
        CKYC_ElectricityBill_Image: String?,
        CKYC_ElectricityBill_Name: String?,
        KElectricNumber: String?,
        CKYC_VoterCard: String?,
        CKYC_VoterCard_Image: String?,
        CKYC_VoterId_Name: String?,

        // GKYC
        GKYC_Aadhar_Name: String?,
        GKYC_UID: String?,
        GKYC_UID_Image: String?,
        GKYC_UID_Image2: String?,
        GKYC_ElectricityBill: String?,
        GKYC_ElectricityBill_Image: String?,
        GurantorKElectricNumber: String?,
        GKYC_VoterCard: String?,
        GKYC_VoterCard_Image: String?,
        GKYC_VoterId_Name: String?,
        GKYC_PANCard: String?,
        GKYC_PANCard_Image: String?,
        GKYC_Pancard_Name: String?,

        // audit
        UpdatedBy: String,
        UpdatedOn: String,
        GUID: String
    ) {
        viewModelScope.launch {
            customerRepository.updateKyc(
                CKYC_Aadhar_Name,
                CKYC_UID,
                CKYC_UID_Image,
                CKYC_ElectricityBill,
                CKYC_ElectricityBill_Image,
                CKYC_ElectricityBill_Name,
                KElectricNumber,
                CKYC_VoterCard,
                CKYC_VoterCard_Image,
                CKYC_VoterId_Name,

                GKYC_Aadhar_Name,
                GKYC_UID,
                GKYC_UID_Image,
                GKYC_UID_Image2,
                GKYC_ElectricityBill,
                GKYC_ElectricityBill_Image,
                GurantorKElectricNumber,
                GKYC_VoterCard,
                GKYC_VoterCard_Image,
                GKYC_VoterId_Name,
                GKYC_PANCard,
                GKYC_PANCard_Image,
                GKYC_Pancard_Name,

                UpdatedBy,
                UpdatedOn,
                GUID
            )

            // optional refresh
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


    fun updateBankDetail(
        customerGuid: String,
        accountNo: String,
        bankId: Int,
        ifscCode: String,
        UpdatedBy: Int?,
        UpdatedOn: String?
    ) {
        viewModelScope.launch {
            customerRepository.updateBankDetail(
                customerGuid, accountNo, bankId, ifscCode, UpdatedBy, UpdatedOn
            )
        }
    }

    fun updateCustomerBasicDetails(
        guid: String?,
        firstName: String?,
        middleName: String?,
        lastName: String?,
        maritalStatusId: Int?,
        educationId: Int?,
        religionId: Int?,
        contactNo: String?,
        husbandFName: String?,
        husbandMName: String?,
        husbandLName: String?,
        age: Int?,
        guarantorFName: String?,
        guarantorMName: String?,
        guarantorLName: String?,
        phoneNo: String?,
        dob: String?,
        UpdatedOn: String?,
        UpdatedBy: String?


    ) {
        viewModelScope.launch {
            customerRepository.updateCustomerBasicDetails(
                guid,
                firstName,
                middleName,
                lastName,
                maritalStatusId,
                educationId,
                religionId,
                contactNo,
                husbandFName,
                husbandMName,
                husbandLName,
                guarantorFName,
                guarantorMName,
                guarantorLName,
                age,
                phoneNo,
                dob,
                UpdatedOn,
                UpdatedBy
            )

            // optional: list refresh
        }

    }
}



