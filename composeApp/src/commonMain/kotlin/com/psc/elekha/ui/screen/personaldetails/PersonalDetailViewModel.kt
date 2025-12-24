package com.psc.elekha.ui.screen.personaldetails

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerEntity
import com.psc.elekha.database.viewmodel.CustomerViewModel
import com.psc.elekha.model.ValidationModelContorl
import com.psc.elekha.ui.screen.base.BaseValidationViewModel
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.calculateAgeFromDobKMP
import com.psc.elekha.utils.convertDateFormatDDMMYYYY
import com.psc.elekha.utils.convertDateFormatYYYYMMDD
import com.psc.elekha.utils.currentDatetime
import com.psc.elekha.utils.generateRandomId
import com.psc.elekha.utils.parseNameDynamic
import com.psc.elekha.utils.returnIntegerValue
import com.psc.elekha.utils.returnStringValue
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.data_saved_successfully
import e_lekha.composeapp.generated.resources.data_updated_successfully
import e_lekha.composeapp.generated.resources.personal_annual
import e_lekha.composeapp.generated.resources.personal_customer_name
import e_lekha.composeapp.generated.resources.personal_district
import e_lekha.composeapp.generated.resources.personal_education
import e_lekha.composeapp.generated.resources.personal_education_selection
import e_lekha.composeapp.generated.resources.personal_emi_enter
import e_lekha.composeapp.generated.resources.personal_father
import e_lekha.composeapp.generated.resources.personal_full_address
import e_lekha.composeapp.generated.resources.personal_full_name
import e_lekha.composeapp.generated.resources.personal_gurantor_mobile
import e_lekha.composeapp.generated.resources.personal_gurantor_name
import e_lekha.composeapp.generated.resources.personal_husband_name
import e_lekha.composeapp.generated.resources.personal_landmark
import e_lekha.composeapp.generated.resources.personal_loan_enter

import e_lekha.composeapp.generated.resources.personal_marital
import e_lekha.composeapp.generated.resources.personal_maternal_address
import e_lekha.composeapp.generated.resources.personal_maternal_mobile
import e_lekha.composeapp.generated.resources.personal_medical
import e_lekha.composeapp.generated.resources.personal_mfi
import e_lekha.composeapp.generated.resources.personal_mobile_number
import e_lekha.composeapp.generated.resources.personal_others
import e_lekha.composeapp.generated.resources.personal_outstanding
import e_lekha.composeapp.generated.resources.personal_payment_daily
import e_lekha.composeapp.generated.resources.personal_pincode
import e_lekha.composeapp.generated.resources.personal_purpose
import e_lekha.composeapp.generated.resources.personal_relation
import e_lekha.composeapp.generated.resources.personal_religion
import e_lekha.composeapp.generated.resources.personal_remarks
import e_lekha.composeapp.generated.resources.personal_state
import e_lekha.composeapp.generated.resources.personal_tehsil
import e_lekha.composeapp.generated.resources.personal_total_monthly
import e_lekha.composeapp.generated.resources.personal_village

import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString


class PersonalDetailViewModel(
    val appPreferences: AppPreferences,
    val customerViewModel: CustomerViewModel
) :
    BaseValidationViewModel() {
    var customerName by mutableStateOf("")
    var dateOfBirth by mutableStateOf("")
    var religionId by mutableStateOf(0)
    var purposeId by mutableStateOf(0)
    var mobileNumber by mutableStateOf("")
    var otpNumber by mutableStateOf("")
    var husbandName by mutableStateOf("")
    var gurantorName by mutableStateOf("")
    var relationId by mutableStateOf(0)
    var dateOfBirths by mutableStateOf("")
    var gurantormobileNumber by mutableStateOf("")
    var otpNumbers by mutableStateOf("")
    var fulladdresss by mutableStateOf("")
    var stateId by mutableStateOf(0)
    var districtId by mutableStateOf(0)
    var villageId by mutableStateOf(0)
    var branchId by mutableStateOf<Int?>(null)
    var tehsilName by mutableStateOf("")
    var landMark by mutableStateOf("")
    var pinCode by mutableStateOf("")
    var customerImage by mutableStateOf("")
    var gurantorImage by mutableStateOf("")
    var maternalMobileNo by mutableStateOf("")
    var fatherName by mutableStateOf("")
    var villageNames by mutableStateOf("")
    var statesId by mutableStateOf("")
    var maternalAddress by mutableStateOf("")
    var maritalStatusId by mutableStateOf(0)

    var educationId by mutableStateOf(0)
    var dailyExpense by mutableStateOf("")
    var educationExpense by mutableStateOf("")
    var medicalExpense by mutableStateOf("")
    var othersExpense by mutableStateOf("")
    var totalMonthlyExpense by mutableStateOf("")
    var annualExpense by mutableStateOf("")
    var mfiBankExpense by mutableStateOf("")
    var loanAmountExpense by mutableStateOf("")
    var outStandingExpense by mutableStateOf("")
    var emiExpense by mutableStateOf("")
    var fullNameExpense by mutableStateOf("")
    var remarksExpense by mutableStateOf("")
    var name by mutableStateOf("")


    val bringIntoViewRequesterCustomerName = BringIntoViewRequester()
    val bringIntoViewRequesterDateOfBirth = BringIntoViewRequester()
    val bringIntoViewRequesterMaritalStatusId = BringIntoViewRequester()
    val bringIntoViewRequesterEducationId = BringIntoViewRequester()
    val bringIntoViewRequesterReligionId = BringIntoViewRequester()
    val bringIntoViewRequesterPurposeId = BringIntoViewRequester()
    val bringIntoViewRequesterMobileNumber = BringIntoViewRequester()
    val bringIntoViewRequesterGurantorName = BringIntoViewRequester()
    val bringIntoViewRequesterRelationId = BringIntoViewRequester()
    val bringIntoViewRequesterDateOfBirths = BringIntoViewRequester()
    val bringIntoViewRequesterGurantormobileNumber = BringIntoViewRequester()
    val bringIntoViewRequesterStateId = BringIntoViewRequester()
    val bringIntoViewRequesterDistrictId = BringIntoViewRequester()
    val bringIntoViewRequesterVillageName = BringIntoViewRequester()
    val bringIntoViewRequesterTehsilName = BringIntoViewRequester()
    val bringIntoViewRequesterLandMark = BringIntoViewRequester()
    val bringIntoViewRequesterPinCode = BringIntoViewRequester()
    val bringIntoViewRequesterHusbandName = BringIntoViewRequester()
    val bringIntoViewRequesterFullAddress = BringIntoViewRequester()
    val bringIntoViewRequesterMaternalMobileNo = BringIntoViewRequester()
    val bringIntoViewRequesterFatherName = BringIntoViewRequester()
    val bringIntoViewRequesterVillageNames = BringIntoViewRequester()
    val bringIntoViewRequesterStatesId = BringIntoViewRequester()
    val bringIntoViewRequesterDailyExpense = BringIntoViewRequester()
    val bringIntoViewRequesterEducationExpense = BringIntoViewRequester()
    val bringIntoViewRequesterMedicalExpense = BringIntoViewRequester()
    val bringIntoViewRequesterOthersExpense = BringIntoViewRequester()
    val bringIntoViewRequesterTotalMonthlyExpense = BringIntoViewRequester()
    val bringIntoViewRequesterAnnualExpense = BringIntoViewRequester()
    val bringIntoViewRequesterMfiBankExpense = BringIntoViewRequester()
    val bringIntoViewRequesterLoanAmountExpense = BringIntoViewRequester()
    val bringIntoViewRequesterOutStandingExpense = BringIntoViewRequester()
    val bringIntoViewRequesterFullNameExpense = BringIntoViewRequester()
    val bringIntoViewRequesterRemarksExpense = BringIntoViewRequester()
    val bringIntoViewRequesterEmiExpense = BringIntoViewRequester()

    val bringIntoViewRequesterMaternalAddress = BringIntoViewRequester()
    val focusRequesterMovableAssetId = FocusRequester()
    val focusRequesterVehicleNo = FocusRequester()

    val focusRequesterCustomerName = FocusRequester()

    val focusRequesterMaternalMobileNo = FocusRequester()
    val focusRequesterFatherName = FocusRequester()
    val focusRequesterVillageNames = FocusRequester()
    val focusRequesterStatesId = FocusRequester()
    val focusRequesterMaternalAddress = FocusRequester()
    val focusRequesterMaritalStatusId = FocusRequester()
    val focusRequesterEducationId = FocusRequester()
    val focusRequesterReligionId = FocusRequester()
    val focusRequesterPurposeId = FocusRequester()
    val focusRequesterMobileNumber = FocusRequester()
    val focusRequesterGurantorName = FocusRequester()
    val focusRequesterDateOfBirths = FocusRequester()
    val focusRequesterGurantormobileNumber = FocusRequester()
    val focusRequesterDistrictId = FocusRequester()
    val focusRequesterVillageName = FocusRequester()
    val focusRequesterDob = FocusRequester()
    val focusRequesterStateId = FocusRequester()
    val focusRequesterTehsilName = FocusRequester()
    val focusRequesterLandMark = FocusRequester()
    val focusRequesterPinCode = FocusRequester()
    val focusRequesterFullAddress = FocusRequester()
    val focusRequesterHusbandName = FocusRequester()
    val focusRequesterRelationId = FocusRequester()
    val focusRequesterDailyExpense = FocusRequester()
    val focusRequesterEducationExpense = FocusRequester()
    val focusRequesterMedicalExpense = FocusRequester()
    val focusRequesterOthersExpense = FocusRequester()
    val focusRequesterTotalMonthlyExpense = FocusRequester()
    val focusRequesterAnnualExpense = FocusRequester()
    val focusRequesterMfiBankExpense = FocusRequester()
    val focusRequesterLoanAmountExpense = FocusRequester()
    val focusRequesterOutStandingExpense = FocusRequester()
    val focusRequesterFullNameExpense = FocusRequester()
    val focusRequesterRemarksExpense = FocusRequester()
    val focusRequesterEmiExpense = FocusRequester()

    suspend fun savePersonalDetail() {
        val guid = appPreferences.getString(AppSP.customerGuid)
        val name = parseNameDynamic(returnStringValue(customerName))
        val husName = parseNameDynamic(returnStringValue(husbandName))
        val gurName = parseNameDynamic(returnStringValue(gurantorName))

        if (returnStringValue(guid).isEmpty()) {
            val newguid = generateRandomId()
            val entity = CustomerEntity(
                newguid,
                "",
                0,
                "",
                0,
                maritalStatusId,
                returnStringValue(name.firstName),
                returnStringValue(name.middleName),
                returnStringValue(name.lastName),
                "",
                returnStringValue(husName.firstName),
                returnStringValue(husName.middleName),
                returnStringValue(husName.lastName),
                0,
                returnStringValue(gurName.firstName),
                returnStringValue(gurName.middleName),
                returnStringValue(gurName.lastName),
                "",
                convertDateFormatYYYYMMDD(returnStringValue(dateOfBirth)),
                0,
                calculateAgeFromDobKMP(dateOfBirth),
                0,
                mobileNumber,
                gurantormobileNumber,
                religionId,
                0,
                educationId,
                0,
                0,
                0,
                "",
                "",
                "",
                "",
                "",
                villageId,
                "",
                pinCode,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                false,
                0,
                false,
                0,
                false,
                0,
                false,
                0,
                false,
                0,
                false,
                false,
                false,
                false,
                false,
                0,
                0,
                0,
                0,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                0,
                "",
                "",
                "",
                0,
                "",
                "",
                "",
                0,
                "",
                "",
                "",
                0,
                "",
                "",
                "",
                "",
                0,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                0,
                "",
                "",
                "",
                0,
                "",
                "",
                "",
                0,
                "",
                "",
                "",
                0,
                "",
                "",
                "",
                "",
                0,
                "",
                "",
                0,
                0,
                0,
                0,
                returnIntegerValue(outStandingExpense),
                "",
                "",
                "",
                0,
                "",
                "",
                0,
                0,
                "",
                0,
                0,
                0,
                "",
                "",
                "",
                0,
                "",
                0,
                "",
                0,
                0.0,
                0,
                0,
                0,
                0,
                0,
                "",
                false,
                "",
                0,
                appPreferences.getString(AppSP.userId),
                currentDatetime(),
                "",
                "",
                false,
                "",
                "",
                "",
                "",
                "",
                0,
                0,
                0,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                false,
                "",
                false,
                0,
                0,
                "",
                "",
                "",
                false,
                0,
                "",
                "",
                0,
                "",
                "",
                0,
                0,
                "",
                "",
                "",
                "",
                "",
                convertDateFormatYYYYMMDD(returnStringValue(appPreferences.getString(AppSP.dateOfBirth))),
                "",
                remarksExpense,
                1,
                "",
                0,
                0,
                "",

                )
            customerViewModel.insertCustomer(entity)
            appPreferences.putString(AppSP.customerGuid, newguid)
            saveMessage = getString(Res.string.data_saved_successfully)
            showSaveAlert = true
        }
        else {
            customerViewModel.updateCustomerBasicDetails(
                guid,
                name.firstName,
                name.middleName,
                name.lastName,
                maritalStatusId,
                educationId,
                religionId,
                mobileNumber,
                husName.firstName,
                husName.middleName,
                husName.lastName,
                calculateAgeFromDobKMP(dateOfBirth),
                gurName.firstName,
                gurName.middleName,
                gurName.lastName,
                gurantormobileNumber,
                dateOfBirth,
                appPreferences.getString(AppSP.userId),
                currentDatetime()
            )
            saveMessage = getString(Res.string.data_updated_successfully)
            showSaveAlert = true


        }
    }

    fun loadSavedData() {
        viewModelScope.launch {

            val savedGuid = returnStringValue(appPreferences.getString(AppSP.customerGuid))
            if (savedGuid.isNotEmpty()) {

                val listData = customerViewModel.getCustomerDetailGuid(savedGuid)
                if (listData.isNotEmpty()) {

                    val data = listData[0]

                    customerName = returnStringValue(data.FirstName)
                    maritalStatusId = returnIntegerValue(data.MaritalStatusID?.toString())
                    educationId = returnIntegerValue(data.EducationID?.toString())
                    religionId = returnIntegerValue(data.ReligionID?.toString())
                    mobileNumber = returnStringValue(listData[0].ContactNo)
                    husbandName = returnStringValue(listData[0].HusbandFName)
                    gurantorName = returnStringValue(listData[0].GurantorFName)
                    dateOfBirth = convertDateFormatDDMMYYYY(returnStringValue(listData[0].DOB))
                    //  relationId = returnIntegerValue(data.Re.toString())
                    remarksExpense = returnStringValue(data.Remarks)
                    //  gurantormobileNumber = returnIntegerValue(data..toString())
                    //districtId = returnIntegerValue(data.DistrictId.toString())
                    villageId =returnIntegerValue(data.VillageID?.toString())


                    // tehsilName = returnStringValue(data.TehsilName)
                    // landMark = returnStringValue(data.Landmark)
                    pinCode = returnStringValue(data.PinCode)
                }
            }
        }

    }

    fun saveData() {
        viewModelScope.launch {

            val validation = checkValidation()
            if (validation.isValid) {
                savePersonalDetail()
                showSaveAlert = true
                saveFlag = 1
            } else {
                showValidationError(validation)
            }
        }
    }


    private suspend fun checkValidation(): ValidationModelContorl {
        val pleasemaritalstatus = getString(Res.string.personal_marital)
        val pleaseEducation = getString(Res.string.personal_education)
        val pleaseReligion = getString(Res.string.personal_religion)
        val pleasePurpose = getString(Res.string.personal_purpose)
        val pleaseRelation = getString(Res.string.personal_relation)
        val pleaseState = getString(Res.string.personal_state)
        val pleaseDistrict = getString(Res.string.personal_district)

        return when {

            returnStringValue(customerName).isBlank() -> {
                val nameLabel = getString(Res.string.personal_customer_name)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterCustomerName,
                    bringIntoViewRequester = bringIntoViewRequesterCustomerName
                )
            }


            returnIntegerValue(maritalStatusId.toString()) == 0 -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleasemaritalstatus,
                    focusRequester = focusRequesterMaritalStatusId,
                    bringIntoViewRequester = bringIntoViewRequesterMaritalStatusId
                )
            }

            returnIntegerValue(educationId.toString()) == 0 -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleaseEducation,
                    focusRequester = focusRequesterEducationId,
                    bringIntoViewRequester = bringIntoViewRequesterEducationId
                )
            }

            returnIntegerValue(religionId.toString()) == 0 -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleaseReligion,
                    focusRequester = focusRequesterReligionId,
                    bringIntoViewRequester = bringIntoViewRequesterReligionId
                )
            }

            returnIntegerValue(purposeId.toString()) == 0 -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleasePurpose,
                    focusRequester = focusRequesterPurposeId,
                    bringIntoViewRequester = bringIntoViewRequesterPurposeId
                )
            }

            returnStringValue(mobileNumber).length < 10 -> {
                val msg = getString(Res.string.personal_mobile_number)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = msg,
                    focusRequester = focusRequesterMobileNumber,
                    bringIntoViewRequester = bringIntoViewRequesterMobileNumber
                )
            }

            returnStringValue(husbandName).isBlank() -> {
                val nameLabel = getString(Res.string.personal_husband_name)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterHusbandName,
                    bringIntoViewRequester = bringIntoViewRequesterHusbandName
                )
            }

            returnStringValue(gurantorName).isBlank() -> {
                val nameLabel = getString(Res.string.personal_gurantor_name)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterGurantorName,
                    bringIntoViewRequester = bringIntoViewRequesterGurantorName
                )
            }

            returnIntegerValue(relationId.toString()) == 0 -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleaseRelation,
                    focusRequester = focusRequesterRelationId,
                    bringIntoViewRequester = bringIntoViewRequesterRelationId
                )
            }

            returnStringValue(gurantormobileNumber).length < 10 -> {
                val nameLabel = getString(Res.string.personal_gurantor_mobile)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterGurantormobileNumber,
                    bringIntoViewRequester = bringIntoViewRequesterGurantormobileNumber
                )
            }

            returnStringValue(fulladdresss).isBlank() -> {
                val nameLabel = getString(Res.string.personal_full_address)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterFullAddress,
                    bringIntoViewRequester = bringIntoViewRequesterFullAddress
                )
            }

            returnIntegerValue(stateId.toString()) == 0 -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleaseState,
                    focusRequester = focusRequesterStateId,
                    bringIntoViewRequester = bringIntoViewRequesterStateId
                )
            }

            returnIntegerValue(districtId.toString()) == 0 -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleaseDistrict,
                    focusRequester = focusRequesterDistrictId,
                    bringIntoViewRequester = bringIntoViewRequesterDistrictId
                )
            }

            returnIntegerValue(villageId.toString()) == 0 -> {
                val nameLabel = getString(Res.string.personal_village)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterVillageName,
                    bringIntoViewRequester = bringIntoViewRequesterVillageName
                )
            }

            returnStringValue(tehsilName).isBlank() -> {
                val nameLabel = getString(Res.string.personal_tehsil)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterTehsilName,
                    bringIntoViewRequester = bringIntoViewRequesterTehsilName
                )
            }

            returnStringValue(landMark).isBlank() -> {
                val nameLabel = getString(Res.string.personal_landmark)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterLandMark,
                    bringIntoViewRequester = bringIntoViewRequesterLandMark
                )
            }

            returnStringValue(pinCode).length < 6 -> {
                val nameLabel = getString(Res.string.personal_pincode)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterPinCode,
                    bringIntoViewRequester = bringIntoViewRequesterPinCode
                )
            }

            returnStringValue(maternalAddress).isBlank() -> {
                val nameLabel = getString(Res.string.personal_maternal_address)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterMaternalAddress,
                    bringIntoViewRequester = bringIntoViewRequesterMaternalAddress
                )
            }

            returnStringValue(maternalMobileNo).isBlank() -> {
                val nameLabel = getString(Res.string.personal_maternal_mobile)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterMaternalMobileNo,
                    bringIntoViewRequester = bringIntoViewRequesterMaternalMobileNo
                )
            }

            returnStringValue(fatherName).isBlank() -> {
                val nameLabel = getString(Res.string.personal_father)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterFatherName,
                    bringIntoViewRequester = bringIntoViewRequesterFatherName
                )
            }


            returnStringValue(dailyExpense).isBlank() -> {
                val nameLabel = getString(Res.string.personal_payment_daily)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterDailyExpense,
                    bringIntoViewRequester = bringIntoViewRequesterDailyExpense
                )
            }

            returnStringValue(educationExpense).isBlank() -> {
                val nameLabel = getString(Res.string.personal_education_selection)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterEducationExpense,
                    bringIntoViewRequester = bringIntoViewRequesterEducationExpense
                )
            }

            returnStringValue(medicalExpense).isBlank() -> {
                val nameLabel = getString(Res.string.personal_medical)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterMedicalExpense,
                    bringIntoViewRequester = bringIntoViewRequesterMedicalExpense
                )
            }

            returnStringValue(othersExpense).isBlank() -> {
                val nameLabel = getString(Res.string.personal_others)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterOthersExpense,
                    bringIntoViewRequester = bringIntoViewRequesterOthersExpense
                )
            }

            returnStringValue(totalMonthlyExpense).isBlank() -> {
                val nameLabel = getString(Res.string.personal_total_monthly)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterTotalMonthlyExpense,
                    bringIntoViewRequester = bringIntoViewRequesterTotalMonthlyExpense
                )
            }

            returnStringValue(annualExpense).isBlank() -> {
                val nameLabel = getString(Res.string.personal_annual)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterAnnualExpense,
                    bringIntoViewRequester = bringIntoViewRequesterAnnualExpense
                )
            }

            returnStringValue(mfiBankExpense).isBlank() -> {
                val nameLabel = getString(Res.string.personal_mfi)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterMfiBankExpense,
                    bringIntoViewRequester = bringIntoViewRequesterMfiBankExpense
                )
            }

            returnStringValue(loanAmountExpense).isBlank() -> {
                val nameLabel = getString(Res.string.personal_loan_enter)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterLoanAmountExpense,
                    bringIntoViewRequester = bringIntoViewRequesterLoanAmountExpense
                )
            }

            returnStringValue(outStandingExpense).isBlank() -> {
                val nameLabel = getString(Res.string.personal_outstanding)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterOutStandingExpense,
                    bringIntoViewRequester = bringIntoViewRequesterOutStandingExpense
                )
            }

            returnStringValue(emiExpense).isBlank() -> {
                val nameLabel = getString(Res.string.personal_emi_enter)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterEmiExpense,
                    bringIntoViewRequester = bringIntoViewRequesterEmiExpense
                )
            }

            returnStringValue(fullNameExpense).isBlank() -> {
                val nameLabel = getString(Res.string.personal_full_name)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterFullNameExpense,
                    bringIntoViewRequester = bringIntoViewRequesterFullNameExpense
                )
            }

            returnStringValue(remarksExpense).isBlank() -> {
                val nameLabel = getString(Res.string.personal_remarks)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterRemarksExpense,
                    bringIntoViewRequester = bringIntoViewRequesterRemarksExpense
                )
            }


            else -> ValidationModelContorl(isValid = true)

        }
    }


}