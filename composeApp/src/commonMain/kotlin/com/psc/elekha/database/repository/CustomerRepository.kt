import com.psc.elekha.database.dao.CustomerDao
import com.psc.elekha.database.entity.CustomerEntity
import com.psc.elekha.database.entity.MSTVillageEntity


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
        customerDao.updateMyKYC(
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
    }

    suspend fun searchCustomerByName(search: String): List<CustomerEntity> {
        return customerDao.searchCustomerByName(search)
    }


    suspend fun getCustomerByGuid(guId: String): List<CustomerEntity> {
        return customerDao.getCustomerByGuid(guId)
    }

    suspend fun updateBankDetail(
        bankId: Int?,
        accountNo: String?,
        bankImage: String?,
        ifscCode: String?,
        branchName: String?,
        updatedBy: Int?,
        updatedOn: String?,
        guid: String
    ) {
        customerDao.updateBankDetail(
            CKYC_Bank = bankId,
            CKYC_BankAccountNumber = accountNo,
            CKYC_Bank_Image = bankImage,
            CustomerBankIFSCCode = ifscCode,
            CKYC_Bank_Branch = branchName,
            UpdatedBy = updatedBy,
            UpdatedOn = updatedOn,
            GUID = guid
        )
    }


    suspend fun updateCustomerBasicDetails(
        guid: String,
        firstName: String?,
        middleName: String?,
        lastName: String?,
        maritalStatusId: Int?,
        educationId: Int?,
        religionId: Int?,
        contactNo: String?,
        husbandFName: String?,
        hubandMName: String?,
        husbandLName: String?,
        gurantorFName: String?,
        gurantorMName: String?,
        gurantorLName: String?,
        age: Int?,
        outStanding:Int?,
        address: String?,

        gurantorDOB: String?,
        stateID: Int?,
        districtId: Int?,
        villageId: Int?,
        guarantorID: Int?,
        gurantorMobile: String?,
        tehsil: String?,
        landmark: String?,
        maternalAddress: String?,
        villageName: String?,
        maternalMobile: String?,
        maternalFather: String?,
        dailyExpenses: Int?,
        educationExpense: Int?,
        medicalExpense: Int?,
        others: Int?,
        totalMonthlyExpendture: Int?,
        totalAnnual: Int?,
        dob: String?,
        updatedOn: String?,
        updatedBy: String?
    ) {
        customerDao.updateCustomerBasicDetails(
            guid,
            firstName,
            middleName,
            lastName,
            maritalStatusId,
            educationId,
            religionId,
            contactNo,
            husbandFName,
            hubandMName,
            husbandLName,
            gurantorFName,
            gurantorMName,
            gurantorLName,
            age,
            outStanding,
            address,

            gurantorDOB,
            stateID,
            districtId,
            villageId,
            guarantorID,
            gurantorMobile,
            tehsil,
            landmark,
            maternalAddress,
            villageName,
            maternalMobile,
            maternalFather,
            dailyExpenses,
            educationExpense,
            medicalExpense,
            others,
            totalMonthlyExpendture,
            totalAnnual,
            dob,
            updatedOn,
            updatedBy
        )
    }



}
