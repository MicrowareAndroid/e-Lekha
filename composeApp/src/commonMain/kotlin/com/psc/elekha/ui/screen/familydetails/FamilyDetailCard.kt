package com.psc.elekha.ui.screen.familydetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.psc.elekha.model.FamilyDetailModel
import com.psc.elekha.model.RegistrationModel
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.ui.theme.loginBg
import com.psc.elekha.ui.theme.repaymentColor
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewGrayCard
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.delete
import e_lekha.composeapp.generated.resources.edit
import e_lekha.composeapp.generated.resources.education
import e_lekha.composeapp.generated.resources.income
import e_lekha.composeapp.generated.resources.marital_status
import e_lekha.composeapp.generated.resources.mobile_number
import e_lekha.composeapp.generated.resources.name
import e_lekha.composeapp.generated.resources.occupation
import e_lekha.composeapp.generated.resources.relation
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun FamilyDetailCard(
    familyDetailModel: FamilyDetailModel,
    onDelete: () -> Unit
) {

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = loginBg),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            /* ---------- ROW 1 : Name + Delete ---------- */

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ReusableTextViewGrayCard(
                        "Name:",
                        fontSize = 12,
                        modifier = Modifier.width(80.dp)
                    )

                    ReusableTextViewBlackCard(
                        familyDetailModel.name,
                        fontSize = 12,

                    )
                }

                IconButton(onClick = onDelete) {
                    Icon(
                        painter = painterResource(Res.drawable.delete),
                        contentDescription = "Delete",
                        tint = black
                    )
                }
            }

            /* ---------- ROW 2 : Relation | Education ---------- */

            Row(modifier = Modifier.fillMaxWidth()) {

                FamilyDetailItem(
                    label = "Relation:",
                    value = familyDetailModel.relation,
                    modifier = Modifier.weight(1f)
                )

                FamilyDetailItem(
                    label = "Education:",
                    value = familyDetailModel.education,
                    modifier = Modifier.weight(1f)
                )
            }

            /* ---------- ROW 3 : Occupation | Income ---------- */

            Row(modifier = Modifier.fillMaxWidth()) {

                FamilyDetailItem(
                    label = "Occupation:",
                    value = familyDetailModel.occupation,
                    modifier = Modifier.weight(1f)
                )

                FamilyDetailItem(
                    label = "Income:",
                    value = familyDetailModel.income,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun FamilyDetailItem(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(end = 6.dp),
        verticalAlignment = Alignment.Top
    ) {

        ReusableTextViewGrayCard(
            label,
            fontSize = 13,
            modifier = Modifier.width(75.dp)   // FIXED WIDTH
        )

        ReusableTextViewBlackCard(
            value,
            fontSize = 13,

        )
    }
}
