package com.psc.elekha.database.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerDefaultEntity
import com.psc.elekha.database.repository.CustomerDefaultRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class CustomerDefaultViewModel(
    private val repository: CustomerDefaultRepository
) : ViewModel() {

    private val _allCustomers = MutableStateFlow<List<CustomerDefaultEntity>>(emptyList())
    val allCustomers: StateFlow<List<CustomerDefaultEntity>> = _allCustomers

    private val _customerDetails = MutableStateFlow<CustomerDefaultEntity?>(null)
    val customerDetails: StateFlow<CustomerDefaultEntity?> = _customerDetails

    private val _isUploaded = MutableStateFlow<Int?>(null)
    val isUploaded: StateFlow<Int?> = _isUploaded

    private val _customerAadhaar = MutableStateFlow<String?>(null)
    val customerAadhaar: StateFlow<String?> = _customerAadhaar

    private val _customerDefaultGUID = MutableStateFlow<String?>(null)
    val customerDefaultGUID: StateFlow<String?> = _customerDefaultGUID

    // --------------------------------
    // Load All Customers
    // --------------------------------
    fun loadAllCustomers() {


        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getAllCustomers() ?: emptyList()
            _allCustomers.value = data
        }
    }

    // --------------------------------
    // Load Customer Details
    // --------------------------------
    fun loadCustomerDetails(guid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _customerDetails.value = repository.getCustomerDetails(guid)
        }
    }

    // --------------------------------
    // Update Profile
    // --------------------------------
    fun updateMyProfile(
        MaritalStatusID: Int,
        FirstName: String,
        MiddleName: String,
        LastName: String,
        Customer_Image: String,
        GuarantorFName: String,
        GuarantorMName: String,
        GuarantorLName: String,
        Guarantor_Image: String,
        DOB: String,
        Age: Int,
        VillageID: Int,
        Pincode: String,
        GurantorAge: Int,
        GuarantorDOB: String,
        IsEdited: Int,
        UpdatedBy: String,
        UpdatedOn: String,
        HusbandFName: String,
        HusbandMName: String,
        HusbandLName: String,
        CasteID: Int,
        EducationID: Int,
        ReligionID: Int,
        GuarantorID: Int,
        HouseNo: String,
        Mohalla: String,
        GUID: String,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateMyProfile(
                MaritalStatusID,
                FirstName,
                MiddleName,
                LastName,
                Customer_Image,
                GuarantorFName,
                GuarantorMName,
                GuarantorLName,
                Guarantor_Image,
                DOB,
                Age,
                VillageID,
                Pincode,
                GurantorAge,
                GuarantorDOB,
                IsEdited,
                UpdatedBy,
                UpdatedOn,
                HusbandFName,
                HusbandMName,
                HusbandLName,
                CasteID,
                EducationID,
                ReligionID,
                GuarantorID,
                HouseNo,
                Mohalla,
                GUID
            )

            onComplete?.invoke()
        }
    }

    // --------------------------------
    // Update KYC
    // --------------------------------
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
        IsEdited: Int,
        UpdatedBy: String,
        UpdatedOn: String,
        CKYC_RationCard: String,
        CKYC_RationCard_Image: String,
        CKYC_RationCard_Image2: String,
        CKYC_Bank: Int,
        CKYC_BankAccountNumber: String,
        CKYC_Bank_Image: String,
        CustomerBankIFSCCode: String,
        CustomerBankNameEditable: String,
        GUID: String,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
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
                IsEdited,
                UpdatedBy,
                UpdatedOn,
                CKYC_RationCard,
                CKYC_RationCard_Image,
                CKYC_RationCard_Image2,
                CKYC_Bank,
                CKYC_BankAccountNumber,
                CKYC_Bank_Image,
                CustomerBankIFSCCode,
                CustomerBankNameEditable,
                GUID
            )

            onComplete?.invoke()
        }
    }

    // --------------------------------
    // Aadhaar
    // --------------------------------
    fun loadCustomerAadhaar(guid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _customerAadhaar.value = repository.getCustomerAadhaar(guid)
        }
    }

    fun loadCustomerDefaultGUID(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _customerDefaultGUID.value = repository.getCustomerDefaultGUID(userId)
        }
    }

    fun loadIsUploaded(guid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isUploaded.value = repository.getIsUploaded(guid)
        }
    }

    fun updateUploaded() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUploaded()
        }
    }

    fun updateUploadedNew() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUploadedNew()
        }
    }
}
