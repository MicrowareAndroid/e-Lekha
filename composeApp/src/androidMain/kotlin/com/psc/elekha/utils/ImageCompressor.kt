package com.psc.elekha.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream
import java.io.File

object ImageCompressor {

    fun compressToKB(inputFile: File): File {
        val bitmap = BitmapFactory.decodeFile(inputFile.absolutePath)

        var quality = 90
        val outputStream = ByteArrayOutputStream()

        do {
            outputStream.reset()
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
            quality -= 5
        } while (outputStream.size() / 1024 > 20 && quality > 5)

        // overwrite same file
        inputFile.writeBytes(outputStream.toByteArray())

        return inputFile
    }
}
