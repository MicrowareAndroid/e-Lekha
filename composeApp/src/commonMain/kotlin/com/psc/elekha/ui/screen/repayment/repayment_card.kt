package com.psc.elekha.ui.screen.repayment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.psc.elekha.database.entity.LoanRepaymentEntity
<<<<<<< Updated upstream
=======
import com.psc.elekha.ui.theme.appleblue
>>>>>>> Stashed changes
import com.psc.elekha.ui.theme.loginBg
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewGrayCard
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.personal_customer
import e_lekha.composeapp.generated.resources.personal_emi
import e_lekha.composeapp.generated.resources.personal_loan
import org.jetbrains.compose.resources.stringResource

@Composable
fun RepaymentItemCard(
    item: LoanRepaymentEntity,
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
            .padding(2.dp)
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
                    ) {
<<<<<<< Updated upstream
                      /*  Image(
                            painter = painterResource(Res.drawable.user_default),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )*/
=======
                        /*  Image(
                              painter = painterResource(Res.drawable.user_default),
                              contentDescription = null,
                              modifier = Modifier.fillMaxSize(),
                              contentScale = ContentScale.Crop
                          )*/
>>>>>>> Stashed changes
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.personal_customer).plus(":"),
                            fontSize = 13,
                            modifier = Modifier.wrapContentWidth(),
                            fontWeight = FontWeight.Bold,
                            textColor = appleblue
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        ReusableTextViewBlackCard(
                            "${item.CustomerID}  ${item.CustomerName}",
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
                            stringResource(Res.string.personal_loan).plus(":"),
                            fontSize = 13,
                            modifier = Modifier.wrapContentWidth(),
                            fontWeight = FontWeight.Bold,
                            textColor = appleblue
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        ReusableTextViewBlackCard(
                            (item.Total?.toInt()?.toString() ?: "0"),
                            fontSize = 13,
                            modifier = Modifier.weight(1f)
                        )
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.personal_emi).plus(":"),
                            fontSize = 13,
                            modifier = Modifier.wrapContentWidth(),
                            fontWeight = FontWeight.Bold, textColor = appleblue
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        ReusableTextViewBlackCard(
                            (item.EMI?.toInt()?.toString() ?: "0"),
                            fontSize = 13,
                            modifier = Modifier.weight(1f)
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
        }
    }
}

