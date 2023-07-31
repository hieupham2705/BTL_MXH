package com.example.btl_mxh.model

data class Login(
    val tokenType: String,
    val accessToken: String,
    val refreshToken: String,
    val id: String,
    val authorities: List<Authority>,
)

data class Authority(
    val authority: String,
)
