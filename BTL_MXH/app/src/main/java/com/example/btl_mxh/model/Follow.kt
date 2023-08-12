package com.example.btl_mxh.model

data class Follow(
    val createdDate: String,
    val lastModifiedDate: String,
    val createdBy: String,
    val lastModifiedBy: String,
    val id: String,
    val from: From,
    val to: To,
)

data class From(
    val createdDate: String,
    val lastModifiedDate: String,
    val id: String,
    val email: String,
    val fullName: String,
    val username: String,
    val phone: String,
    val gender: String,
    val avatar: String,
    val birthday: String,
    val role: Role,
)

data class Role(
    val id: Long,
    val name: String,
)

data class To(
    val createdDate: String,
    val lastModifiedDate: String,
    val id: String,
    val email: String,
    val fullName: String,
    val username: String,
    val phone: String,
    val gender: String,
    val avatar: String,
    val birthday: String,
    val role: Role2,
)

data class Role2(
    val id: Long,
    val name: String,
)
