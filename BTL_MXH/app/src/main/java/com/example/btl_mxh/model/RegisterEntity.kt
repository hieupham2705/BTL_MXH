package com.example.btl_mxh.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegisterEntity(
    val email: String,
    var password: String,
    val fullName: String,
    val username: String,
    val phone: String,
) : Parcelable