package com.psc.elekha.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.psc.elekha.getAppVersion

import com.psc.elekha.ui.theme.*
import com.psc.elekha.utils.PasswordField
import com.psc.elekha.utils.RouteName
import com.psc.elekha.utils.SimpleOtp
import com.psc.elekha.utils.UsernameField
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreenNew(navController: NavController) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    var showOtpField by remember { mutableStateOf(false) }
    val versionName = getAppVersion()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {


        Image(
            painter = painterResource(Res.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent,
            bottomBar = {


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(bottom = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                        Text(
                            text = stringResource(Res.string.registered_office_address),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        )
                        Text(
                            text = stringResource(Res.string.address_two_login),
                            style = MaterialTheme.typography.bodySmall.copy(color = Color.Black)
                        )
                        Text(
                            text = stringResource(Res.string.address_three_login),
                            style = MaterialTheme.typography.bodySmall.copy(color = Color.Black)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Version: $versionName",
                            style = MaterialTheme.typography.bodySmall.copy(color = Color.Black)
                        )
                    }
                }
            }
        ) { innerPadding ->


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp),
            ) {

                Spacer(modifier = Modifier.height(30.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(Res.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(140.dp)
                    )
                }

                Spacer(modifier = Modifier.height(13.dp))


                Text(
                    text = stringResource(Res.string.planned_social_concern),
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = PrimaryDark,
                        fontSize = 36.sp
                    ),
                    modifier = Modifier.padding(start = 4.dp)
                )

                Spacer(modifier = Modifier.height(7.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 30.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(16.dp)
                            .border(
                                width = 2.dp,
                                color = LightBlue,
                                shape = RoundedCornerShape(20.dp)
                            ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = MediumLightBlue)
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = stringResource(Res.string.log_in),
                                style = MaterialTheme.typography.headlineMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            UsernameField(
                                value = username,
                                onValueChange = { username = it }
                            )

                            PasswordField(
                                password = password,
                                onPasswordChange = { password = it }
                            )

                            if (showOtpField) {
                                Spacer(modifier = Modifier.height(12.dp))
                                SimpleOtp(otp = otp, onOtpChange = { otp = it })
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Button(
                                onClick = {
                                    if (!showOtpField) {
                                        showOtpField = true
                                    }else
                                        navController.navigate(RouteName.home)
                                },
                                modifier = Modifier
                                    .width(200.dp)
                                    .height(56.dp)
                                    .background(
                                        brush = Brush.horizontalGradient(
                                            listOf(WhitishYellow, BrightYellow)
                                        ),
                                        shape = RoundedCornerShape(12.dp)
                                    ),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Text(
                                    text = if (showOtpField) stringResource(Res.string.proceed)
                                    else stringResource(Res.string.send_otp),
                                    color = Color.White,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}
