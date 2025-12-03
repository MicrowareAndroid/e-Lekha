package com.psc.elekha.ui.screen.personaldetails

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CommonActionButtons
import com.psc.elekha.utils.CommonSaveButton
import com.psc.elekha.utils.CommonSingleButtons
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.DynamicCheckBox
import com.psc.elekha.utils.FormDatePicker
import com.psc.elekha.utils.FormField
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.pickDate
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.customer_name
import e_lekha.composeapp.generated.resources.date
import e_lekha.composeapp.generated.resources.date_of_birth
import e_lekha.composeapp.generated.resources.district
import e_lekha.composeapp.generated.resources.education
import e_lekha.composeapp.generated.resources.enter_otp
import e_lekha.composeapp.generated.resources.enter_your_personal_details
import e_lekha.composeapp.generated.resources.guarantor_mobile_number
import e_lekha.composeapp.generated.resources.guarantor_name
import e_lekha.composeapp.generated.resources.husband_name
import e_lekha.composeapp.generated.resources.landmark
import e_lekha.composeapp.generated.resources.marital_status
import e_lekha.composeapp.generated.resources.mobile_number
import e_lekha.composeapp.generated.resources.next
import e_lekha.composeapp.generated.resources.not_same_as_customer_mobile_number
import e_lekha.composeapp.generated.resources.pin_code
import e_lekha.composeapp.generated.resources.purpose
import e_lekha.composeapp.generated.resources.relation
import e_lekha.composeapp.generated.resources.religion
import e_lekha.composeapp.generated.resources.roboto_medium
import e_lekha.composeapp.generated.resources.roboto_regular
import e_lekha.composeapp.generated.resources.roboto_semibold
import e_lekha.composeapp.generated.resources.same_as_husband
import e_lekha.composeapp.generated.resources.send_otp
import e_lekha.composeapp.generated.resources.state
import e_lekha.composeapp.generated.resources.tehsil
import e_lekha.composeapp.generated.resources.type_here
import e_lekha.composeapp.generated.resources.village_name
import e_lekha.composeapp.generated.resources.your_full_address
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


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

    LaunchedEffect(Unit) {
//        stateViewModel.loadUsers()
//        viewModel.selectState=2
//        lookUpValueViewModel.loadLookUpValues(lookupTypeFk = 1, langId = 1)

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(10.dp))

            // -------- ALL FORM CONTENT SHOULD BE INSIDE THIS SCROLL COLUMN ----------
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 15.dp)
            ) {

                ReusableTextView(
                    text = stringResource(Res.string.enter_your_personal_details),
                    fontSize = 16,
                    textColor = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                // -------- Row --------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                )
                {
                    FormField(
                        label = stringResource(Res.string.customer_name),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f),
                        maxLength = 30
                    )

                    FormDatePicker(
                        label = stringResource(Res.string.date_of_birth),
                        value = "",
                        onValueChange = {},
                        onClick = {
                            pickDate(context) { date ->
                                ""
                            }

                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(Res.drawable.date),
                                contentDescription = "Date Icon",
                                tint = Color.Unspecified
                            )
                        },
                        isEnable = false,
                        isReadable = true,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // -------- Row 2 --------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormSpinner(
                        label = stringResource(Res.string.marital_status),
                        options = listOf("Married", "Unmarried", "Single", "Separated"),
                        selectedOption = "",
                        onOptionSelected = { },
                        modifier = Modifier.weight(1f)
                    )

                    FormSpinner(
                        label = stringResource(Res.string.education),
                        options = listOf("Graduation", "Post Graduation", "12th"),
                        selectedOption = "",
                        onOptionSelected = { },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormSpinner(
                        label = stringResource(Res.string.religion),
                        options = listOf("Hindu", "Muslim"),
                        selectedOption = "",
                        onOptionSelected = { },
                        modifier = Modifier.weight(1f)
                    )

                    FormSpinner(
                        label = stringResource(Res.string.purpose),
                        options = listOf("Study Loan", "Home Loan"),
                        selectedOption = "",
                        onOptionSelected = { },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.Bottom   // 👈 THIS aligns button with EditText
                ) {
                    FormField(
                        label = stringResource(Res.string.mobile_number),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.weight(1f)
                    )

                    FormField(
                        label = stringResource(Res.string.enter_otp),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
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
                FormField(
                    label = stringResource(Res.string.husband_name),
                    value = "",
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { "" },
                    maxLength = 20
                )

                Spacer(modifier = Modifier.height(3.dp))

                DynamicCheckBox(
                    label = stringResource(Res.string.same_as_husband),
                    isChecked = false,
                    onCheckedChange = {}
                )

                Spacer(modifier = Modifier.height(2.dp))

                // ---------------- Form Start ----------------
                FormField(
                    label = stringResource(Res.string.guarantor_name),
                    value = "",
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { "" },
                    maxLength = 20
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormSpinner(
                        label = stringResource(Res.string.relation),
                        options = listOf("Brother", "Husband"),
                        selectedOption = "",
                        onOptionSelected = { },
                        modifier = Modifier.weight(1f)
                    )

                    FormDatePicker(
                        label = stringResource(Res.string.date_of_birth),
                        value = "",
                        onValueChange = {},
                        onClick = {
                            pickDate(context) { date ->
                                ""
                            }

                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(Res.drawable.date),
                                contentDescription = "Date Icon",
                                tint = Color.Unspecified
                            )
                        },
                        isEnable = false,
                        isReadable = true,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // ---------------- Form Start ----------------
                FormField(
                    label = stringResource(Res.string.guarantor_mobile_number),
                    value = "",
                    placeholder = stringResource(Res.string.not_same_as_customer_mobile_number),
                    onValueChange = { "" },
                    maxLength = 10
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.Bottom   // 👈 THIS aligns button with EditText
                ) {
                    FormField(
                        label = stringResource(Res.string.enter_otp),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(2f)
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
                FormField(
                    label = stringResource(Res.string.your_full_address),
                    value = "",
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { "" },
                    maxLength = 20
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormSpinner(
                        label = stringResource(Res.string.state),
                        options = listOf("Delhi", "Punjab"),
                        selectedOption = "",
                        onOptionSelected = { },
                        modifier = Modifier.weight(1f)
                    )

                    FormSpinner(
                        label = stringResource(Res.string.district),
                        options = listOf("West", "South"),
                        selectedOption = "",
                        onOptionSelected = { },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormField(
                        label = stringResource(Res.string.village_name),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                    )

                    FormField(
                        label = stringResource(Res.string.tehsil),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormField(
                        label = stringResource(Res.string.landmark),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                    )

                    FormField(
                        label = stringResource(Res.string.pin_code),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f)
                    )
                }

            } // END Scroll Column

            // Bottom Buttons (Not scrollable)
            CommonSaveButton (
                onSaveClick = {},
                saveText = stringResource(Res.string.next)
            )
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
