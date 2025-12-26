package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.CustomerEntity

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customerEntity: CustomerEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCustomer(customerEntity: List<CustomerEntity>)

    @Query("Select * from Customer")
    suspend fun getAllCustomer(): List<CustomerEntity>

    @Query("Select Count(*) from Customer Where IsDeleted = 0 and IsUpload = 0 and CutomerStatusID = 1")
    suspend fun getAllCountCustomer(): Int

    @Query("Select Count(*) from Customer where CutomerStatusID in(2,3) and IsDeleted = 0")
    suspend fun getLoanAppliedIDCount(): Int

    @Query("Select * from Customer where IsDeleted=0 and IsEdited=1")
    suspend fun getAllCustomerUpload(): List<CustomerEntity>

    @Query("Select * from Customer where ContactNo=:ContactNo")
    suspend fun getCustomerByContactNumber(ContactNo: String): List<CustomerEntity>

    @Query("Select * from Customer where ContactNo=:ContactNo and UserID=:UserID and CutomerStatusID = 5")
    suspend fun getCustomerByContactNumber(ContactNo: String, UserID: String): List<CustomerEntity>

    @Query("Select Count(*) from Customer where ContactNo=:ContactNo and CutomerStatusID=:CutomerStatusID")
    suspend fun getCountByContactNumber(ContactNo: String, CutomerStatusID: Int): Int

    @Query("Select Count(*) from Customer where ContactNo=:ContactNo")
    suspend fun getCountByContactNumber(ContactNo: String): Int

    @Query("Select * from Customer where GUID=:GUID")
    suspend fun getCustomerDetails(GUID: String): CustomerEntity

    @Query("Select CutomerStatusID from Customer where GUID=:GUID")
    suspend fun getCustomerStatus(GUID: String): Int

    @Query("Select Count(*) from Customer where GUID=:GUID and length(FirstName) > 0")
    suspend fun getMyProfileCount(GUID: String): Int

    @Query("Select Count(*) from Customer where GUID=:GUID and length(CKYC_UID) > 0")
    suspend fun getMyKYCCount(GUID: String): Int

    @Query("Delete from Customer")
    suspend fun deleteAllCustomer()

    @Query("Update Customer set MaritalStatusID=:MaritalStatusID, FirstName=:FirstName, MiddleName=:MiddleName, LastName=:LastName, CustomerImage=:Customer_Image, GurantorFName=:GuarantorFName, GurantorMName=:GuarantorMName, GurantorLName=:GuarantorLName, GuarantorImage=:Guarantor_Image, DOB=:DOB, Age=:Age, VillageID=:VillageID, Pincode=:Pincode, IsEdited=:IsEdited, GurantorAge=:GurantorAge, GuarantorDOB=:GurantorDOB, UpdatedBy=:UpdatedBy, UpdatedOn=:UpdatedOn, HusbandFName=:HusbandFName, HusbandMName=:HusbandMName, HusbandLName=:HusbandLName, CasteID=:CasteID, EducationID=:EducationID, ReligionID=:ReligionID, GuarantorID=:GuarantorID, HouseNo=:HouseNo, Mohalla=:Mohalla where GUID=:GUID")
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

    @Query(
        """
    UPDATE Customer SET
        -- CKYC
        CKYC_Aadhar_Name = :CKYC_Aadhar_Name,
        CKYC_UID = :CKYC_UID,
        CKYC_UID_Image = :CKYC_UID_Image,
        CKYC_ElectricityBill = :CKYC_ElectricityBill,
        CKYC_ElectricityBill_Image = :CKYC_ElectricityBill_Image,
        CKYC_ElectricityBill_Name = :CKYC_ElectricityBill_Name,
        KElectricNumber = :KElectricNumber,
        CKYC_VoterCard = :CKYC_VoterCard,
        CKYC_VoterCard_Image = :CKYC_VoterCard_Image,
        CKYC_VoterId_Name = :CKYC_VoterId_Name,

        -- GKYC
        GKYC_Aadhar_Name = :GKYC_Aadhar_Name,
        GKYC_UID = :GKYC_UID,
        GKYC_UID_Image = :GKYC_UID_Image,
        GKYC_UID_Image2 = :GKYC_UID_Image2,
        GKYC_ElectricityBill = :GKYC_ElectricityBill,
        GKYC_ElectricityBill_Image = :GKYC_ElectricityBill_Image,
        GurantorKElectricNumber = :GurantorKElectricNumber,
        GKYC_VoterCard = :GKYC_VoterCard,
        GKYC_VoterCard_Image = :GKYC_VoterCard_Image,
        GKYC_VoterId_Name = :GKYC_VoterId_Name,
        GKYC_PANCard = :GKYC_PANCard,
        GKYC_PANCard_Image = :GKYC_PANCard_Image,
        GKYC_Pancard_Name = :GKYC_Pancard_Name,

        -- common audit
        IsEdited = 1,
        UpdatedBy = :UpdatedBy,
        UpdatedOn = :UpdatedOn

    WHERE GUID = :GUID
    """
    )
    suspend fun updateMyKYC(
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
    )


    @Query("Update Customer set LoanAppliedID=:LoanAppliedID, FamilyMonthlyIncome=:FamilyMonthlyIncome, LoanPurposeID=:LoanPurposeID,CutomerStatusID=:CutomerStatusID,RegistrationDate=:RegistrationDate, IsEdited=:IsEdited, UpdatedBy=:UpdatedBy, UpdatedOn=:UpdatedOn, RegPlace=:RegPlace, RegLat=:RegLat, RegLong=:RegLong where GUID=:GUID")
    suspend fun updateMyLoan(
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
    suspend fun getCustomerByLoanApplied(CutomerStatusID: List<Int>): List<CustomerEntity>

    @Query("Select CKYC_UID from Customer where GUID =:GUID")
    suspend fun getCustomerAadhaar(GUID: String): String

    @Query("Select LoanAppliedID from Customer where GUID =:GUID")
    suspend fun getCustomerLoanAppliedID(GUID: String): Int

    @Query("Select :ColumnName from Customer where GUID =:GUID and IsDeleted=0")
    suspend fun getCustomerImageName(GUID: String, ColumnName: String): String

    /*@Query("select GUID from Customer where IsDeleted=0 UNION ALL select GUID from CustomerDefault where IsDeleted=0")
    fun getAllGUID(): List<String>?*/

    @Query("Update Customer set IsEdited=0, IsUpload=1 where IsEdited=1 and IsDeleted=0")
    suspend fun updateUploaded()

    @Query("Select IsUpload from Customer where GUID =:GUID")
    suspend fun getIsUploaded(GUID: String): Int

    @Query("Select Count(*) from Customer where IsDeleted = 0")
    suspend fun getCount(): Int

    @Query("Select * from Customer where RegistrationStatusID NOT in(:RegistrationStatusID) order by RegistrationStatusID")
    suspend fun getCustomerByRegistrationStatusID(RegistrationStatusID: List<Int>): List<CustomerEntity>

    @Query("Select max(LoanDisbursedDate) from Customer where ContactNo=:ContactNo")
    suspend fun getMaxLoan(ContactNo: String): String

    @Query("Select * from Customer where LoanDisbursedDate=:LoanDisbursedDate")
    suspend fun getCustomerDataBYLoanDate(LoanDisbursedDate: String): List<CustomerEntity>

    @Query("Select Count(*) from Customer where IsDeleted = 0 and CutomerStatusID in(:CutomerStatusID)")
    suspend fun getCustomerByLoanAppliedCount(CutomerStatusID: List<Int>): Int

    @Query("Select Count(*) from Customer where IsDeleted=0 and IsEdited=1")
    suspend fun getAllCustomerUploadCount(): Int

    @Query("Select * from Customer where IsDeleted=0 and IsEdited=1 and CustomerBankIFSCCode is not null and LoanAppliedID != 0")
    suspend  fun getAllCustomerUploadNew(): List<CustomerEntity>

    @Query("Select Count(*) from Customer where IsDeleted=0 and IsEdited=1 and CustomerBankIFSCCode is not null and LoanAppliedID != 0")
    suspend fun getAllCustomerUploadCountNew(): Int

    @Query("Update Customer set IsEdited=0, IsUpload=1 where IsEdited=1 and IsDeleted=0 and CustomerBankIFSCCode is not null and LoanAppliedID != 0")
    suspend fun updateUploadedNew()

    @Query("Select CustomerID from Customer where GUID=:GUID")
    suspend fun getCustomerIDByGUID(GUID: String): String

    @Query(
        "SELECT * FROM Customer " +
                "WHERE TRIM(" +
                "COALESCE(FirstName, '') || ' ' || " +
                "COALESCE(MiddleName, '') || ' ' || " +
                "COALESCE(LastName, '')" +
                ") LIKE '%' || :search || '%'"
    )
    fun searchCustomerByName(search: String): List<CustomerEntity>

    @Query(" SELECT * FROM Customer WHERE GUID =:guId")
    suspend fun getCustomerByGuid(guId: String): List<CustomerEntity>

    @Query("UPDATE Customer set CKYC_BankAccountNumber=:accountNo,CKYC_Bank=:bankId,CustomerBankIFSCCode=:ifscCode,UpdatedBy=:UpdatedBy,UpdatedOn=:UpdatedOn,isEdited = 1 WHERE GUID = :customerGuid")
    suspend fun updateBankDetail(
        customerGuid: String,
        accountNo: String,
        bankId: Int,
        ifscCode: String,
        UpdatedBy: Int?,
        UpdatedOn: String?)

    @Query("""
UPDATE Customer SET
    FirstName = :firstName,
    MiddleName = :middleName,
    LastName = :lastName,
    MaritalStatusID = :maritalStatusId,
    EducationID = :educationId,
    ReligionID = :religionId,
    ContactNo = :contactNo,
    HusbandFName = :husbandFName,
    HusbandMName = :hubandMName,
    HusbandLName = :husbandLName,
    GurantorFName = :gurantorFName,
    GurantorMName = :gurantorMName,
    GurantorLName = :gurantorLName,
    GuarantorDOB = :gurantorDOB,
    GuarantorMobileNo = :gurantorMobile,
    Age = :age,
    StateID = :stateID,
    DistrictID = :districtId,
    VillageID = :villageId,
    GuarantorID = :guarantorID,
    Tehsil = :tehsil,
    Landmark = :landmark,
    Address = :address,
    MaternalAddress = :maternalAddress,
    MaternalVillageName = :villageName,
    MaternalMobileNo = :maternalMobile,
    MaternalFatherName = :maternalFather,
    
    LoanMFIOutstandingCreditEnquiry=:outStanding,
    DailyExpense = :dailyExpenses,
    MedicalExpense = :medicalExpense,
    OtherExpense = :others,
    TotalMonthlyExpenditure = :totalMonthlyExpendture,
    TotalAnnualExpenditure = :totalAnnual,
    DOB = :dob,
    UpdatedOn = :updatedOn,
    UpdatedBy = :updatedBy,
    IsEdited = 1

WHERE GUID = :guid
""")
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
        medicalExpense: Int?,
        others: Int?,
        totalMonthlyExpendture: Int?,
        totalAnnual: Int?,
        dob: String?,
        updatedOn: String?,
        updatedBy: String?
    )


}