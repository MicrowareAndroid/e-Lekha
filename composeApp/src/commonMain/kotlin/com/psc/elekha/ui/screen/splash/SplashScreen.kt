package com.psc.elekha.ui.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.wise.astitva.ui.theme.desire_orange
import com.psc.elekha.utils.ReusableImageView
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.RouteName
import com.psc.elekha.utils.VersionInfo
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.app_logo_s
import e_lekha.composeapp.generated.resources.inter_bold
import e_lekha.composeapp.generated.resources.inter_medium
import e_lekha.composeapp.generated.resources.roboto_regular
import e_lekha.composeapp.generated.resources.splash_bg_new
import e_lekha.composeapp.generated.resources.splash_subtitle
import e_lekha.composeapp.generated.resources.splash_title
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SplashScreen(navController: NavController) {
//    val viewModel = koinViewModel<LookupViewmodel>()

    LaunchedEffect(Unit) {
        navController.navigate(RouteName.login) {
            popUpTo(RouteName.splash) { inclusive = true }
        }

        /*val count = viewModel.getLookupCount()
        delay(5000)
        if (count > 0){
            navController.navigate(RouteName.home) {
                popUpTo(RouteName.splash) { inclusive = true }
            }
        }else{
            navController.navigate(RouteName.login) {
                popUpTo(RouteName.splash) { inclusive = true }
            }
        }*/
    }
    val version = "Version :"+ VersionInfo.getVersionInfo()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ReusableImageView(
            painter = painterResource(Res.drawable.splash_bg_new),
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            flag = 0
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ReusableImageView(
                painter = painterResource(Res.drawable.app_logo_s),
                modifier = Modifier
                    .size(200.dp)
                    .padding(16.dp)
                    .background(
                        Color.White, shape = RoundedCornerShape(32.dp)
                    ),
                flag = 1
            )

            Spacer(modifier = Modifier.height(24.dp))

            ReusableTextView(
                text = stringResource(Res.string.splash_title),
                textColor = desire_orange,
                fontSize = 20,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily(Font(Res.font.inter_bold))
            )

            Spacer(modifier = Modifier.height(10.dp))

            ReusableTextView(
                text = stringResource(Res.string.splash_subtitle),
                textAlignment = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(Font(Res.font.inter_medium))
            )
        }

        ReusableTextView(
            text = version,
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 50.dp),
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily(Font(Res.font.roboto_regular))
        )
    }

}

