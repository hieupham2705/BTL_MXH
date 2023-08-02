package com.example.btl_mxh.utils.extension

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.btl_mxh.R

fun ImageView.loadImageFromUrl(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}
