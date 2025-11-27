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
val lightOrange = Color(0xFFFFE4CE)
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
