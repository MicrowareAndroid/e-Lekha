package com.psc.elekha.ui.screen.gtrlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.psc.elekha.ui.theme.LightSkyBlue
import com.psc.elekha.ui.theme.PrimaryDark
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.*
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.back
import e_lekha.composeapp.generated.resources.background
import e_lekha.composeapp.generated.resources.gtr_select
import e_lekha.composeapp.generated.resources.home_date
import e_lekha.composeapp.generated.resources.home_time
import e_lekha.composeapp.generated.resources.home_user
import e_lekha.composeapp.generated.resources.inter_medium
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun GtrListScreen(
    navController: NavHostController,
) {

    val branchList = listOf("All", "Center", "Village")
    var selectedBranch by remember { mutableStateOf("") }
    var selectedScreen by remember { mutableStateOf("GTR List") }

    val duduCardList = listOf(
        GroupCardData("D3140", 8, "DUDU", "Afshan", "", "DD/MM/YY", "111(17)", "Monday", "DD/MM/YY"),
        GroupCardData("D3140", 8, "DUDU", "Afshan", "", "DD/MM/YY", "111(17)", "Monday", "DD/MM/YY"),
        GroupCardData("D3140", 8, "DUDU", "Afshan", "", "DD/MM/YY", "111(17)", "Monday", "DD/MM/YY"),
        GroupCardData("D3140", 8, "DUDU", "Afshan", "", "DD/MM/YY", "111(17)", "Monday", "DD/MM/YY")
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ReusableTopBar(
                title = selectedScreen,
                navigationIcon = painterResource(Res.drawable.back),
                fontFamily = FontFamily(Font(Res.font.inter_medium)),
                onNavigationClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {


            Image(
                painter = painterResource(Res.drawable.background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp, vertical = 5.dp)
            )
            {

                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                )
                {

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        ReusableTextView(
                            text = stringResource(Res.string.home_user),
                            textColor = PrimaryDark
                        )
                        Spacer(Modifier.width(6.dp))
                        ReusableTextView(text = "Vikash", textColor =Color.Black)
                    }


                    Row(verticalAlignment = Alignment.CenterVertically) {
                        ReusableTextView(text = stringResource(Res.string.home_time), textColor = PrimaryDark)
                        Spacer(Modifier.width(6.dp))
                        ReusableTextView(text = "10:45 AM", textColor =Color.Black)
                    }


                    Row(verticalAlignment = Alignment.CenterVertically) {
                        ReusableTextView(text =  stringResource(Res.string.home_date), textColor =PrimaryDark )
                        Spacer(Modifier.width(6.dp))
                        ReusableTextView(text = "04/12/2025", textColor =Color.Black)
                    }
                }
                Spacer(Modifier.height(12.dp))


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 10.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        ReusableTextView(
                            text = stringResource(Res.string.gtr_select),
                            textColor = Color.Black
                        )

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
                }

                Spacer(Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                        .padding(top = 10.dp, bottom = 24.dp)
                ){

                if (selectedBranch == "All") {
                    duduCardList.forEach { item ->
                        GroupCardUI(
                            item = item,
                            onCardClick = {
                                navController.navigate(RouteName.gtr_list_data_screen)
                            }
                        )
                    }
                        Spacer(Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}
