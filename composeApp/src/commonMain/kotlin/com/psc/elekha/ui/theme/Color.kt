package com.psc.elekha.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val desire_orange = Color(0xFFFF5722)
val teal700 = Color(0xFFAA1615)
val black = Color(0xFF000000)
val white = Color(0xFFFFFFFF)
val accentOrange = Color(0xFFAF2D2D)
val assureOrange = Color(0xFFAA1615)
val lightgreen = Color(0xFFC8F5C8)
val lightgreens = Color(0xFF5FCC9A)
val lightGrey = Color(0xFFF7F7F7)
val tealOrange = Color(0xFF8C0C04)
val tealOranges = Color(0xFFFFEFF4)
val darkBluishGrey = Color(0xFF313957)
val formborder = Color(0xFFD0D0D0)
val lightBackground = Color(0xFFF8FAFC)
val boderColor = Color(0xFFCBCBCB)
val bgColor = Color(0xFFF8F8F8)

val PrimaryColor = Color(0xFFE3F1FA)
val PrimaryDark = Color(0xFF285684)
val MediumLightBlue = Color(0xff40ca9e)
val LightBlue = Color(0xff6cfdcf)
val YellowButton = Color(0xFFFFEB3B)

val LoginTextBox = Color(0xff208767)
val TextGray = Color(0xFF888888)

val WhitishYellow = Color(0xfff3eb6b)   // soft pale yellow
val BrightYellow  = Color(0xffedda19)
val lightblue = Color(0xFF88E7D1)
val lightdeep =Color(0xFFB6F4E7)
val lighttheme = Color(0xFFFFE28A)
val repaymentColor = Color(0xFFC8EEA0)
val LightBlueBackground = Color(0xFFE3F2F9)
val LightSkyBlue = Color(0xFFC3E7F4)
val LightMint = Color(0xFF8DE9CB)
val LightTeal = Color(0xFFB5F4E5)
val LightYellow = Color(0xFFFFE48A)
val CardColor = Color(0xFFC4E2EA)
val LightPink = Color(0xFFDBFAFA)


val textview_color = Color(0xFF658889)
val editext_bg_color = Color(0xFFC4E2EA)
val btn_color = Color(0xFFFCC739)

val text_fiiled_color= Color(0xFFE8F2FF)
val toolbar_color = Color(0xFF02435A)
fun blendColors(color1: Color, color2: Color, ratio: Float): Color {
    val inverseRatio = 1 - ratio
    return Color(
        red   = color1.red * inverseRatio + color2.red * ratio,
        green = color1.green * inverseRatio + color2.green * ratio,
        blue  = color1.blue * inverseRatio + color2.blue * ratio,
        alpha = color1.alpha * inverseRatio + color2.alpha * ratio
    )
}

val MixedYellow = blendColors(WhitishYellow, BrightYellow, 0.5f)

