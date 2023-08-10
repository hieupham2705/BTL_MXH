package com.example.btl_mxh.utils.extension

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

object FileUtils {

    fun getRealPathFromUri(context: Context, uri: Uri): String? {
        val contentResolver: ContentResolver = context.contentResolver

        // Kiểm tra scheme của URI
        if ("content".equals(uri.scheme, ignoreCase = true)) {
            val projection = arrayOf(MediaStore.Images.Media.DATA)
            var cursor: Cursor? = null
            try {
                cursor = contentResolver.query(uri, projection, null, null, null)
                val column_index: Int = cursor?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA) ?: -1
                cursor?.moveToFirst()
                return cursor?.getString(column_index)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                cursor?.close()
            }
        } else if ("file".equals(uri.scheme, ignoreCase = true)) {
            return uri.path
        }

        return null
    }
    fun uriToJpg(contentResolver: ContentResolver, uri: Uri, context: Context): String? {
        try {
            val inputStream = contentResolver.openInputStream(uri)
            inputStream?.use {
                // Chuyển đổi dữ liệu của tập tin ảnh thành đối tượng Bitmap
                val bitmap = BitmapFactory.decodeStream(inputStream)

                // Tạo một tập tin mới với định dạng JPG trong thư mục lưu trữ ngoài của ứng dụng
                val storageDir = context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                val file = File.createTempFile("image", ".jpg", storageDir)

                // Ghi dữ liệu của Bitmap vào tập tin mới với định dạng JPG
                val outputStream: OutputStream = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                outputStream.flush()
                outputStream.close()

                return file.absolutePath
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}
