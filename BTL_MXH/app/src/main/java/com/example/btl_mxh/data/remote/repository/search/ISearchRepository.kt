package com.example.btl_mxh.data.remote.repository.search

import Search
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.model.*
import java.io.File

interface ISearchRepository {
    suspend fun searchUserId(
        id:String
    ):DataResult<BaseResponse<Search>>
}