package com.example.btl_mxh.base

data class BaseResponse<T>(
    val status: String,
    val data: T? = null,
    val message: Any? = null
)