package com.psc.elekha.utils

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap

actual fun loadImageFromPath(path: String): ImageBitmap? {
    return BitmapFactory.decodeFile(path)?.asImageBitmap()
}
