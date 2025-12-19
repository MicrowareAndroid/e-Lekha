package com.psc.elekha.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.psc.elekha.model.DashboardItem
import com.psc.elekha.model.SliderItem
import com.psc.elekha.ui.screen.login.LoginScreenNew
import com.psc.elekha.ui.theme.LightMint
import com.psc.elekha.ui.theme.LightTeal
import com.psc.elekha.ui.theme.LightYellow
import com.psc.elekha.ui.theme.PrimaryDark
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.homeRegistrationColor
import com.psc.elekha.ui.theme.homeViewLineColor
import com.psc.elekha.ui.theme.homedatareportsColor
import com.psc.elekha.ui.theme.homegtrColor
import com.psc.elekha.ui.theme.homemenuGreyColor
import com.psc.elekha.ui.theme.homerepaymentColor
import com.psc.elekha.ui.theme.lightGrey
import com.psc.elekha.ui.theme.lightgreens
import com.psc.elekha.ui.theme.loginBg
import com.psc.elekha.ui.theme.loginbgGradientBottom
import com.psc.elekha.ui.theme.loginbgGradientTop
import com.psc.elekha.ui.theme.repaymentColor
import com.psc.elekha.ui.theme.viewmorebgColor
import com.psc.elekha.utils.CommonSingleButtons
import com.psc.elekha.utils.DashboardCardItem
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.RouteName
import com.psc.elekha.utils.TripleIconSlider
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.activecustomer
import e_lekha.composeapp.generated.resources.arrear
import e_lekha.composeapp.generated.resources.case_load
import e_lekha.composeapp.generated.resources.credit_enquiry
import e_lekha.composeapp.generated.resources.data_reports
import e_lekha.composeapp.generated.resources.default
import e_lekha.composeapp.generated.resources.group
import e_lekha.composeapp.generated.resources.gtr
import e_lekha.composeapp.generated.resources.gtr_done
import e_lekha.composeapp.generated.resources.home_active_customer
import e_lekha.composeapp.generated.resources.home_arrear
import e_lekha.composeapp.generated.resources.home_case
import e_lekha.composeapp.generated.resources.home_closed
import e_lekha.composeapp.generated.resources.home_data
import e_lekha.composeapp.generated.resources.home_date
import e_lekha.composeapp.generated.resources.home_default
import e_lekha.composeapp.generated.resources.home_gtr
import e_lekha.composeapp.generated.resources.home_gtr_home
import e_lekha.composeapp.generated.resources.home_registration
import e_lekha.composeapp.generated.resources.home_registration_detail
import e_lekha.composeapp.generated.resources.home_repayment
import e_lekha.composeapp.generated.resources.home_time
import e_lekha.composeapp.generated.resources.home_user
import e_lekha.composeapp.generated.resources.ic_loan
import e_lekha.composeapp.generated.resources.ic_menu
import e_lekha.composeapp.generated.resources.ic_repayment
import e_lekha.composeapp.generated.resources.ic_savings
import e_lekha.composeapp.generated.resources.ic_setting
import e_lekha.composeapp.generated.resources.loan_closed
import e_lekha.composeapp.generated.resources.logo
import e_lekha.composeapp.generated.resources.registration
import e_lekha.composeapp.generated.resources.registration_top
import e_lekha.composeapp.generated.resources.repayment
import e_lekha.composeapp.generated.resources.right_arrow
import e_lekha.composeapp.generated.resources.view_more

import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    navController: NavHostController,
    onMenuClick: () -> Unit
) {
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
        DashboardItem("837", stringResource(Res.string.home_active_customer), painterResource(Res.drawable.activecustomer)),
        DashboardItem("80", stringResource(Res.string.home_default), painterResource(Res.drawable.default)),
        DashboardItem("50", stringResource(Res.string.home_registration), painterResource(Res.drawable.registration_top)),
        DashboardItem("27", stringResource(Res.string.home_active_customer), painterResource(Res.drawable.credit_enquiry
        )),
        DashboardItem("837", stringResource(Res.string.home_arrear), painterResource(Res.drawable.arrear)),
        DashboardItem("80", stringResource(Res.string.home_closed), painterResource(Res.drawable.loan_closed)),
        DashboardItem("50", stringResource(Res.string.home_gtr), painterResource(Res.drawable.gtr_done)),
        DashboardItem("27", stringResource(Res.string.home_case), painterResource(Res.drawable.case_load))
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {


        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent
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
                            ReusableTextView(text = stringResource(Res.string.home_user), textColor = PrimaryDark)
                            Spacer(Modifier.width(6.dp))
                            ReusableTextView(text = "Vikash", textColor = Color.Black)
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            ReusableTextView(text = stringResource(Res.string.home_time), textColor = PrimaryDark)
                            Spacer(Modifier.width(6.dp))
                            ReusableTextView(text = "10:45 AM", textColor = Color.Black)
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            ReusableTextView(text = stringResource(Res.string.home_date), textColor = PrimaryDark)
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
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 14.dp),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Row(
                                modifier = Modifier
                                    .background(
                                        color = viewmorebgColor,
                                        shape = RoundedCornerShape(14.dp)
                                    )
                                    .clickable {
                                    }
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                ReusableTextView(
                                    text = stringResource(Res.string.view_more),
                                    textColor = Color.Black,
                                    fontSize = 8
                                )
                                Spacer(Modifier.width(2.dp))
                                Icon(
                                    painter = painterResource(Res.drawable.right_arrow), // or any arrow
                                    contentDescription = null,
                                    tint = black,
                                    modifier = Modifier.size(10.dp)
                                )
                            }
                        }
                    }



                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 32.dp)
                        ) {
                            LazyVerticalGrid(
                                columns = GridCells.Fixed(2),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(330.dp),
                                horizontalArrangement = Arrangement.spacedBy(20.dp),
                                verticalArrangement = Arrangement.spacedBy(20.dp),
                                userScrollEnabled = false
                            ) {

                                item {
                                    CommonSingleButtons(
                                        onOkClick = { navController.navigate(RouteName.registration_list) },
                                        backgroundColor = homeRegistrationColor,
                                        text = stringResource(Res.string.home_registration_detail),
                                        textColor = black,
                                        bgImage = painterResource(Res.drawable.registration)
                                    )
                                }

                                item {
                                    CommonSingleButtons(
                                        onOkClick = { navController.navigate(RouteName.replayment_list) },
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

