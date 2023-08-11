package com.example.btl_mxh.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EditPost(
    val caption: String? = null,
    val link: List<String>? = null
) : Parcelable
