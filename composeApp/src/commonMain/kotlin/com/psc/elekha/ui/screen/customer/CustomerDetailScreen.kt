package com.psc.elekha.ui.screen.customer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
import com.psc.elekha.database.viewmodel.MSTLoanProductViewModel
import com.psc.elekha.ui.screen.gtrlist.BranchItem
import com.psc.elekha.ui.screen.gtrlist.GtrViewModel
import com.psc.elekha.ui.screen.repayment.RepaymentViewModel
import com.psc.elekha.ui.theme.LightSkyBlue
import com.psc.elekha.ui.theme.LightTeal
import com.psc.elekha.ui.theme.PrimaryDark
import com.psc.elekha.ui.theme.appleblue
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.blue
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.ui.theme.homedatareportsColor
import com.psc.elekha.ui.theme.text_fiiled_color
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CameraPicker
import com.psc.elekha.utils.CommonActionButtons
import com.psc.elekha.utils.CommonDivider
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.CustomAlertDialog
import com.psc.elekha.utils.Dimens
import com.psc.elekha.utils.FillDynamicSpinner
import com.psc.elekha.utils.FillDynamicSpinnerespt

import com.psc.elekha.utils.FormFieldCompact

import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableCard
import com.psc.elekha.utils.ReusableDynamicSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViews
import com.psc.elekha.utils.ReusableTopBar
import com.psc.elekha.utils.loadImageFromPath

import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import kotlin.collections.listOf

@Composable
fun CustomerDetailScreen(
    navController: NavHostController,
) {
    val viewModel = koinViewModel<GtrViewModel>()
    var mSTLoanProductViewModel=koinViewModel<MSTLoanProductViewModel>()
    val loanRecommendationList by mSTLoanProductViewModel.loanRecommendation.collectAsState()
    var selectedScreen by remember { mutableStateOf("New Customer") }

    var openCameraCustomer by remember { mutableStateOf(false) }
    var openCameraGuarantor by remember { mutableStateOf(false) }
    var openCameraEMeter by remember { mutableStateOf(false) }
    var openCameraHouseVerification by remember { mutableStateOf(false) }
    var customerImgBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    var guarantorImgBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    var eMeterImgBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    var houseVerificationImgBitmap by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(Unit) {

        mSTLoanProductViewModel.loadLoanAmount()
        viewModel.loadSavedData()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ReusableTopBar(
                title = selectedScreen,
                navigationIcon = painterResource(Res.drawable.back),
                fontFamily = FontFamily(Font(Res.font.inter_medium)),
                onNavigationClick = { navController.popBackStack() }
            )
        },
        /*bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(toolbar_color)
                    .padding(horizontal = Dimens.sixteendp, vertical = Dimens.tendp)
                    .navigationBarsPadding()
            ) {
                CommonSingleButtonsBottomString(
                    onOkClick = {

                    },
                    stringResource(Res.string.user_proceed),
                    textSize = 16
                )
            }
        }*/
    )
    { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)


        )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize().padding(bottom = 45.dp)
                    .verticalScroll(rememberScrollState())
//                    .padding(horizontal = 0.dp, vertical = Dimens.fivedp),


            )
            {
                ReusableCard(
                    modifier = Modifier
                        .fillMaxWidth(),
                    backgroundColor = text_fiiled_color,
                    cornerRadius = 0
                )
                {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {

                        // LEFT
                        Column(verticalArrangement = Arrangement.Center)
                        {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                ReusableTextView(
                                    text = stringResource(Res.string.home_user).plus(
                                        ":"
                                    ),
                                    textColor = appleblue, fontWeight = FontWeight.Bold
                                )
                                Spacer(Modifier.width(6.dp))
                                ReusableTextView(
                                    text = "Vikash",
                                    textColor = black,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                ReusableTextView(
                                    text = stringResource(Res.string.home_time).plus(":"),
                                    textColor = appleblue, fontWeight = FontWeight.Bold
                                )
                                Spacer(Modifier.width(6.dp))
                                ReusableTextView(
                                    text = "10:45 AM",
                                    textColor = black,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                        }

                        // RIGHT
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                ReusableTextView(
                                    text = stringResource(Res.string.home_date).plus(":"),
                                    textColor = appleblue, fontWeight = FontWeight.Bold
                                )
                                Spacer(Modifier.width(6.dp))
                                ReusableTextView(
                                    text = "04/12/2025",
                                    textColor = black,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Dimens.tendp)
                )
                {
                    Spacer(modifier = Modifier.height(Dimens.tendp))


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Dimens.tendp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {

                        ReusableTextView(
                            text = stringResource(Res.string.customer_name),
                            fontSize = 16,
                            textColor = black
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Dimens.tendp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    )
                    {

                        // -------- LEFT IMAGE + CAMERA --------
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .background(
                                        Color(0xFFE8E8E8),
                                        RoundedCornerShape(Dimens.fivedp)
                                    )
                            ) {
                                customerImgBitmap?.let { img ->
                                    Image(
                                        bitmap = img,
                                        contentDescription = null,
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop

                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(Dimens.fivedp))

                            Icon(
                                painter = painterResource(Res.drawable.camera),
                                contentDescription = "",
                                tint = blue,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clickable {
                                        openCameraCustomer = true
                                    }
                            )
                        }

                        // -------- RIGHT IMAGE + CAMERA --------
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .background(
                                        Color(0xFFE8E8E8),
                                        RoundedCornerShape(Dimens.fivedp)
                                    )
                            ) {
                                guarantorImgBitmap?.let { img ->
                                    Image(
                                        bitmap = img,
                                        contentDescription = null,
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop

                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(Dimens.fivedp))

                            Icon(
                                painter = painterResource(Res.drawable.camera),
                                contentDescription = "",
                                tint = blue,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clickable {
                                        openCameraGuarantor = true
                                    }
                            )
                        }
                    }


                    Spacer(modifier = Modifier.height(15.dp))

                    Divider(color = LightSkyBlue, thickness = 1.dp)

                    Spacer(modifier = Modifier.height(15.dp))
                    Column(
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                    )
                    {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.tendp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            // Fixed width text (avoid Row squeezing)
                            ReusableTextViewBlackCard(
                                text = stringResource(Res.string.user_last_loan).plus(":"),
                                modifier = Modifier.width(120.dp) // <--- IMPORTANT
                            )

                            Spacer(modifier = Modifier.width(8.dp))
                            FormFieldCompact(
                                value = "₹ 15,000",
                                onValueChange = {},
                                isReadable = true,
                                isEnable = false,
                                placeholder = "",
                                modifier = Modifier.weight(1f)
                            )
                        }

                        Spacer(modifier = Modifier.height(Dimens.tendp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.tendp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextViewBlackCard(
                                text = stringResource(Res.string.user_psc).plus(":"),
                                modifier = Modifier.width(120.dp),
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            FormFieldCompact(
                                value = "₹ 25,000",
                                onValueChange = {},
                                isReadable = true,
                                isEnable = false,
                                placeholder = "",
                                modifier = Modifier.weight(1f)
                            )
                        }
                        Spacer(modifier = Modifier.height(Dimens.tendp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.tendp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextViewBlackCard(

                                text = stringResource(Res.string.user_total).plus(":"),
                                modifier = Modifier.width(120.dp),
                            )
                            Spacer(modifier = Modifier.width(7.dp))
                            FormFieldCompact(
                                value = "₹ 32,000",
                                onValueChange = {},
                                isReadable = true,
                                isEnable = false,
                                placeholder = "",
                                modifier = Modifier.weight(1f)
                            )
                        }

                        Spacer(modifier = Modifier.height(Dimens.tendp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.tendp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextViewBlackCard(
                                text = stringResource(Res.string.user_loan).plus(":"),
                                modifier = Modifier.width(120.dp),
                            )
                            Spacer(modifier = Modifier.width(7.dp))
                            FormFieldCompact(
                                value = "Business Expansion",
                                onValueChange = {},
                                isReadable = true,
                                isEnable = false,
                                placeholder = "",
                                modifier = Modifier.weight(1f)
                            )
                        }
                        Spacer(modifier = Modifier.height(Dimens.tendp))

                        Divider(color = LightSkyBlue, thickness = 1.dp)

                        Spacer(modifier = Modifier.height(Dimens.tendp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.tendp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextViewBlackCard(
                                text = stringResource(Res.string.user_existing).plus(":"),
                                modifier = Modifier.width(120.dp),

                                )
                            Spacer(modifier = Modifier.width(7.dp))
                            FormFieldCompact(
                                value = "₹ 45,000",
                                onValueChange = {},
                                isReadable = true,
                                isEnable = false,
                                placeholder = "",
                                modifier = Modifier.weight(1f)
                            )
                        }
                        Spacer(modifier = Modifier.height(Dimens.tendp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.tendp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextViewBlackCard(
                                text = stringResource(Res.string.user_ebill).plus(":"),
                                modifier = Modifier.width(120.dp),

                                )
                            Spacer(modifier = Modifier.width(7.dp))
                            FormFieldCompact(
                                value = "EB12345",
                                onValueChange = {},
                                isReadable = true,
                                isEnable = false,
                                placeholder = "",
                                modifier = Modifier.weight(1f)
                            )
                        }
                        Spacer(modifier = Modifier.height(7.dp))
                        FormFieldCompact(
                            value = viewModel.eBillRemark,
                            onValueChange = { eBillRemark ->
                                viewModel.eBillRemark = eBillRemark
                            },
                            placeholder = stringResource(Res.string.user_remark),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.tendp)
                                .focusRequester(viewModel.focusRequesterEBillRemark)
                                .bringIntoViewRequester(viewModel.bringIntoViewRequesterEBillRemark),
                            maxLength = 30
                        )

                        Spacer(modifier = Modifier.height(Dimens.tendp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.tendp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // LEFT → Text
                            Text(
                                text = stringResource(Res.string.user_electricity).plus(":"), // "Electricity Meter"
                                fontSize = 14.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(Res.font.roboto_medium)),
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.weight(1f) // left side space
                            )

                            // RIGHT → Box + Camera Icon (Column)
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(100.dp)
                                        .background(Color(0xFFE8E8E8))
                                ) {
                                    eMeterImgBitmap?.let { img ->
                                        Image(
                                            bitmap = img,
                                            contentDescription = "Electricity Meter Image",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(Dimens.fivedp))

                                Icon(
                                    painter = painterResource(Res.drawable.camera),
                                    contentDescription = null,
                                    tint = blue,
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clickable { openCameraEMeter = true }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(Dimens.tendp))

                        Divider(color = LightSkyBlue, thickness = 1.dp)

                        Spacer(modifier = Modifier.height(Dimens.tendp))



                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.tendp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // LEFT → Text
                            Text(
                                text = stringResource(Res.string.user_house).plus(":"), // "House Verification"
                                fontSize = 14.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(Res.font.roboto_medium)),
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.weight(1f) // take available space on left
                            )

                            // RIGHT → Box + Camera Icon
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(100.dp)
                                        .background(Color(0xFFE8E8E8))
                                ) {
                                    houseVerificationImgBitmap?.let { img ->
                                        Image(
                                            bitmap = img,
                                            contentDescription = "House Verification Image",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(Dimens.fivedp))

                                Icon(
                                    painter = painterResource(Res.drawable.camera),
                                    contentDescription = null,
                                    tint = blue,
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clickable { openCameraHouseVerification = true }
                                )
                            }
                        }

                        FormFieldCompact(
                            value = viewModel.houseVerificationRemark,
                            onValueChange = { houseVerificationRemark ->
                                viewModel.houseVerificationRemark = houseVerificationRemark
                            },
                            placeholder = stringResource(Res.string.user_remarks),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.tendp)
                                .focusRequester(viewModel.focusRequesterHouseVerificationRemark)
                                .bringIntoViewRequester(viewModel.bringIntoViewRequesterHouseVerificationRemark),
                            maxLength = 30
                        )
                        Spacer(Modifier.height(Dimens.tendp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.tendp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            ReusableTextViewBlackCard(
                                text = stringResource(Res.string.user_loan_any).plus(":"),
                                modifier = Modifier.width(120.dp),

                                )
                            Spacer(modifier = Modifier.width(7.dp))
                            /*ReusableDynamicSpinner(
                                selectedValue = selectedBranch,
                                options = branchList,
                                onValueSelected = { selectedBranch = it },
                                modifier = Modifier.weight(1f)
                            )*/

                            FillDynamicSpinnerespt(
                                label = "",
                                options = loanRecommendationList,
                                selectedOption = viewModel.loanRecommendationID,
                                onOptionSelected = { viewModel.loanRecommendationID = it },
                                focusRequester = viewModel.focusRequesterLoanRecommendationID,
                                bringIntoViewRequester = viewModel.bringIntoViewRequesterLoanRecommendationID,
                                getOptionId = { it.LoanProductID },
                                getOptionLabel = { it.LoanProduct.toString() },
                                modifier = Modifier.weight(1f)
                            )

                        }
                        Spacer(modifier = Modifier.height(Dimens.tendp))
                        FormFieldCompact(
                            value = viewModel.loanRecommendationRemark,
                            onValueChange = { loanRecommendationRemark ->
                                viewModel.loanRecommendationRemark = loanRecommendationRemark
                            },
                            placeholder = stringResource(Res.string.user_remarks),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.tendp)
                                .focusRequester(viewModel.focusRequesterLoanRecommendationRemark)
                                .bringIntoViewRequester(viewModel.bringIntoViewRequesterLoanRecommendationRemark),
                            maxLength = 30
                        )

                        Spacer(modifier = Modifier.height(Dimens.tendp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.tendp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            ReusableTextViews(
                                text = stringResource(Res.string.user_note).plus(":"),
                                fontSize = 15,
                                textColor = Color.Gray,
                                isMandatory = 1
                            )


                            ReusableTextViewBlackCard(
                                text = stringResource(Res.string.user_reduce),
                                fontSize = 13,
                            )
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.sixteendp, vertical = Dimens.fivedp)
                    .align(Alignment.BottomCenter)

            ) {
                CommonSingleButtonsBottomString(
                    onOkClick = { viewModel.saveData() },
                    text = stringResource(Res.string.gtr_save),
                    textSize = 16,
                )
                if (viewModel.showSaveAlert) {
                    CustomAlertDialog(
                        showDialog = viewModel.showSaveAlert,
                        message = viewModel.saveMessage,
                        onConfirm = {
                            if (viewModel.saveFlag == 1) {
                                viewModel.showSaveAlert = false
                                navController.popBackStack()
                            } else {
                                viewModel.requestFocus()
                            }
                        }
                    )
                }
            }
        }

        if (openCameraCustomer) {
            CameraPicker(
                openCamera = openCameraCustomer,
                onImagePicked = { path ->
                    path?.let {
                        customerImgBitmap = loadImageFromPath(it)
                        viewModel.setCustomerImage(it)
                    }
                    openCameraCustomer = false
                }
            )
        }

        if (openCameraGuarantor) {
            CameraPicker(
                openCamera = openCameraGuarantor,
                onImagePicked = { path ->
                    path?.let {
                        guarantorImgBitmap = loadImageFromPath(it)
                        viewModel.setGuarantorImage(it)
                    }
                    openCameraGuarantor = false
                }
            )
        }

        if (openCameraEMeter) {
            CameraPicker(
                openCamera = openCameraEMeter,
                onImagePicked = { path ->
                    path?.let {
                        eMeterImgBitmap = loadImageFromPath(it)
                        viewModel.setEMeterImage(it)
                    }
                    openCameraEMeter = false
                }
            )
        }

        if (openCameraHouseVerification) {
            CameraPicker(
                openCamera = openCameraHouseVerification,
                onImagePicked = { path ->
                    path?.let {
                        houseVerificationImgBitmap = loadImageFromPath(it)
                        viewModel.setHouseVerificationImage(it)
                    }
                    openCameraHouseVerification = false
                }
            )
        }
    }
}