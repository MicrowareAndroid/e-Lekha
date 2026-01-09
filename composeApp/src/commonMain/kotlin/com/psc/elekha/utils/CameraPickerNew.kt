package com.psc.elekha.utils

import androidx.compose.runtime.Composable



// Common expect function
// Common expect function
// commonMain
@Composable
expect fun CameraPickerNew(
    openCamera: Boolean,
    onImagePicked: (imageName: String?, imagePath: String?) -> Unit
)


