package com.psc.elekha.utils

import androidx.compose.runtime.Composable



// Common expect function
@Composable
expect fun CameraPicker(
    onImagePicked: (ByteArray?) -> Unit,
    openCamera: Boolean
)