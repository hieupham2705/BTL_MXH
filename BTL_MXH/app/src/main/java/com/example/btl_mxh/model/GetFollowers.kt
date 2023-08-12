package com.example.btl_mxh.model

data class GetFollowers (
    val meta: JsonToKotlinBaseMeta, 
    val items: List<Auth>,
)
data class JsonToKotlinBaseMeta (
    val totalElements: Byte,
    val totalPages: Byte,
    val pageNum: Byte,
    val pageSize: Byte,
    val sortBy: String,
    val sortType: String,
)