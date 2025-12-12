package com.psc.elekha.model

import androidx.compose.ui.graphics.painter.Painter

data class SliderItem(
    val left: Painter,
    val center: Painter,
    val right: Painter,
    val title: String
)
