package com.psc.elekha.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.psc.elekha.model.DashboardItem
import com.psc.elekha.model.SliderItem
import com.psc.elekha.ui.theme.LightMint
import com.psc.elekha.ui.theme.LightTeal
import com.psc.elekha.ui.theme.LightYellow
import com.psc.elekha.ui.theme.PrimaryDark
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.lightgreens
import com.psc.elekha.ui.theme.repaymentColor
import com.psc.elekha.utils.CommonSingleButtons
import com.psc.elekha.utils.DashboardCardItem
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.RouteName
import com.psc.elekha.utils.TripleIconSlider
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

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
        DashboardItem("837", stringResource(Res.string.home_active_customer), painterResource(Res.drawable.ic_setting)),
        DashboardItem("80", stringResource(Res.string.home_default), painterResource(Res.drawable.ic_setting)),
        DashboardItem("50", stringResource(Res.string.home_registration), painterResource(Res.drawable.ic_setting)),
        DashboardItem("27", stringResource(Res.string.home_active_customer), painterResource(Res.drawable.ic_setting)),
        DashboardItem("837", stringResource(Res.string.home_arrear), painterResource(Res.drawable.ic_setting)),
        DashboardItem("80", stringResource(Res.string.home_closed), painterResource(Res.drawable.ic_setting)),
        DashboardItem("50", stringResource(Res.string.home_gtr), painterResource(Res.drawable.ic_setting)),
        DashboardItem("27", stringResource(Res.string.home_case), painterResource(Res.drawable.ic_setting))
    )

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(Res.drawable.group),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 15.dp)
                    .statusBarsPadding()
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
                        tint = lightgreens,
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
                                .height(220.dp),   // ⭐ FIXED HEIGHT PREVENTS CRASH
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
                        Divider(
                            color = lightgreens,
                            thickness = 1.dp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }

                    item {
                        CommonSingleButtons(
                            onOkClick = { navController.navigate(RouteName.registration_list) },
                            backgroundColor = LightMint,
                            text = stringResource(Res.string.home_registration_detail),
                            textColor = black
                        )
                    }

                    item {
                        CommonSingleButtons(
                            onOkClick = { navController.navigate(RouteName.gtr_list_screen) },
                            backgroundColor = LightTeal,
                            text = stringResource(Res.string.home_gtr_home),
                            textColor = black
                        )
                    }

                    item {
                        CommonSingleButtons(
                            onOkClick = { navController.navigate(RouteName.replayment_list) },
                            backgroundColor = LightYellow,
                            text = stringResource(Res.string.home_repayment),
                            textColor = black
                        )
                    }

                    item {
                        CommonSingleButtons(
                            onOkClick = {},
                            backgroundColor = repaymentColor,
                            text = stringResource(Res.string.home_data),
                            textColor = black
                        )
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
