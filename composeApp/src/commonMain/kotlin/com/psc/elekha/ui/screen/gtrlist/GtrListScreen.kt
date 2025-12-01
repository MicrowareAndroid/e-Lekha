package com.psc.elekha.ui.screen.gtrlist

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.psc.elekha.utils.FillDynamicSpinner
import com.psc.elekha.utils.GroupCardUI
import com.psc.elekha.utils.ReusableCard
import com.psc.elekha.utils.ReusableTextView
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.back
import e_lekha.composeapp.generated.resources.gtr_group
import e_lekha.composeapp.generated.resources.home_date
import e_lekha.composeapp.generated.resources.home_time
import e_lekha.composeapp.generated.resources.home_user
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.psc.elekha.ui.theme.LightSkyBlue
import com.psc.elekha.utils.RouteName

@Composable
fun GtrListScreen(
    navController: NavHostController,
) {
    val branchList = listOf(
        "Dudu",
        "Sikar",
        "Jaipur",
        "Ajmer"
    )


    var selectedBranch by remember { mutableStateOf("") }


    val duduCardList = listOf(
        GroupCardData(
            groupName = "D3140",
            customers = 8,
            village = "DUDU",
            officer = "Afshan",
            formation = "",
            disbursement = "DD/MM/YY",
            center = "111(17)",
            meetingDay = "Monday",
            nextMeeting = "DD/MM/YY"
        ),
        GroupCardData(
            groupName = "D3140",
            customers = 8,
            village = "DUDU",
            officer = "Afshan",
            formation = "",
            disbursement = "DD/MM/YY",
            center = "111(17)",
            meetingDay = "Monday",
            nextMeeting = "DD/MM/YY"
        ),
        GroupCardData(
                groupName = "D3140",
        customers = 8,
        village = "DUDU",
        officer = "Afshan",
        formation = "",
        disbursement = "DD/MM/YY",
        center = "111(17)",
        meetingDay = "Monday",
        nextMeeting = "DD/MM/YY"
    )
        ,
        GroupCardData(
            groupName = "D3140",
            customers = 8,
            village = "DUDU",
            officer = "Afshan",
            formation = "",
            disbursement = "DD/MM/YY",
            center = "111(17)",
            meetingDay = "Monday",
            nextMeeting = "DD/MM/YY"
        )

    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    ) {

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
                    Column(
                        horizontalAlignment = Alignment.Start,

                        ) {

                    Icon(
                        painter = painterResource(Res.drawable.back),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier
                            .size(25.dp)
                            .clickable { }
                    )

                    Spacer(Modifier.height(18.dp))

                    ReusableTextView(
                        text = stringResource(Res.string.gtr_group), fontSize = 16)

                }

                    Column(horizontalAlignment = Alignment.Start) {
                        ReusableTextView(text = stringResource(Res.string.home_user))
                        ReusableTextView(text = stringResource(Res.string.home_time))
                        ReusableTextView(text = stringResource(Res.string.home_date))
                    }
                }

                Spacer(Modifier.height(15.dp))

                ReusableCard(
                        modifier = Modifier.padding(vertical = 8.dp), backgroundColor = Color.White
                    )
                {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        ReusableTextView(text = "Select Branch")

                        FillDynamicSpinner(
                            label = "",
                            options = branchList.mapIndexed { index, name ->
                                BranchItem(index + 1, name)
                            },
                            selectedOption = branchList.indexOf(selectedBranch) + 1,
                            onOptionSelected = { id ->
                                selectedBranch = branchList[id - 1]
                            },
                            getOptionId = { it.id },
                            getOptionLabel = { it.name },
                            modifier = Modifier.width(160.dp)
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    Divider(color = LightSkyBlue, thickness = 1.dp)

                    Spacer(Modifier.height(12.dp))

                    if (selectedBranch == "Dudu") {
                        Column(
                            modifier = Modifier.verticalScroll(rememberScrollState())
                        ) {
                            duduCardList.forEach { item ->
                                GroupCardUI(
                                    item = item,
                                    onCardClick = { selectedItem ->
                                        navController.navigate(RouteName.gtr_list_data_screen)
                                    })
                                Spacer(Modifier.height(12.dp))
                            }
                        }
                    }
                }

                    }
                }
            }
        }


