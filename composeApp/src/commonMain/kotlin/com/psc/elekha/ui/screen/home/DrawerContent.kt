package com.psc.elekha.ui.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.psc.elekha.database.appdatabase.dbFileName
import com.psc.elekha.expectfile.DatabaseExporter

import com.psc.elekha.expectfile.PermissionManager
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.blue
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.lightgreens
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.FormFieldCompact

import com.psc.elekha.utils.ReusableTextView
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.background
import e_lekha.composeapp.generated.resources.background_drawer
import e_lekha.composeapp.generated.resources.customer_name
import e_lekha.composeapp.generated.resources.home_date
import e_lekha.composeapp.generated.resources.home_drawer_contact
import e_lekha.composeapp.generated.resources.home_drawer_logout
import e_lekha.composeapp.generated.resources.home_drawer_number
import e_lekha.composeapp.generated.resources.home_drawer_or
import e_lekha.composeapp.generated.resources.home_drawer_scan
import e_lekha.composeapp.generated.resources.home_drawer_upi
import e_lekha.composeapp.generated.resources.home_drawer_web
import e_lekha.composeapp.generated.resources.home_time
import e_lekha.composeapp.generated.resources.home_user
import e_lekha.composeapp.generated.resources.ic_logout
import e_lekha.composeapp.generated.resources.ic_menu
import e_lekha.composeapp.generated.resources.ic_setting
import e_lekha.composeapp.generated.resources.krishi_vihar
import e_lekha.composeapp.generated.resources.profile_picture
import e_lekha.composeapp.generated.resources.ro_address
import e_lekha.composeapp.generated.resources.scanner
import e_lekha.composeapp.generated.resources.type_here
import e_lekha.composeapp.generated.resources.upi_idd
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DrawerContent() {

    var username by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    )
    {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 40.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start
        ) {


            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),

                )
            {
                // Profile Picture
                Box(
                    modifier = Modifier
                        .size(35.dp)
                        .background(Color.White, CircleShape)
                        .border(1.dp, lightgreens, CircleShape),

                    ) {
                    Image(
                        painter = painterResource(Res.drawable.profile_picture),
                        contentDescription = "Profile Picture",

                        modifier = Modifier.size(90.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    ReusableTextView(
                        text = "Mr. Xyz Singh",
                        fontWeight = FontWeight.Bold,
                        textColor = black
                    )


                }
            }



            Spacer(Modifier.height(20.dp))


            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {


                Box(
                    modifier = Modifier
                        .size(130.dp)
                        .border(2.dp, lightgreens, RoundedCornerShape(6.dp))
                ) {
                    Image(
                        painter = painterResource(Res.drawable.scanner),
                        contentDescription = null,
                        modifier = Modifier.size(129.dp)
                    )
                }

                Spacer(Modifier.height(5.dp))


                ReusableTextView(
                    text = stringResource(Res.string.home_drawer_scan), textColor = black
                )

                Spacer(Modifier.height(5.dp))


                ReusableTextView(
                    text = stringResource(Res.string.home_drawer_or),
                    fontWeight = FontWeight.Bold,
                    textAlignment = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(0.4f), textColor = black
                )

                Spacer(Modifier.height(5.dp))


                ReusableTextView(
                    text = stringResource(Res.string.home_drawer_upi),
                    fontWeight = FontWeight.Bold,
                    textAlignment = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(0.4f), textColor = black
                )


                Spacer(Modifier.height(5.dp))
                FormFieldCompact(
                    value = "",
                    onValueChange = { "" },
                    placeholder = stringResource(Res.string.upi_idd),
                    modifier = Modifier.width(150.dp),
                    maxLength = 30
                )

                Spacer(Modifier.height(5.dp))

                Button(
                    onClick = {
                        val exporter = DatabaseExporter()
                        exporter.exportAndShare(dbFileName)
                    },
                    shape = RoundedCornerShape(8.dp),




                    modifier = Modifier
                        .width(130.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    border = BorderStroke(2.dp, lightgreens)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .width(130.dp),
                    ) {


                        Icon(
                            painter = painterResource(Res.drawable.ic_setting),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = Color.Black
                        )

                        Spacer(modifier = Modifier.width(8.dp))


                        Text(
                            text = stringResource(Res.string.home_drawer_contact),
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 10.sp
                        )
                    }
                }

                Spacer(Modifier.height(10.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .width(130.dp),
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_setting),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.Black
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    ReusableTextView(
                        text = stringResource(Res.string.home_drawer_number),
                        fontWeight = FontWeight.Medium, textColor = black
                    )
                }

                Spacer(Modifier.height(6.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_setting),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.Black
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    ReusableTextView(
                        text = stringResource(Res.string.home_drawer_web),
                        fontWeight = FontWeight.Medium, textColor = black
                    )
                }

                Spacer(Modifier.height(30.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Text(
                        text = stringResource(Res.string.ro_address),
                        fontWeight = FontWeight.Bold,
                        color = blue,
                        fontSize = 16.sp
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = stringResource(Res.string.krishi_vihar),
                        color = blue,
                        fontSize = 13.sp
                    )
                }


                Spacer(Modifier.height(30.dp))
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(1.dp),
                    modifier = Modifier.width(130.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 4.dp,
                        pressedElevation = 6.dp,
                        focusedElevation = 4.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = btn_color
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = stringResource(Res.string.home_drawer_logout),
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 13.sp
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Icon(
                            painter = painterResource(Res.drawable.ic_logout),
                            contentDescription = null,
                            modifier = Modifier.size(22.dp),
                            tint = Color.White
                        )
                    }
                }


            }


        }
    }
}

@Preview
@Composable
fun DrawerContentPreview(){
    DrawerContent()
}