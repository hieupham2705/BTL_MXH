package com.example.btl_mxh.model

data class GetById(
    val createdDate: String? = null,
    val lastModifiedDate: String? = null,
    val id: String? = null,
    val email: String? = null,
    val fullName: String? = null,
    val username: String? = null,
    val phone: String? = null,
    val gender: String? = null,
    val avatar: String? = null,
    val birthday: String? = null,
    val role: JsonToKotlinBaseRole? = null,
)

data class JsonToKotlinBaseRole(
    val id: Byte? = null,
    val name: String? = null,
)