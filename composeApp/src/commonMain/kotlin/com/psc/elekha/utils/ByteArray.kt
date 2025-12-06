package com.psc.elekha.utils

import androidx.compose.ui.graphics.ImageBitmap

expect fun ByteArray.toPlatformImageBitmap(): ImageBitmap
