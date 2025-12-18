package com.psc.elekha.utils

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
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
    onImagePicked: (ByteArray?) -> Unit,
    openCamera: Boolean
) {
    val context = LocalContext.current

    val permissionManager = remember {
        PermissionManager(context.applicationContext)
    }

    // Camera launcher
    val cameraLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val bitmap = result.data?.extras?.get("data") as? Bitmap
                bitmap?.let {
                    val stream = ByteArrayOutputStream()
                    it.compress(Bitmap.CompressFormat.JPEG, 90, stream)
                    onImagePicked(stream.toByteArray())
                }
            } else {
                onImagePicked(null)
            }
        }

    // Permission launcher
    val permissionLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { granted ->
            if (granted) {
                cameraLauncher.launch(
                    Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                )
            } else {
                Toast.makeText(
                    context,
                    "Camera permission denied",
                    Toast.LENGTH_SHORT
                ).show()
                onImagePicked(null)
            }
        }

    LaunchedEffect(openCamera) {
        if (!openCamera) return@LaunchedEffect

        when (permissionManager.checkPermission(AppPermission.CAMERA)) {

            PermissionStatus.GRANTED -> {
                cameraLauncher.launch(
                    Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                )
            }

            PermissionStatus.NOT_DETERMINED,
            PermissionStatus.DENIED -> {
                context
                    .getSharedPreferences("permissions", Activity.MODE_PRIVATE)
                    .edit()
                    .putBoolean(AppPermission.CAMERA.name, true)
                    .apply()

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
