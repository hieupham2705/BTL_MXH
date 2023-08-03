package com.example.btl_mxh.base

data class  BaseResponse<T>(
    val status : String,
    val data: T?,
    val message: String?
)