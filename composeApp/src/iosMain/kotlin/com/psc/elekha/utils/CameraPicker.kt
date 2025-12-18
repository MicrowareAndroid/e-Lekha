package com.psc.elekha.utils

import androidx.compose.runtime.*
import androidx.compose.ui.interop.LocalUIViewController
import com.psc.elekha.expectfile.PermissionManager
import com.psc.elekha.expectfile.PermissionStatus
import kotlinx.cinterop.*
import kotlinx.coroutines.launch
import platform.Foundation.NSData
import platform.UIKit.*
import platform.darwin.NSObject
import platform.posix.memcpy

@Composable
actual fun CameraPicker(
    onImagePicked: (ByteArray?) -> Unit,
    openCamera: Boolean
) {
    if (!openCamera) return

    val viewController = LocalUIViewController.current
    val coroutineScope = rememberCoroutineScope()
    var launched by remember { mutableStateOf(false) }
    var permissionChecked by remember { mutableStateOf(false) }

    val permissionManager = remember { PermissionManager() }

    LaunchedEffect(openCamera) {
        if (!launched && !permissionChecked) {
            permissionChecked = true

            coroutineScope.launch {
                val status = permissionManager.checkPermission(AppPermission.CAMERA)

                when (status) {
                    PermissionStatus.GRANTED -> {
                        // Permission granted, open camera
                        launched = true
                        launchCamera(viewController, onImagePicked)
                    }
                    PermissionStatus.NOT_DETERMINED, PermissionStatus.DENIED -> {
                        // Request permission
                        val result = permissionManager.requestPermission(AppPermission.CAMERA)
                        if (result == PermissionStatus.GRANTED) {
                            launched = true
                            launchCamera(viewController, onImagePicked)
                        } else {
                            onImagePicked(null)
                        }
                    }
                    PermissionStatus.DENIED_PERMANENTLY -> {
                        // Show alert to open settings
                        showSettingsAlert(viewController, permissionManager)
                        onImagePicked(null)
                    }
                }
            }
        }
    }
}

private fun launchCamera(
    viewController: UIViewController,
    onImagePicked: (ByteArray?) -> Unit
) {
    val picker = UIImagePickerController().apply {
        sourceType = UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypeCamera
        allowsEditing = false
        delegate = object : NSObject(),
            UIImagePickerControllerDelegateProtocol,
            UINavigationControllerDelegateProtocol {

            override fun imagePickerController(
                picker: UIImagePickerController,
                didFinishPickingMediaWithInfo: Map<Any?, *>
            ) {
                val image = didFinishPickingMediaWithInfo[UIImagePickerControllerOriginalImage] as? UIImage
                val imageData = image?.JPEGRepresentation(0.9)
                val bytes = imageData?.toByteArray()
                onImagePicked(bytes)
                picker.dismissViewControllerAnimated(true, completion = null)
            }

            override fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
                picker.dismissViewControllerAnimated(true, completion = null)
                onImagePicked(null)
            }
        }
    }
    viewController.presentViewController(picker, animated = true, completion = null)
}

private fun showSettingsAlert(
    viewController: UIViewController,
    permissionManager: PermissionManager
) {
    val alert = UIAlertController.alertControllerWithTitle(
        title = "Camera Permission Required",
        message = "Camera permission is permanently denied. Please enable it in Settings.",
        preferredStyle = UIAlertControllerStyleAlert
    )

    alert.addAction(
        UIAlertAction.actionWithTitle(
            title = "Settings",
            style = UIAlertActionStyleDefault,
            handler = {
                permissionManager.openAppSettings()
            }
        )
    )

    alert.addAction(
        UIAlertAction.actionWithTitle(
            title = "Cancel",
            style = UIAlertActionStyleCancel,
            handler = null
        )
    )

    viewController.presentViewController(alert, animated = true, completion = null)
}

// Helper: convert NSData to ByteArray
@OptIn(ExperimentalForeignApi::class)
fun NSData.toByteArray(): ByteArray = ByteArray(length.toInt()).apply {
    usePinned { memcpy(it.addressOf(0), bytes, length) }
}

// Helper: convert UIImage to JPEG NSData
fun UIImage.JPEGRepresentation(compression: Double): NSData? {
    return UIImageJPEGRepresentation(this, compression)
}