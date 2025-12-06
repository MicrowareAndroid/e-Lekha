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
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewGrayCard
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.delete
import e_lekha.composeapp.generated.resources.edit
import e_lekha.composeapp.generated.resources.education
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
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = editext_bg_color),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.Top
        ) {
            // LEFT SIDE CONTENT
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {

                // ---------- FIRST ROW ----------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.name)
                        )
                        Spacer(Modifier.height(4.dp))
                        ReusableTextViewBlackCard(familyDetailModel.name)
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.relation)
                        )
                        Spacer(Modifier.height(4.dp))
                        ReusableTextViewBlackCard(familyDetailModel.relation)
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // ---------- SECOND ROW ----------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.education)
                        )
                        Spacer(Modifier.height(4.dp))
                        ReusableTextViewBlackCard(familyDetailModel.education)
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.occupation)
                        )
                        Spacer(Modifier.height(4.dp))
                        ReusableTextViewBlackCard(familyDetailModel.occupation)
                    }
                }
            }

            // RIGHT SIDE BUTTON COLUMN
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = onEdit) {
                    Icon(
                        painter = painterResource(Res.drawable.edit),
                        contentDescription = "Edit",
                        modifier = Modifier.size(30.dp),
                        tint = black
                    )
                }
                IconButton(onClick = onDelete) {
                    Icon(
                        painter = painterResource(Res.drawable.delete),
                        contentDescription = "Delete",
                        modifier = Modifier.size(30.dp),
                        tint = black
                    )
                }
            }
        }
    }


}