package com.psc.elekha.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.psc.elekha.apicall.APiState
import com.psc.elekha.database.viewmodel.LoanOfficerDashboardViewModel
import com.psc.elekha.database.viewmodel.UsersViewModel
import com.psc.elekha.model.DashboardItem
import com.psc.elekha.model.SliderItem
import com.psc.elekha.ui.theme.PrimaryDark
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.homeRegistrationColor
import com.psc.elekha.ui.theme.homedatareportsColor
import com.psc.elekha.ui.theme.homegtrColor
import com.psc.elekha.ui.theme.homemenuGreyColor
import com.psc.elekha.ui.theme.homerepaymentColor
import com.psc.elekha.ui.theme.loginbgGradientBottom
import com.psc.elekha.ui.theme.loginbgGradientTop
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.CommonSingleButtons
import com.psc.elekha.utils.DashboardCardItem
import com.psc.elekha.utils.ProgressDialog
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.RouteName
import com.psc.elekha.utils.TripleIconSlider
import com.psc.elekha.utils.currentDate
import com.psc.elekha.utils.returnIntToString
import e_lekha.composeapp.generated.resources.*

import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    onMenuClick: () -> Unit
) {
    val viewModel = koinViewModel<HomeScreenViewModel>()
    val userViewModel = koinViewModel<UsersViewModel>()
    val loanOfcviewModel = koinViewModel<LoanOfficerDashboardViewModel>()
    val dataState = viewModel.dataState.collectAsState().value
    val dashboardData = loanOfcviewModel.loDataList.collectAsState().value
    var showProgress by remember { mutableStateOf(false) }
    val appPreferences: AppPreferences = koinInject()

    LaunchedEffect(Unit) {
        if (appPreferences.getString(AppSP.DashboardDownloaddate) == currentDate()) {
            loanOfcviewModel.getAllLoanOfficerData()
        } else {
            viewModel.getDashboardData(appPreferences.getString(AppSP.userId) ?: "")
        }
    }
    LaunchedEffect(dataState) {
        when (dataState) {
            is APiState.loading -> {
                showProgress = true
            }

            is APiState.success -> {
                showProgress = false
                loanOfcviewModel.getAllLoanOfficerData()
            }

            is APiState.error -> {
                showProgress = false
            }

            else -> {
                showProgress = false
            }
        }
    }

    val sliderItems = listOf(
        SliderItem(
            painterResource(Res.drawable.ic_loan),
            painterResource(Res.drawable.ic_repayment),
            painterResource(Res.drawable.ic_savings),
            "Loan Process"
        ),
        SliderItem(
            painterResource(Res.drawable.ic_loan),
            painterResource(Res.drawable.ic_repayment),
            painterResource(Res.drawable.ic_savings),
            "Repayment Info"
        ),
        SliderItem(
            painterResource(Res.drawable.ic_loan),
            painterResource(Res.drawable.ic_repayment),
            painterResource(Res.drawable.ic_savings),
            "Case Alerts"
        )
    )

    val dashboardItems = listOf(
        DashboardItem(
            returnIntToString(dashboardData.firstOrNull()?.ActiveCustomer ?: 0),
            stringResource(Res.string.home_active_customer),
            painterResource(Res.drawable.activecustomer)
        ),
        DashboardItem(
            returnIntToString(dashboardData.firstOrNull()?.Default ?: 0),
            stringResource(Res.string.home_default),
            painterResource(Res.drawable.default)
        ),
        DashboardItem(
            returnIntToString(dashboardData.firstOrNull()?.Registration ?: 0),
            stringResource(Res.string.home_registration),
            painterResource(Res.drawable.registration_top)
        ),
        DashboardItem(
            returnIntToString(dashboardData.firstOrNull()?.CreditEnquiry ?: 0),
            stringResource(Res.string.home_credit),
            painterResource(
                Res.drawable.credit_enquiry
            )
        ),
        DashboardItem(
            returnIntToString(dashboardData.firstOrNull()?.Arrear_PAR ?: 0),
            stringResource(Res.string.home_arrear),
            painterResource(Res.drawable.arrear)
        ),
        DashboardItem(
            returnIntToString(dashboardData.firstOrNull()?.LoanClosed ?: 0),
            stringResource(Res.string.home_closed),
            painterResource(Res.drawable.loan_closed)
        ),
        DashboardItem(
            returnIntToString(dashboardData.firstOrNull()?.GTRDone ?: 0),
            stringResource(Res.string.home_gtr),
            painterResource(Res.drawable.gtr_done)
        ),
        DashboardItem(
            returnIntToString(dashboardData.firstOrNull()?.CaseLoad ?: 0),
            stringResource(Res.string.home_case),
            painterResource(Res.drawable.case_load)
        )
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        /* Image(
             painter = painterResource(Res.drawable.group),
             contentDescription = null,
             contentScale = ContentScale.FillBounds,
             modifier = Modifier.matchParentSize()
         )*/

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
            //containerColor = loginBg
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                loginbgGradientTop,
                                loginbgGradientBottom
                            )
                        )
                    )
                    .statusBarsPadding()
                    .padding(innerPadding)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_menu),
                        contentDescription = null,
                        tint = homemenuGreyColor,

                        modifier = Modifier
                            .size(25.dp)
                            .clickable { onMenuClick() }
                    )

                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            ReusableTextView(
                                text = stringResource(Res.string.home_user),
                                textColor = PrimaryDark
                            )
                            Spacer(Modifier.width(6.dp))
                            ReusableTextView(text = "Vikash", textColor = Color.Black)
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            ReusableTextView(
                                text = stringResource(Res.string.home_time).plus(":"),
                                textColor = PrimaryDark
                            )
                            Spacer(Modifier.width(6.dp))
                            ReusableTextView(text = "10:45 AM", textColor = Color.Black)
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            ReusableTextView(
                                text = stringResource(Res.string.home_date).plus(":"),
                                textColor = PrimaryDark
                            )
                            Spacer(Modifier.width(6.dp))
                            ReusableTextView(text = "04/12/2025", textColor = Color.Black)
                        }
                    }
                }

                Spacer(Modifier.height(15.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    item {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(4),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 25.dp)
                                .height(220.dp),

                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            userScrollEnabled = false
                        ) {
                            items(dashboardItems.size) { index ->
                                val item = dashboardItems[index]
                                DashboardCardItem(item.count, item.title, item.icon, Modifier)
                            }
                        }
                    }

                    item {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .height(330.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            userScrollEnabled = false
                        ) {

                            item {
                                CommonSingleButtons(
                                    onOkClick = { navController.navigate(RouteName.registration_list) },
                                    backgroundColor = homeRegistrationColor,
                                    text = stringResource(Res.string.home_registration).uppercase(),
                                    textColor = black,
                                    bgImage = painterResource(Res.drawable.registration)
                                )
                            }

                            item {
                                CommonSingleButtons(
                                    onOkClick = { navController.navigate(RouteName.loan_filter_screen) },
                                    backgroundColor = homerepaymentColor,
                                    text = stringResource(Res.string.home_repayment),
                                    textColor = black,
                                    bgImage = painterResource(Res.drawable.repayment)
                                )
                            }


                            item {
                                CommonSingleButtons(
                                    onOkClick = { navController.navigate(RouteName.gtr_list_screen) },
                                    backgroundColor = homegtrColor,
                                    text = stringResource(Res.string.home_gtr_home),
                                    textColor = black,
                                    bgImage = painterResource(Res.drawable.gtr)
                                )
                            }


                            item {
                                CommonSingleButtons(
                                    onOkClick = {},
                                    backgroundColor = homedatareportsColor,
                                    text = stringResource(Res.string.home_data),
                                    textColor = black,
                                    bgImage = painterResource(Res.drawable.data_reports)
                                )
                            }
                        }
                    }

                    item {
                        TripleIconSlider(
                            items = sliderItems,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            bgColor = Color(0xFFDDEFFF)
                        )
                    }
                }
            }
        }
        if (showProgress) {
            ProgressDialog(showProgress, "")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            navController = rememberNavController(),
            onMenuClick = {}
        )
    }
}

