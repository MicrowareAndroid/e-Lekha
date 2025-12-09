package com.psc.elekha.ui.screen.kycdetails

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
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableImageView
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.pickDate
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.aadhaar_card
import e_lekha.composeapp.generated.resources.back_image
import e_lekha.composeapp.generated.resources.customer_details
import e_lekha.composeapp.generated.resources.customer_name
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
import e_lekha.composeapp.generated.resources.image
import e_lekha.composeapp.generated.resources.k_no
import e_lekha.composeapp.generated.resources.landmark
import e_lekha.composeapp.generated.resources.marital_status
import e_lekha.composeapp.generated.resources.mobile_number
import e_lekha.composeapp.generated.resources.name
import e_lekha.composeapp.generated.resources.next
import e_lekha.composeapp.generated.resources.not_same_as_customer_mobile_number
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
fun KycDetailsScreen(onNextTab: () -> Unit = {}, onCancelTab: () -> Unit = {}) {
    val context = LocalPlatformContext.current
    var showDialog by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }

    var customerAadhaarImage1 by remember { mutableStateOf<Uri?>(null) }
    var customerAadhaarImage2 by remember { mutableStateOf<Uri?>(null) }
    var voterIDImage1 by remember { mutableStateOf<Uri?>(null) }
    var voterIDImage2 by remember { mutableStateOf<Uri?>(null) }
    var rationCardImage1 by remember { mutableStateOf<Uri?>(null) }
    var rationCardImage2 by remember { mutableStateOf<Uri?>(null) }
    var guarantorAadhaarImage1 by remember { mutableStateOf<Uri?>(null) }
    var guarantorAadhaarImage2 by remember { mutableStateOf<Uri?>(null) }
    var electricityBillImage1 by remember { mutableStateOf<Uri?>(null) }
    var electricityBillImage2 by remember { mutableStateOf<Uri?>(null) }
    var customerName by remember { mutableStateOf(value = "") }
    var adharCard by remember{mutableStateOf(value = "")}
    var voteridCard by remember { mutableStateOf(value = "") }
    var rasanCard by remember { mutableStateOf(value = "") }


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
                    text = stringResource(Res.string.enter_your_kyc_details)
                )

                Spacer(modifier = Modifier.height(8.dp))

                /*ReusableTextView(
                    text = stringResource(Res.string.customer_details),
                    fontSize = 14
                )*/

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    ReusableTextView(
                        text = stringResource(Res.string.customer_details),
                        fontSize = 14
                    )

                    CommonDivider(
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                /*FormField(
                    label = stringResource(Res.string.customer_name),
                    value = "",
                    placeholder = "",
                    onValueChange = { "" },
                    isEnable = false
                )*/

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormField(
                        label = stringResource(Res.string.customer_name),
                        value = customerName,
                        onValueChange = {newName -> customerName = newName},
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f),
                        isEnable = true
                    )

                    ReusableImageView(
                        painterResource(Res.drawable.user_default),
                        contentDescription = "Image Preview",
                        modifier = Modifier
                            .size(100.dp)
                            .border(2.dp, Color.White),
                        contentScale = ContentScale.Fit,

                    )

                    /*// Apply weight OUTSIDE the reusable function
                    Box(
                        modifier = Modifier
                            .weight(1f)         // <-- Weight applied here
                            .height(100.dp),    // <-- required to show image properly
                        contentAlignment = Alignment.Center
                    ) {
                        ReusableImageView(
                            painterResource(Res.drawable.user_default),
                            contentDescription = "Image Preview",
                            modifier = Modifier
                                .fillMaxSize()   // <-- This will now expand inside weighted Box
                                .border(2.dp, Color.White),
                            contentScale = ContentScale.Fit
                        )
                    }*/
                }

                Spacer(modifier = Modifier.height(8.dp))

                FormField(
                    label = stringResource(Res.string.aadhaar_card),
                    value = adharCard,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { newadharcard->adharCard=newadharcard },
                    maxLength = 12,
                    inputType = KeyboardType.Number
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                )
                {
                    ReusableTextView(
                        text = stringResource(Res.string.front_image),
                        fontSize = 14,
                        textColor = textview_color, modifier = Modifier.weight(1f)
                    )

                    ReusableTextView(
                        text = stringResource(Res.string.back_image),
                        fontSize = 14,
                        textColor = textview_color, modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(3.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    CameraPreviewField(
                        image = customerAadhaarImage1,
                        onClick = { },
                        modifier = Modifier.weight(1f)
                    )

                    CameraPreviewField(
                        image = customerAadhaarImage2,
                        onClick = { },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                FormField(
                    label = stringResource(Res.string.voter_id_card),
                    value = voteridCard,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { newvoterid->voteridCard=newvoterid },
                    maxLength = 17
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                )
                {
                    ReusableTextView(
                        text = stringResource(Res.string.front_image),
                        fontSize = 14,
                        textColor = textview_color, modifier = Modifier.weight(1f)
                    )

                    ReusableTextView(
                        text = stringResource(Res.string.back_image),
                        fontSize = 14,
                        textColor = textview_color, modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(3.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    CameraPreviewField(
                        image = voterIDImage1,
                        onClick = { },
                        placeholderRes = Res.drawable.voter_id,
                        modifier = Modifier.weight(1f)
                    )

                    CameraPreviewField(
                        image = voterIDImage2,
                        onClick = { },
                        placeholderRes = Res.drawable.voter_id,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                FormField(
                    label = stringResource(Res.string.ration_card_4_digit),
                    value = rasanCard,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { newratanCard->rasanCard=newratanCard },
                    maxLength = 4,
                    inputType = KeyboardType.Number
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                )
                {
                    ReusableTextView(
                        text = stringResource(Res.string.front_image),
                        fontSize = 14,
                        textColor = textview_color, modifier = Modifier.weight(1f)
                    )

                    ReusableTextView(
                        text = stringResource(Res.string.back_image),
                        fontSize = 14,
                        textColor = textview_color, modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(3.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    CameraPreviewField(
                        image = rationCardImage1,
                        onClick = { },
                        placeholderRes = Res.drawable.voter_id,
                        modifier = Modifier.weight(1f)
                    )

                    CameraPreviewField(
                        image = rationCardImage2,
                        onClick = { },
                        placeholderRes = Res.drawable.voter_id,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                /*ReusableTextView(
                    text = stringResource(Res.string.guarantor_details),
                    fontSize = 14
                )*/
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    ReusableTextView(
                        text = stringResource(Res.string.guarantor_details),
                        fontSize = 14
                    )

                    CommonDivider(
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                /*FormField(
                    label = stringResource(Res.string.guarantor_name),
                    value = "",
                    placeholder = "",
                    onValueChange = { "" },
                    isEnable = false
                )*/

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FormField(
                        label = stringResource(Res.string.customer_name),
                        value = "",
                        onValueChange = { "" },
                        placeholder = "",
                        modifier = Modifier.weight(1f),
                        isEnable = false
                    )

                    ReusableImageView(
                        painterResource(Res.drawable.user_default),
                        contentDescription = "Image Preview",
                        modifier = Modifier
                            .size(100.dp)
                            .border(2.dp, Color.White),
                        contentScale = ContentScale.Fit,

                        )
                }

                Spacer(modifier = Modifier.height(8.dp))

                FormField(
                    label = stringResource(Res.string.guarantor_aadhaar_card),
                    value = "",
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { "" },
                    maxLength = 12,
                    inputType = KeyboardType.Number
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                )
                {
                    ReusableTextView(
                        text = stringResource(Res.string.front_image),
                        fontSize = 14,
                        textColor = textview_color, modifier = Modifier.weight(1f)
                    )

                    ReusableTextView(
                        text = stringResource(Res.string.back_image),
                        fontSize = 14,
                        textColor = textview_color, modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(3.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    CameraPreviewField(
                        image = guarantorAadhaarImage1,
                        onClick = { },
                        modifier = Modifier.weight(1f)
                    )

                    CameraPreviewField(
                        image = guarantorAadhaarImage2,
                        onClick = { },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                /*ReusableTextView(
                    text = stringResource(Res.string.electricity_bill),
                    fontSize = 14
                )*/

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    ReusableTextView(
                        text = stringResource(Res.string.electricity_bill),
                        fontSize = 14
                    )

                    CommonDivider(
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),      // Make text area match the height of right side
                        contentAlignment = Alignment.CenterStart        // Center vertically
                    ) {
                        ReusableTextView(
                            text = stringResource(Res.string.image),
                            fontSize = 14,
                            textColor = textview_color
                        )
                    }

                    CameraPreviewField(
                        image = electricityBillImage1,
                        onClick = { },
                        placeholderRes = Res.drawable.voter_id,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                )
                {
                    FormField(
                        label = stringResource(Res.string.k_no),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f),
                        maxLength = 12,
                        inputType = KeyboardType.Number
                    )

                    FormField(
                        label = stringResource(Res.string.name),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f),
                        maxLength = 30
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                )
                {
                    FormField(
                        label = stringResource(Res.string.electricity_account_no),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f),
                        maxLength = 8,
                        inputType = KeyboardType.Number
                    )

                    FormSpinner(
                        label = stringResource(Res.string.relation),
                        options = listOf("Brother", "Husband"),
                        selectedOption = "",
                        onOptionSelected = { },
                        modifier = Modifier.weight(1f)
                    )
                }


                Spacer(modifier = Modifier.height(8.dp))

                /*ReusableTextView(
                    text = stringResource(Res.string.electricity_bill_two),
                    fontSize = 14
                )*/



                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    ReusableTextView(
                        text = stringResource(Res.string.electricity_bill_two),
                        fontSize = 14
                    )

                    CommonDivider(
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),      // Make text area match the height of right side
                        contentAlignment = Alignment.CenterStart        // Center vertically
                    ) {
                        ReusableTextView(
                            text = stringResource(Res.string.image),
                            fontSize = 14,
                            textColor = textview_color
                        )
                    }

                    CameraPreviewField(
                        image = electricityBillImage2,
                        onClick = { },
                        placeholderRes = Res.drawable.voter_id,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                )
                {
                    FormField(
                        label = stringResource(Res.string.k_no),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f),
                        maxLength = 12,
                        inputType = KeyboardType.Number
                    )

                    FormField(
                        label = stringResource(Res.string.name),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f),
                        maxLength = 30
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                )
                {
                    FormField(
                        label = stringResource(Res.string.electricity_account_no),
                        value = "",
                        onValueChange = { "" },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f),
                        maxLength = 8,
                        inputType = KeyboardType.Number
                    )

                    FormSpinner(
                        label = stringResource(Res.string.relation),
                        options = listOf("Brother", "Husband"),
                        selectedOption = "",
                        onOptionSelected = { },
                        modifier = Modifier.weight(1f)
                    )
                }


            } // END Scroll Column

            // Bottom Buttons (Not scrollable)
            CommonSaveButton(
                onSaveClick = {},
                saveText = stringResource(Res.string.next)
            )
        }
    }

}