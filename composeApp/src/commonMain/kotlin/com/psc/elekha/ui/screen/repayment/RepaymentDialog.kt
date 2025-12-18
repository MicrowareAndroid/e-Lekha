package com.psc.elekha.ui.screen.repayment



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.psc.elekha.ui.screen.home.HomeScreen
import com.psc.elekha.ui.screen.repayment.model.RepaymentItem
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.blue
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.ui.theme.lightGrey
import com.psc.elekha.ui.theme.loginBg
import com.psc.elekha.ui.theme.repaymentColor
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CommonActionButtons
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.FormFieldCompacts
import com.psc.elekha.utils.ReusableDynamicSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewGrayCard
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.call
import e_lekha.composeapp.generated.resources.camera
import e_lekha.composeapp.generated.resources.front_image
import e_lekha.composeapp.generated.resources.gtr_save
import e_lekha.composeapp.generated.resources.mobile_number
import e_lekha.composeapp.generated.resources.personal_current
import e_lekha.composeapp.generated.resources.personal_current_mobile
import e_lekha.composeapp.generated.resources.personal_current_payment
import e_lekha.composeapp.generated.resources.personal_customer
import e_lekha.composeapp.generated.resources.personal_distribute_date
import e_lekha.composeapp.generated.resources.personal_emi
import e_lekha.composeapp.generated.resources.personal_emi_number
import e_lekha.composeapp.generated.resources.personal_loan
import e_lekha.composeapp.generated.resources.personal_past
import e_lekha.composeapp.generated.resources.personal_payment_detail
import e_lekha.composeapp.generated.resources.personal_payment_image
import e_lekha.composeapp.generated.resources.personal_payment_utr
import e_lekha.composeapp.generated.resources.personal_pre_closure
import e_lekha.composeapp.generated.resources.personal_total_due
import e_lekha.composeapp.generated.resources.personal_weeks_arrear
import e_lekha.composeapp.generated.resources.type_here
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RepaymentDialog(
    item: RepaymentItem,
    isSelected: Boolean,
    onSelected: () -> Unit,
    onCameraClick: () -> Unit = {},
    onBack: () -> Unit
) {
    var selectedPaymentMode by remember { mutableStateOf("Select") }
    val paymentOptions = listOf("Cash", "Online", "UPI")

    var repaymentAmounts by remember { mutableStateOf("") }
    var repaymentAmount by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = white),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

    )
    {
        Box(
            modifier = Modifier
                .widthIn(min = 350.dp, max = 500.dp)
                .background(lightGrey, RoundedCornerShape(16.dp))
                .border(1.dp, lightGrey, RoundedCornerShape(16.dp))
        )
        {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // HEADER
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            toolbar_color,
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        )
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    ReusableTextView(
                        text = stringResource(Res.string.personal_payment_detail),
                        fontSize = 20,
                        fontWeight = FontWeight.Bold,
                        textColor = white,
                        textAlignment = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 550.dp)
                        .verticalScroll(scrollState)
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                ) {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            // CUSTOMER ROW
                            Row(verticalAlignment = Alignment.Top) {
                                ReusableTextViewGrayCard(
                                    stringResource(Res.string.personal_customer),
                                    fontSize = 13
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                ReusableTextViewBlackCard(
                                    "${item.customerId}  ${item.customerName}",
                                    fontSize = 13
                                )
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            // Loan + EMI

                            Column(
                                modifier = Modifier.fillMaxWidth()
                            )
                            {

                                // 🔹 FIRST ROW (upar)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(Res.drawable.call),
                                        tint = blue,
                                        contentDescription = stringResource(Res.string.front_image),
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    ReusableTextViewBlackCard(
                                        item.mobileNumber,
                                        fontSize = 13
                                    )
                                }

                                Spacer(modifier = Modifier.height(6.dp))

                                // 🔹 SECOND ROW (niche)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    ReusableTextViewGrayCard(
                                        stringResource(Res.string.personal_emi),
                                        fontSize = 13
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    ReusableTextViewBlackCard(
                                        item.emiAmount,
                                        fontSize = 13
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(6.dp))

                            Column(
                                modifier = Modifier.fillMaxWidth()
                            )
                            {

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    ReusableTextViewGrayCard(
                                        stringResource(Res.string.personal_total_due),
                                        fontSize = 13
                                    )
                                    Spacer(modifier = Modifier.height(6.dp))
                                    ReusableTextViewBlackCard(
                                        item.totalDue,
                                        fontSize = 13
                                    )
                                }

                                Spacer(modifier = Modifier.height(6.dp))


                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    ReusableTextViewGrayCard(
                                        stringResource(Res.string.personal_weeks_arrear),
                                        fontSize = 13
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    ReusableTextViewBlackCard(
                                        item.weeksInArrear,
                                        fontSize = 13
                                    )
                                }
                            }
                            // Total Due + Weeks


                        }
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    )
                    {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextViewGrayCard(
                                stringResource(Res.string.personal_loan),
                                fontSize = 13
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            ReusableTextViewBlackCard(
                                item.loanAmount,
                                fontSize = 13
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextViewGrayCard(
                                stringResource(Res.string.personal_current),
                                fontSize = 13
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            ReusableTextViewBlackCard(
                                item.currentDue,
                                fontSize = 13
                            )
                        }
                    }




                    Spacer(modifier = Modifier.height(6.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth()
                    )
                    {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextViewGrayCard(
                                stringResource(Res.string.personal_emi_number),
                                fontSize = 13
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            ReusableTextViewBlackCard(
                                item.emiNumber,
                                fontSize = 13
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextViewGrayCard(
                                stringResource(Res.string.personal_distribute_date),
                                fontSize = 13
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            ReusableTextViewBlackCard(
                                item.distributeDate,
                                fontSize = 13
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    )
                    {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextViewGrayCard(
                                stringResource(Res.string.personal_pre_closure),
                                fontSize = 13
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            ReusableTextViewBlackCard(
                                item.preClosureAmount,
                                fontSize = 13
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextViewGrayCard(
                                stringResource(Res.string.personal_past),
                                fontSize = 13
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            ReusableTextViewBlackCard(
                                item.pastDue,
                                fontSize = 13
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        ReusableTextViewGrayCard(
                            "Payment Mode",
                            fontSize = 13
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        //  Spinner
                        ReusableDynamicSpinner(
                            selectedValue = selectedPaymentMode,
                            options = paymentOptions,
                            onValueSelected = { selectedPaymentMode = it },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.personal_payment_utr),
                            fontSize = 13
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        //  Spinner
                        FormFieldCompacts(
                            value = repaymentAmounts,
                            onValueChange = { repaymentAmounts = it },
                            placeholder = stringResource(Res.string.type_here),
                            maxLength = 10,
                            modifier = Modifier.fillMaxWidth()
                        )

                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.personal_current_payment),
                            fontSize = 13
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        //  Spinner
                        FormFieldCompacts(
                            value = repaymentAmount,
                            onValueChange = { repaymentAmount = it },
                            placeholder = stringResource(Res.string.type_here),
                            maxLength = 10,
                            modifier = Modifier.fillMaxWidth()

                        )

                    }

                    Spacer(modifier = Modifier.height(6.dp))
                        // Front Image Box




                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Front Image Box
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        )
                        {
                            Box(
                                modifier = Modifier
                                    .size(55.dp)
                                    .background(Color(0xFFE8E8E8)), // Light Grey Box
                                contentAlignment = Alignment.Center
                            ) {
                                // Preview can go here
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Icon(
                                painter = painterResource(Res.drawable.camera),
                                tint = blue,
                                contentDescription = stringResource(Res.string.front_image),
                                modifier = Modifier.size(28.dp)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            ReusableTextView(text = stringResource(Res.string.personal_payment_image))
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        CommonActionButtons(

                            onSaveClick = {

                            }, onCloseClick = { onBack() })
                    }

                }



                }
            }
        }

    }

@Preview
@Composable
fun RepaymentDialog() {
    MaterialTheme {
        HomeScreen(
            navController = rememberNavController(),
            onMenuClick = {}
        )
    }
}