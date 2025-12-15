package com.psc.elekha.ui.screen.registrationtab
import androidx.compose.foundation.Image
import com.psc.elekha.ui.screen.kycdetails.KycDetailsScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.psc.elekha.ui.screen.bankdetails.BankDetailsScreen
import com.psc.elekha.ui.screen.economicdetails.EconomicDetailsScreen
import com.psc.elekha.ui.screen.familydetails.FamilyDetailListScreen
import com.psc.elekha.ui.screen.personaldetails.PersonalDetailsScreen
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.ReusableTopBar
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.background
import e_lekha.composeapp.generated.resources.bank_details
import e_lekha.composeapp.generated.resources.economic_details
import e_lekha.composeapp.generated.resources.family_details
import e_lekha.composeapp.generated.resources.ic_back
import e_lekha.composeapp.generated.resources.kyc
import e_lekha.composeapp.generated.resources.personal_details
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun RegistartionTabScreen(navController: NavController, pref: AppPreferences) {

    val tabs = listOf(
        stringResource(Res.string.personal_details),
        stringResource(Res.string.kyc),
        stringResource(Res.string.bank_details),
        stringResource(Res.string.family_details),
        stringResource(Res.string.economic_details)
    )


    var selectedTabIndex by remember { mutableStateOf(0) }
    var categoryFlag by remember { mutableStateOf(-1) }
    var showAddRespondent by remember { mutableStateOf(false) }
    var showAddCounselling by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // ✅ BACKGROUND IMAGE (FULL SCREEN)
        Image(
            painter = painterResource(Res.drawable.background),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            containerColor = Color.Transparent,
            topBar = {
                ReusableTopBar(
                    title = tabs[selectedTabIndex],
                    navigationIcon = painterResource(Res.drawable.ic_back),
                    onNavigationClick = {
                        navController.popBackStack()
                    }
                )
            },
        )
        { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    //.background(Color.White)
            ) {

                val underlineWidth = 45.dp
                val underlineHeight = 5.dp
                val underlineShape = RoundedCornerShape(50)


                ScrollableTabRow(
                    selectedTabIndex = selectedTabIndex,
                    edgePadding = 0.dp,
                    containerColor = Color.Transparent,
                    indicator = { tabPositions ->
                        // defensive check: ensure index valid
                        if (tabPositions.size > selectedTabIndex) {
                            val current = tabPositions[selectedTabIndex]

                            // `tabIndicatorOffset(current)` positions at the start (left) of the tab.
                            // Then we offset by half the remaining space to center the underline:
                            Box(
                                modifier = Modifier
                                    .tabIndicatorOffset(current)
                                    .fillMaxWidth() // keep full tab width area so we can offset inside it
                            ) {
                                Box(
                                    modifier = Modifier
                                        .offset(x = (current.width - underlineWidth) / 2) // center underline
                                        .width(underlineWidth)
                                        .height(underlineHeight)
                                        .clip(underlineShape)
                                        .background(toolbar_color) // selected blue
                                )
                            }
                        }
                    },
                    divider = {} // Remove full-width grey line
                )
                {

                    tabs.forEachIndexed { index, title ->

                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            selectedContentColor = Color.Black,
                            unselectedContentColor = Color.Black
                        ) {

                            Column(
                                modifier = Modifier.padding(horizontal = 12.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                // TAB TEXT
                                Text(
                                    text = title,
                                    modifier = Modifier.padding(top = 8.dp, bottom = 6.dp),
                                    fontSize = 14.sp,
                                    fontWeight = if (selectedTabIndex == index)
                                        FontWeight.Bold else FontWeight.Normal
                                )

                                // GREY UNDERLINE for unselected
                                if (selectedTabIndex != index) {
                                    Box(
                                        modifier = Modifier
                                            .height(underlineHeight)
                                            .width(underlineWidth)
                                            .clip(underlineShape)   // Rounded blue underline
                                            .background(Color(0xFFBDBDBD))
                                    )
                                }
                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        //.background(white)
                ) {
                    when (selectedTabIndex) {
                        0 -> PersonalDetailsScreen(
                            onNextTab = { selectedTabIndex++ },
                            onCancelTab = { navController.popBackStack() })


                        1 -> KycDetailsScreen(
                            onNextTab = { selectedTabIndex++ },
                            onCancelTab = { selectedTabIndex-- })

                        2 -> BankDetailsScreen(
                            onNextTab = { selectedTabIndex++ },
                            onCancelTab = { selectedTabIndex-- })

                        3 -> FamilyDetailListScreen(
                            onNextTab = { selectedTabIndex++ },
                            onCancelTab = { selectedTabIndex-- },
                            navController = navController
                        )

                        4 -> EconomicDetailsScreen(
                            onNextTab = { selectedTabIndex++ },
                            onCancelTab = { selectedTabIndex-- }
                        )

                        /*3 -> CustomAlertDialog(
                        true,
                        message = "Hello"
                    )*/

                        /*2 -> CaseCategoryScreen(onNextTab = {
                        categoryFlag = it
                        selectedTabIndex++
                    }, onCancelTab = { selectedTabIndex-- })
                    3 -> CaseSubCategoryScreen(
                        categoryFlag,
                        onNextTab = { selectedTabIndex++ },
                        onCancelTab = { selectedTabIndex-- })
                    4->{
                        CrossCuttingScreen(
                            onNextTab = { selectedTabIndex++ },
                            onCancelTab = { selectedTabIndex-- })
                    }*/

                    }
                }
            }

        }
    }

}