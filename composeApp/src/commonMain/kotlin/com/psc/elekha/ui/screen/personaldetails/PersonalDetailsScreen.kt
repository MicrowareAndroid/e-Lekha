package com.psc.elekha.ui.screen.personaldetails

import CustomAlertMovableAssets
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import com.psc.elekha.database.viewmodel.CustomerFamilyMemberDetailsViewModel
import com.psc.elekha.database.viewmodel.CustomerMovableAssetsViewModel
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
import com.psc.elekha.database.viewmodel.MSTDistrictViewModel
import com.psc.elekha.database.viewmodel.MSTStateViewModel
import com.psc.elekha.database.viewmodel.MSTVillageViewModel
import com.psc.elekha.database.viewmodel.UserBranchViewModel
import com.psc.elekha.model.EconomicMonthlyIncomeModel
import com.psc.elekha.model.EconomicMovableAssetsModel
import com.psc.elekha.model.FamilyDetailModel
import com.psc.elekha.ui.screen.economicdetails.EconomicMovableAssetsCard
import com.psc.elekha.ui.screen.familydetails.FamilyDetailCard
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.formborder
import com.psc.elekha.ui.theme.text_fiiled_color
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.CommonSaveButton
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.CustomAlertDialog
import com.psc.elekha.utils.DynamicCheckBox

import com.psc.elekha.utils.FillDynamicSpinnerespt
import com.psc.elekha.utils.FormDatePickerCompacts
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTextViewes
import com.psc.elekha.utils.getMaxDateInstant
import com.psc.elekha.utils.getMinDateInstant
import com.psc.elekha.utils.isAge18Plus
import com.psc.elekha.utils.pickMinMaxDate
import com.psc.elekha.utils.returnStringValue
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.add
import e_lekha.composeapp.generated.resources.add_more_family_member
import e_lekha.composeapp.generated.resources.address
import e_lekha.composeapp.generated.resources.annual
import e_lekha.composeapp.generated.resources.customer_name
import e_lekha.composeapp.generated.resources.daily_expenses
import e_lekha.composeapp.generated.resources.date
import e_lekha.composeapp.generated.resources.date_of_birth
import e_lekha.composeapp.generated.resources.district
import e_lekha.composeapp.generated.resources.education
import e_lekha.composeapp.generated.resources.emi
import e_lekha.composeapp.generated.resources.enter_otp
import e_lekha.composeapp.generated.resources.enter_your_kyc_details
import e_lekha.composeapp.generated.resources.family_econonic_profile
import e_lekha.composeapp.generated.resources.father_name
import e_lekha.composeapp.generated.resources.full_name_of_applicant
import e_lekha.composeapp.generated.resources.guarantor_mobile_number
import e_lekha.composeapp.generated.resources.guarantor_name
import e_lekha.composeapp.generated.resources.husband_name
import e_lekha.composeapp.generated.resources.ic_add
import e_lekha.composeapp.generated.resources.income
import e_lekha.composeapp.generated.resources.landmark
import e_lekha.composeapp.generated.resources.marital_status
import e_lekha.composeapp.generated.resources.maternal_address
import e_lekha.composeapp.generated.resources.maternal_mob_no
import e_lekha.composeapp.generated.resources.medical
import e_lekha.composeapp.generated.resources.mfi_bank_name
import e_lekha.composeapp.generated.resources.mfi_details
import e_lekha.composeapp.generated.resources.mobile_number
import e_lekha.composeapp.generated.resources.movable_assets
import e_lekha.composeapp.generated.resources.next
import e_lekha.composeapp.generated.resources.not_same_as_customer_mobile_number
import e_lekha.composeapp.generated.resources.others
import e_lekha.composeapp.generated.resources.outstanding
import e_lekha.composeapp.generated.resources.pin_code
import e_lekha.composeapp.generated.resources.purpose
import e_lekha.composeapp.generated.resources.relation
import e_lekha.composeapp.generated.resources.religion
import e_lekha.composeapp.generated.resources.remarks
import e_lekha.composeapp.generated.resources.same_as_husband
import e_lekha.composeapp.generated.resources.select_customer_loan
import e_lekha.composeapp.generated.resources.send_otp
import e_lekha.composeapp.generated.resources.state
import e_lekha.composeapp.generated.resources.tehsil
import e_lekha.composeapp.generated.resources.total_monthly_expenditure
import e_lekha.composeapp.generated.resources.type_here
import e_lekha.composeapp.generated.resources.village_name
import e_lekha.composeapp.generated.resources.your_full_address
import e_lekha.composeapp.generated.resources.your_monthly_expenditure
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalDetailsScreen(
    onNextTab: () -> Unit = {}, onCancelTab: () -> Unit = {},

) {
    val context = LocalPlatformContext.current
    var showDialog by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }

    val viewModel = koinViewModel<PersonalDetailViewModel>()


    var showFamilyDialog by remember { mutableStateOf(false) }

    var mstComboViewModel=koinViewModel<MSTComboBox_NViewModel>()
    val maritalList by mstComboViewModel.maritalStatus.collectAsState()
    val qualificationList by mstComboViewModel.mstQualificationValue.collectAsState()
    val religionList by mstComboViewModel.religionValue.collectAsState()
    val relationList by mstComboViewModel.relationStatus.collectAsState()
    val locationList by mstComboViewModel.locationValue.collectAsState()
    val purposeList by mstComboViewModel.purposeValue.collectAsState()


    val stateViewModel = koinViewModel<MSTStateViewModel>()
    val branchViewModel = koinViewModel<UserBranchViewModel>()
    val mstVillageModel = koinViewModel<MSTVillageViewModel>()
    val districtViewModel = koinViewModel<MSTDistrictViewModel>()
    val customerFamilyViewmodel = koinViewModel<CustomerFamilyMemberDetailsViewModel>()
    val movableAssetsViewmodel = koinViewModel<CustomerMovableAssetsViewModel>()
    val stateList by stateViewModel.stateList.collectAsState()
    val districtList by districtViewModel.districtList.collectAsState()
    val villageList by mstVillageModel.villageList.collectAsState()
    val appPreferences: AppPreferences = koinInject()
    val familyMemberList by customerFamilyViewmodel.familyMemebers.collectAsState()
    val aseetsList by movableAssetsViewmodel.movalbleAssets.collectAsState()

    val totalFamilyIncome by remember(familyMemberList) {
        derivedStateOf {
            familyMemberList.sumOf {
                it.MonthlyIncome ?: 0
            }
        }
    }


    LaunchedEffect(Unit) {

        mstComboViewModel.loadLookUpValues(lookupTypeFk = 27)
        mstComboViewModel.loadLookUpValues(lookupTypeFk = 2)
        mstComboViewModel.loadLookUpValues(lookupTypeFk = 4)
        mstComboViewModel.loadLookUpValues(lookupTypeFk = 1)
        mstComboViewModel.loadLookUpValues(lookupTypeFk = 7)
        districtViewModel.loadDistrictByStateID()
        branchViewModel.loadAllUserBranches()
        val username = "developer" // Or get from logged-in user
        mstVillageModel.loadVillagesByUsername(username)
        /*var branchId=appPreferences.getInt(AppSP.branchId)
        mstVillageModel.loadVillagesByBranchID(branchId )*/
        stateViewModel.loadAllStates()
        viewModel.loadSavedData()
        customerFamilyViewmodel.getCustomerByGuid(returnStringValue(appPreferences.getString(AppSP.customerGuid)))
        movableAssetsViewmodel.getAssetsByCustGuid(returnStringValue(appPreferences.getString(AppSP.customerGuid)))
    }
    val filteredDistrictList by remember(districtList, viewModel.stateId) {
        derivedStateOf {
            districtList.filter { it.StateID == viewModel.stateId }
        }
    }
   /* val filterVillageList by remember(villageList, viewModel.branchId) {
        derivedStateOf {
            villageList.filter { it.BranchID == viewModel.branchId }
        }
    }*/

    Box(
        modifier = Modifier
            .fillMaxSize()
        //.background(white)
    )
    {

        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(10.dp))


            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())

                    .padding(bottom = 16.dp)
            )
            {

                Spacer(modifier = Modifier.height(8.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                )
                {
                    FormFieldCompact(
                        label = stringResource(Res.string.customer_name),
                        value = viewModel.customerName,
                        onValueChange = { viewModel.customerName = it },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterCustomerName)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterCustomerName),
                        maxLength = 30,

                        )

                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormDatePickerCompacts(
                        label = stringResource(Res.string.date_of_birth),
                        value = viewModel.dateOfBirth,
                        onValueChange = { },
                        onClick = {
                            pickMinMaxDate(
                                context = context,
                                onDatePicked = { date ->
                                    viewModel.dateOfBirth = date
                                    /*// Optional validation: make sure user picked >=18 years
                                    if (isAge18Plus(date)) {
                                        viewModel.dateOfBirth = date
                                    } else {

                                    }*/
                                },
                                minDate = getMinDateInstant(),
                                maxDate = getMaxDateInstant()
                            )
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(Res.drawable.date),
                                contentDescription = "Date Icon",
                                tint = Color.Unspecified
                            )
                        },
                        isEnable = true,
                        modifier = Modifier.weight(1f)
                    )

                    FillDynamicSpinnerespt(
                        label = stringResource(Res.string.marital_status),
                        options = maritalList,
                        selectedOption = viewModel.maritalStatusId,
                        onOptionSelected = { viewModel.maritalStatusId = it },
                        focusRequester = viewModel.focusRequesterMaritalStatusId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterMaritalStatusId,
                        getOptionId = { it.ID },
                        getOptionLabel = { it.Value.toString() },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    FillDynamicSpinnerespt(
                        label = stringResource(Res.string.education),
                        options = qualificationList,
                        selectedOption = viewModel.educationId,
                        onOptionSelected = { viewModel.educationId = it },
                        focusRequester = viewModel.focusRequesterEducationId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterEducationId,
                        getOptionId = { it.ID },
                        getOptionLabel = { it.Value.toString() },
                        modifier = Modifier.weight(1f)
                    )


                    FillDynamicSpinnerespt(
                        label = stringResource(Res.string.religion),
                        options = religionList,
                        selectedOption = viewModel.religionId,
                        onOptionSelected = { viewModel.religionId = it },
                        focusRequester = viewModel.focusRequesterReligionId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterReligionId,
                        getOptionId = { it.ID },
                        getOptionLabel = { it.Value.toString() },
                        modifier = Modifier.weight(1f)
                    )


                }
                Spacer(modifier = Modifier.height(8.dp))

                FillDynamicSpinnerespt(
                    label = stringResource(Res.string.purpose),
                    options = purposeList,
                    selectedOption = viewModel.purposeId,
                    onOptionSelected = {viewModel.purposeId = it },
                    focusRequester = viewModel.focusRequesterPurposeId,
                    bringIntoViewRequester = viewModel.bringIntoViewRequesterPurposeId,
                    getOptionId = { it.ID },
                    getOptionLabel = { it.Value.toString() },
                    modifier = Modifier.fillMaxWidth()
                )



                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.mobile_number),
                        value = viewModel.mobileNumber,
                        onValueChange = { mobilenumber ->
                            viewModel.mobileNumber = mobilenumber
                        },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.fillMaxWidth()
                            .focusRequester(viewModel.focusRequesterMobileNumber)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterMobileNumber),
                        inputType = KeyboardType.Number,

                        )

                }
                Spacer(modifier = Modifier.height(8.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.enter_otp),
                        value = viewModel.otpNumber,
                        onValueChange = { gurantorotp ->
                            viewModel.otpNumber = gurantorotp
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(2f),
                        inputType = KeyboardType.Number
                    )

                    CommonSingleButtonsBottomString(
                        onOkClick = {

                        },
                        stringResource(Res.string.send_otp),
                        modifier = Modifier.weight(1f),
                        textSize =12
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))


                FormFieldCompact(
                    label = stringResource(Res.string.husband_name),
                    value = viewModel.husbandName,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { husbandname ->
                        viewModel.husbandName = husbandname

                        if (isChecked) {
                            viewModel.gurantorName = husbandname
                        }
                    },
                    inputType = KeyboardType.Text,
                    modifier = Modifier
                        .focusRequester(viewModel.focusRequesterHusbandName)
                        .bringIntoViewRequester(viewModel.bringIntoViewRequesterHusbandName)
                )

                Spacer(modifier = Modifier.height(3.dp))


                DynamicCheckBox(
                    label = stringResource(Res.string.same_as_husband),
                    isChecked = isChecked,
                    onCheckedChange = { checked ->
                        isChecked = checked
                        if (checked) {

                            viewModel.gurantorName = viewModel.husbandName
                        }
                    }
                )

                Spacer(modifier = Modifier.height(2.dp))


                FormFieldCompact(
                    label = stringResource(Res.string.guarantor_name),
                    value = viewModel.gurantorName,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { gurantorname ->
                        if (!isChecked) {
                            viewModel.gurantorName = gurantorname
                        }
                    },
                    inputType = KeyboardType.Text,
                    isEnable = !isChecked,
                    modifier = Modifier
                        .focusRequester(viewModel.focusRequesterGurantorName)
                        .bringIntoViewRequester(viewModel.bringIntoViewRequesterGurantorName),

                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FillDynamicSpinnerespt(
                        label = stringResource(Res.string.relation),
                        options = relationList,
                        selectedOption = viewModel.relationId,
                        onOptionSelected = {viewModel.relationId = it },
                        focusRequester = viewModel.focusRequesterRelationId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterRelationId,
                        getOptionId = { it.ID },
                        getOptionLabel = { it.Value.toString() },
                        modifier = Modifier.weight(1f)
                    )
                    FormDatePickerCompacts(
                        label = stringResource(Res.string.date_of_birth),
                        value = viewModel.gurantordateOfBirth,
                        onValueChange = {  },
                        onClick = {
                            pickMinMaxDate(
                                context = context,
                                onDatePicked = { date ->
                                    viewModel.gurantordateOfBirth = date
                                    /*if (isAge18Plus(date)) {
                                        viewModel.gurantordateOfBirth = date
                                    } else {

                                    }*/
                                },
                                minDate = getMinDateInstant(),
                                maxDate = getMaxDateInstant()
                            )
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(Res.drawable.date),
                                contentDescription = "Date Icon",
                                tint = Color.Unspecified
                            )
                        },
                        isEnable = true,
                        modifier = Modifier.weight(1f)
                    )


                }

                Spacer(modifier = Modifier.height(8.dp))

                // ---------------- Form Start ----------------
                FormFieldCompact(
                    label = stringResource(Res.string.guarantor_mobile_number),
                    value = viewModel.gurantormobileNumber,
                    placeholder = stringResource(Res.string.not_same_as_customer_mobile_number),
                    onValueChange = { gurantormbno ->
                        viewModel.gurantormobileNumber = gurantormbno
                    },
                    modifier = Modifier.focusRequester(viewModel.focusRequesterGurantormobileNumber)
                        .bringIntoViewRequester(viewModel.bringIntoViewRequesterGurantormobileNumber),
                    maxLength = 10,
                    inputType = KeyboardType.Number,


                    )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.enter_otp),
                        value = viewModel.guranterOtp,
                        onValueChange = { gurantorotp ->
                            viewModel.guranterOtp = gurantorotp
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(2f),
                        inputType = KeyboardType.Number
                    )

                    CommonSingleButtonsBottomString(
                        onOkClick = {

                        },
                        stringResource(Res.string.send_otp),
                        modifier = Modifier.weight(1f),
                        textSize =12
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // ---------------- Form Start ----------------
                FormFieldCompact(
                    label = stringResource(Res.string.your_full_address),
                    value = viewModel.fulladdresss,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { yourfulladdress ->
                        viewModel.fulladdresss = yourfulladdress
                    },
                    inputType = KeyboardType.Text,
                    modifier = Modifier.focusRequester(viewModel.focusRequesterFullAddress)
                        .bringIntoViewRequester(viewModel.bringIntoViewRequesterFullAddress),

                    )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FillDynamicSpinnerespt(
                        label = stringResource(Res.string.state),
                        options = stateList,
                        selectedOption = viewModel.stateId,
                        onOptionSelected = {viewModel.stateId = it },
                        focusRequester = viewModel.focusRequesterStateId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterStateId,
                        getOptionId = { it.StateID },
                        getOptionLabel = { it.State.toString() },
                        modifier = Modifier.weight(1f)
                    )

                    FillDynamicSpinnerespt(
                        label = stringResource(Res.string.district),
                        options = filteredDistrictList,
                        selectedOption = viewModel.districtId,
                        onOptionSelected = {viewModel.districtId = it },
                        focusRequester = viewModel.focusRequesterStateId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterStateId,
                        getOptionId = { it.DistrictID },
                        getOptionLabel = { it.District.toString() },
                        modifier = Modifier.weight(1f)
                    )

                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FillDynamicSpinnerespt(
                        label = stringResource(Res.string.village_name),
                        options = villageList,
                        selectedOption = viewModel.villageId,
                        onOptionSelected = {viewModel.villageId = it },
                        focusRequester = viewModel.focusRequesterStateId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterStateId,
                        getOptionId = { it.VillageID },
                        getOptionLabel = { it.Village.toString() },
                        modifier = Modifier.weight(1f)
                    )


                    FormFieldCompact(
                        label = stringResource(Res.string.tehsil),
                        value = viewModel.tehsilName,
                        onValueChange = { tehsill ->
                            viewModel.tehsilName = tehsill
                        },
                        inputType = KeyboardType.Text,
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterTehsilName)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterTehsilName),


                        )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.landmark),
                        value = viewModel.landMark,
                        onValueChange = { landmarks ->
                            viewModel.landMark = landmarks
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterLandMark)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterLandMark),


                        )

                    FormFieldCompact(
                        label = stringResource(Res.string.pin_code),
                        value = viewModel.pinCode,
                        onValueChange = { pincode ->
                            viewModel.pinCode = pincode
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterPinCode)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterPinCode),
                        inputType = KeyboardType.Number,
                        maxLength = 6

                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                ReusableTextViewes(
                    text = stringResource(Res.string.maternal_address)
                )
                Spacer(modifier = Modifier.height(8.dp))
                FormFieldCompact(
                    label = stringResource(Res.string.address),
                    value = viewModel.maternalAddress,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { maternaladdress ->
                        viewModel.maternalAddress = maternaladdress
                    },
                    inputType = KeyboardType.Text,
                    isEnable = true,
                    modifier = Modifier.focusRequester(viewModel.focusRequesterMaternalAddress)
                        .bringIntoViewRequester(viewModel.bringIntoViewRequesterMaternalAddress)


                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    FormFieldCompact(
                        label = stringResource(Res.string.village_name),
                        value = viewModel.villageNames,
                        onValueChange = {viewModel.villageNames=it},
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterMaternalVillage)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterMaternalVillage),

                        inputType = KeyboardType.Text,


                    )

                    FormFieldCompact(
                        label = stringResource(Res.string.maternal_mob_no),
                        value = viewModel.maternalMobileNo,
                        onValueChange = { maternalmbno ->
                            viewModel.maternalMobileNo = maternalmbno
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterMaternalMobileNo)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterMaternalMobileNo),
                        inputType = KeyboardType.Number,
                        maxLength = 10

                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.father_name),
                        value = viewModel.fatherName,
                        onValueChange = { fathername ->
                            viewModel.fatherName = fathername
                        },
                        inputType = KeyboardType.Text,
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterFatherName)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterFatherName),


                        )
                    FillDynamicSpinnerespt(
                        label = stringResource(Res.string.state),
                        options = stateList,
                        selectedOption = viewModel.stateId,
                        onOptionSelected = {viewModel.stateId = it },
                        focusRequester = viewModel.focusRequesterStateId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterStateId,
                        getOptionId = { it.StateID },
                        getOptionLabel = { it.State.toString() },
                        modifier = Modifier.weight(1f)
                    )


                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ReusableTextViewes(
                        text = stringResource(Res.string.add_more_family_member),
                                modifier = Modifier.weight(1f)
                    )

                    FloatingActionButton(
                        onClick = {
                            appPreferences.putString(AppSP.FamilyMemberGuid, "")
                            showFamilyDialog = true },
                        containerColor = btn_color,
                        shape = CircleShape,
                        modifier = Modifier
                            .size(50.dp)
                            .border(1.dp, btn_color, CircleShape)
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_add),
                            contentDescription = stringResource(Res.string.add),
                            tint = black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
                if (showFamilyDialog) {
                    CustomAlertFamilyDetails(
                        title = stringResource(Res.string.add_more_family_member),
                        onSubmit = { customerFamilyViewmodel.getCustomerByGuid(
                            returnStringValue(appPreferences.getString(AppSP.customerGuid)))
                            showFamilyDialog = false},
                        onCancel = { showFamilyDialog = false }
                    )
                }


                familyMemberList.forEach { item ->
                    FamilyDetailCard(
                        familyDetailModel = item,
                        onDelete = {
                            customerFamilyViewmodel.deleteFamilyMember(item)


                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
                Spacer(modifier = Modifier.height(10.dp))
                ReusableTextViewes(
                    text = stringResource(Res.string.family_econonic_profile)
                )
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically //  IMPORTANT
                ) {
                    ReusableTextView(
                        text = stringResource(Res.string.income),
                        textColor = black,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.weight(1f)
                    )

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .background(
                                color = text_fiiled_color,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = formborder,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        ReusableTextView(
                            text = returnStringValue(totalFamilyIncome.toString())
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                ReusableTextViewes(
                    text = stringResource(Res.string.your_monthly_expenditure)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.daily_expenses),
                        value = viewModel.dailyExpense,
                        onValueChange = { viewModel.dailyExpense=it },
                        inputType = KeyboardType.Number,
                        maxLength = 7,
                        placeholder = stringResource(Res.string.type_here),

                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterDailyExpense)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterDailyExpense),

                        )
                    Spacer(modifier = Modifier.width(30.dp))
                    FormFieldCompact(
                        label = stringResource(Res.string.education),
                        value = viewModel.educationExpense,
                        onValueChange = { viewModel.educationExpense=it },
                        placeholder = stringResource(Res.string.type_here),
                        inputType = KeyboardType.Number,
                        maxLength = 7,

                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterEducationExpense)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterEducationExpense),

                        )

                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.medical),
                        value = viewModel.medicalExpense,
                        onValueChange = { viewModel.medicalExpense = it},
                        placeholder = stringResource(Res.string.type_here),
                        inputType = KeyboardType.Number,
                        maxLength = 7,

                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterMedicalExpense)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterMedicalExpense),

                        )
                    Spacer(modifier = Modifier.width(30.dp))
                    FormFieldCompact(
                        label = stringResource(Res.string.others),
                        value = viewModel.othersExpense,
                        onValueChange = { viewModel.othersExpense = it},
                        placeholder = stringResource(Res.string.type_here),
                        inputType = KeyboardType.Number,
                        maxLength = 7,

                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterOthersExpense)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterOthersExpense),

                        )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.total_monthly_expenditure),
                        value = viewModel.totalMonthlyExpense,
                        onValueChange = { viewModel.totalMonthlyExpense = it},
                        placeholder = stringResource(Res.string.type_here),
                        inputType = KeyboardType.Number,
                        maxLength = 7,
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterTotalMonthlyExpense)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterTotalMonthlyExpense),
                    )
                    Spacer(modifier = Modifier.width(30.dp))

                    FormFieldCompact(
                        label = stringResource(Res.string.annual),
                        value = viewModel.annualExpense,
                        onValueChange = { viewModel.annualExpense = it },
                        placeholder = stringResource(Res.string.type_here),
                        inputType = KeyboardType.Number,
                        maxLength = 7,
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterAnnualExpense)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterAnnualExpense),

                        )
                }
                Spacer(modifier = Modifier.height(10.dp))
                ReusableTextViewes(
                    text = stringResource(Res.string.mfi_details)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    FormFieldCompact(
                        label = stringResource(Res.string.mfi_bank_name),
                        value = viewModel.mfiBankExpense,
                        onValueChange = { viewModel.mfiBankExpense = it },
                        placeholder = stringResource(Res.string.type_here),
                        inputType = KeyboardType.Text,
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterMfiBankExpense)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterMfiBankExpense),

                        )
                    Spacer(modifier = Modifier.width(30.dp))
                    FormFieldCompact(
                        label = stringResource(Res.string.select_customer_loan),
                        value = viewModel.loanAmountExpense,
                        onValueChange = {viewModel.loanAmountExpense = it},
                        placeholder = stringResource(Res.string.type_here),
                        inputType = KeyboardType.Number,
                        maxLength = 9,
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterLoanAmountExpense)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterLoanAmountExpense),

                        )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.outstanding),
                        value = viewModel.outStandingExpense,
                        onValueChange = { viewModel.outStandingExpense = it },
                        placeholder = stringResource(Res.string.type_here),
                        inputType = KeyboardType.Number,
                        maxLength = 9,
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterOutStandingExpense)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterOutStandingExpense),

                        )
                    Spacer(modifier = Modifier.width(30.dp))
                    FormFieldCompact(
                        label = stringResource(Res.string.emi),
                        value = viewModel.emiExpense,
                        onValueChange = { viewModel.emiExpense = it },
                        placeholder = stringResource(Res.string.type_here),
                        inputType = KeyboardType.Number,
                        maxLength = 9,
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterEmiExpense)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterEmiExpense),

                        )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.full_name_of_applicant),
                        value = viewModel.fullNameExpense,
                        onValueChange = { viewModel.fullNameExpense = it},
                        placeholder = stringResource(Res.string.type_here),
                        inputType = KeyboardType.Text,
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterFullNameExpense)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterFullNameExpense),

                        )
                    Spacer(modifier = Modifier.width(30.dp))
                    FormFieldCompact(
                        label = stringResource(Res.string.remarks),
                        value =viewModel.remarksExpense,
                        onValueChange = { viewModel.remarksExpense = it},
                        placeholder = stringResource(Res.string.type_here),

                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterRemarksExpense)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterRemarksExpense),

                        )
                }


                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    ReusableTextViewes(
                        text = stringResource(Res.string.movable_assets),
                        modifier = Modifier.weight(1f)
                    )


                    // Right FAB
                    FloatingActionButton(
                        onClick = {
                            appPreferences.putString(AppSP.MovableAssetsGuid, "")
                            showDialog = true },
                        containerColor = btn_color,
                        shape = CircleShape,
                        modifier = Modifier
                            .size(50.dp)
                            .border(
                                width = 1.dp,
                                color = btn_color,
                                shape = CircleShape
                            )
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_add),
                            contentDescription = stringResource(Res.string.add),
                            tint = black
                        )
                    }
                }



                Spacer(modifier = Modifier.height(8.dp))

               /* LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 100.dp, max = 600.dp)
                        .padding(bottom = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(economicMovableAssetsModel.size) { index ->
                        EconomicMovableAssetsCard(
                            economicMovableAssetsModel = economicMovableAssetsModel[index],
                            onDelete = {
                                economicMovableAssetsModel =
                                    economicMovableAssetsModel.toMutableList().also {
                                        it.removeAt(index)
                                    }
                            }
                        )

                    }
                }*/

                if (showDialog) {
                    CustomAlertMovableAssets(
                        title = stringResource(Res.string.movable_assets),
                        onSubmit = { movableAssetsViewmodel.getAssetsByCustGuid(
                            returnStringValue(appPreferences.getString(AppSP.customerGuid)))
                            showDialog = false},
                        onCancel = { showDialog = false }
                    )
                }


                aseetsList.forEach { item ->
                    EconomicMovableAssetsCard(
                        economicMovableAssetsModel = item,
                        onDelete = {
                            movableAssetsViewmodel.deleteMovableAssets(item)
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }


            }

            CommonSaveButton(
                onSaveClick = {
                    viewModel.saveData()
                },
                saveText = stringResource(Res.string.next)
            )
            if (viewModel.showSaveAlert) {
                CustomAlertDialog(
                    showDialog = viewModel.showSaveAlert,
                    message = viewModel.saveMessage,
                    onConfirm = {
                        if (viewModel.saveFlag == 1) {
                            viewModel.showSaveAlert = false
                            onNextTab()
                        } else {
                            viewModel.requestFocus()
                        }
                    }
                )
            }
        }
    }
}







@Preview(showBackground = true)
@Composable
fun PersonalDetailsScreenPreview() {
    MaterialTheme {
        PersonalDetailsScreen(
            onNextTab = {},
            onCancelTab = {},

        )
    }
}
