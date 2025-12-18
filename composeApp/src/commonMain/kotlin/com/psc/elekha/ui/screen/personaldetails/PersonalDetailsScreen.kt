package com.psc.elekha.ui.screen.personaldetails

import CustomAlertMovableAssets
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil3.Uri
import coil3.compose.LocalPlatformContext
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
import com.psc.elekha.model.EconomicMonthlyIncomeModel
import com.psc.elekha.model.EconomicMovableAssetsModel
import com.psc.elekha.model.FamilyDetailModel
import com.psc.elekha.ui.screen.economicdetails.EconomicMovableAssetsCard
import com.psc.elekha.ui.screen.familydetails.FamilyDetailCard
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.blue
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.utils.AddCircleButton
import com.psc.elekha.utils.CommonSaveButton
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.CustomAlertDialog
import com.psc.elekha.utils.DynamicCheckBox
import com.psc.elekha.utils.FillDynamicSpinner
import com.psc.elekha.utils.FormDatePickerCompact
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.StaticComboBoxData
import com.psc.elekha.utils.pickDate
import com.psc.elekha.utils.toValueList
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.add
import e_lekha.composeapp.generated.resources.add_more_family
import e_lekha.composeapp.generated.resources.add_more_family_member
import e_lekha.composeapp.generated.resources.annual
import e_lekha.composeapp.generated.resources.camera
import e_lekha.composeapp.generated.resources.customer_id
import e_lekha.composeapp.generated.resources.customer_image
import e_lekha.composeapp.generated.resources.customer_name
import e_lekha.composeapp.generated.resources.daily_expenses
import e_lekha.composeapp.generated.resources.date
import e_lekha.composeapp.generated.resources.date_of_birth
import e_lekha.composeapp.generated.resources.district
import e_lekha.composeapp.generated.resources.education
import e_lekha.composeapp.generated.resources.emi
import e_lekha.composeapp.generated.resources.enter_otp
import e_lekha.composeapp.generated.resources.family_econonic
import e_lekha.composeapp.generated.resources.family_econonic_profile
import e_lekha.composeapp.generated.resources.father_name
import e_lekha.composeapp.generated.resources.full_name_of_applicant
import e_lekha.composeapp.generated.resources.guarantor_mobile_number
import e_lekha.composeapp.generated.resources.guarantor_name
import e_lekha.composeapp.generated.resources.husband_name
import e_lekha.composeapp.generated.resources.ic_add
import e_lekha.composeapp.generated.resources.ic_customer
import e_lekha.composeapp.generated.resources.ic_gurantor
import e_lekha.composeapp.generated.resources.income
import e_lekha.composeapp.generated.resources.landmark
import e_lekha.composeapp.generated.resources.marital_status
import e_lekha.composeapp.generated.resources.maternal_address
import e_lekha.composeapp.generated.resources.maternal_mob_no
import e_lekha.composeapp.generated.resources.medical
import e_lekha.composeapp.generated.resources.mfi_bank_name
import e_lekha.composeapp.generated.resources.mobile_number
import e_lekha.composeapp.generated.resources.movable_assets
import e_lekha.composeapp.generated.resources.next
import e_lekha.composeapp.generated.resources.no_vehicle
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
import e_lekha.composeapp.generated.resources.vehicle_no
import e_lekha.composeapp.generated.resources.village_name
import e_lekha.composeapp.generated.resources.your_full_address
import e_lekha.composeapp.generated.resources.your_monthly_expenditure
import e_lekha.composeapp.generated.resources.your_photo_with_guarantor
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalDetailsScreen(onNextTab: () -> Unit = {}, onCancelTab: () -> Unit = {}) {
    val context = LocalPlatformContext.current
    var showDialog by remember { mutableStateOf(false) }
//    val stateViewModel = koinViewModel<StateViewModel>()
//    val stateList by stateViewModel.stateValue.collectAsState()
    var expanded by remember { mutableStateOf(false) }
//    val lookUpValueViewModel = koinViewModel<LookUpValueViewmodel>()
//    val viewModel = koinViewModel<CaseIdentifierViewModel>()

//    val genderList by lookUpValueViewModel.genderLookups.collectAsState()
//
//    var showAlert = viewModel.showSaveAlert
//    var message = viewModel.saveMessage
    var familyDetailModel by rememberSaveable {
        mutableStateOf(
            listOf(
                FamilyDetailModel(
                    "Test",
                    "Brother",
                    "Graduate",
                    "Teacher"
                ),
                FamilyDetailModel(
                    "XYZ",
                    "Sister",
                    "PostGraduate",
                    "Doctor"
                ),
            )
        )


    }

    var economicMovableAssetsModel by rememberSaveable {
        mutableStateOf(
            listOf(
                EconomicMovableAssetsModel(
                    "Car",
                    "DL02A4444"
                ),
                EconomicMovableAssetsModel(
                    "Bike",
                    "DL02A4000"
                ),
                EconomicMovableAssetsModel(
                    "Truck",
                    "DL02A3000"
                )
            )
        )
    }

    var economicMonthlyIncomeModel by rememberSaveable {
        mutableStateOf(
            listOf(
                EconomicMonthlyIncomeModel(
                    "Test",
                    "Self",
                    "Working",
                    "20000"
                ),
                EconomicMonthlyIncomeModel(
                    "ABC",
                    "Brother",
                    "Working",
                    "10000"
                )
            )
        )
    }
   var mstComboViewModel=koinViewModel<MSTComboBox_NViewModel>()
    val maritalList by mstComboViewModel.maritalStatus.collectAsState()
    val qualificationList by mstComboViewModel.mstQualificationValue.collectAsState()
    val religionList by mstComboViewModel.religionValue.collectAsState()
    val relationList by mstComboViewModel.relationValue.collectAsState()
    val locationList by mstComboViewModel.locationValue.collectAsState()
    val genderList by mstComboViewModel.genderValue.collectAsState()

    var dob by remember { mutableStateOf("") }
    var maritalStatus by remember { mutableStateOf("") }

    var enter_otp by remember { mutableStateOf("") }

    var guarantordob by remember { mutableStateOf("") }

    var gurantor_enter_otp by remember { mutableStateOf("") }

    var isChecked by remember { mutableStateOf(false) }

    val viewModel = koinViewModel<PersonalDetailViewModel>()
    val coroutineScope = rememberCoroutineScope()

    var showFamilyDialog by remember { mutableStateOf(false) }


    LaunchedEffect(Unit) {
        mstComboViewModel.loadLookUpValues(lookupTypeFk = 1)
        mstComboViewModel.loadLookUpValues(lookupTypeFk = 2)
        mstComboViewModel.loadLookUpValues(lookupTypeFk = 3)
        mstComboViewModel.loadLookUpValues(lookupTypeFk = 4)
        mstComboViewModel.loadLookUpValues(lookupTypeFk = 5)
        mstComboViewModel.loadLookUpValues(lookupTypeFk = 6)


        viewModel.loadSavedData()
    }

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
                    .padding(bottom = 15.dp)

            ) {

                Spacer(modifier = Modifier.height(6.dp))
                ReusableTextView(
                    text = stringResource(Res.string.customer_id)
                )
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 10.dp),
//                    horizontalArrangement = Arrangement.spacedBy(16.dp)
//                ) {
//
//
//                    Column(
//                        modifier = Modifier.weight(1f),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//
//                        Spacer(modifier = Modifier.height(6.dp))
//
//                        Image(
//                            painter = painterResource(Res.drawable.ic_customer),
//                            contentDescription = null,
//                            modifier = Modifier
//                                .size(120.dp)
//                                .background(
//                                    Color(0xFFE8E8E8),
//                                    shape = RoundedCornerShape(8.dp)   // optional, looks better
//                                )
//                                .padding(4.dp),   // optional
//                            contentScale = ContentScale.Crop
//                        )
//                        Spacer(modifier = Modifier.height(6.dp))
//                        Icon(
//                            painter = painterResource(Res.drawable.camera),
//                            contentDescription = "Back Camera",
//                            tint = blue,
//                            modifier = Modifier.size(28.dp)
//                        )
//                        Spacer(modifier = Modifier.height(4.dp))
//                        ReusableTextView(
//                            text = stringResource(Res.string.customer_image)
//                        )
//
//                    }
//
//                    Column(
//                        modifier = Modifier.weight(1f),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//
//                        Spacer(modifier = Modifier.height(6.dp))
//
//                        Image(
//                            painter = painterResource(Res.drawable.ic_gurantor),
//                            contentDescription = null,
//                            modifier = Modifier
//                                .size(160.dp, 120.dp)
//                                .background(
//                                    Color(0xFFE8E8E8),
//                                    shape = RoundedCornerShape(8.dp)   // optional, looks better
//                                )
//                                .padding(4.dp),   // optional
//                            contentScale = ContentScale.Crop
//                        )
//                        Spacer(modifier = Modifier.height(6.dp))
//                        Icon(
//                            painter = painterResource(Res.drawable.camera),
//                            contentDescription = "Back Camera",
//                            tint = blue,
//                            modifier = Modifier.size(28.dp)
//                        )
//                        Spacer(modifier = Modifier.height(4.dp))
//                        ReusableTextView(
//                            text = stringResource(Res.string.your_photo_with_guarantor)
//                        )
//
//                    }
//                }

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
                    FormDatePickerCompact(
                        label = stringResource(Res.string.date_of_birth),
                        value = dob,
                        onValueChange = { dob = it },
                        onClick = {
                            pickDate(context) { date ->
                                dob = date
                            }
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

                    FormSpinner(
                        label = stringResource(Res.string.marital_status),
                        options = listOf("Married", "Unmarried", "Single"),
                        selectedOption = maritalStatus,
                        onOptionSelected = { selected ->
                            maritalStatus = selected
                        },
                        modifier = Modifier.weight(1f)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormDatePickerCompact(
                        label = stringResource(Res.string.date_of_birth),
                        value = dob,
                        onValueChange = { dob = it },
                        onClick = {
                            pickDate(context) { date ->
                                dob = date
                            }
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

                    FillDynamicSpinner(
                        label = stringResource(Res.string.marital_status),
                        options = maritalList,
                        selectedOption = viewModel.maritalStatusId,
                        onOptionSelected = { selected ->
                            viewModel.maritalStatusId = selected

                        },
                        focusRequester = viewModel.focusRequesterMaritalStatusId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterMaritalStatusId,
                        getOptionId = { it.ID },
                        getOptionLabel = { it.Value.toString() }
                    )


                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FillDynamicSpinner(
                        label = stringResource(Res.string.education),
                        options = qualificationList,
                        selectedOption = viewModel.educationId,
                        onOptionSelected = { selected ->
                            viewModel.educationId = selected

                        },
                        focusRequester = viewModel.focusRequesterEducationId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterEducationId,
                        getOptionId = { it.ID },
                        getOptionLabel = { it.Value.toString() }
                    )
                    FillDynamicSpinner(
                        label = stringResource(Res.string.religion),
                        options = religionList,
                        selectedOption = viewModel.religionId,
                        onOptionSelected = { selected ->
                            viewModel.religionId = selected

                        },
                        focusRequester = viewModel.focusRequesterReligionId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterReligionId,
                        getOptionId = { it.ID },
                        getOptionLabel = { it.Value.toString() }
                    )


                }
                Spacer(modifier = Modifier.height(8.dp))

                FillDynamicSpinner(
                    label = stringResource(Res.string.purpose),
                    options = relationList,
                    selectedOption = viewModel.purposeId,
                    onOptionSelected = { selected ->
                        viewModel.purposeId = selected

                    },
                    focusRequester = viewModel.focusRequesterPurposeId,
                    bringIntoViewRequester = viewModel.bringIntoViewRequesterPurposeId,
                    getOptionId = { it.ID },
                    getOptionLabel = { it.Value.toString() }
                )



                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.Bottom   // THIS aligns button with EditText
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.mobile_number),
                        value = viewModel.mobileNumber,
                        onValueChange = { mobilenumber ->
                            viewModel.mobileNumber = mobilenumber
                        },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(2f)
                            .focusRequester(viewModel.focusRequesterMobileNumber)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterMobileNumber),
                        inputType = KeyboardType.Number,

                        )

                    FormFieldCompact(
                        label = stringResource(Res.string.enter_otp),
                        value = enter_otp,
                        onValueChange = { enterotp ->
                            enter_otp = enterotp
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f),
                        inputType = KeyboardType.Number
                    )

                    CommonSingleButtonsBottomString(
                        onOkClick = {

                        },
                        stringResource(Res.string.send_otp),
                        modifier = Modifier.weight(1f),
                        textSize = 10
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // ---------------- Form Start ----------------
                FormFieldCompact(
                    label = stringResource(Res.string.husband_name),
                    value = viewModel.husbandName,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { husbandname ->
                        viewModel.husbandName = husbandname
                    },
                    maxLength = 20,
                    modifier = Modifier.focusRequester(viewModel.focusRequesterHusbandName)
                        .bringIntoViewRequester(viewModel.bringIntoViewRequesterHusbandName)

                )

                Spacer(modifier = Modifier.height(3.dp))

                DynamicCheckBox(
                    label = stringResource(Res.string.same_as_husband),
                    isChecked = isChecked,
                    onCheckedChange = { checked ->
                        isChecked = checked

                    }
                )

                Spacer(modifier = Modifier.height(2.dp))

                // ---------------- Form Start ----------------
                FormFieldCompact(
                    label = stringResource(Res.string.guarantor_name),
                    value = viewModel.gurantorName,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { gurantorname ->
                        viewModel.gurantorName = gurantorname
                    },
                    modifier = Modifier.focusRequester(viewModel.focusRequesterGurantorName)
                        .bringIntoViewRequester(viewModel.bringIntoViewRequesterGurantorName),
                    maxLength = 20,


                    )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    /*FormSpinner(
                        label = stringResource(Res.string.relation),
                        options = StaticComboBoxData.relationList.toValueList(),
                        selectedOption = viewModel.relationId,
                        onOptionSelected = { selectedValue ->
                            relationValue = selectedValue
                            viewModel.relationId =
                                StaticComboBoxData.relationList.firstOrNull { it.Value == selectedValue }?.ID
                                    ?: 0
                        },
                        modifier = Modifier.weight(1f)
                    )
*/
                    FormDatePickerCompact(
                        label = stringResource(Res.string.date_of_birth),
                        value = guarantordob,
                        onValueChange = { guarantordob = it },
                        onClick = {
                            pickDate(context) { date ->
                                guarantordob = date
                            }

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
                    verticalAlignment = Alignment.Bottom   // THIS aligns button with EditText
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.enter_otp),
                        value = gurantor_enter_otp,
                        onValueChange = { gurantorotp ->
                            gurantor_enter_otp = gurantorotp
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
                        textSize = 12
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
                    maxLength = 20,
                    modifier = Modifier.focusRequester(viewModel.focusRequesterFullAddress)
                        .bringIntoViewRequester(viewModel.bringIntoViewRequesterFullAddress),

                    )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    /*FormSpinner(
                        label = stringResource(Res.string.state),
                        options = StaticComboBoxData.stateList.toValueList(),
                        selectedOption = stateValue,
                        onOptionSelected = { selectedValue ->
                            stateValue = selectedValue
                            viewModel.stateId =
                                StaticComboBoxData.stateList.firstOrNull { it.Value == selectedValue }?.ID
                                    ?: 0
                        },
                        modifier = Modifier.weight(1f),
                    )*/

                    /*FormSpinner(
                        label = stringResource(Res.string.district),
                        options = StaticComboBoxData.districtList.toValueList(),
                        selectedOption = distictValue,
                        onOptionSelected = { selectedValue ->
                            distictValue = selectedValue
                            viewModel.districtId =
                                StaticComboBoxData.districtList.firstOrNull { it.Value == selectedValue }?.ID
                                    ?: 0
                        },
                        modifier = Modifier.weight(1f),
                    )*/
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.village_name),
                        value = viewModel.villageName,
                        onValueChange = { villagename ->
                            viewModel.villageName = villagename
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterVillageName)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterVillageName),


                        )

                    FormFieldCompact(
                        label = stringResource(Res.string.tehsil),
                        value = viewModel.tehsilName,
                        onValueChange = { tehsill ->
                            viewModel.tehsilName = tehsill
                        },
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
                FormFieldCompact(
                    label = stringResource(Res.string.maternal_address),
                    value = viewModel.maternalAddress,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { maternaladdress ->
                        viewModel.maternalAddress = maternaladdress
                    },
                    maxLength = 20,
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
                        value = viewModel.villageName,
                        onValueChange = { gurantorvillagename ->
                            viewModel.villageName = gurantorvillagename
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterVillageNames)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterVillageNames),


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
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                            .focusRequester(viewModel.focusRequesterFatherName)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterFatherName),


                        )
                   /* FormSpinner(
                        label = stringResource(Res.string.state),
                        options = StaticComboBoxData.stateList.toValueList(),
                        selectedOption = stateValue,
                        onOptionSelected = { selectedValue ->
                            stateValue = selectedValue
                            viewModel.stateId =
                                StaticComboBoxData.stateList.firstOrNull { it.Value == selectedValue }?.ID
                                    ?: 0
                        },
                        modifier = Modifier.weight(1f),
                    )*/

                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ReusableTextView(
                        text = stringResource(Res.string.add_more_family_member),
                        modifier = Modifier.weight(1f)
                    )

                    FloatingActionButton(
                        onClick = { showFamilyDialog = true },
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

                if (showFamilyDialog) {
                    CustomAlertFamilyDetails(
                        title = stringResource(Res.string.add_more_family_member),
                        onSubmit = { showFamilyDialog = false },
                        onCancel = { showFamilyDialog = false }
                    )
                }

                familyDetailModel.forEach { item ->
                    FamilyDetailCard(
                        familyDetailModel = item,
                        onEdit = {},
                        onDelete = {}
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
                Spacer(modifier = Modifier.height(10.dp))
                ReusableTextView(
                    text = stringResource(Res.string.family_econonic_profile)
                )
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.Bottom
                )
                {
                    ReusableTextView(
                        text = stringResource(Res.string.income),
                        modifier = Modifier.weight(1f)
                    )

                    ReusableTextView(
                        text = "20000",
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                ReusableTextView(
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
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(1f),
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    FormFieldCompact(
                        label = stringResource(Res.string.education),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(1f),
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
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(1f),
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    FormFieldCompact(
                        label = stringResource(Res.string.others),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(1f),
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
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(1f),
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    FormFieldCompact(
                        label = stringResource(Res.string.annual),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(1f),
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
                        label = stringResource(Res.string.mfi_bank_name),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(1f),
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    FormFieldCompact(
                        label = stringResource(Res.string.select_customer_loan),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(1f),
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
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(1f),
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    FormFieldCompact(
                        label = stringResource(Res.string.emi),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(1f),
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
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(1f),
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    FormFieldCompact(
                        label = stringResource(Res.string.remarks),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(1f),
                    )
                }


                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    ReusableTextView(
                        text = stringResource(Res.string.movable_assets),
                        modifier = Modifier.weight(1f)
                    )

                    // Right FAB
                    FloatingActionButton(
                        onClick = { showDialog = true },
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

                if (showDialog) {
                    CustomAlertMovableAssets(
                        onSubmit = {
                            showDialog = false
                        },
                        onCancel = {
                            showDialog = false
                        }
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                LazyVerticalGrid(
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
                            economicMovableAssetsModel[index]
                        )
                    }
                }


            } // END Scroll Column

            // Bottom Buttons (Not scrollable)
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







/*@Composable
fun SelectUserPopupDialog(
    onSave: (String) -> Unit = {},
    onClose: () -> Unit = {}
) {
    val users = listOf(
        "Suhani Singh" to "9235632587",
        "Anita Kumari" to "9235632587",
        "Babita Singh" to "9235632587"
    )

    var selectedUser by remember { mutableStateOf<String?>(null) }
    var searchQuery by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onClose) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(Color.White, shape = RoundedCornerShape(20.dp))
                .padding(20.dp)
        ) {
            Column {
                // Title
                Text(
                    stringResource(Res.string.pop_up),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = black,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))
                // Search Field
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { stringResource(Res.string.search_mobile_no) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(Res.drawable.search),
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // List Title
                ReusableTextView(
                    text = stringResource(Res.string.list),
                    textColor = black,
                    fontWeight = FontWeight.W500
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Filtered List
                val filteredUsers = users.filter {
                    it.first.contains(searchQuery, ignoreCase = true) ||
                            it.second.contains(searchQuery)
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.heightIn(max = 300.dp)
                ) {
                    filteredUsers.forEach { (name, mobile) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFF9F9F9))
                                .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(10.dp))
                                .clickable { selectedUser = name }
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(Modifier.weight(1f)) {
                                ReusableTextView(
                                    text = name,
                                    fontWeight = FontWeight.Bold,
                                    textColor = desire_orange,

                                )
                                ReusableTextView(
                                    text = mobile,
                                    fontWeight = FontWeight.Normal,
                                    textColor = black,
                                    
                                )
                            }

                            RadioButton(
                                selected = selectedUser == name,
                                onClick = { selectedUser = name }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Buttons
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .imePadding()
                        .navigationBarsPadding()
                        .padding(bottom = 8.dp)
                        .background(white)
                ) {
                    CommonActionButtons(
                        onSaveClick = {
                            onSave(selectedUser!!)

                        },
                        onCloseClick = onClose
                    )
                }
            }
        }
    }
}*/


