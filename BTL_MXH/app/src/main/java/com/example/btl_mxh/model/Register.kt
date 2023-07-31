package com.example.btl_mxh.model
data class Register(
    val createdDate: String,
    val lastModifiedDate: String,
    val id: String,
    var email: String,
    val fullName: String,
    val username: String,
    val phone: String,
    val gender: Any?,
    val avatar: Any?,
    val birthday: Any?,
    val roleName: String,
)

