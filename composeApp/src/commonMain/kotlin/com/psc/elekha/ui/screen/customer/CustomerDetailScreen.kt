package com.psc.elekha.ui.screen.customer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.psc.elekha.ui.screen.gtrlist.BranchItem
import com.psc.elekha.ui.theme.LightSkyBlue
import com.psc.elekha.ui.theme.LightTeal
import com.psc.elekha.ui.theme.PrimaryDark
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.blue
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.ui.theme.homedatareportsColor
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CameraPicker
import com.psc.elekha.utils.CommonDivider
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.FillDynamicSpinner
import com.psc.elekha.utils.FormField
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.FormFields
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableCard
import com.psc.elekha.utils.ReusableDynamicSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViews
import com.psc.elekha.utils.ReusableTopBar

import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import kotlin.collections.listOf

@Composable
fun CustomerDetailScreen(
    navController: NavHostController,
) {
    var selectedScreen by remember { mutableStateOf("New Customer") }
    var branchList = listOf("3000", "4000", "5000", "6000")
    var selectedBranch by remember { mutableStateOf("") }
    var textfiledLoan by remember { mutableStateOf("") }
    var textfiledPSC by remember { mutableStateOf("") }
    var textfiledMFI by remember { mutableStateOf("") }
    var textfiledLoanPurpose by remember { mutableStateOf("") }
    var textfiledExisting by remember { mutableStateOf("") }
    var textfiledEbill by remember { mutableStateOf("") }
    var textfiledRemark by remember { mutableStateOf("") }
    var textfiledRemarks by remember { mutableStateOf("") }


    var openCamera by remember { mutableStateOf(false) }
    var activeCamera by remember { mutableStateOf("") }
    var customerImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var centerImage by remember { mutableStateOf<ImageBitmap?>(null) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ReusableTopBar(
                title = selectedScreen,
                navigationIcon = painterResource(Res.drawable.back),
                fontFamily = FontFamily(Font(Res.font.inter_medium)),
                onNavigationClick = { navController.popBackStack() }
            )
        },
        /*bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(toolbar_color)
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .navigationBarsPadding()
            ) {
                CommonSingleButtonsBottomString(
                    onOkClick = {

                    },
                    stringResource(Res.string.user_proceed),
                    textSize = 16
                )
            }
        }*/
    )
    { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)


        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp, vertical = 5.dp),


            )
            {


                ReusableCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    backgroundColor = homedatareportsColor,
                    cornerRadius = 12
                )
                {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    ) {

                        // ---------- ROW 1 : USER NAME (LEFT FULL WIDTH) ----------
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            ReusableTextView(
                                text = stringResource(Res.string.home_user).plus(":"),
                                textColor = toolbar_color
                            )
                            Spacer(Modifier.width(6.dp))
                            ReusableTextView(text = "Vikash", textColor = Color.Black)
                        }

                        Spacer(Modifier.height(6.dp))

                        // ---------- ROW 2 : TIME (LEFT) + DATE (RIGHT) ----------
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {

                            // TIME → LEFT
                            Row(
                                modifier = Modifier.weight(1f),   // <-- Left side full space
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                ReusableTextView(
                                    text = stringResource(Res.string.home_time).plus(":"),
                                    textColor = toolbar_color
                                )
                                Spacer(Modifier.width(6.dp))
                                ReusableTextView(text = "10:45 AM", textColor = Color.Black)
                            }

                            // DATE → RIGHT
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                ReusableTextView(
                                    text = stringResource(Res.string.home_date).plus(":"),
                                    textColor = toolbar_color
                                )
                                Spacer(Modifier.width(6.dp))
                                ReusableTextView(text = "04/12/2025", textColor = Color.Black)
                            }
                        }

                    }
                }


                Spacer(modifier = Modifier.height(10.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    ReusableTextView(
                        text = stringResource(Res.string.customer_name),
                        fontSize = 16,
                        textColor = black
                    )


                    ReusableTextView(
                        text = stringResource(Res.string.user_name_details),
                        fontSize = 16,
                        textColor = black
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(Color(0xFFE8E8E8), RoundedCornerShape(6.dp))
                    )
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background((Color(0xFFE8E8E8)), RoundedCornerShape(6.dp))
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))

                Divider(color = LightSkyBlue, thickness = 1.dp)

                Spacer(modifier = Modifier.height(15.dp))
                Column(
                    modifier = Modifier

                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 20.dp)
                )
                {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Fixed width text (avoid Row squeezing)
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_last_loan).plus(":"),
                            modifier = Modifier.width(120.dp) // <--- IMPORTANT
                        )

                        Spacer(modifier = Modifier.width(8.dp))



                        FormFieldCompact(
                            value = textfiledPSC,
                            onValueChange = { textfiledPSC=it },
                            placeholder = stringResource(Res.string.type_here),
                            modifier = Modifier.weight(1f),
                            maxLength = 30
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_psc).plus(":"),
                            modifier = Modifier.width(120.dp),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        FormFieldCompact(
                            value = textfiledLoan,
                            onValueChange = { textfiledLoan=it },
                            placeholder = stringResource(Res.string.type_here),
                            modifier = Modifier.weight(1f),
                            maxLength = 30
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewBlackCard(

                            text = stringResource(Res.string.user_total).plus(":"),
                            modifier = Modifier.width(120.dp),
                        )
                        Spacer(modifier = Modifier.width(7.dp))
                        FormFieldCompact(
                            value = textfiledMFI,
                            onValueChange = { textfiledMFI=it },
                            placeholder = stringResource(Res.string.type_here),
                            modifier = Modifier.weight(1f),
                            maxLength = 30
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_loan).plus(":"),
                            modifier = Modifier.width(120.dp),
                        )
                        Spacer(modifier = Modifier.width(7.dp))
                        FormFieldCompact(
                            value = textfiledLoanPurpose,
                            onValueChange = { textfiledLoanPurpose=it },
                            placeholder = stringResource(Res.string.type_here),
                            modifier = Modifier.weight(1f),
                            maxLength = 30
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))

                    Divider(color = LightSkyBlue, thickness = 1.dp)

                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_existing).plus(":"),
                            modifier = Modifier.width(120.dp),

                            )
                        Spacer(modifier = Modifier.width(7.dp))
                        FormFieldCompact(
                            value = textfiledExisting,
                            onValueChange = { textfiledExisting=it },
                            placeholder = stringResource(Res.string.type_here),
                            modifier = Modifier.weight(1f),
                            maxLength = 30
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_ebill).plus(":"),
                            modifier = Modifier.width(120.dp),

                            )
                        Spacer(modifier = Modifier.width(7.dp))
                        FormFieldCompact(
                            value = textfiledEbill,
                            onValueChange = { textfiledEbill=it },
                            placeholder = stringResource(Res.string.user_billno),
                            modifier = Modifier.weight(1f),
                            maxLength = 30
                        )
                    }
                    Spacer(modifier = Modifier.height(7.dp))
                    FormFieldCompact(
                        value = textfiledRemark,
                        onValueChange = { textfiledRemark=it },
                        placeholder = stringResource(Res.string.user_remark),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        maxLength = 30
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    )
                    {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                            horizontalAlignment = Alignment.End
                        )
                        {
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .background((Color(0xFFE8E8E8)))
                            ) {
                                customerImage?.let { img ->
                                    Image(
                                        bitmap = img,
                                        contentDescription = "Customer Image",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }

                            Spacer(Modifier.height(8.dp))


                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                Text(
                                    text = stringResource(Res.string.user_electricity).plus(":"), // left side text
                                    fontSize = 14.sp,
                                    color = Color.Black,
                                    fontFamily = FontFamily(Font(Res.font.roboto_medium)),
                                    fontWeight = FontWeight.SemiBold
                                )

                                Icon(
                                    painter = painterResource(Res.drawable.camera),
                                    contentDescription = null,
                                    tint = blue,
                                    modifier = Modifier
                                        .size(45.dp).padding(end = 15.dp)
                                        .clickable { openCamera = true }
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Divider(color = LightSkyBlue, thickness = 1.dp)

                    Spacer(modifier = Modifier.height(10.dp))



                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    )
                    {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                            horizontalAlignment = Alignment.End
                        )
                        {
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .background((Color(0xFFE8E8E8)))
                            ) {
                                customerImage?.let { img ->
                                    Image(
                                        bitmap = img,
                                        contentDescription = "Customer Image",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }

                            Spacer(Modifier.height(8.dp))


                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                Text(
                                    text = stringResource(Res.string.user_house).plus(":"), // left side text
                                    fontSize = 14.sp,
                                    color = Color.Black,
                                    fontFamily = FontFamily(Font(Res.font.roboto_medium)),
                                    fontWeight = FontWeight.SemiBold,

                                )

                                Icon(
                                    painter = painterResource(Res.drawable.camera),
                                    contentDescription = null,
                                    tint = blue,
                                    modifier = Modifier
                                        .size(45.dp).padding(end = 15.dp)
                                        .clickable { openCamera = true }
                                )
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_loan_any).plus(":"),
                            modifier = Modifier.width(120.dp),

                            )
                        Spacer(modifier = Modifier.width(7.dp))
                        ReusableDynamicSpinner(
                            selectedValue = selectedBranch,
                            options = branchList,
                            onValueSelected = { selectedBranch = it },
                            modifier = Modifier.weight(1f)
                        )

                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    FormFieldCompact(
                        value = textfiledRemarks,
                        onValueChange = { textfiledRemarks=it },
                        placeholder = stringResource(Res.string.user_remarks),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        maxLength = 30
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        ReusableTextViews(
                            text = stringResource(Res.string.user_note).plus(":"),
                            fontSize = 15,
                            textColor = Color.Gray,
                            isMandatory = 1
                        )


                        ReusableTextViewBlackCard(
                            text = stringResource(Res.string.user_reduce),
                            fontSize = 13,
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 5.dp)
                    .align(Alignment.BottomCenter)

            ) {
                CommonSingleButtonsBottomString(
                    onOkClick = {},
                    text = stringResource(Res.string.gtr_save),
                    textSize = 16,


                    )
            }

        }
    }
}