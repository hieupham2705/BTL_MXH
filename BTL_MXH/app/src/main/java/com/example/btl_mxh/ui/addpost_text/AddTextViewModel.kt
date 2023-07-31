package com.example.btl_mxh.ui.addpost_text

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.example.btl_mxh.base.BaseViewModel
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener

class AddTextViewModel : BaseViewModel() {
    fun check_Permissions(context: Context){
        // Kiểm tra quyền truy cập bộ sưu tập ảnh
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Quyền đã được cấp, có thể truy cập bộ sưu tập ảnh tại đây
            // Viết mã của bạn để truy cập vào bộ sưu tập ảnh ở đây
        } else {
            // Quyền chưa được cấp, yêu cầu cấp quyền
            requestStoragePermission(context)
        }
    }
    private fun requestStoragePermission(context: Context) {
        Dexter.withContext(context)
            .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse) {
                    // Quyền được cấp, có thể truy cập bộ sưu tập ảnh tại đây
                    // Viết mã của bạn để truy cập vào bộ sưu tập ảnh ở đây
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse) {
                    // Xử lý khi người dùng từ chối cấp quyền
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest,
                    token: PermissionToken
                ) {
                    token.continuePermissionRequest()
                }
            }).check()
    }
}