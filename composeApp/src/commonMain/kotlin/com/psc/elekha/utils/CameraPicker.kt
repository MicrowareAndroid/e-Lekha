package com.psc.elekha.utils

import androidx.compose.runtime.Composable

@Composable
expect fun CameraPicker(
    onImagePicked: (ByteArray?) -> Unit,
    openCamera: Boolean
)
