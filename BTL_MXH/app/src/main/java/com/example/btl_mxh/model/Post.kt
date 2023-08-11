package com.example.btl_mxh.model

data class Post(
    val createdDate: String? = null,
    val lastModifiedDate: String? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val id: String? = null,
    val caption: String? = null,
    val userId: String? = null,
    val username: String? = null,
    val avatar: String? = null,
    val mediaFiles: List<String>? = null,
)