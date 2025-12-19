import com.psc.elekha.database.dao.CustomerDao
import com.psc.elekha.database.entity.CustomerEntity


class CustomerRepository(private val customerDao: CustomerDao) {

    suspend fun insertCustomer(customer: CustomerEntity) {
        customerDao.insertCustomer(customer)
    }

    suspend fun insertAllCustomers(customers: List<CustomerEntity>) {
        customerDao.insertAllCustomer(customers)
    }

    suspend fun getAllCustomers(): List<CustomerEntity> {
        return customerDao.getAllCustomer()
    }

    suspend fun getCustomerByContact(contactNo: String): List<CustomerEntity> {
        return customerDao.getCustomerByContactNumber(contactNo)
    }

    suspend fun getCustomerDetails(guid: String): CustomerEntity {
        return customerDao.getCustomerDetails(guid)
    }

    suspend fun updateMyProfile(
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
        customerDao.updateMyProfile(
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
    suspend fun updateKyc(
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
        customerDao.updateMyKYC(
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
    }

    suspend fun searchCustomerByName(search: String): List<CustomerEntity> {
        return customerDao.searchCustomerByName(search)
    }


    suspend fun getCustomerByGuid(guId: String): List<CustomerEntity> {
        return customerDao.getCustomerByGuid(guId)
    }

    suspend fun updateBankDetail(
        customerGuid: String,
        accountNo: String,
        bankId: Int,
        ifscCode: String,
        UpdatedBy: Int?,
        UpdatedOn: String?
    ) {
        customerDao.updateBankDetail(
            customerGuid,accountNo,bankId,ifscCode,UpdatedBy,UpdatedOn
        )
    }



}
