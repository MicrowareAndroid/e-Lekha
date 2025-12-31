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
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
import com.psc.elekha.database.viewmodel.MSTVillageViewModel
import com.psc.elekha.ui.screen.repayment.model.RepaymentItem
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.blue
import com.psc.elekha.ui.theme.lightGrey
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CameraPicker
import com.psc.elekha.utils.CommonActionButtons
import com.psc.elekha.utils.CustomAlertDialog
import com.psc.elekha.utils.Dimens
import com.psc.elekha.utils.FillDynamicSpinnerespt
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.FormFieldCompacts
import com.psc.elekha.utils.ReusableDynamicSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewGrayCard
import com.psc.elekha.utils.ReusableTextViewes
import com.psc.elekha.utils.ReusableTopBar
import com.psc.elekha.utils.loadImageFromPath
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.call
import e_lekha.composeapp.generated.resources.camera
import e_lekha.composeapp.generated.resources.customer_details
import e_lekha.composeapp.generated.resources.disburse_date
import e_lekha.composeapp.generated.resources.emi_no
import e_lekha.composeapp.generated.resources.front_image
import e_lekha.composeapp.generated.resources.ic_back
import e_lekha.composeapp.generated.resources.loan
import e_lekha.composeapp.generated.resources.loan_details
import e_lekha.composeapp.generated.resources.mobile_number
import e_lekha.composeapp.generated.resources.payment_details
import e_lekha.composeapp.generated.resources.personal_current
import e_lekha.composeapp.generated.resources.personal_current_payment
import e_lekha.composeapp.generated.resources.personal_customer
import e_lekha.composeapp.generated.resources.personal_emi
import e_lekha.composeapp.generated.resources.personal_past
import e_lekha.composeapp.generated.resources.personal_payment_detail
import e_lekha.composeapp.generated.resources.personal_payment_image
import e_lekha.composeapp.generated.resources.personal_payment_mode
import e_lekha.composeapp.generated.resources.personal_payment_utr
import e_lekha.composeapp.generated.resources.personal_total_due
import e_lekha.composeapp.generated.resources.personal_weeks_arrear
import e_lekha.composeapp.generated.resources.pre_closure_amt
import e_lekha.composeapp.generated.resources.select_customer_id
import e_lekha.composeapp.generated.resources.total_due
import e_lekha.composeapp.generated.resources.type_here
import e_lekha.composeapp.generated.resources.village
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RepaymentDialog(
    navController: NavHostController
) {
    val sampleItem = RepaymentItem(
        "BHK03.123",
        "MEENA W/O Kailash chand",
        "1,00,000",
        "5300",
        "10,600",
        "4",
        true,
        "17",
        "12/05/2020",
        "6500",
        "5500",
        "4700",
        "7834456567"
    )
    var openCamera by remember { mutableStateOf(false) }
    var paymentImgBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    val viewModel = koinViewModel<RepaymentViewModel>()
    val mstComboViewModel = koinViewModel<MSTComboBox_NViewModel>()
    val modeList by mstComboViewModel.cashStatusValue.collectAsState()

    LaunchedEffect(Unit) {
        mstComboViewModel.loadLookUpValues(lookupTypeFk = 20)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        topBar = {
            ReusableTopBar(
                title = stringResource(Res.string.personal_payment_detail),
                navigationIcon = painterResource(Res.drawable.ic_back),
                onNavigationClick = { navController.popBackStack() }
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
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
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
                            "${sampleItem.customerId}  ${sampleItem.customerName}",
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
                            sampleItem.mobileNumber,
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
                    Spacer(modifier = Modifier.height(Dimens.tendp))
                    ReusableTextViewes(stringResource(Res.string.loan_details))
                    Spacer(modifier = Modifier.height(Dimens.tendp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextView(
                                stringResource(Res.string.loan),
                                fontSize = 14,
                                modifier = Modifier.wrapContentWidth()
                            )
                            Spacer(modifier = Modifier.width(Dimens.fivedp))
                            ReusableTextViewBlackCard(
                                sampleItem.loanAmount,
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
                                sampleItem.emiAmount,
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
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextView(
                                stringResource(Res.string.emi_no),
                                fontSize = 14, modifier = Modifier.wrapContentWidth()
                            )
                            Spacer(modifier = Modifier.width(Dimens.fivedp))
                            ReusableTextViewBlackCard(
                                sampleItem.emiNumber,
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
                                sampleItem.distributeDate,
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
                            sampleItem.preClosureAmount,
                            fontSize = 13, modifier = Modifier.wrapContentWidth()
                        )
                    }
                    Spacer(modifier = Modifier.height(Dimens.tendp))
                    ReusableTextViewes(stringResource(Res.string.total_due))
                    Spacer(modifier = Modifier.height(Dimens.tendp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            ReusableTextView(
                                stringResource(Res.string.personal_weeks_arrear),
                                fontSize = 14, modifier = Modifier.wrapContentWidth()
                            )
                            Spacer(modifier = Modifier.width(Dimens.fivedp))
                            ReusableTextViewBlackCard(
                                sampleItem.weeksInArrear,
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
                                sampleItem.pastDue,
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
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextView(
                                stringResource(Res.string.personal_current),
                                fontSize = 14,
                                modifier = Modifier.wrapContentWidth()
                            )
                            Spacer(modifier = Modifier.width(Dimens.fivedp))
                            ReusableTextViewBlackCard(
                                sampleItem.currentDue,
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
                                sampleItem.totalDue,
                                fontSize = 13, modifier = Modifier.wrapContentWidth()
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(Dimens.tendp))
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
                            placeholder = stringResource(Res.string.type_here),
                            onValueChange = { utrNo ->
                                viewModel.utrNo = utrNo
                            },
                            inputType = KeyboardType.Text
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        FormFieldCompact(
                            label = stringResource(Res.string.personal_current_payment),
                            value = viewModel.totalAmt,
                            placeholder = stringResource(Res.string.type_here),
                            onValueChange = { totalAmt ->
                                viewModel.totalAmt = totalAmt
                            },
                            inputType = KeyboardType.Number
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
                    Spacer(modifier = Modifier.height(8.dp))
                }
                Box(
                    modifier = Modifier.fillMaxWidth().padding(Dimens.tendp)
                ) {
                    CommonActionButtons(

                        onSaveClick = {
                            viewModel.saveData()
                        }, onCloseClick = { navController.popBackStack() })
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