package com.psc.elekha.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider

import com.psc.elekha.expectfile.PermissionManager
import com.psc.elekha.expectfile.PermissionStatus
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.File

@Composable
actual fun CameraPicker(
    openCamera: Boolean,
    onImagePicked: (String?) -> Unit
) {
    val context = LocalContext.current
    var photoFile by remember { mutableStateOf<File?>(null) }


    val cameraLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                onImagePicked(photoFile?.absolutePath)
            } else {
                onImagePicked(null)
            }
        }


    val permissionLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { granted ->
            if (granted) {
                launchCamera(context) { file, uri ->
                    photoFile = file
                    cameraLauncher.launch(
                        Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                            putExtra(MediaStore.EXTRA_OUTPUT, uri)
                        }
                    )
                }
            } else {
                Toast.makeText(
                    context,
                    "Camera permission denied",
                    Toast.LENGTH_SHORT
                ).show()
                onImagePicked(null)
            }
        }

    val permissionManager = remember { PermissionManager(context.applicationContext) }

    LaunchedEffect(openCamera) {
        if (!openCamera) return@LaunchedEffect

        when (permissionManager.checkPermission(AppPermission.CAMERA)) {

            PermissionStatus.GRANTED -> {
                // Permission already granted
                launchCamera(context) { file, uri ->
                    photoFile = file
                    cameraLauncher.launch(
                        Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                            putExtra(MediaStore.EXTRA_OUTPUT, uri)
                        }
                    )
                }
            }

            PermissionStatus.NOT_DETERMINED,
            PermissionStatus.DENIED -> {
                // Request permission via launcher
                permissionLauncher.launch(Manifest.permission.CAMERA)
            }

            PermissionStatus.DENIED_PERMANENTLY -> {
                Toast.makeText(
                    context,
                    "Camera permission permanently denied. Enable it from settings.",
                    Toast.LENGTH_LONG
                ).show()
                permissionManager.openAppSettings()
                onImagePicked(null)
            }
        }
    }
}

/**
 * Creates image file + FileProvider URI
 */
private fun launchCamera(
    context: Context,
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
