package com.psc.elekha.ui.screen.repayment


import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.psc.elekha.database.viewmodel.LoanRepaymentViewModel
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
import com.psc.elekha.expectfile.AppBackHandler
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.blue
import com.psc.elekha.ui.theme.lightGrey
import com.psc.elekha.ui.theme.loginBg
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.CameraPicker
import com.psc.elekha.utils.CommonActionButtons
import com.psc.elekha.utils.CustomAlertDialog
import com.psc.elekha.utils.Dimens
import com.psc.elekha.utils.FillDynamicSpinnerespt
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewes
import com.psc.elekha.utils.ReusableTopBar
import com.psc.elekha.utils.RouteName
import com.psc.elekha.utils.loadImageFromPath
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RepaymentDialog(
    navController: NavHostController
) {
    AppBackHandler {
        navController.navigate(RouteName.replayment_list) {
            popUpTo(RouteName.replayment_detail_list) { inclusive = true }
            launchSingleTop = true
        }
    }
    var openCamera by remember { mutableStateOf(false) }
    var paymentImgBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    val viewModel = koinViewModel<RepaymentViewModel>()
    val loanViewModel = koinViewModel<LoanRepaymentViewModel>()
    val mstComboViewModel = koinViewModel<MSTComboBox_NViewModel>()
    val modeList by mstComboViewModel.cashStatusValue.collectAsState()
    val repaymentData by viewModel.loanRepayment.collectAsState()
    val appPreferences: AppPreferences = koinInject()

    LaunchedEffect(Unit) {
        mstComboViewModel.loadLookUpValues(lookupTypeFk = 20)
        viewModel.getLoanRepaymentByGUID()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        topBar = {
            ReusableTopBar(
                title = stringResource(Res.string.personal_payment_detail),
                navigationIcon = painterResource(Res.drawable.ic_back),
                onNavigationClick = {
                    navController.navigate(RouteName.replayment_list) {
                        popUpTo(RouteName.replayment_detail_list) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        },
    ) { innerPadding ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
            colors = CardDefaults.cardColors(containerColor = white)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(lightGrey)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(6.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Card(
                        shape = RoundedCornerShape(2.dp),
                        colors = CardDefaults.cardColors(containerColor = loginBg),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .padding(Dimens.tendp)
                        ) {
                            ReusableTextViewes(stringResource(Res.string.customer_details))
                            Spacer(modifier = Modifier.height(Dimens.tendp))
                            Row(verticalAlignment = Alignment.Top) {
                                ReusableTextView(
                                    stringResource(Res.string.personal_customer),
                                    fontSize = 14,
                                    modifier = Modifier.wrapContentWidth(),
                                    textColor = black
                                )
                                Spacer(modifier = Modifier.width(Dimens.fivedp))
                                ReusableTextViewBlackCard(
                                    "${repaymentData.CustomerID ?: ""}  ${repaymentData.CustomerName ?: ""}",
                                    fontSize = 13,
                                    modifier = Modifier.wrapContentWidth()
                                )
                            }
                            Spacer(modifier = Modifier.height(Dimens.fivedp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                ReusableTextView(
                                    stringResource(Res.string.mobile_number),
                                    fontSize = 14,
                                    modifier = Modifier.wrapContentWidth()
                                )
                                Spacer(modifier = Modifier.width(Dimens.fivedp))
                                ReusableTextViewBlackCard(
                                    repaymentData.MobileNo ?: "",
                                    fontSize = 13, modifier = Modifier.wrapContentWidth()
                                )
                                Spacer(modifier = Modifier.width(Dimens.fivedp))
                                Icon(
                                    painter = painterResource(Res.drawable.call),
                                    tint = blue,
                                    contentDescription = stringResource(Res.string.front_image),
                                    modifier = Modifier.size(15.dp).clickable {

                                    }
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(Dimens.tendp))
                    Card(
                        shape = RoundedCornerShape(2.dp),
                        colors = CardDefaults.cardColors(containerColor = loginBg),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .padding(Dimens.tendp)
                        ) {
                            ReusableTextViewes(stringResource(Res.string.loan_details))
                            Spacer(modifier = Modifier.height(Dimens.tendp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.weight(0.8f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    ReusableTextView(
                                        stringResource(Res.string.loan),
                                        fontSize = 14,
                                        modifier = Modifier.wrapContentWidth()
                                    )
                                    Spacer(modifier = Modifier.width(Dimens.fivedp))
                                    ReusableTextViewBlackCard(
                                        (repaymentData.Total?.toInt()?.toString() ?: "0"),
                                        fontSize = 13,
                                        modifier = Modifier.wrapContentWidth()
                                    )
                                }
                                Row(
                                    modifier = Modifier.weight(1f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    ReusableTextView(
                                        stringResource(Res.string.personal_emi),
                                        fontSize = 14,
                                        modifier = Modifier.wrapContentWidth()
                                    )
                                    Spacer(modifier = Modifier.width(Dimens.fivedp))
                                    ReusableTextViewBlackCard(
                                        (repaymentData.EMI?.toInt()?.toString() ?: "0"),
                                        fontSize = 13,
                                        modifier = Modifier.wrapContentWidth()
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(Dimens.fivedp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.weight(0.8f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    ReusableTextView(
                                        stringResource(Res.string.emi_no),
                                        fontSize = 14, modifier = Modifier.wrapContentWidth()
                                    )
                                    Spacer(modifier = Modifier.width(Dimens.fivedp))
                                    ReusableTextViewBlackCard(
                                        "",
                                        fontSize = 13, modifier = Modifier.wrapContentWidth()
                                    )
                                }
                                Row(
                                    modifier = Modifier.weight(1f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    ReusableTextView(
                                        stringResource(Res.string.disburse_date),
                                        fontSize = 14,
                                        modifier = Modifier.wrapContentWidth()
                                    )
                                    Spacer(modifier = Modifier.width(Dimens.fivedp))
                                    ReusableTextViewBlackCard(
                                        repaymentData.DisbursementDate ?: "",
                                        fontSize = 13,
                                        modifier = Modifier.wrapContentWidth()
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(Dimens.fivedp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                ReusableTextView(
                                    stringResource(Res.string.pre_closure_amt),
                                    fontSize = 14, modifier = Modifier.wrapContentWidth()
                                )
                                Spacer(modifier = Modifier.width(Dimens.fivedp))
                                ReusableTextViewBlackCard(
                                    "",
                                    fontSize = 13, modifier = Modifier.wrapContentWidth()
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(Dimens.tendp))
                    Card(
                        shape = RoundedCornerShape(2.dp),
                        colors = CardDefaults.cardColors(containerColor = loginBg),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .padding(Dimens.tendp)
                        ) {
                            ReusableTextViewes(stringResource(Res.string.total_due))
                            Spacer(modifier = Modifier.height(Dimens.tendp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.weight(0.8f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    ReusableTextView(
                                        stringResource(Res.string.personal_weeks_arrear),
                                        fontSize = 14, modifier = Modifier.wrapContentWidth()
                                    )
                                    Spacer(modifier = Modifier.width(Dimens.fivedp))
                                    ReusableTextViewBlackCard(
                                        (repaymentData.WeekInArrear?.toInt()?.toString() ?: "0"),
                                        fontSize = 13, modifier = Modifier.wrapContentWidth()
                                    )
                                }
                                Row(
                                    modifier = Modifier.weight(1f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    ReusableTextView(
                                        stringResource(Res.string.personal_past),
                                        fontSize = 14,
                                        modifier = Modifier.wrapContentWidth()
                                    )
                                    Spacer(modifier = Modifier.width(Dimens.fivedp))
                                    ReusableTextViewBlackCard(
                                        (repaymentData.PastDue?.toInt()?.toString() ?: "0"),
                                        fontSize = 13,
                                        modifier = Modifier.wrapContentWidth()
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(Dimens.fivedp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.weight(0.8f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    ReusableTextView(
                                        stringResource(Res.string.personal_current),
                                        fontSize = 14,
                                        modifier = Modifier.wrapContentWidth()
                                    )
                                    Spacer(modifier = Modifier.width(Dimens.fivedp))
                                    ReusableTextViewBlackCard(
                                        (repaymentData.CurrentDue?.toInt()?.toString() ?: "0"),
                                        fontSize = 13,
                                        modifier = Modifier.wrapContentWidth()
                                    )
                                }
                                Row(
                                    modifier = Modifier.weight(1f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    ReusableTextView(
                                        stringResource(Res.string.personal_total_due),
                                        fontSize = 14, modifier = Modifier.wrapContentWidth()
                                    )
                                    Spacer(modifier = Modifier.width(Dimens.fivedp))
                                    ReusableTextViewBlackCard(
                                        (repaymentData.Due?.toInt()?.toString() ?: "0"),
                                        fontSize = 13, modifier = Modifier.wrapContentWidth()
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(Dimens.tendp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal =Dimens.tendp)
                    ) {
                        ReusableTextViewes(stringResource(Res.string.payment_details))
                        Spacer(modifier = Modifier.height(Dimens.tendp))

                        Column(
                            modifier = Modifier.fillMaxWidth()
                        )
                        {
                            FillDynamicSpinnerespt(
                                label = stringResource(Res.string.personal_payment_mode),
                                options = modeList,
                                selectedOption = viewModel.modeID,
                                onOptionSelected = { viewModel.modeID = it },
                                getOptionId = { it.ID },
                                getOptionLabel = { it.Value.toString() }
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth()
                        )
                        {
                            FormFieldCompact(
                                label = stringResource(Res.string.personal_payment_utr),
                                value = viewModel.utrNo,
                                onValueChange = { utrNo ->
                                    viewModel.utrNo = utrNo
                                },
                                inputType = KeyboardType.Number, maxLength = 10
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth()
                        )
                        {
                            FormFieldCompact(
                                label = stringResource(Res.string.total_repayment),
                                value = viewModel.totalAmt.toDoubleOrNull()?.takeIf { it != 0.0 }
                                    ?.toInt()?.toString() ?: "",
                                onValueChange = { totalAmt ->
                                    viewModel.totalAmt = totalAmt
                                },
                                inputType = KeyboardType.Number, maxLength = 10
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .size(55.dp)
                                        .background(Color(0xFFE8E8E8)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    paymentImgBitmap?.let { img ->
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
                                    modifier = Modifier.size(28.dp)
                                        .clickable { openCamera = true }
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                ReusableTextView(text = stringResource(Res.string.personal_payment_image))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
                Box(
                    modifier = Modifier.fillMaxWidth().padding(Dimens.sixteendp)
                ) {
                    CommonActionButtons(
                        onSaveClick = {
                            viewModel.saveData(appPreferences.getString(AppSP.LoanRepaymentGUID)!!)
                        }, onCloseClick = {
                            navController.navigate(RouteName.replayment_list) {
                                popUpTo(RouteName.replayment_detail_list) { inclusive = true }
                                launchSingleTop = true
                            }
                        })
                    if (viewModel.showSaveAlert) {
                        CustomAlertDialog(
                            showDialog = viewModel.showSaveAlert,
                            message = viewModel.saveMessage,
                            onConfirm = {
                                if (viewModel.saveFlag == 1) {
                                    viewModel.showSaveAlert = false
                                    navController.navigate(RouteName.replayment_list) {
                                        popUpTo(RouteName.replayment_detail_list) {
                                            inclusive = true
                                        }
                                        launchSingleTop = true
                                    }
                                } else {
                                    viewModel.requestFocus()
                                }
                            }
                        )
                    }
                }
            }
        }
    }
    if (openCamera) {
        CameraPicker(
            openCamera = openCamera,
            onImagePicked = { path ->
                path?.let {
                    paymentImgBitmap = loadImageFromPath(it)
                    viewModel.setPaymentImage(it)
                }
                openCamera = false
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepaymentDialogPreview() {

    RepaymentDialog(
        navController = rememberNavController()
    )
}