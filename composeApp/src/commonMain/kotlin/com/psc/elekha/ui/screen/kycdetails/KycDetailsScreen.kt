package com.psc.elekha.ui.screen.kycdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.psc.elekha.ui.theme.appleblue
import com.psc.elekha.ui.theme.lightblues
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CommonSaveButton
import com.psc.elekha.utils.FormField
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.ReusableTextView
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.aadhaar_card
import e_lekha.composeapp.generated.resources.aadhar_no
import e_lekha.composeapp.generated.resources.account_no
import e_lekha.composeapp.generated.resources.back_image
import e_lekha.composeapp.generated.resources.camera
import e_lekha.composeapp.generated.resources.chose_document_type
import e_lekha.composeapp.generated.resources.electricity_bill
import e_lekha.composeapp.generated.resources.enter_aadhar
import e_lekha.composeapp.generated.resources.enter_pan
import e_lekha.composeapp.generated.resources.enter_voter_id
import e_lekha.composeapp.generated.resources.enter_your_kyc_details
import e_lekha.composeapp.generated.resources.front_image
import e_lekha.composeapp.generated.resources.k_number
import e_lekha.composeapp.generated.resources.name_electricity
import e_lekha.composeapp.generated.resources.name_on_aadhar
import e_lekha.composeapp.generated.resources.name_on_pan
import e_lekha.composeapp.generated.resources.name_on_vid
import e_lekha.composeapp.generated.resources.next
import e_lekha.composeapp.generated.resources.pan_camera
import e_lekha.composeapp.generated.resources.pan_number
import e_lekha.composeapp.generated.resources.select_id_proof
import e_lekha.composeapp.generated.resources.type_here
import e_lekha.composeapp.generated.resources.voter_no
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun KycDetailsScreen(
    onNextTab: () -> Unit = {}, onCancelTab: () -> Unit = {}

) {

    var selectedTab by remember { mutableStateOf(0) }

    val tabs = listOf("Electricity bill", "Aadhaar Card", "Voter ID")

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

                ReusableTextView(
                    text = stringResource(Res.string.enter_your_kyc_details)
                )
                Spacer(Modifier.height(12.dp))
                ReusableTextView(
                    text = stringResource(Res.string.chose_document_type)
                )

                Spacer(Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    tabs.forEachIndexed { index, label ->
                        Box(
                            modifier = Modifier
                                .size(width = 120.dp, height = 35.dp)
                                .background(
                                    if (selectedTab == index) appleblue else lightblues,
                                    RoundedCornerShape(20.dp)
                                )
                                .padding(horizontal = 12.dp)
                                .clickable { selectedTab = index },
                                    contentAlignment = Alignment.Center

                        ) {
                            Text(
                                text = label,
                                fontSize = 12.sp,
                                maxLines = 1,
                                textAlign = TextAlign.Center,
                                color = if (selectedTab == index) Color.White else Color.Black
                            )
                        }
                    }
                }

                Spacer(Modifier.height(20.dp))
                when (selectedTab) {
                    0 -> ElectricityBillForm()


                    1 -> AadhaarCardForm()

                    2 -> VidForm()
                }

                Spacer(Modifier.height(20.dp))

                IdProofSection()

            }
            CommonSaveButton (
                onSaveClick = {},
                saveText = stringResource(Res.string.next)
            )
        }
    }
}



@Composable
fun ElectricityBillForm() {

    var billName by remember { mutableStateOf("") }
    var accountNumber by remember { mutableStateOf("") }
    var kNumber by remember { mutableStateOf("") }
    Column(    modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        FormFieldCompact(
            label = stringResource(Res.string.name_electricity),
            value = billName,
            onValueChange = {
                billName = it
            },
            placeholder = stringResource(Res.string.type_here)
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(
            label = stringResource(Res.string.account_no),
            value = accountNumber,
            onValueChange = {
                accountNumber = it
            },
            placeholder = stringResource(Res.string.type_here),
            inputType = KeyboardType.Number
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(
            label = stringResource(Res.string.k_number),
            value = kNumber,
            onValueChange = {
                kno->
                kNumber=kno
            },
            placeholder = stringResource(Res.string.type_here),
            inputType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(10.dp))

    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Front Image Box
        Column(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
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
                contentDescription = stringResource(Res.string.front_image),
                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            ReusableTextView(text = stringResource(Res.string.front_image))
        }
    }
}


@Composable
fun AadhaarCardForm() {
    var aadharno by remember { mutableStateOf("") }
    var nameonadhar by remember { mutableStateOf("") }
    Column {
        FormFieldCompact(
            label = stringResource(Res.string.aadhar_no),
            value = aadharno,
            onValueChange = {
                aadharnoo->
                aadharno=aadharnoo
            },
            placeholder = stringResource(Res.string.enter_aadhar),
            maxLength = 12,
            inputType = KeyboardType.Number
        )
        Spacer(Modifier.height(12.dp))
        FormFieldCompact(
            label = stringResource(Res.string.name_on_aadhar),
            value = nameonadhar,
            onValueChange = {
                nameonaadhar->
                nameonadhar=nameonaadhar
            },
            placeholder = stringResource(Res.string.type_here)
        )
        Spacer(Modifier.height(20.dp))

        // ------------------ FRONT & BACK IMAGE PREVIEW ------------------
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Front Image Box
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                    contentDescription = stringResource(Res.string.front_image),
                    tint = Color.Black,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                ReusableTextView(text = stringResource(Res.string.front_image))
            }

            // Back Image Box
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                    contentDescription = stringResource(Res.string.back_image),
                    tint = Color.Black,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                ReusableTextView(text = stringResource(Res.string.back_image))
            }
        }
    }
}




@Composable
fun VidForm() {
    var voterno by remember { mutableStateOf("") }
    var nameonvid by remember { mutableStateOf("") }
Column {
    FormFieldCompact(
        label = stringResource(Res.string.voter_no),
        value = voterno,
        onValueChange = {
            voternoo->
            voterno=voternoo
        },
        placeholder = stringResource(Res.string.enter_voter_id),
        maxLength = 16,
        inputType = KeyboardType.Number
    )
    Spacer(modifier = Modifier.height(10.dp))

    FormFieldCompact(
        label = stringResource(Res.string.name_on_vid),
        value = nameonvid,
        onValueChange = {
            nameonvidd->
            nameonvid=nameonvidd
        },
        placeholder = stringResource(Res.string.enter_voter_id),
        maxLength = 16,
    )
    Spacer(modifier = Modifier.height(20.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(Color(0xFFE8E8E8)),
                contentAlignment = Alignment.Center
            ) { }

            Spacer(modifier = Modifier.height(6.dp))

            Icon(
                painter = painterResource(Res.drawable.camera),
                contentDescription = stringResource(Res.string.front_image),
                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            ReusableTextView(text = stringResource(Res.string.front_image))
        }
    }

}
}

@Composable
fun IdProofSection() {

    var selectedProof by remember { mutableStateOf(0) }

    val idProofTabs = listOf("Electricity bill", "Aadhaar Card", "Voter ID", "Pan Card")

    Column(modifier = Modifier.fillMaxWidth(),

        ) {

        ReusableTextView(text = stringResource(Res.string.select_id_proof))
        Spacer(Modifier.height(10.dp))


        Row(
            modifier = Modifier.fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(12.dp)



        ) {
            idProofTabs.forEachIndexed { index, label ->
                Box(
                    modifier = Modifier
                         .height(40.dp)
                        .background(
                            if (selectedProof == index) Color(0xFF0A84FF) else Color(0xFFEAF2FF),
                            RoundedCornerShape(20.dp)
                        )
                        .clickable { selectedProof = index }
                    .padding(horizontal = 20.dp),
                contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = label,
                        fontSize = 12.sp,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        color = if (selectedProof == index) Color.White else Color.Black
                    )
                }
            }
        }

        Spacer(Modifier.height(15.dp))

        when (selectedProof) {
            0 -> ElectricityBillForm()
            1 -> AadhaarCardForm()
            2 -> VidForm()
            3 -> PanCardForm()
        }
    }
}
@Composable
fun PanCardForm() {
    var panNumber by remember { mutableStateOf("") }
    var nameOnPan by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormFieldCompact(
            label = stringResource(Res.string.pan_number),
            value = panNumber,
            onValueChange = {
                pannumber->
                panNumber=pannumber
            },
            placeholder = stringResource(Res.string.enter_pan),
            inputType = KeyboardType.Number
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(
            label = stringResource(Res.string.name_on_pan),
            value = nameOnPan,
            onValueChange = {
                nameonpan->
                nameOnPan=nameonpan
            },
            placeholder = stringResource(Res.string.type_here)
        )

        Spacer(Modifier.height(20.dp))

        // IMAGE BOX
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(Color(0xFFE8E8E8)),
                contentAlignment = Alignment.Center
            ) { }

            Spacer(Modifier.height(6.dp))

            Icon(
                painter = painterResource(Res.drawable.camera),
                contentDescription = stringResource(Res.string.pan_camera),
                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )

            Spacer(Modifier.height(4.dp))
            ReusableTextView(text = stringResource(Res.string.front_image))
        }
    }
}

