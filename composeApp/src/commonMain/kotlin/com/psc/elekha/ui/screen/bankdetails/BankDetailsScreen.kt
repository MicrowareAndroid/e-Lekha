/*
package com.psc.elekha.ui.screen.bankdetails

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.Uri
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import com.psc.elekha.ui.theme.textview_color
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
import com.psc.elekha.utils.pickDate
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.aadhaar_card
import e_lekha.composeapp.generated.resources.back_image
import e_lekha.composeapp.generated.resources.bank_account_number
import e_lekha.composeapp.generated.resources.bank_name
import e_lekha.composeapp.generated.resources.branch_name
import e_lekha.composeapp.generated.resources.camera
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
import e_lekha.composeapp.generated.resources.guarantor_aadhaar_card
import e_lekha.composeapp.generated.resources.guarantor_details
import e_lekha.composeapp.generated.resources.guarantor_mobile_number
import e_lekha.composeapp.generated.resources.guarantor_name
import e_lekha.composeapp.generated.resources.husband_name
import e_lekha.composeapp.generated.resources.ifsc_code
import e_lekha.composeapp.generated.resources.image
import e_lekha.composeapp.generated.resources.k_no
import e_lekha.composeapp.generated.resources.landmark
import e_lekha.composeapp.generated.resources.marital_status
import e_lekha.composeapp.generated.resources.mobile_number
import e_lekha.composeapp.generated.resources.name
import e_lekha.composeapp.generated.resources.next
import e_lekha.composeapp.generated.resources.not_same_as_customer_mobile_number
import e_lekha.composeapp.generated.resources.passbook_image
import e_lekha.composeapp.generated.resources.pin_code
import e_lekha.composeapp.generated.resources.purpose
import e_lekha.composeapp.generated.resources.ration_card_4_digit
import e_lekha.composeapp.generated.resources.relation
import e_lekha.composeapp.generated.resources.religion
import e_lekha.composeapp.generated.resources.same_as_husband
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
fun BankDetailsScreen(onNextTab: () -> Unit = {}, onCancelTab: () -> Unit = {}) {
    var passbookImage by remember { mutableStateOf<Uri?>(null) }
    var nameOnAccount by remember { mutableStateOf("") }
    var AccountNo by remember { mutableStateOf("") }
    var bankName by remember { mutableStateOf("") }
    var branchName by remember { mutableStateOf("") }
    var ifscCode by remember { mutableStateOf("") }


    LaunchedEffect(Unit) {

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
                    text = stringResource(Res.string.customer_bank_details)
                )

                Spacer(modifier = Modifier.height(8.dp))

                FormFieldCompact(
                    label = stringResource(Res.string.customer_name_in_bank_dairy),
                    value = nameOnAccount,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { nameOnAccount = it},
                    maxLength = 30
                )

                Spacer(modifier = Modifier.height(8.dp))

                FormFieldCompact(
                    label = stringResource(Res.string.bank_account_number),
                    value = AccountNo,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { AccountNo = it },
                    maxLength = 18,
                    inputType = KeyboardType.Number
                )

                Spacer(modifier = Modifier.height(8.dp))

                FormSpinner(
                    label = stringResource(Res.string.bank_name),
                    options = listOf("SBI", "HDFC", "AXIS"),
                    selectedOption = bankName,
                    onOptionSelected = { bankName = it}
                )

                Spacer(modifier = Modifier.height(8.dp))

                FormSpinner(
                    label = stringResource(Res.string.branch_name),
                    options = listOf("SBI Delhi","SBI Gurgaon", "HDFC Delhi","HDFC Gurgaon", "AXIS Delhi","AXIS Gurgaon"),
                    selectedOption = branchName,
                    onOptionSelected = {branchName = it }
                )

                Spacer(modifier = Modifier.height(8.dp))

                FormFieldCompact(
                    label = stringResource(Res.string.ifsc_code),
                    value = ifscCode,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { ifscCode = it},
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    // Front Image Box
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(120.dp)
                                .background(Color(0xFFE8E8E8)), // Light Grey Box
                            contentAlignment = Alignment.Center
                        ) {
                            // Preview can go here
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Icon(
                            painter = painterResource(Res.drawable.camera),
                            contentDescription = "",
                            tint = Color.Black,
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        ReusableTextView(
                            text = stringResource(Res.string.passbook_image),
                            fontSize = 14,
                            textColor = textview_color
                        )
                    }
                }


            } // END Scroll Column

            // Bottom Buttons (Not scrollable)
            CommonSaveButton(
                onSaveClick = {},
                saveText = stringResource(Res.string.next)
            )
        }
    }

}*/
