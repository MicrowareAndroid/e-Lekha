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
import androidx.compose.foundation.relocation.bringIntoViewRequester
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
import androidx.compose.ui.focus.focusRequester
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
import com.psc.elekha.utils.ReusableTextViewes
import com.psc.elekha.utils.loadImageFromPath
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.aadhar_no
import e_lekha.composeapp.generated.resources.back_image
import e_lekha.composeapp.generated.resources.camera
import e_lekha.composeapp.generated.resources.customer_image
import e_lekha.composeapp.generated.resources.customer_kyc
import e_lekha.composeapp.generated.resources.electricity_account_no
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
import kotlin.math.log
import kotlin.math.max

@Composable
fun KycDetailsScreen(
    onNextTab: () -> Unit = {}, onCancelTab: () -> Unit = {}
) {
    var selectedTab by remember { mutableStateOf(0) }
    var openCamera by remember { mutableStateOf(false) }
    var currentCameraTarget by remember { mutableStateOf("") }
    var ebFrontImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var otherEbFrontImage by remember { mutableStateOf<ImageBitmap?>(null) }
// VID usually doesn’t have back image, so you can skip if not needed

    var panBackImage by remember { mutableStateOf<ImageBitmap?>(null) } // optional

    val tabs = listOf("Electricity bill", "Aadhaar Card", "Voter ID","Others")
    var viewModel = koinViewModel<KycDetailViewModel>()
    val coroutineScope = rememberCoroutineScope()
    var aadhaarFrontImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var aadhaarBackImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var vidFrontImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var panFrontImage by remember { mutableStateOf<ImageBitmap?>(null) }


    //gurantor
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
//
//                Spacer(Modifier.height(12.dp))
                ReusableTextViewes(
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
                    0 -> ElectricityBillForm(
                        viewModel,
                        ebFrontImage = ebFrontImage,
                        onCameraClick = {
                            currentCameraTarget = "EB_FRONT"
                            openCamera = true
                        }
                    )

                    1 -> AadhaarCardForm(viewModel,
                        aadhaarFrontImage=aadhaarFrontImage,
                        aadhaarBackImage= aadhaarBackImage,
                        onCameraClick = { side ->
                            currentCameraTarget = side
                            openCamera = true
                        }
                    )
                    2 -> VidForm(
                        viewModel,
                        vidFrontImage = vidFrontImage, // if you don't have back, otherwise pass vidBackImage
                        onCameraClick = { side ->
                            currentCameraTarget = side
                            openCamera = true
                        }
                    )
                    3 -> OtherElectricityForm(
                        viewModel = viewModel,
                        otherFrontImage = otherEbFrontImage,
                        onCameraClick = {
                            currentCameraTarget = "OTHER_EB_FRONT"
                            openCamera = true
                        }
                    )
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
                    viewModel.onNextClick {
                        onNextTab
                    }
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
                path?.let {
                    val imgBitmap = loadImageFromPath(it)
                    when(currentCameraTarget) {
                        "EB_FRONT" -> {
                            ebFrontImage = imgBitmap
                            viewModel.setEbImage(it)
                        }
                        "AADHAAR_FRONT" -> {
                            aadhaarFrontImage = imgBitmap
                            viewModel.setAadhaarFrontImage(it)
                        }
                        "AADHAAR_BACK" -> {
                            aadhaarBackImage = imgBitmap
                            viewModel.setAadhaarBackImage(it)
                        }
                        "VID_FRONT" -> {
                            vidFrontImage = imgBitmap
                            viewModel.setVidFrontImage(it)
                        }
                        "OTHER_EB_FRONT" -> {
                            otherEbFrontImage = imgBitmap
                            viewModel.setOtherEbImage(path)
                        }
                    }
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
            onValueChange = { viewModel.billName = it },
            maxLength = 20,
            modifier = Modifier
                .bringIntoViewRequester(viewModel.bringIntoViewBillName)
                .focusRequester(viewModel.focusBillName),
            placeholder = stringResource(Res.string.type_here)
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(
            label = stringResource(Res.string.electricity_account_no),
            value = viewModel.accountNumber,
            onValueChange = {
                viewModel.accountNumber = it
            },
            modifier = Modifier
                .bringIntoViewRequester(viewModel.bringIntoViewAccountNumber)
                .focusRequester(viewModel.focusAccountNumber),

            maxLength = 15,
            placeholder = stringResource(Res.string.type_here),
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(

            maxLength = 15,
            label = stringResource(Res.string.k_number),
            value = viewModel.kNumber,
            onValueChange = {
                viewModel.kNumber = it
            },
            modifier = Modifier
                .bringIntoViewRequester(viewModel.bringIntoViewKNumber)
                .focusRequester(viewModel.focusKNumber),
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
fun AadhaarCardForm(viewModel: KycDetailViewModel,
                    aadhaarFrontImage: ImageBitmap?,
                    aadhaarBackImage: ImageBitmap?,
                    onCameraClick: (String) -> Unit
) {
    Column {
        FormFieldCompact(
            label = stringResource(Res.string.aadhar_no),
            value = viewModel.aadharno,
            onValueChange = {
                viewModel.aadharno = it
            },
            modifier = Modifier
                .bringIntoViewRequester(viewModel.bringIntoViewAadharNo)
                .focusRequester(viewModel.focusAadharNo),
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
            modifier = Modifier
                .bringIntoViewRequester(viewModel.bringIntoViewNameOnAadhar)
                .focusRequester(viewModel.focusNameOnAadhar),
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
                        .background(Color(0xFFE8E8E8)),
                    contentAlignment = Alignment.Center
                ) {
                    aadhaarFrontImage?.let { img ->
                        Image(
                            bitmap = img,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Icon(
                    painter = painterResource(Res.drawable.camera),
                    tint = blue,
                    contentDescription = stringResource(Res.string.front_image),
                    modifier = Modifier
                        .size(28.dp)
                        .clickable { onCameraClick("AADHAAR_FRONT") }
                )
                Spacer(modifier = Modifier.height(4.dp))
                ReusableTextView(text = stringResource(Res.string.front_image))
            }

            // Back Image Box
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color(0xFFE8E8E8)),
                    contentAlignment = Alignment.Center
                ) {
                    aadhaarBackImage?.let { img ->
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
                        .clickable { onCameraClick("AADHAAR_BACK") }
                )
                Spacer(modifier = Modifier.height(4.dp))
                ReusableTextView(text = stringResource(Res.string.back_image))
            }
        }
    }
}

@Composable
fun VidForm(viewModel: KycDetailViewModel,
            vidFrontImage: ImageBitmap?,
            onCameraClick: (String) -> Unit  ) {
    Column {
        FormFieldCompact(
            label = stringResource(Res.string.voter_no),
            value = viewModel.voterno,
            onValueChange = {
                viewModel.voterno = it
            },
            modifier = Modifier
                .bringIntoViewRequester(viewModel.bringIntoViewVoterNo)
                .focusRequester(viewModel.focusVoterNo),

            placeholder = stringResource(Res.string.enter_voter_id),
            maxLength = 16,
        )
        Spacer(modifier = Modifier.height(10.dp))

        FormFieldCompact(
            label = stringResource(Res.string.name_on_vid),
            value = viewModel.nameonvid,
            onValueChange = {
                viewModel.nameonvid = it  // Fixed: was voterno
            },
            modifier = Modifier
                .bringIntoViewRequester(viewModel.bringIntoViewNameOnVid)
                .focusRequester(viewModel.focusNameOnVid),
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
                ) {
                    vidFrontImage?.let { img ->
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
                        .clickable { onCameraClick("VID_FRONT") }
                )

                Spacer(modifier = Modifier.height(4.dp))

                ReusableTextView(text = stringResource(Res.string.front_image))
            }
        }
    }
}

@Composable
fun OtherElectricityForm(
    viewModel: KycDetailViewModel,
    otherFrontImage: ImageBitmap?,
    onCameraClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FormFieldCompact(
            label = stringResource(Res.string.name_electricity),
            value = "",
            onValueChange = { },
            maxLength = 20,
            placeholder = stringResource(Res.string.type_here)
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(
            label = stringResource(Res.string.electricity_account_no),
            value = "",
            onValueChange = { },
            maxLength = 15,
            placeholder = stringResource(Res.string.type_here)
        )

        Spacer(Modifier.height(12.dp))

        FormFieldCompact(
            label = stringResource(Res.string.k_number),
            value = "",
            onValueChange = {},
            maxLength = 15,
            inputType = KeyboardType.Number,
            placeholder = stringResource(Res.string.type_here)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(Color(0xFFE8E8E8)),
                contentAlignment = Alignment.Center
            ) {
                otherFrontImage?.let {
                    Image(
                        bitmap = it,
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
fun IdProofSection(viewModel: KycDetailViewModel) {
    var selectedProof by remember { mutableStateOf(0) }
    var idEbFrontImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var idAadhaarFrontImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var idAadhaarBackImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var idVidFrontImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var idPanFrontImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var openCamera by remember { mutableStateOf(false) }
    var currentCameraTarget by remember { mutableStateOf("") }
    val idProofTabs = listOf("Aadhaar Card", "Voter ID", "Pan Card")

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        ReusableTextViewes(text = stringResource(Res.string.gurantor_kyc))
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
            0 -> IdProofAadhaarCardForm(
                viewModel = viewModel,
                idAadhaarFrontImage = idAadhaarFrontImage,
                idAadhaarBackImage = idAadhaarBackImage,
                onFrontCameraClick = {
                    currentCameraTarget = "ID_AADHAAR_FRONT"
                    openCamera = true
                },
                onBackCameraClick = {
                    currentCameraTarget = "ID_AADHAAR_BACK"
                    openCamera = true
                }
            )
            1 -> IdProofVidForm(
                viewModel,
                idVidFrontImage = idVidFrontImage,
                onCameraClick = { currentCameraTarget = "ID_VID_FRONT"; openCamera = true }
            )
            2 -> PanCardForm(
                viewModel,
                idPanFrontImage = idPanFrontImage,
                onCameraClick = { currentCameraTarget = "ID_PAN_FRONT"; openCamera = true }
            )
        }
    }
    if (openCamera) {
        CameraPicker(
            openCamera = openCamera,
            onImagePicked = { path ->
                path?.let {
                    val bitmap = loadImageFromPath(it)
                    when(currentCameraTarget) {
                        "ID_AADHAAR_FRONT" -> { idAadhaarFrontImage = bitmap; viewModel.setGAadhaarFront(it) }
                        "ID_AADHAAR_BACK" -> { idAadhaarBackImage = bitmap; viewModel.setAadhaarBackImage(it) }
                        "ID_VID_FRONT" -> { idVidFrontImage = bitmap; viewModel.setGVoterImage(it) }
                        "ID_PAN_FRONT" -> { idPanFrontImage = bitmap; viewModel.setGPanImage(it) }
                    }
                }
                openCamera = false
            }
        )
    }
}
@Composable
fun IdProofAadhaarCardForm(
    viewModel: KycDetailViewModel,
    idAadhaarFrontImage: ImageBitmap?,
    idAadhaarBackImage: ImageBitmap?,
    onFrontCameraClick: () -> Unit,
    onBackCameraClick: () -> Unit
) {
    Column {
        FormFieldCompact(
            label = stringResource(Res.string.aadhar_no),
            value = viewModel.gAadharNo,
            onValueChange = {
                viewModel.gAadharNo = it
            },
            modifier = Modifier
                .bringIntoViewRequester(viewModel.bringIntoViewGAadharNo)
                .focusRequester(viewModel.focusGAadharNo),
            placeholder = stringResource(Res.string.enter_aadhar),
            maxLength = 12,
            inputType = KeyboardType.Number
        )
        Spacer(Modifier.height(12.dp))
        FormFieldCompact(
            label = stringResource(Res.string.name_on_aadhar),
            value = viewModel.gAadharName,
            onValueChange = {
                viewModel.gAadharName = it
            },
            modifier = Modifier
                .bringIntoViewRequester(viewModel.bringIntoViewGAadharName)
                .focusRequester(viewModel.focusGAadharName),

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
                        .background(Color(0xFFE8E8E8)),
                    contentAlignment = Alignment.Center
                ) {
                    idAadhaarFrontImage?.let {
                        Image(
                            bitmap = it,
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
                        .clickable { onFrontCameraClick() }
                )
                Spacer(modifier = Modifier.height(4.dp))
                ReusableTextView(text = stringResource(Res.string.front_image))
            }

            // Back Image Box
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color(0xFFE8E8E8)),
                    contentAlignment = Alignment.Center
                ) {
                    idAadhaarBackImage?.let {
                        Image(
                            bitmap = it,
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
                        .clickable { onBackCameraClick() }
                )
                Spacer(modifier = Modifier.height(4.dp))
                ReusableTextView(text = stringResource(Res.string.back_image))
            }
        }
    }
}
@Composable
fun IdProofVidForm(viewModel: KycDetailViewModel,
                   idVidFrontImage:ImageBitmap?,
                   onCameraClick: () -> Unit
) {
    Column {
        FormFieldCompact(
            label = stringResource(Res.string.voter_no),
            value = viewModel.gVoterNo,
            onValueChange = {
                viewModel.gVoterNo = it
            },
            modifier = Modifier
                .bringIntoViewRequester(viewModel.bringIntoViewGVoterNo)
                .focusRequester(viewModel.focusGVoterNo),
            placeholder = stringResource(Res.string.enter_voter_id),
            maxLength = 16,
        )
        Spacer(modifier = Modifier.height(10.dp))
        FormFieldCompact(
            label = stringResource(Res.string.name_on_vid),
            value = viewModel.gVoterName,
            onValueChange = {
                viewModel.gVoterName = it  // Fixed: was voterno
            },
            modifier = Modifier
                .bringIntoViewRequester(viewModel.bringIntoViewGVoterName)
                .focusRequester(viewModel.focusGVoterName),
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
                ) {
                    idVidFrontImage?.let {
                        Image(
                            bitmap = it,
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
}
@Composable
fun PanCardForm(viewModel: KycDetailViewModel,
                idPanFrontImage:ImageBitmap?,
                onCameraClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormFieldCompact(
            label = stringResource(Res.string.pan_number),
            value = viewModel.gPanNumber,
            onValueChange = {
                viewModel.gPanNumber = it
            },
            modifier = Modifier
                .bringIntoViewRequester(viewModel.bringIntoViewgPanNumber)
                .focusRequester(viewModel.focusgPanNumber),
            maxLength = 12,
            placeholder = stringResource(Res.string.enter_pan),
        )
        Spacer(Modifier.height(12.dp))
        FormFieldCompact(
            label = stringResource(Res.string.name_on_pan),
            value = viewModel.gPanName,
            onValueChange = {
                viewModel.gPanName = it
            },
            modifier = Modifier
                .bringIntoViewRequester(viewModel.bringIntoViewNameOnPan)
                .focusRequester(viewModel.focusNameOnPan),
            maxLength = 20,
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
            ) {
                idPanFrontImage?.let {
                    Image(
                        bitmap = it,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Spacer(Modifier.height(6.dp))
            Icon(
                painter = painterResource(Res.drawable.camera),
                tint = blue,
                contentDescription = stringResource(Res.string.front_image),
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onCameraClick() }
            )
            Spacer(Modifier.height(4.dp))
            ReusableTextView(text = stringResource(Res.string.front_image))
        }
    }
}