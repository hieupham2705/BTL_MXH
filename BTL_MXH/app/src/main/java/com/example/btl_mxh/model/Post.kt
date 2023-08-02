package com.example.btl_mxh.model

data class Post(
    val createdDate: String,
    val lastModifiedDate: String,
    val createdBy: String,
    val lastModifiedBy: String,
    val id: String,
    val caption: String,
    val userId: String,
    val mediaFiles: Array<String>,
)