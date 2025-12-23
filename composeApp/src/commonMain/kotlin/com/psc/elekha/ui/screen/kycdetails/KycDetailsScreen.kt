// Updated KycDetailsScreen.kt
package com.psc.elekha.ui.screen.kycdetails
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.psc.elekha.ui.theme.blue
import com.psc.elekha.ui.theme.appleblue
import com.psc.elekha.ui.theme.lightblues
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CameraPicker
import com.psc.elekha.utils.CommonSaveButton
import com.psc.elekha.utils.CustomAlertDialog

import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.loadImageFromPath
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.aadhar_no
import e_lekha.composeapp.generated.resources.account_no
import e_lekha.composeapp.generated.resources.back_image
import e_lekha.composeapp.generated.resources.camera
import e_lekha.composeapp.generated.resources.customer_image
import e_lekha.composeapp.generated.resources.customer_kyc
import e_lekha.composeapp.generated.resources.enter_aadhar
import e_lekha.composeapp.generated.resources.enter_pan
import e_lekha.composeapp.generated.resources.enter_voter_id
import e_lekha.composeapp.generated.resources.enter_your_kyc_details
import e_lekha.composeapp.generated.resources.front_image
import e_lekha.composeapp.generated.resources.gurantor_kyc
import e_lekha.composeapp.generated.resources.ic_customer
import e_lekha.composeapp.generated.resources.ic_gurantor
import e_lekha.composeapp.generated.resources.k_number
import e_lekha.composeapp.generated.resources.name_electricity
import e_lekha.composeapp.generated.resources.name_on_aadhar
import e_lekha.composeapp.generated.resources.name_on_pan
import e_lekha.composeapp.generated.resources.name_on_vid
import e_lekha.composeapp.generated.resources.next
import e_lekha.composeapp.generated.resources.roboto_regular
import org.jetbrains.compose.resources.Font
import e_lekha.composeapp.generated.resources.pan_camera
import e_lekha.composeapp.generated.resources.pan_number
import e_lekha.composeapp.generated.resources.type_here
import e_lekha.composeapp.generated.resources.voter_no
import e_lekha.composeapp.generated.resources.your_photo_with_guarantor
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun KycDetailsScreen(
    onNextTab: () -> Unit = {}, onCancelTab: () -> Unit = {}
) {
    var selectedTab by remember { mutableStateOf(0) }
    var openCamera by remember { mutableStateOf(false) }
    var currentCameraTarget by remember { mutableStateOf("") }
    var ebFrontImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var aadhaarFrontImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var aadhaarBackImage by remember { mutableStateOf<ImageBitmap?>(null) }

    var vidFrontImage by remember { mutableStateOf<ImageBitmap?>(null) }
// VID usually doesn’t have back image, so you can skip if not needed

    var panFrontImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var panBackImage by remember { mutableStateOf<ImageBitmap?>(null) } // optional

    val tabs = listOf("Electricity bill", "Aadhaar Card", "Voter ID")
    var viewModel = koinViewModel<KycDetailViewModel>()
    val coroutineScope = rememberCoroutineScope()

/*    LaunchedEffect(Unit) {
        viewModel.loadSaveData()
    }*/

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(10.dp))

            Spacer(modifier = Modifier.height(18.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 15.dp)
            ) {
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
                        Spacer(modifier = Modifier.height(6.dp))
                        Icon(
                            painter = painterResource(Res.drawable.camera),
                            contentDescription = "Back Camera",
                            tint = blue,
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
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
                                .size(160.dp, 120.dp)
                                .background(
                                    Color(0xFFE8E8E8),
                                    shape = RoundedCornerShape(8.dp)   // optional, looks better
                                )
                                .padding(4.dp),   // optional
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Icon(
                            painter = painterResource(Res.drawable.camera),
                            contentDescription = "Back Camera",
                            tint = blue,
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        ReusableTextView(
                            text = stringResource(Res.string.your_photo_with_guarantor)
                        )

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                ReusableTextView(
                    text = stringResource(Res.string.enter_your_kyc_details)
                )
                Spacer(Modifier.height(12.dp))
                ReusableTextView(
                    text = stringResource(Res.string.customer_kyc)
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
                                fontFamily = FontFamily(Font(Res.font.roboto_regular)),
                                textAlign = TextAlign.Center,
                                color = if (selectedTab == index) Color.White else Color.Black
                            )
                        }
                    }
                }

                Spacer(Modifier.height(20.dp))
                when (selectedTab) {
                    0 -> ElectricityBillForm(viewModel,
                        ebFrontImage = ebFrontImage,
                        onCameraClick = {
                            currentCameraTarget = "EB_FRONT"
                            openCamera = true
                        }
                        )
                    1 -> AadhaarCardForm(viewModel)
                    2 -> VidForm(viewModel)
                }

                Spacer(Modifier.height(20.dp))

                IdProofSection(viewModel)
            }
            CommonSaveButton(
                onSaveClick = {
                    /*println("billNam")
                    coroutineScope.launch {
                        try {
                            viewModel.SaveKyc()
                        } catch (e: Exception) {
                            println("Save error: ${e.message}")
                            // Handle error: e.g., set showSaveAlert=true with error message
                        }
                    }*/
                   viewModel.updateKyc {
                       viewModel.kNumber
                       viewModel.kNumberIdProof
                       viewModel.accountNumber
                       viewModel.nameonadhar
                       viewModel.accountNumberIdProof
                       viewModel.voterno
                       viewModel.nameonvid
                       viewModel.voternoIdProof
                       viewModel.panNumber
                       viewModel.nameOnPan
                   }
                    onNextTab
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
    if (openCamera) {
        CameraPicker(
            openCamera = openCamera,
            onImagePicked = { path ->
                val bitmap = path?.let { loadImageFromPath(it) }

                when (currentCameraTarget) {
                    "EB_FRONT" -> ebFrontImage = bitmap
                    // later you can add:
                    // "AADHAAR_FRONT" -> aadhaarFrontImage = bitmap
                    // "PAN" -> panImage = bitmap
                }

                openCamera = false
            }
        )
    }

}

@Composable
fun ElectricityBillForm(viewModel: KycDetailViewModel, ebFrontImage: ImageBitmap?,
                        onCameraClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormFieldCompact(
            label = stringResource(Res.string.name_electricity),
            value = viewModel.billName,
            onValueChange = {
                viewModel.billName = it
            },
            maxLength = 30,
            placeholder = stringResource(Res.string.type_here)

        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(
            label = stringResource(Res.string.account_no),
            value = viewModel.accountNumber,
            onValueChange = {
                viewModel.accountNumber = it
            },

            maxLength = 20,
            placeholder = stringResource(Res.string.type_here),
            inputType = KeyboardType.Number
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(

            maxLength = 30,
            label = stringResource(Res.string.k_number),
            value = viewModel.kNumber,
            onValueChange = {
                viewModel.kNumber = it
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(Color(0xFFE8E8E8)),
                contentAlignment = Alignment.Center
            ) {
                ebFrontImage?.let {img ->
                    Image(
                        bitmap = img,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Icon(
                painter = painterResource(Res.drawable.camera),
                tint = blue,
                contentDescription = stringResource(Res.string.front_image),
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onCameraClick() }
            )
            Spacer(modifier = Modifier.height(4.dp))
            ReusableTextView(text = stringResource(Res.string.front_image))
        }
    }

}

@Composable
fun AadhaarCardForm(viewModel: KycDetailViewModel) {
    Column {
        FormFieldCompact(
            label = stringResource(Res.string.aadhar_no),
            value = viewModel.aadharno,
            onValueChange = {
                viewModel.aadharno = it
            },
            placeholder = stringResource(Res.string.enter_aadhar),
            maxLength = 12,
            inputType = KeyboardType.Number
        )
        Spacer(Modifier.height(12.dp))
        FormFieldCompact(
            label = stringResource(Res.string.name_on_aadhar),
            value = viewModel.nameonadhar,
            onValueChange = {
                viewModel.nameonadhar = it
            },
            maxLength = 20,
            placeholder = stringResource(Res.string.type_here)
        )
        Spacer(Modifier.height(20.dp))

        // ------------------ FRONT & BACK IMAGE PREVIEW ------------------
        Row(
            modifier = Modifier
                .fillMaxWidth()
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
                    tint = blue,
                    contentDescription = stringResource(Res.string.front_image),
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
                    tint = blue,
                    contentDescription = stringResource(Res.string.back_image),
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                ReusableTextView(text = stringResource(Res.string.back_image))
            }
        }
    }
}

@Composable
fun VidForm(viewModel: KycDetailViewModel) {
    Column {
        FormFieldCompact(
            label = stringResource(Res.string.voter_no),
            value = viewModel.voterno,
            onValueChange = {
                viewModel.voterno = it
            },
            placeholder = stringResource(Res.string.enter_voter_id),
            maxLength = 16,
            inputType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(10.dp))

        FormFieldCompact(
            label = stringResource(Res.string.name_on_vid),
            value = viewModel.nameonvid,
            onValueChange = {
                viewModel.nameonvid = it  // Fixed: was voterno
            },
            placeholder = stringResource(Res.string.type_here),
            maxLength = 30,
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
                tint = blue,
                contentDescription = stringResource(Res.string.front_image),
                modifier = Modifier.size(28.dp)
            )

                Spacer(modifier = Modifier.height(4.dp))

                ReusableTextView(text = stringResource(Res.string.front_image))
            }
        }
    }
}

@Composable
fun IdProofSection(viewModel: KycDetailViewModel) {
    var selectedProof by remember { mutableStateOf(0) }

    val idProofTabs = listOf("Electricity bill", "Aadhaar Card", "Voter ID", "Pan Card")

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        ReusableTextView(text = stringResource(Res.string.gurantor_kyc))
        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
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
                        fontFamily = FontFamily(Font(Res.font.roboto_regular)),
                        color = if (selectedProof == index) Color.White else Color.Black
                    )
                }
            }
        }

        Spacer(Modifier.height(15.dp))

        when (selectedProof) {
            0 -> IdProofElectricityBillForm(viewModel)
            1 -> IdProofAadhaarCardForm(viewModel)
            2 -> IdProofVidForm(viewModel)
            3 -> PanCardForm(viewModel)
        }
    }
}
@Composable
fun IdProofElectricityBillForm(viewModel: KycDetailViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormFieldCompact(
            label = stringResource(Res.string.name_electricity),
            value = viewModel.billNameIdProof,
            onValueChange = {
                viewModel.billNameIdProof = it
            },
            placeholder = stringResource(Res.string.type_here)
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(
            label = stringResource(Res.string.account_no),
            value = viewModel.accountNumberIdProof,
            onValueChange = {
                viewModel.accountNumberIdProof = it
            },

            maxLength = 10,
            placeholder = stringResource(Res.string.type_here),
            inputType = KeyboardType.Number
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(

            maxLength = 30,
            label = stringResource(Res.string.k_number),
            value = viewModel.kNumberIdProof,
            onValueChange = {
                viewModel.kNumberIdProof = it
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
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
                tint = blue,
                contentDescription = stringResource(Res.string.front_image),
//                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            ReusableTextView(text = stringResource(Res.string.front_image))
        }
    }
}

@Composable
fun IdProofAadhaarCardForm(viewModel: KycDetailViewModel) {
    Column {
        FormFieldCompact(
            label = stringResource(Res.string.aadhar_no),
            value = viewModel.aadharnoIdProof,
            onValueChange = {
                viewModel.aadharnoIdProof = it
            },
            placeholder = stringResource(Res.string.enter_aadhar),
            maxLength = 12,
            inputType = KeyboardType.Number
        )
        Spacer(Modifier.height(12.dp))
        FormFieldCompact(
            label = stringResource(Res.string.name_on_aadhar),
            value = viewModel.nameonadharIdProof,
            onValueChange = {
                viewModel.nameonadharIdProof = it
            },
            maxLength = 30,
            placeholder = stringResource(Res.string.type_here)
        )
        Spacer(Modifier.height(20.dp))

        // ------------------ FRONT & BACK IMAGE PREVIEW ------------------
        Row(
            modifier = Modifier
                .fillMaxWidth()
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
                    tint = blue,
                    contentDescription = stringResource(Res.string.front_image),
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
                    tint = blue,
                    contentDescription = stringResource(Res.string.back_image),
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                ReusableTextView(text = stringResource(Res.string.back_image))
            }
        }
    }
}

@Composable
fun IdProofVidForm(viewModel: KycDetailViewModel) {
    Column {
        FormFieldCompact(
            label = stringResource(Res.string.voter_no),
            value = viewModel.voternoIdProof,
            onValueChange = {
                viewModel.voternoIdProof = it
            },
            placeholder = stringResource(Res.string.enter_voter_id),
            maxLength = 16,
            inputType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(10.dp))

        FormFieldCompact(
            label = stringResource(Res.string.name_on_vid),
            value = viewModel.nameonvidIdProof,
            onValueChange = {
                viewModel.nameonvidIdProof = it  // Fixed: was voterno
            },
            placeholder = stringResource(Res.string.type_here),
            maxLength = 20,
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
                    tint = blue,
                    contentDescription = stringResource(Res.string.front_image),
                    modifier = Modifier.size(28.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                ReusableTextView(text = stringResource(Res.string.front_image))
            }
        }
    }
}
@Composable
fun PanCardForm(viewModel: KycDetailViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormFieldCompact(
            label = stringResource(Res.string.pan_number),
            value = viewModel.panNumber,
            onValueChange = {
                viewModel.panNumber = it
            },
            maxLength = 10,
            placeholder = stringResource(Res.string.enter_pan),
            inputType = KeyboardType.Number
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(
            label = stringResource(Res.string.name_on_pan),
            value = viewModel.nameOnPan,
            onValueChange = {
                viewModel.nameOnPan = it
            },
            maxLength = 30,
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
                tint = blue,
                contentDescription = stringResource(Res.string.pan_camera),
                modifier = Modifier.size(28.dp)
            )

            Spacer(Modifier.height(4.dp))
            ReusableTextView(text = stringResource(Res.string.front_image))
        }
    }

}