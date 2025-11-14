package com.psc.elekha.ui.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.psc.elekha.getAppVersion
import com.psc.elekha.ui.PasswordField
import com.psc.elekha.ui.SimpleOtp
import com.psc.elekha.ui.UsernameField
import e_lekha.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    var showOtpField by remember { mutableStateOf(false) }
    var otp by remember { mutableStateOf("") }

    var otpDigits = remember { mutableStateListOf("", "", "", "") }
    val focusRequesters = List(4) { FocusRequester() }
    val versionName = getAppVersion()

    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFFE3F1FA))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.logo_psc),
                contentDescription = "Livelihood illustration",
                modifier = Modifier
                    .size(200.dp)
            )
        }
            Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

                ) {

                Text(
                    text = "Planned Social Concern",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color =  Color(0xFF285684)
                    ),
                    modifier = Modifier.padding(vertical = 16.dp)
                )


                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF55B3CC))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "Log In",
                                style = MaterialTheme.typography.headlineMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                ),
//                            modifier = Modifier.padding(vertical = 16.dp)
                            )
                            Column(
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 0.dp, start = 16.dp, end = 16.dp)
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                UsernameField(
                                    value = username,
                                    onValueChange = { username = it },
                                )

//                            Spacer(modifier = Modifier.height(12.dp))

                                PasswordField(
                                    password = password,
                                    onPasswordChange = { password = it },
                                )

                                if (showOtpField) {
                                    Spacer(modifier = Modifier.height(12.dp))
                                    SimpleOtp(otp = otp, onOtpChange = { otp = it })
                                }


                                /*  Text(
                                text = "Forgot Password?",
                                color = Color.Blue,
                                fontSize = 12.sp,
                                textDecoration = TextDecoration.Underline,
                                modifier = Modifier
                                    .align(Alignment.End)
                                    .padding(bottom = 16.dp)
                                    .clickable {

                                    }
                            )*/

                                Spacer(modifier = Modifier.height(8.dp))

                                Button(
                                    onClick = {
                                        if (!showOtpField) {
                                            // OTP requested
                                            showOtpField = true
                                        } else {
                                            // Proceed logic after OTP entered
                                            // onProceedClick()
                                        }
                                    },
                                    modifier = Modifier
                                        .width(200.dp)
                                        .height(56.dp),
                                    shape = RoundedCornerShape(32.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xfff6ca48)
                                    )
                                ) {
                                    Text(
                                        text = if (showOtpField) "Proceed" else "Send OTP",
                                        color = Color.White,
                                        fontSize = 20.sp
                                    )
                                }
                            }
                        }
                    }
                }

            }

        }
        Column(
            modifier = Modifier
                    .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Registered Office Address:",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold,color = Color.Black)
            )
            Text(
                text = "S15, Krishi Vihar, S Block, Badarwas",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.Black)
            )
            Text(
                text = "Jaipur, Rajasthan 302019",
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
