package com.psc.elekha.ui.screen.gtrlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.psc.elekha.ui.theme.LightYellow
import com.psc.elekha.ui.theme.black
import com.psc.elekha.utils.CommonSingleButtons
import com.psc.elekha.utils.CustomerItemCard
import com.psc.elekha.utils.ReusableCard
import com.psc.elekha.utils.ReusableTextView
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun GtrListDataScreen(
    navController: NavHostController,
) {

    val customerList = listOf(
        CustomerData("Shanti Devi w/o Manohar Singh", "987654321", "50,000"),
        CustomerData("Shanti Devi w/o Manohar Singh", "987654321", "50,000"),
        CustomerData("Shanti Devi w/o Manohar Singh", "987654321", "50,000"),
        CustomerData("Shanti Devi w/o Manohar Singh", "987654321", "50,000"),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFEFEFEF))
    ) {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(15.dp)
            ) {


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {

                    Column {
                        Icon(
                            painter = painterResource(Res.drawable.back),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier
                                .size(25.dp)
                                .clickable { navController.popBackStack() }
                        )
                        Spacer(Modifier.height(18.dp))

                        ReusableTextView(
                            text = stringResource(Res.string.gtr_group),
                            fontSize = 16
                        )
                    }

                    Column(horizontalAlignment = Alignment.Start) {
                        ReusableTextView(text = stringResource(Res.string.home_user))
                        ReusableTextView(text = stringResource(Res.string.home_time))
                        ReusableTextView(text = stringResource(Res.string.home_date))
                    }
                }

                Spacer(Modifier.height(15.dp))


                ReusableCard(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = Color.White
                ) {

                    Column(Modifier.padding(12.dp)) {


                        ReusableTextView(text = "No of Customers : 7")
                        ReusableTextView(text = "Center : 11177")
                        ReusableTextView(text = "Meeting Day : ")
                        ReusableTextView(text = "Next meeting date : ")
                        ReusableTextView(text = "Remaining day(s) for GTR : ")

                        Spacer(Modifier.height(10.dp))


                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                                Box(
                                    modifier = Modifier
                                        .size(120.dp)
                                        .background(Color.LightGray)
                                )

                                Spacer(Modifier.height(8.dp))

                                Icon(
                                    painter = painterResource(Res.drawable.camera),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(35.dp)
                                        .clickable { }
                                )
                            }
                        }

                        Spacer(Modifier.height(15.dp))


                        customerList.forEach { customer ->
                            CustomerItemCard(customer)
                        }

                        Spacer(Modifier.height(20.dp))


                        CommonSingleButtons(
                            onOkClick = {},
                            backgroundColor =LightYellow,
                            text = stringResource(Res.string.gtr_save),
                            textColor = black
                        )




                    }
                }
            }
        }
    }
}




