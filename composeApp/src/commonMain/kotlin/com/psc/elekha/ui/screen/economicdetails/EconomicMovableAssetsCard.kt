package com.psc.elekha.ui.screen.economicdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.psc.elekha.model.EconomicMovableAssetsModel
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.ui.theme.loginBg
import com.psc.elekha.ui.theme.repaymentColor
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewGrayCard
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.movable_assets
import e_lekha.composeapp.generated.resources.vehicle_no
import org.jetbrains.compose.resources.stringResource

@Composable
fun EconomicMovableAssetsCard(
    economicMovableAssetsModel: EconomicMovableAssetsModel
) {

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = loginBg),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            DetailRow(
                label = stringResource(Res.string.movable_assets),
                value = economicMovableAssetsModel.type
            )

            DetailRow(
                label = stringResource(Res.string.vehicle_no),
                value = economicMovableAssetsModel.vehicle_no
            )
        }
    }
}

@Composable
private fun DetailRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ReusableTextViewGrayCard(
            label,
            modifier = Modifier.width(100.dp)
        )
        ReusableTextViewBlackCard(
            value,
            modifier = Modifier.weight(1f)
        )
    }
}
