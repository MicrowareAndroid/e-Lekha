package com.psc.elekha.ui.screen.customer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.psc.elekha.ui.screen.gtrlist.BranchItem
import com.psc.elekha.ui.theme.LightSkyBlue
import com.psc.elekha.ui.theme.PrimaryDark
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.FillDynamicSpinner
import com.psc.elekha.utils.FormField
import com.psc.elekha.utils.FormFields
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViews
import com.psc.elekha.utils.ReusableTopBar
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import kotlin.collections.listOf

@Composable
fun CustomerDetailScreen(
    navController: NavHostController,
) {
    var selectedScreen by remember { mutableStateOf("New Customer") }
    val branchList = listOf("3000", "4000", "5000", "6000")
    var selectedBranch by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ReusableTopBar(
                title = selectedScreen,
                navigationIcon = painterResource(Res.drawable.back),
                fontFamily = FontFamily(Font(Res.font.inter_medium)),
                onNavigationClick = { navController.popBackStack() }
            )
        },
                bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(white)
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .navigationBarsPadding()
            ) {
                CommonSingleButtonsBottomString(
                    onOkClick = {

                    },
                    stringResource(Res.string.user_proceed),
                    textSize = 16
                )
            }
        }
    )
    { innerPadding ->

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
            ) {


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


                Spacer(modifier = Modifier.height(20.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    ReusableTextView(
                        text = stringResource(Res.string.customer_name),
                        fontSize = 16,
                        textColor = black
                    )


                    ReusableTextView(
                        text = stringResource(Res.string.user_name_details),
                        fontSize = 16,
                        textColor = black
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(Color.Gray, RoundedCornerShape(6.dp))
                    )
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(Color.Gray, RoundedCornerShape(6.dp))
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))

                Divider(color = LightSkyBlue, thickness = 1.dp)

                Spacer(modifier = Modifier.height(15.dp))
                Column(
                    modifier = Modifier

                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 20.dp)
                )
                {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_last_loan),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        FormFields(
                            value = "",
                            placeholder = stringResource(Res.string.type_here),
                            onValueChange = { "" },
                            maxLength = 20
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_psc),
                        )
                        Spacer(modifier = Modifier.width(30.dp))
                        FormFields(
                            value = "",
                            placeholder = stringResource(Res.string.type_here),
                            onValueChange = { "" },
                            maxLength = 20
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_total),
                        )
                        Spacer(modifier = Modifier.width(30.dp))
                        FormFields(
                            value = "",
                            placeholder = stringResource(Res.string.type_here),
                            onValueChange = { "" },
                            maxLength = 20
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_loan),
                        )
                        Spacer(modifier = Modifier.width(45.dp))
                        FormFields(
                            value = "",
                            placeholder = stringResource(Res.string.type_here),
                            onValueChange = { "" },
                            maxLength = 20
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))

                    Divider(color = LightSkyBlue, thickness = 1.dp)

                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_existing),
                        )
                        Spacer(modifier = Modifier.width(35.dp))
                        FormFields(
                            value = "",
                            placeholder = stringResource(Res.string.type_here),
                            onValueChange = { "" },
                            maxLength = 20
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_ebill),
                        )
                        Spacer(modifier = Modifier.width(93.dp))
                        FormFields(
                            value = "",
                            placeholder = stringResource(Res.string.user_billno),
                            onValueChange = { "" },
                            maxLength = 20
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Box(
                            modifier = Modifier
                                .size(85.dp)
                                .background(Color.Gray, RoundedCornerShape(12.dp)),
                            contentAlignment = Alignment.Center
                        ) {

                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_electricity),
                        )
                        Box(
                            modifier = Modifier
                                .padding(end = 15.dp)
                                .size(40.dp)
                                .background(Color.White, RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.camera),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .clickable { },

                                )
                        }
                    }
                    FormFields(
                        value = "",
                        placeholder = stringResource(Res.string.user_remark),
                        onValueChange = { },
                        maxLength = 40
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Divider(color = LightSkyBlue, thickness = 1.dp)

                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Box(
                            modifier = Modifier
                                .size(85.dp)
                                .background(Color.Gray, RoundedCornerShape(12.dp)),
                            contentAlignment = Alignment.Center
                        ) {

                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_house),
                        )
                        Box(
                            modifier = Modifier
                                .padding(end = 15.dp)
                                .size(40.dp)
                                .background(Color.White, RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.camera),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .clickable { },

                                )
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    FormFields(
                        value = "",
                        placeholder = stringResource(Res.string.user_remarks),
                        onValueChange = { },
                        maxLength = 40
                    )


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {


                        Box(
                            modifier = Modifier
                                .wrapContentWidth().padding(top = 15.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            ReusableTextViewBlackCard(
                                text = stringResource(Res.string.user_loan_any),
                                textColor = Color.Black
                            )
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        FormSpinner(
                            label = "",
                            options = branchList,
                            selectedOption = selectedBranch,
                            onOptionSelected = { selectedBranch = it },

                            )
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    FormFields(
                        value = "",
                        placeholder = stringResource(Res.string.user_remarks_any),
                        onValueChange = { },
                        maxLength = 40
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        ReusableTextViews(
                            text = stringResource(Res.string.user_note),
                            fontSize = 15,
                            textColor = Color.Gray,
                            isMandatory = 1
                        )


                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_reduce),
                            fontSize = 13,
                        )
                    }
                }


            }
        }
    }
}
