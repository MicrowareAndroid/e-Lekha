package com.psc.elekha.ui.screen.economicdetails

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
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.psc.elekha.model.EconomicMovableAssetsModel
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.ui.theme.loginBg
import com.psc.elekha.ui.theme.repaymentColor
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewGrayCard
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.delete
import e_lekha.composeapp.generated.resources.movable_assets
import e_lekha.composeapp.generated.resources.vehicle_no
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EconomicMovableAssetsCard(
    economicMovableAssetsModel: EconomicMovableAssetsModel,
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
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            /* -------- Row 1 : Movable Asset + Delete Icon -------- */

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ReusableTextViewGrayCard(
                        stringResource(Res.string.movable_assets).plus(":"),
                        modifier = Modifier.width(120.dp)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    ReusableTextViewBlackCard(
                        economicMovableAssetsModel.type,
                        modifier = Modifier.weight(1f)
                    )
                }

                IconButton(onClick = onDelete) {
                    androidx.compose.material3.Icon(
                        painter = painterResource(Res.drawable.delete),
                        contentDescription = "Delete",
                        modifier = Modifier.size(26.dp).weight(1f),
                        tint = black
                    )
                }
            }

            /* -------- Row 2 : Vehicle No -------- */

            DetailRowOnlyText(
                label = stringResource(Res.string.vehicle_no).plus(":"),
                value = economicMovableAssetsModel.vehicle_no
            )
        }
    }
}

@Composable
private fun DetailRowOnlyText(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        ReusableTextViewGrayCard(
            label,

            modifier = Modifier.width(120.dp)
        )

        Spacer(modifier = Modifier.width(6.dp))

        ReusableTextViewBlackCard(
            value,

            modifier = Modifier.weight(1f)
        )
    }
}


