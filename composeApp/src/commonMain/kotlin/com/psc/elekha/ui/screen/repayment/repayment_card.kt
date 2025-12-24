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
import com.psc.elekha.ui.theme.blue
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.ui.theme.loginBg
import com.psc.elekha.ui.theme.repaymentColor
import com.psc.elekha.utils.FormFieldCompacts
import com.psc.elekha.utils.ReusableDynamicSpinner
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewGrayCard
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.gtr_save
import e_lekha.composeapp.generated.resources.personal_customer
import e_lekha.composeapp.generated.resources.personal_emi
import e_lekha.composeapp.generated.resources.personal_loan
import e_lekha.composeapp.generated.resources.personal_payment_mode
import e_lekha.composeapp.generated.resources.personal_total_due
import e_lekha.composeapp.generated.resources.personal_weeks_arrear
import e_lekha.composeapp.generated.resources.type_here
import org.jetbrains.compose.resources.stringResource

@Composable
fun RepaymentItemCard(
    item: RepaymentItem,
    isSelected: Boolean,
    onSelected: () -> Unit,
    onClicked: () -> Unit
) {

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = loginBg),
        onClick = { onClicked() },
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
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(60.dp)
                        .fillMaxHeight()

                ) {
                    Box(
                        modifier = Modifier
                            .size(55.dp)
                            .background(Color.LightGray)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(verticalAlignment = Alignment.Top,
                        modifier = Modifier.fillMaxWidth()) {
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.personal_customer).plus(":"),
                            fontSize = 13,
                            modifier = Modifier.wrapContentWidth()
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        ReusableTextViewBlackCard(
                            "${item.customerId}  ${item.customerName}",
                            fontSize = 13,
                            modifier = Modifier.weight(1f)
                        )
                        Checkbox(
                            checked = isSelected,
                            onCheckedChange = { onSelected() },
                            modifier = Modifier.size(22.dp),
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.personal_loan).plus(":"),
                            fontSize = 13,
                            modifier = Modifier.wrapContentWidth()
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        ReusableTextViewBlackCard(
                            item.loanAmount,
                            fontSize = 13,
                            modifier = Modifier.weight(1f)
                        )
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.personal_emi).plus(":"),
                            fontSize = 13,
                            modifier = Modifier.wrapContentWidth()
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        ReusableTextViewBlackCard(
                            item.emiAmount,
                            fontSize = 13,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.personal_total_due).plus(":"),
                            fontSize = 13,
                            modifier = Modifier.wrapContentWidth()
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        ReusableTextViewBlackCard(
                            item.totalDue,
                            fontSize = 13,
                            modifier = Modifier.weight(1f)
                        )
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.personal_payment_mode).plus(":"),
                            fontSize = 13,
                            modifier = Modifier.wrapContentWidth()
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        ReusableTextViewBlackCard(
                            "Cash",
                            fontSize = 13,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}

