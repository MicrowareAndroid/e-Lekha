package com.psc.elekha.utils

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import java.io.ByteArrayOutputStream
import java.io.File


@Composable
actual fun CameraPicker(
    onImagePicked: (ByteArray?) -> Unit,
    openCamera: Boolean
) {
    val context = LocalContext.current
    var shouldLaunch by remember { mutableStateOf(openCamera) }

    //  Camera launcher (declare first)
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
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
        shouldLaunch = false
    }

    //  Permission launcher (can now access launcher)
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            launcher.launch(intent)
        } else {
            Toast.makeText(context, "Camera permission denied", Toast.LENGTH_SHORT).show()
            onImagePicked(null)
            shouldLaunch = false
        }
    }

    //  Launch effect
    LaunchedEffect(shouldLaunch) {
        if (shouldLaunch) {
            val permission = Manifest.permission.CAMERA
            if (ContextCompat.checkSelfPermission(context, permission)
                == PackageManager.PERMISSION_GRANTED
            ) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                launcher.launch(intent)
            } else {
                permissionLauncher.launch(permission)
            }
        }
    }
}
