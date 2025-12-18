package com.psc.elekha.utils

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import java.io.File

@Composable
actual fun CameraPicker(
    openCamera: Boolean,
    onImagePicked: (String?) -> Unit
) {
    val context = LocalContext.current
    var shouldLaunch by remember { mutableStateOf(false) }
    var photoFile by remember { mutableStateOf<File?>(null) }

    // Camera launcher
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            onImagePicked(photoFile?.absolutePath)
        } else {
            onImagePicked(null)
        }
        shouldLaunch = false
    }


    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            launchCamera(context) { file, uri ->
                photoFile = file
                launcher.launch(
                    Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                        putExtra(MediaStore.EXTRA_OUTPUT, uri)
                    }
                )
            }
        } else {
            Toast.makeText(context, "Camera permission denied", Toast.LENGTH_SHORT).show()
            onImagePicked(null)
            shouldLaunch = false
        }
    }


    LaunchedEffect(openCamera) {
        if (openCamera) {
            shouldLaunch = true
        }
    }


    LaunchedEffect(shouldLaunch) {
        if (shouldLaunch) {
            val permission = Manifest.permission.CAMERA
            if (ContextCompat.checkSelfPermission(context, permission)
                == android.content.pm.PackageManager.PERMISSION_GRANTED
            ) {
                launchCamera(context) { file, uri ->
                    photoFile = file
                    launcher.launch(
                        Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                            putExtra(MediaStore.EXTRA_OUTPUT, uri)
                        }
                    )
                }
            } else {
                permissionLauncher.launch(permission)
            }
        }
    }
}



private fun launchCamera(
    context: android.content.Context,
    onReady: (File, Uri) -> Unit
) {
    val dir = File(context.filesDir, "camera")
    if (!dir.exists()) dir.mkdirs()

    val file = File(dir, "IMG_${System.currentTimeMillis()}.jpg")
    val uri = FileProvider.getUriForFile(
        context,
        "${context.packageName}.fileprovider",
        file
    )
    onReady(file, uri)
}