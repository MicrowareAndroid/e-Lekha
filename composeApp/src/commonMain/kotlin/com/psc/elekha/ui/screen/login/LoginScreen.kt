package com.psc.elekha.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.psc.elekha.database.entity.MSTComboBox_NEntity
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
import com.psc.elekha.ui.theme.accentOrange
import com.psc.elekha.ui.theme.assureOrange
import com.psc.elekha.ui.theme.bgColor
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.darkBluishGrey
import com.psc.elekha.ui.theme.desire_orange
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CustomAlertDialog
import com.psc.elekha.utils.ProgressDialog
import com.psc.elekha.utils.ReusableImageView
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.RouteName
import com.psc.elekha.utils.VersionInfo
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.email
import e_lekha.composeapp.generated.resources.inter_bold
import e_lekha.composeapp.generated.resources.inter_medium
import e_lekha.composeapp.generated.resources.login_bn
import e_lekha.composeapp.generated.resources.login_logo
import e_lekha.composeapp.generated.resources.login_subtitle
import e_lekha.composeapp.generated.resources.login_title
import e_lekha.composeapp.generated.resources.password
import e_lekha.composeapp.generated.resources.roboto_medium
import e_lekha.composeapp.generated.resources.roboto_regular
import e_lekha.composeapp.generated.resources.roboto_semibold
import e_lekha.composeapp.generated.resources.sign_in
import e_lekha.composeapp.generated.resources.splash_subtitle
import e_lekha.composeapp.generated.resources.splash_title
import e_lekha.composeapp.generated.resources.type_here
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(navController: NavController) {
    val version = "Version :"+ VersionInfo.getVersionInfo()
//    val viewModel = koinViewModel<LoginViewModel>()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var showProgress by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
//    val loginState = viewModel.loginState.collectAsState().value
    val robotoMedium = FontFamily(Font(Res.font.roboto_medium))
    val robotoRegular = FontFamily(Font(Res.font.roboto_regular))
    val robotoSemiBold = FontFamily(Font(Res.font.roboto_semibold))
    val mstComboBox_NViewModel = koinViewModel<MSTComboBox_NViewModel>()

    /*LaunchedEffect(loginState) {
        when (loginState) {
            is APiState.loading -> {
                showProgress = true
                dialogMessage = "Please wait..."
            }
            is APiState.success -> {
                viewModel.getMaster(loginState.accessToken)
            }
            is APiState.error -> {
                showProgress = false
                showDialog = true
                dialogMessage = loginState.message
            }
            is APiState.finish -> {
                showProgress = false
                navController.navigate(RouteName.home)
            }
            else -> {}
        }
    }*/



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .statusBarsPadding(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentAlignment = Alignment.Center
            ) {
                ReusableImageView(
                    painter = painterResource(Res.drawable.login_bn),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Spacer(Modifier.height(10.dp))
                Surface(
                    modifier = Modifier
                        .size(120.dp)
                        .offset(y = 80.dp),
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White,
                    tonalElevation = 8.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        ReusableImageView(
                            painter = painterResource(Res.drawable.login_logo),
                            modifier = Modifier.size(180.dp),
                            contentScale = ContentScale.FillBounds
                        )
                    }
                }
            }
            Spacer(Modifier.height(20.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ReusableTextView(
                    text = stringResource(Res.string.splash_title),
                    textColor = accentOrange,
                    fontSize = 20,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(Res.font.inter_bold))
                )
                Spacer(modifier = Modifier.height(8.dp))
                ReusableTextView(
                    text = stringResource(Res.string.splash_subtitle),
                    textAlignment = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    textColor = black,
                    fontFamily = FontFamily(Font(Res.font.inter_medium))
                )
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                ReusableTextView(
                    text = stringResource(Res.string.login_title),
                    fontSize = 20,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = robotoSemiBold,
                    textColor = black
                )
                Spacer(modifier = Modifier.height(2.dp))
                ReusableTextView(
                    text = stringResource(Res.string.login_subtitle),
                    textAlignment = TextAlign.Center,
                    fontSize = 14,
                    fontWeight = FontWeight.Normal,
                    fontFamily = robotoRegular,
                    textColor = black
                )
            }
            ReusableTextView(
                text = stringResource(Res.string.email),
                textColor = desire_orange,
                modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
                fontWeight = FontWeight.SemiBold,
                fontFamily = robotoSemiBold,

            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = robotoMedium
                ),
                placeholder = { Text(stringResource(Res.string.type_here), color = Color.Gray) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Black
                )
            )
            ReusableTextView(
                text = stringResource(Res.string.password),
                textColor = desire_orange,
                modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
                fontWeight = FontWeight.SemiBold,
                fontFamily = robotoSemiBold
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = robotoMedium
                ),
                placeholder = {
                    Text(
                        stringResource(Res.string.type_here),
                        color = Color.Gray
                    )
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image =
                        if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    val values = MSTComboBox_NEntity(1,"Sudeep",1,"1",true)
                    mstComboBox_NViewModel.insertComboBox(values)

                   /* val validationMessage = Validator.checkValidation(email, password)
                    if (validationMessage != null) {
                        showDialog = true
                        dialogMessage = validationMessage
                    } else {
                        viewModel.getToken(email, password)
                    }*/


                    navController.navigate(RouteName.home)
                },
                colors = ButtonDefaults.buttonColors(assureOrange),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    stringResource(Res.string.sign_in),
                    fontSize = 16.sp,
                    color = white,
                    fontFamily = robotoSemiBold,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            ReusableTextView(
                modifier = Modifier.fillMaxWidth(),
                text = version,
                textAlignment = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                fontFamily = robotoRegular,
                textColor = darkBluishGrey
            )
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
