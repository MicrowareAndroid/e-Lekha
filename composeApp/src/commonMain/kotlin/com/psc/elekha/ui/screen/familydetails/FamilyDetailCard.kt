package com.psc.elekha.ui.screen.familydetails

import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.room.util.splitToIntList
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
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
import com.psc.elekha.utils.returnIntegerValue
import com.psc.elekha.utils.returnStringValue
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.delete
import e_lekha.composeapp.generated.resources.edit
import e_lekha.composeapp.generated.resources.education
import e_lekha.composeapp.generated.resources.full_name_of_applicant
import e_lekha.composeapp.generated.resources.income
import e_lekha.composeapp.generated.resources.marital_status
import e_lekha.composeapp.generated.resources.mobile_number
import e_lekha.composeapp.generated.resources.name
import e_lekha.composeapp.generated.resources.occupation
import e_lekha.composeapp.generated.resources.relation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FamilyDetailCard(
    familyDetailModel: CustomerFamilyMemberDetailsEntity,
    onDelete: () -> Unit
) {

    val viewModel = koinViewModel<MSTComboBox_NViewModel>()

    val relationList by viewModel.relationValue.collectAsState()
    val educationList by viewModel.mstQualificationValue.collectAsState()
    val occupationList by viewModel.occupationValue.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadLookUpValues(6)
        viewModel.loadLookUpValues(4)
        viewModel.loadLookUpValues(5)
    }

    val relationName =
        relationList.firstOrNull { it.ID == familyDetailModel.RelationID }?.Value ?: ""

    val educationName =
        educationList.firstOrNull { it.ID == familyDetailModel.EducationID }?.Value ?: ""

    val occupationName =
        occupationList.firstOrNull { it.ID == familyDetailModel.OccupationID }?.Value ?: ""

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp),
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

            // ---------- NAME ----------
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextWithLabel(
                    label = stringResource(Res.string.name),
                    value = returnStringValue(familyDetailModel.MFirstName),
                    modifier = Modifier.weight(1f)
                )

                Icon(
                    painter = painterResource(Res.drawable.delete),
                    contentDescription = "Delete",
                    tint = black,
                    modifier = Modifier
                        .size(18.dp)
                        .clickable { onDelete() }
                )
            }

            // ---------- ROW 2 ----------
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                TextWithLabel(
                    label = stringResource(Res.string.relation),
                    value = relationName,
                    modifier = Modifier.weight(1f)
                )
                TextWithLabel(
                    label = stringResource(Res.string.education),
                    value = educationName,
                    modifier = Modifier.weight(1f)
                )
            }

            // ---------- ROW 3 ----------
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                TextWithLabel(
                    label = stringResource(Res.string.occupation),
                    value = occupationName,
                    modifier = Modifier.weight(1f)
                )
                TextWithLabel(
                    label = stringResource(Res.string.income),
                    value = returnStringValue(familyDetailModel.MonthlyIncome.toString()),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun TextWithLabel(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ReusableTextViewGrayCard(
            text = "$label:",
            fontSize = 12
        )

        Spacer(modifier = Modifier.width(6.dp))

        ReusableTextViewBlackCard(
            text = value,
            fontSize = 12,
            fontWeight = FontWeight.Medium,

        )
    }
}
