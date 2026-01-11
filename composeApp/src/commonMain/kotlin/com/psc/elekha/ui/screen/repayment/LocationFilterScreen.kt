package com.psc.elekha.ui.screen.repayment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.psc.elekha.apicall.APiState
import com.psc.elekha.database.viewmodel.MSTCenterViewModel
import com.psc.elekha.database.viewmodel.MSTVillageViewModel
import com.psc.elekha.expectfile.AppBackHandler
import com.psc.elekha.ui.theme.*
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.CommonDivider
import com.psc.elekha.utils.CustomAlertDialog
import com.psc.elekha.utils.Dimens
import com.psc.elekha.utils.FillDynamicSpinnerespt
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.ProgressDialog
import com.psc.elekha.utils.ReusableCard
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTopBar
import com.psc.elekha.utils.RouteName
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LocationFilterScreen(
    navController: NavHostController
) {
    AppBackHandler {
        navController.navigate(RouteName.home) {
            popUpTo(RouteName.loan_filter_screen) { inclusive = true }
            launchSingleTop = true
        }
    }

    val viewModel = koinViewModel<RepaymentViewModel>()
    val mstVillageModel = koinViewModel<MSTVillageViewModel>()
    val mstCenterViewModel = koinViewModel<MSTCenterViewModel>()
    val villageList by mstVillageModel.villageList.collectAsState()
    val centreList by mstCenterViewModel.centerList.collectAsState()
    val downloadState = viewModel.downloadState.collectAsState().value
    var showProgress by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    val appPreferences: AppPreferences = koinInject()

    LaunchedEffect(Unit, downloadState) {
        val username = appPreferences.getString(AppSP.username)
        mstVillageModel.loadVillagesByUsername(username ?: "")
        mstCenterViewModel.loadAllCenters()
        when (downloadState) {
            is APiState.loading -> {
                showProgress = true
                dialogMessage = getString(Res.string.select_customer_please)
            }

            is APiState.success -> {
                showProgress = false
                navController.navigate(RouteName.replayment_list) {
                    popUpTo(RouteName.loan_filter_screen) { inclusive = true }
                    launchSingleTop = true
                }
            }

            is APiState.error -> {
                showProgress = false
                showDialog = true
                dialogMessage = downloadState.message
            }

            is APiState.finish -> {
                showProgress = false
            }

            else -> {}
        }
    }

    val filteredCentreList by remember(centreList, viewModel.villageId) {
        derivedStateOf {
            centreList.filter { it.VillageID == viewModel.villageId }
        }
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ReusableTopBar(
                title = stringResource(Res.string.select_customer_filter_details),
                navigationIcon = painterResource(Res.drawable.ic_back),
                onNavigationClick = {
                    navController.navigate(RouteName.home) {
                        popUpTo(RouteName.loan_filter_screen) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        },

        ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

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
                    /*Spacer(modifier = Modifier.height(Dimens.tendp))
                    Button(
                        onClick = {
                            viewModel.getLoanRepayment("PSCMNP5", "test124")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Dimens.sixteendp)
                            .width(200.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(3.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 4.dp,
                            pressedElevation = 6.dp,
                            focusedElevation = 4.dp
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = btnYellow,
                            contentColor = Color.White
                        )
                    ) {
                        ReusableTextView(
                            text = stringResource(Res.string.download_loan),
                            textColor = black,
                            fontSize = 20
                        )
                    }*/
                    Column(modifier = Modifier.padding(Dimens.sixteendp)) {
                        ReusableTextView(
                            text = stringResource(Res.string.select_customer_filter_details).plus(":"),
                            fontSize = 18,
                            fontWeight = FontWeight.SemiBold,
                            textColor = Color.Black,
                            fontFamily = FontFamily(Font(Res.font.roboto_medium)),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        CommonDivider(
                            color = dark_gray,
                            thickness = 1.dp,
                            startPadding = 0.dp,
                            endPadding = 0.dp
                        )
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(Dimens.sixteendp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        FillDynamicSpinnerespt(
                            label = stringResource(Res.string.village),
                            options = villageList,
                            selectedOption = viewModel.villageId,
                            onOptionSelected = { viewModel.villageId = it },
                            focusRequester = viewModel.focusRequesterVlgId,
                            bringIntoViewRequester = viewModel.bringIntoViewRequesterVlgId,
                            getOptionId = { it.VillageID },
                            getOptionLabel = { it.Village.toString() }
                        )
                        Spacer(modifier = Modifier.height(Dimens.tendp))
                        FillDynamicSpinnerespt(
                            label = stringResource(Res.string.select_center),
                            options = filteredCentreList,
                            selectedOption = viewModel.centerId,
                            onOptionSelected = { viewModel.centerId = it },
                            focusRequester = viewModel.focusRequesterCenterId,
                            bringIntoViewRequester = viewModel.bringIntoViewRequesterCenterId,
                            getOptionId = { it.CenterID },
                            getOptionLabel = { it.Center.toString() }
                        )
                        /*Spacer(modifier = Modifier.height(Dimens.tendp))
                        ReusableTextView(
                            text = stringResource(Res.string.select_customer_center_or),
                            fontSize = 16,
                            fontWeight = FontWeight.Bold,
                            textColor = Color.Black,
                            modifier = Modifier.fillMaxWidth(),
                            textAlignment = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        FormFieldCompact(
                            label = stringResource(Res.string.select_customer_id),
                            value = viewModel.customerID,
                            onValueChange = { custID ->
                                viewModel.customerID = custID.uppercase()
                            },
                            inputType = KeyboardType.Text,
                            modifier = Modifier.focusRequester(viewModel.focusRequesterCustID)
                                .bringIntoViewRequester(viewModel.bringIntoViewRequesterCustID),
                        )*/
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(Dimens.sixteendp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(
                            onClick = {
                                navController.navigate(RouteName.home) {
                                    popUpTo(RouteName.loan_filter_screen) { inclusive = true }
                                    launchSingleTop = true
                                }
                            },
                            shape = RoundedCornerShape(0.dp),
                            modifier = Modifier.weight(1f).height(45.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = btn_color,
                                contentColor = Color.Black
                            ),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 4.dp,
                                pressedElevation = 6.dp,
                                focusedElevation = 4.dp
                            )
                        ) { Text(stringResource(Res.string.cancel)) }

                        Button(
                            onClick = {
                                viewModel.filterLoan()
                            },
                            modifier = Modifier.weight(1f).height(45.dp),
                            shape = RoundedCornerShape(0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = btn_color,
                                contentColor = Color.Black
                            ),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 4.dp,
                                pressedElevation = 6.dp,
                                focusedElevation = 4.dp
                            )
                        ) { Text(stringResource(Res.string.select_customer_filter)) }
                        if (viewModel.showSaveAlert) {
                            if (viewModel.saveFlag == 1) {
                                viewModel.showSaveAlert = false
                                appPreferences.putInt(AppSP.filterVlgID, viewModel.villageId)
                                appPreferences.putInt(AppSP.filterCenterID, viewModel.centerId)
                               /* appPreferences.putString(
                                    AppSP.filterCustID,
                                    viewModel.customerID.trim()
                                )*/
                                viewModel.getLoanRepayment("PSCMNP5", "test124")
                               /* navController.navigate(RouteName.replayment_list) {
                                    popUpTo(RouteName.loan_filter_screen) { inclusive = true }
                                    launchSingleTop = true
                                }*/
                            } else {
                                CustomAlertDialog(
                                    showDialog = viewModel.showSaveAlert,
                                    message = viewModel.saveMessage,
                                    onConfirm = {
                                        viewModel.requestFocus()
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
    if (showDialog) {
        CustomAlertDialog(
            showDialog,
            message = dialogMessage,
            onConfirm = { showDialog = false })
    }

    if (showProgress) {
        ProgressDialog(showProgress, dialogMessage)
    }
}

@Preview
@Composable
fun LocationFilterScreenPreview() {
    MaterialTheme {
        LocationFilterScreen(navController = rememberNavController())
    }
}