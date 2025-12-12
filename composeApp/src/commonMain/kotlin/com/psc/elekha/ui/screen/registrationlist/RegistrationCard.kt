package com.psc.elekha.ui.screen.registrationlist

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
import com.psc.elekha.model.RegistrationModel
import com.psc.elekha.ui.theme.LightMint
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.ui.theme.repaymentColor
import com.psc.elekha.ui.theme.text_fiiled_color
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewGrayCard
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.delete
import e_lekha.composeapp.generated.resources.edit
import e_lekha.composeapp.generated.resources.marital_status
import e_lekha.composeapp.generated.resources.mobile_number
import e_lekha.composeapp.generated.resources.name
import e_lekha.composeapp.generated.resources.relation
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun RegistrationCard(
    registrationModel: RegistrationModel,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = repaymentColor),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            //  NAME ROW
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ReusableTextViewGrayCard(stringResource(Res.string.name))
                Spacer(Modifier.width(5.dp))
                ReusableTextViewBlackCard(registrationModel.name)
            }

            //  MOBILE NUMBER ROW
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ReusableTextViewGrayCard(stringResource(Res.string.mobile_number))
                Spacer(Modifier.width(5.dp))
                ReusableTextViewBlackCard(registrationModel.phone)
            }

            //  MARITAL STATUS ROW
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ReusableTextViewGrayCard(stringResource(Res.string.marital_status))
                Spacer(Modifier.width(5.dp))
                ReusableTextViewBlackCard(registrationModel.details)
            }

        }
    }

}