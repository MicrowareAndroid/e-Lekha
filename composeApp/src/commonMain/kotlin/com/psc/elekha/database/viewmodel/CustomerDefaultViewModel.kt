package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerDefaultEntity
import com.psc.elekha.database.entity.CustomerEntity
import com.psc.elekha.database.repository.CustomerDefaultRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CustomerDefaultViewModel(
    private val repository: CustomerDefaultRepository
) : ViewModel() {


    private val _customers = MutableStateFlow<List<CustomerDefaultEntity>>(emptyList())
    val customers: StateFlow<List<CustomerDefaultEntity>> = _customers
    private val _customerDetails = MutableStateFlow<CustomerDefaultEntity?>(null)
    val customerDetails: StateFlow<CustomerDefaultEntity?> = _customerDetails
    private val _customerFullDetails = MutableStateFlow<CustomerEntity?>(null)
    val customerFullDetails: StateFlow<CustomerEntity?> = _customerFullDetails
    private val _uploadCount = MutableStateFlow(0)
    val uploadCount: StateFlow<Int> = _uploadCount
    private val _customerByContact = MutableStateFlow<List<CustomerDefaultEntity>>(emptyList())
    val customerByContact: StateFlow<List<CustomerDefaultEntity>> = _customerByContact
    private val _uploadCountNew = MutableStateFlow(0)
    val uploadCountNew: StateFlow<Int> = _uploadCountNew
    private val _allCustomerUpload = MutableStateFlow<List<CustomerDefaultEntity>>(emptyList())
    val allCustomerUpload: StateFlow<List<CustomerDefaultEntity>> = _allCustomerUpload

    private val _customerAadhaar = MutableStateFlow<String?>(null)
    val customerAadhaar: StateFlow<String?> = _customerAadhaar

    private val _customerDefaultGUIDList = MutableStateFlow<List<CustomerDefaultEntity>>(emptyList())
    val customerDefaultGUIDList: StateFlow<List<CustomerDefaultEntity>> = _customerDefaultGUIDList

    fun loadCustomers() {
        viewModelScope.launch {
            _customers.value = repository.getAllCustomers()
        }
    }

    fun getCustomerDetails(guid: String) {
        viewModelScope.launch {
            _customerDetails.value = repository.getCustomerDetails(guid)
        }
    }


    fun loadCustomerFullDetails(guid: String) {
        viewModelScope.launch {
            _customerFullDetails.value = repository.getCustomerDetailsForCustomer(guid)
        }
    }

    fun insertCustomer(customer: CustomerDefaultEntity) {
        viewModelScope.launch {
            repository.insertCustomer(customer)
            loadCustomers()
        }
    }


    fun insertAllCustomers(list: List<CustomerDefaultEntity>) {
        viewModelScope.launch {
            repository.insertAllCustomers(list)
            loadCustomers()
        }
    }


    fun deleteAllCustomers() {
        viewModelScope.launch {
            repository.deleteAllCustomers()
            loadCustomers()
        }
    }


    fun loadCustomerByContact(contact: String) {
        viewModelScope.launch {
            _customerByContact.value =
                repository.getCustomerByContact(contact)
        }
    }

    fun loadUploadCount() {
        viewModelScope.launch {
            _uploadCount.value = repository.getUploadCount()
        }
    }


    fun loadUploadCountNew() {
        viewModelScope.launch {
            _uploadCountNew.value = repository.getUploadCountNew()
        }
    }


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
            repository.updateMyProfile(
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
        }
    }


    fun updateMyKYC(
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
        isEdited: Int,
        updatedBy: String,
        updatedOn: String,
        CKYC_RationCard: String,
        CKYC_RationCard_Image: String,
        CKYC_RationCard_Image2: String,
        CKYC_Bank: Int,
        CKYC_BankAccountNumber: String,
        CKYC_Bank_Image: String,
        customerBankIFSCCode: String,
        customerBankNameEditable: String,
        guid: String
    ) {
        viewModelScope.launch {
            repository.updateMyKYC(
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
                isEdited,
                updatedBy,
                updatedOn,
                CKYC_RationCard,
                CKYC_RationCard_Image,
                CKYC_RationCard_Image2,
                CKYC_Bank,
                CKYC_BankAccountNumber,
                CKYC_Bank_Image,
                customerBankIFSCCode,
                customerBankNameEditable,
                guid
            )
        }
    }


    fun updateUploaded() {
        viewModelScope.launch {
            repository.updateUploaded()
            loadUploadCount()
        }
    }

    fun updateUploadedNew() {
        viewModelScope.launch {
            repository.updateUploadedNew()
            loadUploadCountNew()
        }
    }

    fun loadAllCustomerUpload() {
        viewModelScope.launch {
            _allCustomerUpload.value = repository.getAllCustomerUpload()
        }
    }

    fun loadCustomerAadhaar(guid: String) {
        viewModelScope.launch {
            _customerAadhaar.value = repository.getCustomerAadhaar(guid)
        }
    }

    fun loadCustomerDefaultGUID(userId: String) {
        viewModelScope.launch {
            _customerDefaultGUIDList.value = repository.getCustomerDefaultGUID(userId)
        }
    }
}



