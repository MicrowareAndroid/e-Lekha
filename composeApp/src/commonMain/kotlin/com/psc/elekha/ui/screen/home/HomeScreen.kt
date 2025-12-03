package com.psc.elekha.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.psc.elekha.ui.theme.LightMint
import com.psc.elekha.ui.theme.LightTeal
import com.psc.elekha.ui.theme.LightYellow

import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.lightgreens
import com.psc.elekha.ui.theme.repaymentColor
import com.psc.elekha.ui.theme.white
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
        Triple(
            painterResource(Res.drawable.ic_setting),
            painterResource(Res.drawable.ic_setting),
            painterResource(Res.drawable.ic_setting)
        ),
        Triple(
            painterResource(Res.drawable.ic_setting),
            painterResource(Res.drawable.ic_setting),
            painterResource(Res.drawable.ic_setting)
        ),
        Triple(
            painterResource(Res.drawable.ic_setting),
            painterResource(Res.drawable.ic_setting),
            painterResource(Res.drawable.ic_setting)
        )
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

                    Column(horizontalAlignment = Alignment.Start) {
                        ReusableTextView(text = stringResource(Res.string.home_user),textColor = black)
                        ReusableTextView(text = stringResource(Res.string.home_time),textColor = black)
                        ReusableTextView(text = stringResource(Res.string.home_date),textColor = black)
                    }
                }

                Spacer(Modifier.height(15.dp))

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 37.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        DashboardCardItem("837", stringResource(Res.string.home_active_customer), painterResource(Res.drawable.ic_setting), Modifier.weight(1f))
                        DashboardCardItem("80", stringResource(Res.string.home_default), painterResource(Res.drawable.ic_setting), Modifier.weight(1f))
                        DashboardCardItem("50", stringResource(Res.string.home_registration), painterResource(Res.drawable.ic_setting), Modifier.weight(1f))
                        DashboardCardItem("27", stringResource(Res.string.home_active_customer), painterResource(Res.drawable.ic_setting), Modifier.weight(1f))
                    }

                    Spacer(Modifier.height(8.dp))


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 37.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        DashboardCardItem("837", stringResource(Res.string.home_arrear), painterResource(Res.drawable.ic_setting), Modifier.weight(1f))
                        DashboardCardItem("80", stringResource(Res.string.home_closed), painterResource(Res.drawable.ic_setting), Modifier.weight(1f))
                        DashboardCardItem("50", stringResource(Res.string.home_gtr), painterResource(Res.drawable.ic_setting), Modifier.weight(1f))
                        DashboardCardItem("27", stringResource(Res.string.home_case), painterResource(Res.drawable.ic_setting), Modifier.weight(1f))
                    }

                    Spacer(Modifier.height(15.dp))

                    Divider(
                        color = lightgreens,
                        thickness = 1.dp,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    Spacer(Modifier.height(20.dp))


                    CommonSingleButtons(
                        onOkClick = {  navController.navigate(RouteName.gtr_list_screen)},
                        backgroundColor = LightMint,
                        text = stringResource(Res.string.home_registration),
                        textColor = black
                    )

                    Spacer(Modifier.height(15.dp))

                    CommonSingleButtons(
                        onOkClick = { navController.navigate(RouteName.registration_tabs)},
                        backgroundColor = LightTeal,
                        text = stringResource(Res.string.home_gtr_home),
                        textColor = black
                    )

                    Spacer(Modifier.height(15.dp))

                    CommonSingleButtons(
                        onOkClick = {},
                        backgroundColor =LightYellow,
                        text = stringResource(Res.string.home_repayment),
                        textColor = black
                    )

                    Spacer(Modifier.height(15.dp))

                    CommonSingleButtons(
                        onOkClick = {},
                        backgroundColor = repaymentColor,
                        text = stringResource(Res.string.home_data),
                        textColor = black
                    )

                    Spacer(Modifier.height(20.dp))


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
