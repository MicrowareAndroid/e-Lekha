package com.psc.elekha.ui.screen.kycdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CommonSaveButton
import com.psc.elekha.utils.FormField
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.ReusableTextView
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.back_image
import e_lekha.composeapp.generated.resources.camera
import e_lekha.composeapp.generated.resources.chose_document_type
import e_lekha.composeapp.generated.resources.enter_your_kyc_details
import e_lekha.composeapp.generated.resources.front_image
import e_lekha.composeapp.generated.resources.next
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

                // --------------------- TOP TAB BUTTONS -------------------------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    tabs.forEachIndexed { index, label ->
                        Box(
                            modifier = Modifier
                                .size(width = 120.dp, height = 35.dp)
                                .background(
                                    if (selectedTab == index) Color(0xFF0A84FF) else Color(0xFFEAF2FF),
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
    Column(    modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        FormFieldCompact(
            label = "Name on Electricity bill",
            value = "",
            onValueChange = {},
            placeholder = "Type here"
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(
            label = "Account Number",
            value = "",
            onValueChange = {},
            placeholder = "Type here",
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(
            label = "K Number",
            value = "",
            onValueChange = {},
            placeholder = "Type here"
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
                contentDescription = "Front Camera",
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
    Column {
        FormFieldCompact(
            label = "Aadhaar Number",
            value = "",
            onValueChange = {},
            placeholder = "Enter Aadhaar",
            maxLength = 12,
        )
        Spacer(Modifier.height(12.dp))
        FormFieldCompact(
            label = "Name on Aadhaar",
            value = "",
            onValueChange = {},
            placeholder = "Type here"
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
                    contentDescription = "Front Camera",
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
                    contentDescription = "Back Camera",
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
Column {
    FormFieldCompact(
        label = "Voter Number",
        value = "",
        onValueChange = {},
        placeholder = "Enter Voter ID",
        maxLength = 16,
    )
    Spacer(modifier = Modifier.height(10.dp))

    FormFieldCompact(
        label = "Name on VID",
        value = "",
        onValueChange = {},
        placeholder = "Enter Voter ID",
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
                contentDescription = "Front Camera",
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

        ReusableTextView(text = "Select ID Proof")
        Spacer(Modifier.height(10.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            idProofTabs.forEachIndexed { index, label ->
                Box(
                    modifier = Modifier
                        .size(width = 100.dp, height = 35.dp)
                        .background(
                            if (selectedProof == index) Color(0xFF0A84FF) else Color(0xFFEAF2FF),
                            RoundedCornerShape(20.dp)
                        )
                        .clickable { selectedProof = index },
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
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormFieldCompact(
            label = "PAN Number",
            value = "",
            onValueChange = {},
            placeholder = "Enter PAN"
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(
            label = "Name on PAN",
            value = "",
            onValueChange = {},
            placeholder = "Type here"
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
                contentDescription = "PAN Camera",
                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )

            Spacer(Modifier.height(4.dp))
            ReusableTextView(text = stringResource(Res.string.front_image))
        }
    }
}

