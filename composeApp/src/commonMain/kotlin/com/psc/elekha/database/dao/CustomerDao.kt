package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.CustomerEntity

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCustomer(customerEntity: CustomerEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCustomer(customerEntity: List<CustomerEntity>?)

    @Query("Select * from Customer")
    fun getAllCustomer(): List<CustomerEntity>?

    @Query("Select Count(*) from Customer Where IsDeleted = 0 and IsUpload = 0 and CutomerStatusID = 1")
    fun getAllCountCustomer(): Int?

    @Query("Select Count(*) from Customer where CutomerStatusID in(2,3) and IsDeleted = 0")
    fun getLoanAppliedIDCount(): Int?

    @Query("Select * from Customer where IsDeleted=0 and IsEdited=1")
    fun getAllCustomerUpload(): List<CustomerEntity>?

    @Query("Select * from Customer where ContactNo=:ContactNo")
    fun getCustomerByContactNumber(ContactNo: String): List<CustomerEntity>?

    @Query("Select * from Customer where ContactNo=:ContactNo and UserID=:UserID and CutomerStatusID = 5")
    fun getCustomerByContactNumber(ContactNo: String, UserID: String): List<CustomerEntity>?

    @Query("Select Count(*) from Customer where ContactNo=:ContactNo and CutomerStatusID=:CutomerStatusID")
    fun getCountByContactNumber(ContactNo: String, CutomerStatusID: Int): Int?

    @Query("Select Count(*) from Customer where ContactNo=:ContactNo")
    fun getCountByContactNumber(ContactNo: String): Int?

    @Query("Select * from Customer where GUID=:GUID")
    fun getCustomerDetails(GUID: String): CustomerEntity?

    @Query("Select CutomerStatusID from Customer where GUID=:GUID")
    fun getCustomerStatus(GUID: String): Int?

    @Query("Select Count(*) from Customer where GUID=:GUID and length(FirstName) > 0")
    fun getMyProfileCount(GUID: String): Int?

    @Query("Select Count(*) from Customer where GUID=:GUID and length(CKYC_UID) > 0")
    fun getMyKYCCount(GUID: String): Int?

    @Query("Delete from Customer")
    fun deleteAllCustomer()

    @Query("Update Customer set MaritalStatusID=:MaritalStatusID, FirstName=:FirstName, MiddleName=:MiddleName, LastName=:LastName, CustomerImage=:Customer_Image, GurantorFName=:GuarantorFName, GurantorMName=:GuarantorMName, GurantorLName=:GuarantorLName, GuarantorImage=:Guarantor_Image, DOB=:DOB, Age=:Age, VillageID=:VillageID, Pincode=:Pincode, IsEdited=:IsEdited, GurantorAge=:GurantorAge, GuarantorDOB=:GurantorDOB, UpdatedBy=:UpdatedBy, UpdatedOn=:UpdatedOn, HusbandFName=:HusbandFName, HusbandMName=:HusbandMName, HusbandLName=:HusbandLName, CasteID=:CasteID, EducationID=:EducationID, ReligionID=:ReligionID, GuarantorID=:GuarantorID, HouseNo=:HouseNo, Mohalla=:Mohalla where GUID=:GUID")
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

    @Query(
        "Update Customer set CKYC_UID=:CKYC_UID, CKYC_UID_Image=:CKYC_UID_Image, CKYC_UID_Image2=:CKYC_UID_Image2, CKYC_VoterCard=:CKYC_VoterCard, CKYC_VoterCard_Image=:CKYC_VoterCardImage, CKYC_VoterCard_Image2=:CKYC_VoterCardImage2, CKYC_ElectricityBill=:CKYC_ElectricityBill , CKYC_ElectricityBill_Image=:CKYC_ElectricityBill_Image, CKYC_ElectricityBillRelationID=:CKYC_ElectricityBillRelationID, CKYC_ElectricityBill_Name=:CKYC_ElectricityBill_Name, KElectricNumber=:KElectricNumber, CKYC_JobCard=:CKYC_JobCard, CKYC_JobCard_Image=:CKYC_JobCard_Image, CKYC_JobCardRelationID=:CKYC_JobCardRelationID, CKYC_JobCard_Name=:CKYC_JobCard_Name, CKYC_JobCard_Image2=:CKYC_JobCard_Image2,GKYC_UID=:GKYC_UID, GKYC_UID_Image=:GKYC_UID_Image, GKYC_UID_Image2=:GKYC_UID_Image2, IsEdited=:IsEdited, UpdatedBy=:UpdatedBy, UpdatedOn=:UpdatedOn,CKYC_Bank=:CKYC_Bank,CKYC_BankAccountNumber=:CKYC_BankAccountNumber,CKYC_Bank_Image=:CKYC_Bank_Image,CustomerBankIFSCCode=:CustomerBankIFSCCode,CustomerBankNameEditable=:CustomerBankNameEditable, CKYC_RationCard=:CKYC_RationCard, CKYC_RationCard_Image=:CKYC_RationCard_Image, CKYC_RationCard_Image2=:CKYC_RationCard_Image2, RegPlace=:RegPlace, RegLat=:RegLat, RegLong=:RegLong where GUID=:GUID"
    )
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
//        GKYC_OtherID: String,
//        GKYC_OtherID_Image: String,
//        GKYC_OtherID_Image2: String,
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
    )

    @Query("Update Customer set LoanAppliedID=:LoanAppliedID, FamilyMonthlyIncome=:FamilyMonthlyIncome, LoanPurposeID=:LoanPurposeID,CutomerStatusID=:CutomerStatusID,RegistrationDate=:RegistrationDate, IsEdited=:IsEdited, UpdatedBy=:UpdatedBy, UpdatedOn=:UpdatedOn, RegPlace=:RegPlace, RegLat=:RegLat, RegLong=:RegLong where GUID=:GUID")
    fun updateMyLoan(
        LoanAppliedID: Int,
        FamilyMonthlyIncome: Int,
        LoanPurposeID: Int,
        CutomerStatusID: Int,
        RegistrationDate: String,
        IsEdited: Int,
        UpdatedBy: String,
        UpdatedOn: String,
        RegPlace: String,
        RegLat: String,
        RegLong: String,
        GUID: String
    )

    @Query("Select * from Customer where IsDeleted = 0 and CutomerStatusID in(:CutomerStatusID) order by CutomerStatusID")
    fun getCustomerByLoanApplied(CutomerStatusID: List<Int>): List<CustomerEntity>?

    @Query("Select CKYC_UID from Customer where GUID =:GUID")
    fun getCustomerAadhaar(GUID: String): String?

    @Query("Select LoanAppliedID from Customer where GUID =:GUID")
    fun getCustomerLoanAppliedID(GUID: String): Int?

    @Query("Select :ColumnName from Customer where GUID =:GUID and IsDeleted=0")
    fun getCustomerImageName(GUID: String, ColumnName: String): String?

    /*@Query("select GUID from Customer where IsDeleted=0 UNION ALL select GUID from CustomerDefault where IsDeleted=0")
    fun getAllGUID(): List<String>?*/

    @Query("Update Customer set IsEdited=0, IsUpload=1 where IsEdited=1 and IsDeleted=0")
    fun updateUploaded()

    @Query("Select IsUpload from Customer where GUID =:GUID")
    fun getIsUploaded(GUID: String): Int?

    @Query("Select Count(*) from Customer where IsDeleted = 0")
    fun getCount(): Int

    @Query("Select * from Customer where RegistrationStatusID NOT in(:RegistrationStatusID) order by RegistrationStatusID")
    fun getCustomerByRegistrationStatusID(RegistrationStatusID: List<Int>): List<CustomerEntity>?

    @Query("Select max(LoanDisbursedDate) from Customer where ContactNo=:ContactNo")
    fun getMaxLoan(ContactNo: String): String?

    @Query("Select * from Customer where LoanDisbursedDate=:LoanDisbursedDate")
    fun getCustomerDataBYLoanDate(LoanDisbursedDate: String): List<CustomerEntity>?

    @Query("Select Count(*) from Customer where IsDeleted = 0 and CutomerStatusID in(:CutomerStatusID)")
    fun getCustomerByLoanAppliedCount(CutomerStatusID: List<Int>): Int?

    @Query("Select Count(*) from Customer where IsDeleted=0 and IsEdited=1")
    fun getAllCustomerUploadCount(): Int

    @Query("Select * from Customer where IsDeleted=0 and IsEdited=1 and CustomerBankIFSCCode is not null and LoanAppliedID != 0")
    fun getAllCustomerUploadNew(): List<CustomerEntity>?

    @Query("Select Count(*) from Customer where IsDeleted=0 and IsEdited=1 and CustomerBankIFSCCode is not null and LoanAppliedID != 0")
    fun getAllCustomerUploadCountNew(): Int

    @Query("Update Customer set IsEdited=0, IsUpload=1 where IsEdited=1 and IsDeleted=0 and CustomerBankIFSCCode is not null and LoanAppliedID != 0")
    fun updateUploadedNew()

    @Query("Select CustomerID from Customer where GUID=:GUID")
    fun getCustomerIDByGUID(GUID: String): String
}