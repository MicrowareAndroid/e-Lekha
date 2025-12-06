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
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.movable_assets)
                        )
                        Spacer(Modifier.height(4.dp))
                        ReusableTextViewBlackCard(economicMovableAssetsModel.type)
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        ReusableTextViewGrayCard(
                            stringResource(Res.string.vehicle_no)
                        )
                        Spacer(Modifier.height(4.dp))
                        ReusableTextViewBlackCard(economicMovableAssetsModel.vehicle_no)
                    }
                }

            }
        }
    }


}