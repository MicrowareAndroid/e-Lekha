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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.psc.elekha.apicall.APiState
import com.psc.elekha.database.viewmodel.UsersViewModel
import com.psc.elekha.getAppVersion
import com.psc.elekha.ui.theme.*
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.CustomAlertDialog
import com.psc.elekha.utils.PasswordField
import com.psc.elekha.utils.ProgressDialog
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.RouteName
import com.psc.elekha.utils.SimpleOtp
import com.psc.elekha.utils.UsernameField
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun LoginScreenNew(navController: NavController) {
    val viewModel = koinViewModel<LoginViewModel>()
    val userViewModel = koinViewModel<UsersViewModel>()
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    var showOtpField by remember { mutableStateOf(false) }
    val versionName = getAppVersion()
    var showProgress by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    val loginState = viewModel.loginState.collectAsState().value
    val verifyState = viewModel.verifyState.collectAsState().value
    var showDialog by remember { mutableStateOf(false) }
    val appPreferences: AppPreferences = koinInject()

    LaunchedEffect(loginState) {
        when (loginState) {
            is APiState.loading -> {
                showProgress = true
                dialogMessage = "Please wait..."
            }

            is APiState.success -> {
                showProgress = false
                showOtpField = true
                userViewModel.getUserContact(appPreferences.getString(AppSP.userId)!!) { contact ->
                    viewModel.getOTP(contact?:"")
                }
            }

            is APiState.error -> {
                showProgress = false
                showDialog = true
                dialogMessage = loginState.message
            }

            else -> {}
        }
    }
    LaunchedEffect(verifyState) {
        when (verifyState) {
            is APiState.loading -> {
                showProgress = true
                dialogMessage = "Validating OTP..."
            }

            is APiState.success -> {
                showProgress = false
                navController.navigate(RouteName.home) {
                    popUpTo(RouteName.login) { inclusive = true }
                    launchSingleTop = true
                }
            }

            is APiState.error -> {
                showProgress = false
                showDialog = true
                dialogMessage = verifyState.message
            }

            else -> {}
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        loginbgGradientTop,
                        loginbgGradientBottom
                    )
                )
            )
    ) {
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
                                color = white
                            )
                        )
                        Text(
                            text = stringResource(Res.string.address_two_login),
                            style = MaterialTheme.typography.bodySmall.copy(color = white)
                        )
                        Text(
                            text = stringResource(Res.string.address_three_login),
                            style = MaterialTheme.typography.bodySmall.copy(color = white)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Version: $versionName",
                            style = MaterialTheme.typography.bodySmall.copy(color = white)
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

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ) {
                    Image(
                        painter = painterResource(Res.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(150.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    ReusableTextView(
                        text = stringResource(Res.string.planned_social_concern),
                        textColor = loginTitle,
                        fontSize = 25,
                        textAlignment = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp)
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 20.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(16.dp)
                            .border(
                                width = 2.dp,
                                color = Color.Transparent,
                                shape = RoundedCornerShape(3.dp)
                            ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        shape = RoundedCornerShape(3.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            loginSmallGradientTop,
                                            loginSmallGradientBottom
                                        )
                                    ),
                                    shape = RoundedCornerShape(3.dp)
                                )
                                .padding(16.dp)
                        ) {


                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                ReusableTextView(
                                    text = stringResource(Res.string.log_in),
                                    textColor = white,
                                    fontSize = 30

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
                                            if (username.isBlank() || password.isBlank()) {
                                                showDialog = true
                                                dialogMessage = "Please Enter Username & Password"
                                            } else {
                                                userViewModel.getUserDetails(username,password){ userList ->
                                                    if (userList.isNotEmpty()) {
                                                        showOtpField = true
                                                        userViewModel.getUserContact(userList.firstOrNull()?.UserId?:"") { contact ->
                                                            appPreferences.putString(AppSP.userId,userList.firstOrNull()?.UserId?:"")
                                                            viewModel.getOTP(contact?:"")
                                                        }
                                                    } else {
                                                        viewModel.getAuthentication(username, password)
                                                    }

                                                }
                                            }
                                        } else {
                                            if (otp.length < 4) {
                                                showDialog = true
                                                dialogMessage = "Please Enter Valid OTP"
                                            } else {
                                                userViewModel.getUserContact(appPreferences.getString(AppSP.userId)!!) { contact ->
                                                    viewModel.verifyOTP(contact?:"", otp)
                                                }
                                            }
                                        }
                                    },
                                    modifier = Modifier
                                        .width(200.dp)
                                        .height(50.dp),
                                    shape = RoundedCornerShape(3.dp),
                                    elevation = ButtonDefaults.buttonElevation(
                                        defaultElevation = 4.dp,
                                        pressedElevation = 6.dp,
                                        focusedElevation = 4.dp
                                    ),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = btnYellow,
                                        contentColor = Color.White
                                    )
                                ) {
                                    ReusableTextView(
                                        text = if (showOtpField) stringResource(Res.string.proceed)
                                        else stringResource(Res.string.send_otp),
                                        textColor = Color.White,
                                        fontSize = 20
                                    )
                                }

                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(60.dp))
            }
        }


        if (showDialog) {
            CustomAlertDialog(
                showDialog,
                message = dialogMessage,
                onConfirm = { showDialog = false })
        }

        if (showProgress) {
            ProgressDialog(showProgress, dialogMessage)
        }
    }
}

@Preview()
@Composable
fun LoginScreenNewPreview() {
    MaterialTheme {
        LoginScreenNew(navController = rememberNavController())
    }
}

