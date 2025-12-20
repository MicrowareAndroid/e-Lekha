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
import com.psc.elekha.database.entity.CustomerEntity
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
import com.psc.elekha.model.RegistrationModel
import com.psc.elekha.ui.theme.LightMint
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.ui.theme.homeTopIconsBg
import com.psc.elekha.ui.theme.loginBg
import com.psc.elekha.ui.theme.repaymentColor
import com.psc.elekha.ui.theme.text_fiiled_color
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewGrayCard
import com.psc.elekha.utils.returnIntegerValue
import com.psc.elekha.utils.returnStringValue
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.customer_id
import e_lekha.composeapp.generated.resources.customer_name
import e_lekha.composeapp.generated.resources.delete
import e_lekha.composeapp.generated.resources.edit
import e_lekha.composeapp.generated.resources.marital_status
import e_lekha.composeapp.generated.resources.mobile_number
import e_lekha.composeapp.generated.resources.name
import e_lekha.composeapp.generated.resources.relation
import e_lekha.composeapp.generated.resources.select_customer_id
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RegistrationCard(
    customer: CustomerEntity,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {

    val mstComboViewModel = koinViewModel<MSTComboBox_NViewModel>()
    val maritalStatus by mstComboViewModel.comboValue.collectAsState()


    LaunchedEffect(customer.MaritalStatusID) {
        mstComboViewModel.loadComboBoxValue(
            flag = 1,
            id = customer.MaritalStatusID ?: 0
        )
    }

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = loginBg),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // 🔹 LEFT SIDE : DETAILS
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ReusableTextViewGrayCard(stringResource(Res.string.select_customer_id))
                    ReusableTextViewBlackCard(returnStringValue(customer.CustomerID))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ReusableTextViewGrayCard("${stringResource(Res.string.customer_name)} : ")
                    ReusableTextViewBlackCard(
                        getFullName(
                            customer.FirstName,
                            customer.MiddleName,
                            customer.LastName
                        )
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ReusableTextViewGrayCard("${stringResource(Res.string.mobile_number)} : ")
                    ReusableTextViewBlackCard(returnStringValue(customer.ContactNo))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ReusableTextViewGrayCard("${stringResource(Res.string.marital_status)} : ")
                    ReusableTextViewBlackCard(maritalStatus)
                }
            }

            // 🔹 RIGHT SIDE : EDIT + DELETE (VERTICAL)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(onClick = onEdit) {
                    Icon(
                        painter = painterResource(Res.drawable.edit),
                        contentDescription = "Edit",
                        modifier = Modifier.size(26.dp),
                        tint = black
                    )
                }

                IconButton(onClick = onDelete) {
                    Icon(
                        painter = painterResource(Res.drawable.delete),
                        contentDescription = "Delete",
                        modifier = Modifier.size(26.dp),
                        tint = black
                    )
                }
            }
        }

    }

}

fun getFullName(
    first: String?,
    middle: String?,
    last: String?
): String {
    return listOf(first, middle, last)
        .filter { !it.isNullOrBlank() }
        .joinToString(" ")
}
