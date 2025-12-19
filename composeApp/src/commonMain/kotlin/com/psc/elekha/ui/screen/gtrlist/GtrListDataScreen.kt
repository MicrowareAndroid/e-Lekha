package com.psc.elekha.ui.screen.gtrlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.psc.elekha.ui.theme.LightSkyBlue
import com.psc.elekha.ui.theme.LightTeal
import com.psc.elekha.ui.theme.PrimaryDark
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.blue
import com.psc.elekha.ui.theme.homedatareportsColor
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.*
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun GtrListDataScreen(
    navController: NavHostController,
) {

    var selectedScreen by remember { mutableStateOf("GTR List Data") }
    val checkedMap = remember { mutableStateMapOf<CustomerData, Boolean>() }
    var imagePath by remember { mutableStateOf<String?>(null) }
    var openCamera by remember { mutableStateOf(false) }
    var capturedImage by remember { mutableStateOf<ImageBitmap?>(null) }

    val customerList = listOf(
        CustomerData(101,"Shanti Devi w/o Manohar Singh", "987654321", "50,000"),
        CustomerData(112,"Rina Kumari w/o Gopal Sharma", "9988776655", "75,000"),
        CustomerData(114,"Kamla Devi w/o Suresh Prasad", "8899776655", "62,000"),
        CustomerData(115,"Ravi w/o Sidhona Singh", "9999554444", "90,000"),
        CustomerData(119,"Soni Kumari w/o Amit Sharma", "9844554455", "45,000"),
        CustomerData(201,"Pritivi Singh w/o Krishna Prasad", "9554334433", "66,000")
    )

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
                    .padding(16.dp)
                    .navigationBarsPadding()
            ) {
                CommonSingleButtonsBottomString(
                    onOkClick = {},
                    text = stringResource(Res.string.gtr_save),
                    textSize = 16,


                )
            }
        }*/
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {



            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp, vertical = 5.dp)
            ) {

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
                                text = stringResource(Res.string.home_user),
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
                                    text = stringResource(Res.string.home_time),
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
                                    text = stringResource(Res.string.home_date),
                                    textColor = toolbar_color
                                )
                                Spacer(Modifier.width(6.dp))
                                ReusableTextView(text = "04/12/2025", textColor = Color.Black)
                            }
                        }

                    }
                }


                Spacer(modifier = Modifier.height(3.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {

                    Column(modifier = Modifier.weight(1f) .padding(start = 5.dp)) {

                        ReusableTextView(
                            text = stringResource(Res.string.gtr_customer),
                            fontSize = 14,
                            textColor = black
                        )
                        Spacer(Modifier.height(6.dp))

                        ReusableTextView(
                            text = stringResource(Res.string.gtr_center),
                            fontSize = 12,
                            textColor = black
                        )
                        Spacer(Modifier.height(6.dp))

                        ReusableTextView(
                            text = stringResource(Res.string.gtr_meeting),
                            fontSize = 12,
                            textColor = black
                        )
                        Spacer(Modifier.height(6.dp))

                        ReusableTextView(
                            text = stringResource(Res.string.gtr_next_meeting),
                            fontSize = 12,
                            textColor = black
                        )
                        Spacer(Modifier.height(6.dp))

                        ReusableTextView(
                            text = stringResource(Res.string.gtr_remaining_days),
                            fontSize = 12,
                            textColor = black
                        )
                    }

                    Spacer(Modifier.width(12.dp))

                    Column(
                        modifier = Modifier.width(120.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .background(Color.LightGray)
                        ) {
                            capturedImage?.let { img ->
                                Image(
                                    bitmap = img,
                                    contentDescription = "Captured Image",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }

                        Spacer(Modifier.height(8.dp))

                        Icon(
                            painter = painterResource(Res.drawable.camera),
                            contentDescription = null,
                            tint = blue,
                            modifier = Modifier
                                .size(35.dp)
                                .clickable { openCamera = true }
                        )
                    }
                }

                Spacer(Modifier.height(10.dp))
                Divider(color = LightSkyBlue, thickness = 1.dp)

                Spacer(Modifier.height(5.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 45.dp)
                ) {
                    customerList.forEach { customer ->
                        val isChecked = checkedMap[customer] ?: false

                        CustomerItemCard(
                            customer = customer,
                            checked = isChecked,
                            onCheckedChange = { checkedMap[customer] = it },
                            onCardClick = {
                                navController.navigate(RouteName.customer_detail_screen)
                            }
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

    if (openCamera) {
        CameraPicker(
            openCamera = openCamera,
            onImagePicked = { path ->
                imagePath = path
                capturedImage = path?.let { loadImageFromPath(it) }
                openCamera = false
            }
        )
    }


}
