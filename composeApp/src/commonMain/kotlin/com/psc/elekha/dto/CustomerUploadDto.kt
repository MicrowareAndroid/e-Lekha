package com.psc.elekha.dto

import kotlinx.serialization.Serializable

@Serializable
data class CustomerUploadDTO(

    val GUID: String,
    val CustomerID: String?,
    val CustomerTypeID: Int?,
    val UserID: String?,
    val LivingStatusID: Int?,
    val MaritalStatusID: Int?,
    val FirstName: String?,
    val MiddleName: String?,
    val LastName: String?,
    val CustomerImage: String?,

    val HusbandFName: String?,
    val HusbandMName: String?,
    val HusbandLName: String?,

    val GuarantorID: Int?,
    val GurantorFName: String?,
    val GurantorMName: String?,
    val GurantorLName: String?,
    val GuarantorImage: String?,

    val GuarantorDOB: String?,
    val GurantorAge: Int?,
    val GurarantorMobileNo: String?,
    val IsMobileNoValidatedGuarantor: Boolean?,
    val GurantorKElectricNumber: String?,

    val DOB: String?,
    val AgeAsOnYear: Int?,
    val Age: Int?,
    val ContactNoOwner: Int?,
    val ContactNo: String?,
    val PhoneNo: String?,

    val ReligionID: Int?,
    val CasteID: Int?,
    val EducationID: Int?,
    val OccuptionID: Int?,
    val MonthlyIncomeID: Int?,
    val LoanPurposeID: Int?,

    val HouseNo: String?,
    val PlotNo: String?,
    val Gali: String?,
    val Mohalla: String?,
    val Road: String?,
    val VillageID: Int?,
    val City: String?,
    val PinCode: String?,
    val StateID: Int?,
    val DistrictID: Int?,
    val Tehsil: String?,
    val Landmark: String?,
    val Address: String?,

    val MaternalAddress: String?,
    val MaternalMobileNo: String?,
    val MaternalStateID: Int?,
    val MaternalVillageName: String?,
    val MaternalFatherName: String?,

    val Assets_HouseEvaluation: Int?,
    val Assets_HouseStatus: Int?,
    val Assets_CeilingStatus: Int?,
    val Assets_Wall: Int?,
    val Assets_Rooms: Int?,
    val Assets_Electricity: Int?,
    val Assets_WaterSupply: Int?,
    val Assets_Sanitation: Int?,
    val Assets_LandHolding: Int?,

    val Assets_Animal_Cow: Boolean?,
    val Assets_Animal_Cow_Quantity: Int?,
    val Assets_Animal_Buffalo: Boolean?,
    val Assets_Animal_Buffalo_Quantity: Int?,
    val Assets_Animal_Goat: Boolean?,
    val Assets_Animal_Goat_Quantity: Int?,
    val Assets_Animal_Sheep: Boolean?,
    val Assets_Animal_Sheep_Quantity: Int?,
    val Assets_Animal_Other: Boolean?,
    val Assets_Animal_Other_Quantity: Int?,

    val Assets_Other_Television: Boolean?,
    val Assets_Other_Refrigerator: Boolean?,
    val Assets_Other_WaterCooler: Boolean?,
    val Assets_Other_WashingMachine: Boolean?,
    val Assets_Other_Sofa: Boolean?,
    val Assets_Other_Gas: Int?,

    val Assets_AddVehicle: Int?,
    val Assets_AddVehicle_Quantity: Int?,
    val Assets_PrimaryVehicle: Int?,
    val Assets_PrimaryVehicle_Quantity: Int?,

    val TotalMFI: Int?,
    val ToatalActiveMFI: Int?,
    val DisbursedAmtMFI: Int?,
    val LoanMFIOutstandingSelf: Int?,
    val LoanMFIOutstandingCreditEnquiry: Int?,
    val CreditEnquiryRemarks: String?,

    val PovertyStatus: String?,
    val KYCStatus: String?,

    val CGTMarks: Int?,
    val GRTDate: String?,
    val GRTPlace: String?,
    val GRTLat: String?,
    val GRTLong: String?,

    val RegistrationStatusID: Int?,
    val RegistrationDate: String?,
    val RegPlace: String?,
    val RegLat: String?,
    val RegLong: String?,

    val LoanAppliedID: Int?,
    val LoanApprovedID: Int?,
    val LoanApprovalDate: String?,
    val LoanApprovedAmt: Int?,
    val LoanApprovedInterestRate: Double?,
    val LoanApprovedInsuranceAmt: Int?,
    val LoanApprovedFeesAmt: Int?,
    val LoanApprovedInstallmentAmt: Int?,
    val LoanApprovedPaymentWeeks: Int?,
    val LoanApprovedCloserMinWeeks: Int?,
    val LoanApprovedRemarks: String?,

    val LoanSanctionedID: Int?,
    val LoanDisbursedID: Int?,
    val LoanDisbursedDate: String?,
    val LoanDisbRemarks: String?,
    val LoanEMIDate: String?,
    val LoanChequeBankID: Int?,
    val LoanChequeNo: String?,

    val IsLoanClosed: Boolean?,
    val IsWriteOff: Boolean?,
    val LoanCycle: Int?,

    val TabletID: String?,
    val TabletVersionName: String?,
    val FundSourceID: Int?,

    val DailyExpense: Int?,
    val MedicalExpense: Int?,
    val EducationExpense: Int?,
    val OtherExpense: Int?,
    val TotalMonthlyExpenditure: Int?,
    val TotalAnnualExpenditure: Int?,
    val FamilyMonthlyIncome: Int?,

    val Duplicate_Customer_Remark: String?,
    val Remarks: String?,

    val IsOldCustomer: Boolean?,
    val CustomerNickName: String?,
    val IsMobileNoValidated: Boolean?,

    val CreatedBy: String?,
    val CreatedOn: String?,
    val UpdatedBy: String?,
    val UpdatedOn: String?,
    val UploadedOn: String?,
    val IsDeleted: Boolean?,
    val IsEdited: Int?,
    val IsUpload: Int?,
    val OTPCODE: String?,

    val CKYC_UID: String?,
    val CKYC_UID_Image: String?,
    val CKYC_UID_Image2: String?,

    val CKYC_VoterCard: String?,
    val CKYC_VoterCard_Image: String?,
    val CKYC_VoterCard_Image2: String?,

    val CKYC_Passport: String?,
    val CKYC_Passport_Image: String?,
    val CKYC_Passport_Image2: String?,

    val CKYC_DL: String?,
    val CKYC_DL_Image: String?,

    val CKYC_PANCard: String?,
    val CKYC_PANCard_Image: String?,
    val CKYC_Pancard_Name: String?,

    val CKYC_OtherID: String?,
    val CKYC_OtherID_Image: String?,


    val CKYC_ElectricityBill: String?,
    val CKYC_ElectricityBillRelationID: Int?,
    val CKYC_ElectricityBill_Image: String?,
    val CKYC_ElectricityBill_Name: String?,

    val CKYC_WaterBill: String?,
    val CKYC_WaterBillRelationID: Int?,
    val CKYC_WaterBill_Image: String?,
    val CKYC_WaterBill_Name: String?,

    val CKYC_JobCard: String?,
    val CKYC_JobCardRelationID: Int?,
    val CKYC_JobCard_Image: String?,
    val CKYC_JobCard_Image2: String?,
    val CKYC_JobCard_Name: String?,

    val CKYC_OtherAP: String?,
    val CKYC_OtherAP_RelationID: Int?,
    val CKYC_OtherAP_Image: String?,
    val CKYC_OtherAP_Name: String?,

    val CKYC_RationCard: String?,
    val CKYC_RationCard_Image: String?,
    val CKYC_RationCard_Image2: String?,

    val CKYC_Bank: Int?,
    val CKYC_BankAccountNumber: String?,
    val CKYC_Bank_Image: String?,
    val CKYC_Bank_Branch: String?,
    val CKYC_Aadhar_Name: String?,
    val CKYC_VoterId_Name: String?,


    val GKYC_UID: String?,
    val GKYC_UID_Image: String?,
    val GKYC_UID_Image2: String?,

    val GKYC_VoterCard: String?,
    val GKYC_VoterCard_Image: String?,
    val GKYC_VoterCard_Image2: String?,

    val GKYC_Passport: String?,
    val GKYC_Passport_Image: String?,
    val GKYC_Passport_Image2: String?,

    val GKYC_DL: String?,
    val GKYC_DL_Image: String?,

    val GKYC_PANCard: String?,
    val GKYC_PANCard_Image: String?,
    val GKYC_Pancard_Name: String?,

    val GKYC_OtherID: String?,
    val GKYC_OtherID_Image: String?,
    val GKYC_OtherID_Image2: String?,

    val GKYC_ElectricityBill: String?,
    val GKYC_ElectricityBillRelationID: Int?,
    val GKYC_ElectricityBill_Image: String?,
    val GKYC_ElectricityBill_Name: String?,

    val GKYC_WaterBill: String?,
    val GKYC_WaterBilRelationID: Int?,
    val GKYC_WaterBill_Image: String?,
    val GKYC_WaterBill_Name: String?,

    val GKYC_JobCard: String?,
    val GKYC_JobCardRelationID: Int?,
    val GKYC_JobCard_Image: String?,
    val GKYC_JobCard_Image2: String?,
    val GKYC_JobCard_Name: String?,

    val GKYC_OtherAP: String?,
    val GKYC_OtherAP_RelationID: Int?,
    val GKYC_OtherAP_Image: String?,
    val GKYC_OtherAP_Name: String?,

    val GKYC_RationCard: String?,
    val GKYC_RationCard_Image: String?,

    val GKYC_Bank: Int?,
    val GKYC_BankAccountNumber: String?,
    val GKYC_Bank_Image: String?,
    val GKYC_IFSCCode: String?,
    val GKYC_BankNameEditable: String?,


    val CutomerStatusID: Int?,
    val LoanApprovalDoneBy: String?,
    val LoanDisbursalDoneBy: String?,
    val GRTDoneBy: String?,
    val CreditEnquiryDoneBy: String?,
    val CGTDoneBy: String?,

    val ExistingLoanAmount: Int?,
    val ExistingLoanCurrentOutstanding: Int?,
    val ExistingLoanCurrentWeek: Int?,

    val KElectricNumber: String?,
    val CustomerBankNameEditable: String?,
    val CustomerBankIFSCCode: String?,
    val CreditEquiryPDF: String?,

    val MandatePrint: Int?,
    val MandateStartDate: String?,
    val MandateEndDate: String?,
    val MandateApproved: Int?,
    val MandateRemark: Int?,

    val HouseHoldAssesment_Image: String?

)
