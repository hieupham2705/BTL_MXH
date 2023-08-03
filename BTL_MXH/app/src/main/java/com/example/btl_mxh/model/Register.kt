package com.example.btl_mxh.model

data class Register(
    val createdDate: String? = null,
    val lastModifiedDate: String? = null,
    val id: String? = null,
    var email: String? = null,
    val fullName: String? = null,
    val username: String? = null,
    val phone: String? = null,
    val gender: Any,
    val avatar: Any,
    val birthday: Any,
    val roleName: String? = null
)

