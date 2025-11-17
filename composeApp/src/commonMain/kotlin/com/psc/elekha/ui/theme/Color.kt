package com.psc.elekha.ui.theme

import androidx.compose.ui.graphics.Color

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