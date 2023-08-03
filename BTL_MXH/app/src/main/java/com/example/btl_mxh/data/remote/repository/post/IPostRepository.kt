package com.example.btl_mxh.data.remote.repository.post

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface IPostRepository {
    suspend fun createNewPost(caption: RequestBody, files: Array<MultipartBody.Part>): DataResult<BaseResponse<CreateNewPost>>
    suspend fun postGetAll():DataResult<BaseResponse<List<Post>>>
}