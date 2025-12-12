package com.psc.elekha.ui.screen.familydetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil3.Uri
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.lightGrey
import com.psc.elekha.ui.theme.textview_color
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CameraPreviewField
import com.psc.elekha.utils.CommonDivider
import com.psc.elekha.utils.CommonSaveButton
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.DynamicCheckBox
import com.psc.elekha.utils.FormDatePicker
import com.psc.elekha.utils.FormField
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableImageView
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTopBar
import com.psc.elekha.utils.pickDate
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.aadhaar_card
import e_lekha.composeapp.generated.resources.age
import e_lekha.composeapp.generated.resources.app_name
import e_lekha.composeapp.generated.resources.back_image
import e_lekha.composeapp.generated.resources.bank_account_number
import e_lekha.composeapp.generated.resources.bank_name
import e_lekha.composeapp.generated.resources.branch_name
import e_lekha.composeapp.generated.resources.cancel
import e_lekha.composeapp.generated.resources.customer_bank_details
import e_lekha.composeapp.generated.resources.customer_details
import e_lekha.composeapp.generated.resources.customer_name
import e_lekha.composeapp.generated.resources.customer_name_in_bank_dairy
import e_lekha.composeapp.generated.resources.date
import e_lekha.composeapp.generated.resources.date_of_birth
import e_lekha.composeapp.generated.resources.district
import e_lekha.composeapp.generated.resources.document_icon
import e_lekha.composeapp.generated.resources.education
import e_lekha.composeapp.generated.resources.electricity_account_no
import e_lekha.composeapp.generated.resources.electricity_bill
import e_lekha.composeapp.generated.resources.electricity_bill_two
import e_lekha.composeapp.generated.resources.enter_otp
import e_lekha.composeapp.generated.resources.enter_your_kyc_details
import e_lekha.composeapp.generated.resources.enter_your_personal_details
import e_lekha.composeapp.generated.resources.front_image
import e_lekha.composeapp.generated.resources.gender
import e_lekha.composeapp.generated.resources.guarantor_aadhaar_card
import e_lekha.composeapp.generated.resources.guarantor_details
import e_lekha.composeapp.generated.resources.guarantor_mobile_number
import e_lekha.composeapp.generated.resources.guarantor_name
import e_lekha.composeapp.generated.resources.husband_name
import e_lekha.composeapp.generated.resources.ic_back
import e_lekha.composeapp.generated.resources.ifsc_code
import e_lekha.composeapp.generated.resources.image
import e_lekha.composeapp.generated.resources.k_no
import e_lekha.composeapp.generated.resources.landmark
import e_lekha.composeapp.generated.resources.list
import e_lekha.composeapp.generated.resources.marital_status
import e_lekha.composeapp.generated.resources.mobile_number
import e_lekha.composeapp.generated.resources.name
import e_lekha.composeapp.generated.resources.next
import e_lekha.composeapp.generated.resources.not_same_as_customer_mobile_number
import e_lekha.composeapp.generated.resources.occupation
import e_lekha.composeapp.generated.resources.ok
import e_lekha.composeapp.generated.resources.passbook_image
import e_lekha.composeapp.generated.resources.pin_code
import e_lekha.composeapp.generated.resources.purpose
import e_lekha.composeapp.generated.resources.ration_card_4_digit
import e_lekha.composeapp.generated.resources.relation
import e_lekha.composeapp.generated.resources.religion
import e_lekha.composeapp.generated.resources.same_as_husband
import e_lekha.composeapp.generated.resources.save
import e_lekha.composeapp.generated.resources.send_otp
import e_lekha.composeapp.generated.resources.state
import e_lekha.composeapp.generated.resources.tehsil
import e_lekha.composeapp.generated.resources.type_here
import e_lekha.composeapp.generated.resources.user_default
import e_lekha.composeapp.generated.resources.village_name
import e_lekha.composeapp.generated.resources.voter_id
import e_lekha.composeapp.generated.resources.voter_id_card
import e_lekha.composeapp.generated.resources.your_full_address
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FamilyDetailFormScreen(navController: NavController) {

    LaunchedEffect(Unit) {

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ReusableTopBar(
                title = stringResource(Res.string.list),
                navigationIcon = painterResource(Res.drawable.ic_back),
                onNavigationClick = {
                    navController.popBackStack()
                }
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(white)
                    .padding(horizontal = 16.dp)
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
                            text = stringResource(Res.string.customer_bank_details)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        FormFieldCompact(
                            label = stringResource(Res.string.name),
                            value = "",
                            placeholder = stringResource(Res.string.type_here),
                            onValueChange = { "" },
                            maxLength = 30
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        FormSpinner(
                            label = stringResource(Res.string.gender),
                            options = listOf("Male", "Female", "Other"),
                            selectedOption = "",
                            onOptionSelected = { }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        FormFieldCompact(
                            label = stringResource(Res.string.age),
                            value = "",
                            onValueChange = { "" },
                            placeholder = stringResource(Res.string.type_here),
                            maxLength = 2,
                            inputType = KeyboardType.Number
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        FormSpinner(
                            label = stringResource(Res.string.relation),
                            options = listOf("Brother", "Husband"),
                            selectedOption = "",
                            onOptionSelected = { }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        FormSpinner(
                            label = stringResource(Res.string.education),
                            options = listOf("Graduation", "Post Graduation", "12th"),
                            selectedOption = "",
                            onOptionSelected = { }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        FormSpinner(
                            label = stringResource(Res.string.occupation),
                            options = listOf("Doctor", "Teacher", "Driver"),
                            selectedOption = "",
                            onOptionSelected = { }
                        )



                    } // END Scroll Column

                    // Bottom Buttons (Not scrollable)
                    CommonSaveButton(
                        onSaveClick = {},
                        saveText = stringResource(Res.string.save)
                    )
                }
            }
        }
    }
}
@Composable
fun CustomAlertFamilyDetails(
    title: String = stringResource(Res.string.app_name),
    submitText: String = stringResource(Res.string.ok),
    cancelText: String = stringResource(Res.string.cancel),
    onSubmit: () -> Unit = {},
    onCancel: () -> Unit = {}
) {
    var name by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var relation by remember { mutableStateOf("") }
    var education by remember { mutableStateOf("") }
    var occupation by remember { mutableStateOf("") }
    Dialog(onDismissRequest = {}) {

        Box(
            modifier = Modifier
                .widthIn(min = 350.dp, max = 500.dp)
                .background(lightGrey, RoundedCornerShape(16.dp))
                .border(1.dp, lightGrey, RoundedCornerShape(16.dp))
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // ----------------------- HEADER (NO MARGIN) -----------------------
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            toolbar_color,
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        )
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    ReusableTextView(
                        text = title,
                        fontSize = 20,
                        fontWeight = FontWeight.Bold,
                        textColor = white,
                        textAlignment = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()  // Perfect centering
                    )
                }

                // ----------------------- CONTENT AREA -----------------------
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),             // Padding ONLY inside content area
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(Modifier.height(8.dp))

                    // ----------- NAME & RELATION SPINNERS -----------
                    FormFieldCompact(
                        label = stringResource(Res.string.name),
                        value = name,
                        placeholder = stringResource(Res.string.type_here),
                        onValueChange = {name = it },

                        )
                    Spacer(Modifier.height(12.dp))
                    FormSpinner(
                        label = stringResource(Res.string.gender),
                        options = listOf("Male", "Female", "Other"),
                        selectedOption = gender,
                        onOptionSelected = {gender = it },
                    )

                    Spacer(Modifier.height(12.dp))

                    // ----------- OCCUPATION & INCOME SPINNERS -----------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        FormFieldCompact(
                            label = stringResource(Res.string.age),
                            value = age,
                            onValueChange = { age = it },
                            placeholder = stringResource(Res.string.type_here),
                            maxLength = 2,
                            inputType = KeyboardType.Number,
                            modifier = Modifier.weight(1f)

                        )

                        FormSpinner(
                            label = stringResource(Res.string.relation),
                            options = listOf("Brother", "Husband"),
                            selectedOption = relation,
                            onOptionSelected = { relation = it},
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(Modifier.height(12.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        FormSpinner(
                            label = stringResource(Res.string.education),
                            options = listOf("Graduation", "Post Graduation", "12th"),
                            selectedOption = education,
                            onOptionSelected = { education = it},
                            modifier = Modifier.weight(1f)

                        )
                        FormSpinner(
                            label = stringResource(Res.string.occupation),
                            options = listOf("Doctor", "Teacher", "Driver"),
                            selectedOption = occupation,
                            onOptionSelected = {occupation = it },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    // ----------- REMARKS FIELD -----------
                    Spacer(Modifier.height(24.dp))
                    // ----------------------- BUTTONS -----------------------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(
                            onClick = onCancel,
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = btn_color,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Text(cancelText)
                        }
                        Button(
                            onClick = onSubmit,
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = btn_color,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Text(submitText)
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }
}





