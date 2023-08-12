package com.example.btl_mxh.utils.extension

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.WindowManager
import com.example.btl_mxh.databinding.DialogDeleteBinding
import com.example.btl_mxh.databinding.DialogNotificationBinding
import com.example.btl_mxh.databinding.DialogShowImageBinding
import com.example.btl_mxh.databinding.DlLoadingCommonBinding
import com.example.btl_mxh.utils.constant.Constant


fun Dialog.start(stopFlag: Boolean = false) {
    val marginY = -170
    val binding = DlLoadingCommonBinding.inflate(layoutInflater)
    setContentView(binding.root)
    window?.apply {
        setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        attributes.apply {
            y = marginY
            gravity = Gravity.CENTER
        }
    }
    setCancelable(stopFlag)
    show()
}

fun Dialog.openDialogQuestion(confirmAction: () -> Unit) {
    this.let {
        val binding = DialogDeleteBinding.inflate(layoutInflater)
        it.setContentView(binding.root)
        it.window?.apply {
            setLayout(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            attributes.apply {
                y = Constant.DIALOGCONFIG.MARGIN_Y
                y = -170
                gravity = Gravity.CENTER

            }
        }
        binding.btnCancle.setOnClickListener {
            dismiss()
        }
        binding.btnConfirm.setOnClickListener {
            confirmAction()
            dismiss()
        }
        it.setCancelable(true)
        it.show()
    }
}

fun Dialog.openDialogNotification() {
    this.let {
        val binding = DialogNotificationBinding.inflate(layoutInflater)
        it.setContentView(binding.root)
        it.window?.apply {
            setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            attributes.apply {
                y = Constant.DIALOGCONFIG.MARGIN_Y
                y = -170
                gravity = Gravity.CENTER

            }
        }
        it.setCancelable(true)
        it.show()
    }
}

fun Dialog.showImage(image: String) {
    this.let {
        val marginY = -170
        val binding = DialogShowImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvImage.loadImageFromUrl(image)
        window?.apply {
            setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            attributes.apply {
                y = marginY
                gravity = Gravity.CENTER
            }
        }
        it.setCancelable(true)
        show()
    }
}