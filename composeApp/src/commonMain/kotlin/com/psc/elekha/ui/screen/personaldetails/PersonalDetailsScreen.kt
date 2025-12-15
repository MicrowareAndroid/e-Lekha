package com.psc.elekha.ui.screen.personaldetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.Uri
import coil3.compose.LocalPlatformContext
import com.psc.elekha.database.entity.MSTComboBox_NEntity
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CommonSaveButton
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.CustomAlertDialog
import com.psc.elekha.utils.DynamicCheckBox
import com.psc.elekha.utils.FormDatePickerCompact
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.StaticComboBoxData
import com.psc.elekha.utils.pickDate
import com.psc.elekha.utils.toValueList

import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.customer_id
import e_lekha.composeapp.generated.resources.customer_image
import e_lekha.composeapp.generated.resources.customer_name
import e_lekha.composeapp.generated.resources.date
import e_lekha.composeapp.generated.resources.date_of_birth
import e_lekha.composeapp.generated.resources.district
import e_lekha.composeapp.generated.resources.education
import e_lekha.composeapp.generated.resources.enter_otp
import e_lekha.composeapp.generated.resources.father_name
import e_lekha.composeapp.generated.resources.guarantor_mobile_number
import e_lekha.composeapp.generated.resources.guarantor_name
import e_lekha.composeapp.generated.resources.husband_name
import e_lekha.composeapp.generated.resources.ic_customer
import e_lekha.composeapp.generated.resources.ic_gurantor
import e_lekha.composeapp.generated.resources.landmark
import e_lekha.composeapp.generated.resources.marital_status
import e_lekha.composeapp.generated.resources.maternal_address
import e_lekha.composeapp.generated.resources.maternal_mob_no
import e_lekha.composeapp.generated.resources.mobile_number
import e_lekha.composeapp.generated.resources.next
import e_lekha.composeapp.generated.resources.not_same_as_customer_mobile_number
import e_lekha.composeapp.generated.resources.pin_code
import e_lekha.composeapp.generated.resources.purpose
import e_lekha.composeapp.generated.resources.relation
import e_lekha.composeapp.generated.resources.religion
import e_lekha.composeapp.generated.resources.same_as_husband
import e_lekha.composeapp.generated.resources.send_otp
import e_lekha.composeapp.generated.resources.state
import e_lekha.composeapp.generated.resources.tehsil
import e_lekha.composeapp.generated.resources.type_here
import e_lekha.composeapp.generated.resources.village_name
import e_lekha.composeapp.generated.resources.your_full_address
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
    var customerImage by remember { mutableStateOf<Uri?>(null) }
    var guarantorImage by remember { mutableStateOf<Uri?>(null) }
    var customename by remember{mutableStateOf("")}
    var dob by remember { mutableStateOf("") }
    var maritalStatus by remember { mutableStateOf("") }
    var education by remember { mutableStateOf("") }
    var religion by remember{mutableStateOf("")}
    var purpose by remember{mutableStateOf("")}
    var mobile_number by remember{mutableStateOf("")}
    var enter_otp by remember { mutableStateOf("") }
    var husband_name by remember{mutableStateOf("")}
    var guarantor_name by remember{mutableStateOf("")}
    var guarantor_mobile_number by remember { mutableStateOf("") }
    var your_full_address by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var district by remember { mutableStateOf("") }
    var village_name by remember {mutableStateOf("")}
    var landmark by remember { mutableStateOf("") }
    var tehsil by remember {mutableStateOf("")}
    var pin_code by remember { mutableStateOf("") }
    var maternal_address by remember { mutableStateOf("") }
    var maternal_mob_no by remember { mutableStateOf("") }
    var father_name by remember { mutableStateOf("") }
    var guarantordob by remember { mutableStateOf("") }
    var gurantor_religion by remember{mutableStateOf("")}
    var gurantor_enter_otp by remember { mutableStateOf("") }
    var gurantor_village_name by remember {mutableStateOf("")}
    var isChecked by remember { mutableStateOf(false) }
    val viewModel = koinViewModel<PersonalDetailViewModel>()
    val coroutineScope = rememberCoroutineScope()
    var maritalStatusValue by remember { mutableStateOf("") }
    var educationValue by remember { mutableStateOf("") }
    var religionValue by remember { mutableStateOf("") }
    var purposeValue by remember { mutableStateOf("") }
    var relationValue by remember { mutableStateOf("") }
    var stateValue by remember { mutableStateOf("") }
    var districtValue by remember { mutableStateOf("") }


   LaunchedEffect(Unit) {
viewModel.loadSavedData()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {



            Spacer(modifier = Modifier.height(10.dp))


            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 15.dp)

            ) {

//                ReusableTextView(
//                    text = stringResource(Res.string.enter_your_personal_details)
//                )
                Spacer(modifier = Modifier.height(6.dp))
                ReusableTextView(
                    text = stringResource(Res.string.customer_id)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {


                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(6.dp))

                        Image(
                            painter = painterResource(Res.drawable.ic_customer),
                            contentDescription = null,
                            modifier = Modifier
                                .size(120.dp)
                                .background(
                                    Color(0xFFE8E8E8),
                                    shape = RoundedCornerShape(8.dp)   // optional, looks better
                                )
                                .padding(4.dp),   // optional
                            contentScale = ContentScale.Crop
                        )
                        ReusableTextView(
                            text = stringResource(Res.string.customer_image)
                        )

                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(6.dp))

                        Image(
                            painter = painterResource(Res.drawable.ic_gurantor),
                            contentDescription = null,
                            modifier = Modifier
                                .size(120.dp)
                                .background(
                                    Color(0xFFE8E8E8),
                                    shape = RoundedCornerShape(8.dp)   // optional, looks better
                                )
                                .padding(4.dp),   // optional
                            contentScale = ContentScale.Crop
                        )
                        ReusableTextView(
                            text = stringResource(Res.string.your_photo_with_guarantor)
                        )

                    }
                }

                Spacer(modifier = Modifier.height(8.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                )
                {
                    FormFieldCompact(
                        label = stringResource(Res.string.customer_name),
                        value = viewModel.customerName,
                        onValueChange = {viewModel. customerName=it },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)/*.focusRequester(viewModel.focusRequesterCustomerName)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterCustomerName)*/,
                        maxLength = 30,
                        focusRequester = viewModel.focusRequesterCustomerName,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterCustomerName
                    )

                }

                Spacer(modifier = Modifier.height(8.dp))


               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.spacedBy(10.dp)
               ) {
                   FormDatePickerCompact(
                       label = stringResource(Res.string.date_of_birth),
                       value = viewModel.dateOfBirth,
                       onValueChange = {viewModel.dateOfBirth=it},
                       onClick = {
                           pickDate(context) { date ->
                               viewModel.dateOfBirth = date
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
                       options = StaticComboBoxData.maritalStatusList.toValueList(),
                       selectedOption = maritalStatusValue,
                       onOptionSelected = { selectedValue ->
                           maritalStatusValue = selectedValue
                           viewModel.maritalStatusId =
                               StaticComboBoxData.maritalStatusList
                                   .firstOrNull { it.Value == selectedValue }
                                   ?.ID ?: 0
                       },
                       modifier = Modifier.weight(1f),
                       focusRequester = viewModel.focusRequesterMaritalStatusId,
                       bringIntoViewRequester = viewModel.bringIntoViewRequesterMaritalStatusId
                   )

               }
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ){
                    FormSpinner(
                        label = stringResource(Res.string.education),
                        options = StaticComboBoxData.educationList.toValueList(),
                        selectedOption = educationValue,
                        onOptionSelected = { selectedValue ->
                            religionValue = selectedValue
                            viewModel.educationId =
                                StaticComboBoxData.educationList
                                    .firstOrNull { it.Value == selectedValue }
                                    ?.ID ?: 0
                        },
                        modifier = Modifier.weight(1f),
                        focusRequester = viewModel.focusRequesterEducationId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterEducationId
                    )
                    FormSpinner(
                        label = stringResource(Res.string.religion),
                        options = StaticComboBoxData.religionList.toValueList(),
                        selectedOption = religionValue,
                        onOptionSelected = { selectedValue ->
                            maritalStatusValue = selectedValue
                            viewModel.religionId =
                                StaticComboBoxData.religionList
                                    .firstOrNull { it.Value == selectedValue }
                                    ?.ID ?: 0
                        },
                        modifier = Modifier.weight(1f),
                        focusRequester = viewModel.focusRequesterReligionId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterReligionId
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                FormSpinner(
                    label = stringResource(Res.string.purpose),
                    options = StaticComboBoxData.purposeList.toValueList(),
                    selectedOption = purposeValue,
                    onOptionSelected = { selectedValue ->
                        purposeValue = selectedValue
                        viewModel.purposeId =
                            StaticComboBoxData.purposeList
                                .firstOrNull { it.Value == selectedValue }
                                ?.ID ?: 0
                    },
                    modifier = Modifier.fillMaxWidth(),
                    focusRequester = viewModel.focusRequesterPurposeId,
                    bringIntoViewRequester = viewModel.bringIntoViewRequesterPurposeId
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
                        onValueChange = { mobilenumber->
                            viewModel.mobileNumber=mobilenumber
                        },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(2f),
                        focusRequester = viewModel.focusRequesterMobileNumber,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterMobileNumber
                    )

                    FormFieldCompact(
                        label = stringResource(Res.string.enter_otp),
                        value = enter_otp,
                        onValueChange = {
                            enterotp->
                            enter_otp=enterotp
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                    )

                    CommonSingleButtonsBottomString(
                        onOkClick = {

                        },
                        stringResource(Res.string.send_otp),
                        modifier = Modifier.weight(1f),
                        textSize = 11
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // ---------------- Form Start ----------------
                FormFieldCompact(
                    label = stringResource(Res.string.husband_name),
                    value = viewModel.husbandName,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = {
                        husbandname->
                        viewModel.husbandName=husbandname
                    },
                    maxLength = 20,
                    focusRequester = viewModel.focusRequesterHusbandName,
                    bringIntoViewRequester = viewModel.bringIntoViewRequesterHusbandName

                )

                Spacer(modifier = Modifier.height(3.dp))

                DynamicCheckBox(
                    label = stringResource(Res.string.same_as_husband),
                    isChecked = isChecked,
                    onCheckedChange = {
                            checked ->
                        isChecked = checked

                    }
                )

                Spacer(modifier = Modifier.height(2.dp))

                // ---------------- Form Start ----------------
                FormFieldCompact(
                    label = stringResource(Res.string.guarantor_name),
                    value =viewModel.gurantorName,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { gurantorname->
                        viewModel.gurantorName=gurantorname
                    },
                    maxLength = 20,
                    focusRequester = viewModel.focusRequesterGurantorName,
                    bringIntoViewRequester = viewModel.bringIntoViewRequesterGurantorName

                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormSpinner(
                        label = stringResource(Res.string.relation),
                        options = StaticComboBoxData.relationList.toValueList(),
                        selectedOption = relationValue,
                        onOptionSelected = { selectedValue ->
                            purposeValue = selectedValue
                            viewModel.relationId =
                                StaticComboBoxData.purposeList
                                    .firstOrNull { it.Value == selectedValue }
                                    ?.ID ?: 0
                        },
                        modifier = Modifier.weight(1f),
                        focusRequester = viewModel.focusRequesterRelationId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterRelationId
                    )

                    FormDatePickerCompact(
                        label = stringResource(Res.string.date_of_birth),
                        value = guarantordob,
                        onValueChange = {guarantordob=it},
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
                    value =viewModel.gurantormobileNumber,
                    placeholder = stringResource(Res.string.not_same_as_customer_mobile_number),
                    onValueChange = {
                        gurantormbno->
                        viewModel.gurantormobileNumber=gurantormbno
                    },
                    maxLength = 10,
                    focusRequester = viewModel.focusRequesterGurantormobileNumber,
                    bringIntoViewRequester = viewModel.bringIntoViewRequesterGurantormobileNumber
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
                        onValueChange = {  gurantorotp->
                            gurantor_enter_otp =gurantorotp },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(2f),

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
                    value = your_full_address,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = {
                        yourfulladdress->
                        your_full_address=yourfulladdress
                    },
                    maxLength = 20
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormSpinner(
                        label = stringResource(Res.string.state),
                        options = StaticComboBoxData.stateList.toValueList(),
                        selectedOption = stateValue,
                        onOptionSelected = { selectedValue ->
                            stateValue = selectedValue
                            viewModel.stateId =
                                StaticComboBoxData.stateList
                                    .firstOrNull { it.Value == selectedValue }
                                    ?.ID ?: 0
                        },
                        modifier = Modifier.weight(1f),
                        focusRequester = viewModel.focusRequesterStateId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterStateId
                    )

                    FormSpinner(
                        label = stringResource(Res.string.district),
                        options = StaticComboBoxData.distictList.toValueList(),
                        selectedOption = districtValue,
                        onOptionSelected = { selectedValue ->
                            districtValue = selectedValue
                            viewModel.districtId =
                                StaticComboBoxData.distictList
                                    .firstOrNull { it.Value == selectedValue }
                                    ?.ID ?: 0
                        },
                        modifier = Modifier.weight(1f),
                        focusRequester = viewModel.focusRequesterDistrictId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterDistrictId
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.village_name),
                        value = viewModel.villageName,
                        onValueChange = {
                            villagename->
                             viewModel.villageName=villagename
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f),
                        focusRequester = viewModel.focusRequesterVillageName,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterVillageName

                    )

                    FormFieldCompact(
                        label = stringResource(Res.string.tehsil),
                        value = tehsil,
                        onValueChange = {
                            tehsill->
                            tehsil=tehsill
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.landmark),
                        value = landmark,
                        onValueChange = {
                            landmarks->
                            landmark=landmarks
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                    )

                    FormFieldCompact(
                        label = stringResource(Res.string.pin_code),
                        value = viewModel.pinCode,
                        onValueChange = {
                            pincode->
                            viewModel.pinCode=pincode
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                FormFieldCompact(
                    label = stringResource(Res.string.maternal_address),
                    value = maternal_address,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = {
                        maternaladdress->
                        maternal_address=maternaladdress
                    },
                    maxLength = 20,
                    isEnable = true
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.village_name),
                        value = viewModel.villageName,
                        onValueChange = { gurantorvillagename->
                            viewModel.villageName=gurantorvillagename
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                    )

                    FormFieldCompact(
                        label = stringResource(Res.string.maternal_mob_no),
                        value = maternal_mob_no,
                        onValueChange = {
                            maternalmbno->
                            maternal_mob_no=maternalmbno
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormFieldCompact(
                        label = stringResource(Res.string.father_name),
                        value = father_name,
                        onValueChange = {
                            fathername->
                            father_name=fathername
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                    )
                    FormSpinner(
                        label = stringResource(Res.string.state),
                        options = StaticComboBoxData.stateList.toValueList(),
                        selectedOption = stateValue,
                        onOptionSelected = { selectedValue ->
                            stateValue = selectedValue
                            viewModel.stateId =
                                StaticComboBoxData.stateList
                                    .firstOrNull { it.Value == selectedValue }
                                    ?.ID ?: 0
                        },
                        modifier = Modifier.weight(1f),
                        focusRequester = viewModel.focusRequesterStateId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterStateId
                    )
                }

            } // END Scroll Column

            // Bottom Buttons (Not scrollable)
            CommonSaveButton (
                onSaveClick ={
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
