package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.CustomerDefaultEntity
import com.psc.elekha.database.entity.CustomerEntity


@Dao
interface CustomerDefaultDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customerDefaultEntity: CustomerDefaultEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCustomer(customerDefaultEntity: List<CustomerDefaultEntity>)

    @Query("Select * from CustomerDefault")
    suspend fun getAllCustomer(): List<CustomerDefaultEntity>

    @Query("Select * from CustomerDefault where ContactNo=:ContactNo and CutomerStatusID = 5")
    suspend fun getCustomerByContactNumber(ContactNo: String): List<CustomerDefaultEntity>

    @Query("Select * from CustomerDefault where GUID=:GUID")
    suspend fun getCustomerDetails(GUID: String): CustomerDefaultEntity

    @Query("Select * from CustomerDefault where GUID=:GUID")
    suspend fun getCustomerDetailsForCustomer(GUID: String): CustomerEntity

    @Query("Select * from CustomerDefault where IsDeleted=0 and IsEdited=1")
    suspend fun getAllCustomerUpload(): List<CustomerDefaultEntity>

    @Query("Select CKYC_UID from CustomerDefault where GUID =:GUID")
    suspend fun getCustomerAadhaar(GUID: String): String?

    @Query("Select GUID from CustomerDefault where UserID =:UserID and CutomerStatusID=5")
    suspend fun getCustomerDefaultGUID(UserID: String): List<CustomerDefaultEntity>

    @Query("Delete from CustomerDefault")
    fun deleteAllCustomer()

    @Query("Update CustomerDefault set MaritalStatusID=:MaritalStatusID, FirstName=:FirstName, MiddleName=:MiddleName, LastName=:LastName, CustomerImage=:Customer_Image, GurantorFName=:GuarantorFName, GurantorMName=:GuarantorMName, GurantorLName=:GuarantorLName, GuarantorImage=:Guarantor_Image, DOB=:DOB, Age=:Age, VillageID=:VillageID, Pincode=:Pincode, IsEdited=:IsEdited, GurantorAge=:GurantorAge, GuarantorDOB=:GurantorDOB, UpdatedBy=:UpdatedBy, UpdatedOn=:UpdatedOn, HusbandFName=:HusbandFName, HusbandMName=:HusbandMName, HusbandLName=:HusbandLName, CasteID=:CasteID, EducationID=:EducationID, ReligionID=:ReligionID, GuarantorID=:GuarantorID, HouseNo=:HouseNo, Mohalla=:Mohalla where GUID=:GUID")
    suspend fun updateMyProfile(
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
        GurantorDOB: String,
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
        GUID: String
    )

    @Query("Update CustomerDefault set CKYC_UID=:CKYC_UID, CKYC_UID_Image=:CKYC_UID_Image, CKYC_UID_Image2=:CKYC_UID_Image2, CKYC_VoterCard=:CKYC_VoterCard, CKYC_VoterCard_Image=:CKYC_VoterCardImage, CKYC_VoterCard_Image2=:CKYC_VoterCardImage2, CKYC_ElectricityBill=:CKYC_ElectricityBill , CKYC_ElectricityBill_Image=:CKYC_ElectricityBill_Image, CKYC_ElectricityBillRelationID=:CKYC_ElectricityBillRelationID, CKYC_ElectricityBill_Name=:CKYC_ElectricityBill_Name, KElectricNumber=:KElectricNumber, CKYC_JobCard=:CKYC_JobCard, CKYC_JobCard_Image=:CKYC_JobCard_Image, CKYC_JobCardRelationID=:CKYC_JobCardRelationID, CKYC_JobCard_Name=:CKYC_JobCard_Name, CKYC_JobCard_Image2=:CKYC_JobCard_Image2,GKYC_UID=:GKYC_UID, GKYC_UID_Image=:GKYC_UID_Image, GKYC_UID_Image2=:GKYC_UID_Image2, IsEdited=:IsEdited, UpdatedBy=:UpdatedBy, UpdatedOn=:UpdatedOn, CKYC_RationCard=:CKYC_RationCard, CKYC_RationCard_Image=:CKYC_RationCard_Image, CKYC_RationCard_Image2=:CKYC_RationCard_Image2,CKYC_Bank=:CKYC_Bank,CKYC_BankAccountNumber=:CKYC_BankAccountNumber,CKYC_Bank_Image=:CKYC_Bank_Image,CustomerBankIFSCCode=:CustomerBankIFSCCode,CustomerBankNameEditable=:CustomerBankNameEditable where GUID=:GUID")
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
        IsEdited: Int,
        UpdatedBy: String,
        UpdatedOn: String,
//        GKYC_OtherID: String,
//        GKYC_OtherID_Image: String,
//        GKYC_OtherID_Image2: String,
        CKYC_RationCard: String,
        CKYC_RationCard_Image: String,
        CKYC_RationCard_Image2: String,
        CKYC_Bank: Int,
        CKYC_BankAccountNumber: String,
        CKYC_Bank_Image: String,
        CustomerBankIFSCCode: String,
        CustomerBankNameEditable: String,
        GUID: String
    )

    @Query("Update CustomerDefault set IsEdited=0, IsUpload=1 where IsEdited=1 and IsDeleted=0")
    suspend fun updateUploaded()

    @Query("Select IsUpload from CustomerDefault where GUID =:GUID")
    suspend fun getIsUploaded(GUID: String): Int?

    @Query("Select Count(*) from CustomerDefault where IsDeleted = 0")
    suspend fun getCount(): Int

    @Query("Select Count(*) from CustomerDefault where IsDeleted=0 and IsEdited=1")
    suspend fun getAllCustomerUploadCount(): Int

    @Query("Select Count(*) from CustomerDefault where IsDeleted=0 and IsEdited=1  and CustomerBankIFSCCode is not null")
    suspend fun getAllCustomerUploadCountNew(): Int

    @Query("Select * from CustomerDefault where IsDeleted=0 and IsEdited=1 and CustomerBankIFSCCode is not null")
    suspend fun getAllCustomerUploadNew(): List<CustomerDefaultEntity>

    @Query("Update CustomerDefault set IsEdited=0, IsUpload=1 where IsEdited=1 and IsDeleted=0 and CustomerBankIFSCCode is not null")
    suspend fun updateUploadedNew()
}