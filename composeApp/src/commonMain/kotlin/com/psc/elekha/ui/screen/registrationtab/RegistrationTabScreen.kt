package com.psc.elekha.ui.screen.registrationtab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.psc.elekha.ui.screen.personaldetails.PersonalDetailsScreen

import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTopBar
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.bank_details
import e_lekha.composeapp.generated.resources.ic_back
import e_lekha.composeapp.generated.resources.kyc
import e_lekha.composeapp.generated.resources.personal_details
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun RegistartionTabScreen(navController: NavController,pref: AppPreferences) {

    val tabs = listOf(
        stringResource(Res.string.personal_details),
        stringResource(Res.string.kyc),
        stringResource(Res.string.bank_details)
    )


    var selectedTabIndex by remember { mutableStateOf(0) }
    var categoryFlag by remember { mutableStateOf(-1) }
    var showAddRespondent by remember { mutableStateOf(false) }
    var showAddCounselling by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
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
                .background(Color.White)
        ) {

            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                edgePadding = 8.dp,
                containerColor = Color.White,
                indicator = {},
                divider = {}
            ) {
                tabs.forEachIndexed { index, title ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 6.dp, vertical = 6.dp)
                            .height(50.dp)
                            .clip(RoundedCornerShape(50))
                            /*.background(
                                if (selectedTabIndex == index)
                                  light
                                else
                                    lightGrey
                            )*/,
                            //.clickable { selectedTabIndex = index },
                        contentAlignment = Alignment.Center
                    ) {
                        ReusableTextView(
                            text = title.replace(" ", "\n"),
                            textAlignment = TextAlign.Center,
                            fontSize = if (selectedTabIndex == index) 13 else 12,
                            textColor = if (selectedTabIndex == index) Color.Black else Color.Gray,
                            fontWeight = if (selectedTabIndex == index) FontWeight.W500 else FontWeight.Normal
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .background(white)
            ) {
                when (selectedTabIndex) {
                    0 -> PersonalDetailsScreen(
                        onNextTab = { selectedTabIndex++ },
                        onCancelTab = { navController.popBackStack() })
                    /*1 -> {
                        pref.putString(AppSP.profileComplainant,"")
                        ProfileComplainantScreen(
                            onNextTab = { selectedTabIndex++ },
                            onCancelTab = { selectedTabIndex-- })
                    }
                    2 -> CaseCategoryScreen(onNextTab = {
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