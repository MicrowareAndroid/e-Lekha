package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.CustomerDefaultDao
import com.psc.elekha.database.entity.CustomerDefaultEntity
import com.psc.elekha.database.entity.CustomerEntity

class CustomerDefaultRepository(private val customerDefaultDao: CustomerDefaultDao) {

    suspend fun insertCustomer(customer: CustomerDefaultEntity) {
        customerDefaultDao.insertCustomer(customer)
    }

    suspend fun insertAllCustomers(customers: List<CustomerDefaultEntity>) {
        customerDefaultDao.insertAllCustomer(customers)
    }

    suspend fun getAllCustomers(): List<CustomerDefaultEntity>? {
        return customerDefaultDao.getAllCustomer()
    }

    suspend fun getCustomerByContact(contactNo: String): List<CustomerDefaultEntity>? {
        return customerDefaultDao.getCustomerByContactNumber(contactNo)
    }

    suspend fun getCustomerDetails(guid: String): CustomerDefaultEntity? {
        return customerDefaultDao.getCustomerDetails(guid)
    }

    suspend fun getCustomerDetailsForCustomer(guid: String): CustomerEntity? {
        return customerDefaultDao.getCustomerDetailsForCustomer(guid)
    }

    suspend fun getAllCustomerUpload(): List<CustomerDefaultEntity>? {
        return customerDefaultDao.getAllCustomerUpload()
    }

    suspend fun getCustomerAadhaar(guid: String): String? {
        return customerDefaultDao.getCustomerAadhaar(guid)
    }

    suspend fun getCustomerDefaultGUID(userId: String): List<CustomerDefaultEntity> {
        return customerDefaultDao.getCustomerDefaultGUID(userId)
    }

    suspend fun deleteAllCustomers() {
        customerDefaultDao.deleteAllCustomer()
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
        customerDefaultDao.updateMyProfile(
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

    suspend fun updateMyKYC(
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
        customerDefaultDao.updateMyKYC(
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

    suspend fun updateUploaded() {
        customerDefaultDao.updateUploaded()
    }

    suspend fun updateUploadedNew() {
        customerDefaultDao.updateUploadedNew()
    }

    suspend fun getIsUploaded(guid: String): Int? {
        return customerDefaultDao.getIsUploaded(guid)
    }

    suspend fun getCount(): Int {
        return customerDefaultDao.getCount()
    }

    suspend fun getUploadCount(): Int {
        return customerDefaultDao.getAllCustomerUploadCount()
    }

    suspend fun getUploadCountNew(): Int {
        return customerDefaultDao.getAllCustomerUploadCountNew()
    }

    suspend fun getAllCustomerUploadNew(): List<CustomerDefaultEntity>? {
        return customerDefaultDao.getAllCustomerUploadNew()
    }
}
