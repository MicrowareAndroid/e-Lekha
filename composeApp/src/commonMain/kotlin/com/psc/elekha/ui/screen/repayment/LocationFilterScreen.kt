package com.psc.elekha.ui.screen.repayment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.dark_gray
import com.psc.elekha.ui.theme.homedatareportsColor
import com.psc.elekha.ui.theme.light_pink
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.utils.CommonDivider
import com.psc.elekha.utils.Dimens
import com.psc.elekha.utils.FilterFieldCompact
import com.psc.elekha.utils.FilterSpinner
import com.psc.elekha.utils.FormFieldCompacts
import com.psc.elekha.utils.ReusableCard
import com.psc.elekha.utils.ReusableDynamicSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTopBar
import com.psc.elekha.utils.RouteName
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.text.ifEmpty

@Composable
fun LocationFilterScreen(
    navController: NavHostController
) {

    var selectedVillage by remember { mutableStateOf("") }
    var selectedCenter by remember { mutableStateOf("") }
    val villages = listOf("Village 1", "Village 2", "Village 3", "Village 4")
    val centers = listOf("Center A", "Center B", "Center C", "Center D")
    val select = stringResource(Res.string.spinner_select)
    var customerIds by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ReusableTopBar(
                title = stringResource(Res.string.select_customer_filter_details),
                navigationIcon = painterResource(Res.drawable.ic_back),
                onNavigationClick = { navController.popBackStack() }
            )
        },

        ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {


            Box(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    ReusableCard(
                        modifier = Modifier
                            .fillMaxWidth(),
                        backgroundColor = homedatareportsColor,
                        cornerRadius = 0
                    )
                    {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {

                            // LEFT
                            Column(verticalArrangement = Arrangement.Center)
                            {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.select_customer_center).plus(
                                            ":"
                                        ),
                                        textColor = toolbar_color
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "Gurgaon", textColor = Color.Black)
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.select_customer_next).plus(
                                            ":"
                                        ),
                                        textColor = toolbar_color
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "10/4/2025", textColor = Color.Black)
                                }
                            }

                            // RIGHT
                            Column(
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.home_user),
                                        textColor = toolbar_color
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "Vikash", textColor = Color.Black)
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.home_time).plus(":"),
                                        textColor = toolbar_color
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "10:45 AM", textColor = Color.Black)
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.home_date).plus(":"),
                                        textColor = toolbar_color
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "04/12/2025", textColor = Color.Black)
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(Dimens.tendp))
                    Column(modifier = Modifier.padding(Dimens.sixteendp)) {
                        ReusableTextView(
                            text = stringResource(Res.string.select_customer_filter_details).plus(":"),
                            fontSize = 18,
                            fontWeight = FontWeight.SemiBold,
                            textColor = Color.Black,
                            fontFamily = FontFamily(Font(Res.font.roboto_medium)),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        CommonDivider(
                            color = dark_gray,
                            thickness = 1.dp,
                            startPadding = 0.dp,
                            endPadding = 0.dp
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(Dimens.sixteendp),
                        verticalArrangement = Arrangement.spacedBy(Dimens.sixteendp)
                    ) {

                        ReusableDynamicSpinner(
                            selectedValue = selectedVillage,
                            options = villages,
                            onValueSelected = { selectedVillage = it },
                            modifier = Modifier.fillMaxWidth()
                        )
                        CommonDivider(
                            color = light_pink,
                            thickness = 1.dp,
                            topPadding = 5.dp,
                            bottomPadding = 5.dp,
                            startPadding = 0.dp,
                            endPadding = 0.dp
                        )

                        ReusableDynamicSpinner(
                            selectedValue = selectedCenter,
                            options = centers,
                            onValueSelected = { selectedCenter = it },
                            modifier = Modifier.fillMaxWidth()
                        )
                        ReusableTextView(
                            text = stringResource(Res.string.select_customer_center_or),
                            fontSize = 16,
                            fontWeight = FontWeight.Bold,
                            textColor = Color.Black,
                            modifier = Modifier.fillMaxWidth(),
                            textAlignment = androidx.compose.ui.text.style.TextAlign.Center
                        )

                        FormFieldCompacts(
                            value = customerIds,
                            onValueChange = { customerIds = it },
                            placeholder = stringResource(Res.string.type_here),
                            maxLength = 10,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(Modifier.height(8.dp))
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(Dimens.sixteendp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(
                            onClick = {
                                navController.popBackStack()
                            },
                            shape = RoundedCornerShape(0.dp),
                            modifier = Modifier.weight(1f).height(45.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = btn_color,
                                contentColor = Color.Black
                            ),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 4.dp,
                                pressedElevation = 6.dp,
                                focusedElevation = 4.dp
                            )
                        ) { Text(stringResource(Res.string.cancel)) }

                        Button(
                            onClick = {
                                navController.navigate(RouteName.replayment_list)
                            },
                            modifier = Modifier.weight(1f).height(45.dp),
                            shape = RoundedCornerShape(0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = btn_color,
                                contentColor = Color.Black
                            ),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 4.dp,
                                pressedElevation = 6.dp,
                                focusedElevation = 4.dp
                            )
                        ) { Text(stringResource(Res.string.select_customer_filter)) }
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun LocationFilterScreenPreview() {
    MaterialTheme {
        LocationFilterScreen(navController = rememberNavController())
    }
}