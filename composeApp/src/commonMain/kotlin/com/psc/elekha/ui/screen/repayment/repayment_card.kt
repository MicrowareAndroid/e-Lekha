package com.psc.elekha.ui.screen.repayment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.psc.elekha.ui.screen.repayment.model.RepaymentItem
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.ui.theme.repaymentColor
import com.psc.elekha.utils.FormFieldCompacts
import com.psc.elekha.utils.ReusableDynamicSpinner
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewGrayCard
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.type_here
import org.jetbrains.compose.resources.stringResource

@Composable
fun RepaymentItemCard(
    item: RepaymentItem,
    isSelected: Boolean,
    onSelected: () -> Unit,
    onCameraClick: () -> Unit = {},
) {
    var selectedPaymentMode by remember { mutableStateOf("Select") }
    val paymentOptions = listOf("Cash", "Online", "UPI")

    var repaymentAmounts by remember { mutableStateOf("") }

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = repaymentColor),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .defaultMinSize(minHeight = 80.dp)

    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
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
                        ReusableTextViewGrayCard("Customer", fontSize = 13)
                        Spacer(modifier = Modifier.width(4.dp))
                        ReusableTextViewBlackCard(
                            "${item.customerId}  ${item.customerName}",
                            fontSize = 13
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Loan + EMI
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Loan Amount Label
                        ReusableTextViewGrayCard(
                            "Loan Amount",
                            fontSize = 13,
                            modifier = Modifier.weight(1.5f)
                        )

                        // Loan Amount Value
                        ReusableTextViewBlackCard(
                            item.loanAmount,
                            fontSize = 13,
                            modifier = Modifier.weight(1f)
                        )

                        // EMI Label
                        ReusableTextViewGrayCard(
                            "EMI",
                            fontSize = 13,
                            modifier = Modifier.weight(0.6f)
                        )

                        // EMI Value
                        ReusableTextViewBlackCard(
                            item.emiAmount,
                            fontSize = 13,
                            modifier = Modifier.weight(1f)
                        )
                    }


                    Spacer(modifier = Modifier.height(10.dp))

                    // Total Due + Weeks
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextViewGrayCard("Total Due", fontSize = 13)
                            Spacer(modifier = Modifier.width(6.dp))
                            ReusableTextViewBlackCard(item.totalDue, fontSize = 13)
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableTextViewGrayCard("Weeks in Arrear", fontSize = 13)
                            Spacer(modifier = Modifier.width(6.dp))
                            ReusableTextViewBlackCard(item.weeksInArrear, fontSize = 13)
                        }
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))


                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(60.dp)
                        .padding(top = 10.dp)

                ) {
                    Box(
                        modifier = Modifier
                            .size(43.dp)
                            .background(Color(0xFFE8E8E8))
                    )

                    IconButton(
                        onClick = onCameraClick,
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CameraAlt,
                            contentDescription = "Camera",
                            tint = black,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))
                Checkbox(
                    checked = isSelected,
                    onCheckedChange = { onSelected() },
                    modifier = Modifier.size(22.dp),
                )


            }




            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                ReusableTextViewGrayCard("Payment Mode", fontSize = 13)
                Spacer(modifier = Modifier.width(6.dp))

                ReusableDynamicSpinner(
                    selectedValue = selectedPaymentMode,
                    options = paymentOptions,
                    onValueSelected = { selectedPaymentMode = it },
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(10.dp))

                FormFieldCompacts(
                    value = repaymentAmounts,
                    onValueChange = { repaymentAmounts = it },
                    placeholder = stringResource(Res.string.type_here),
                    maxLength = 10,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
