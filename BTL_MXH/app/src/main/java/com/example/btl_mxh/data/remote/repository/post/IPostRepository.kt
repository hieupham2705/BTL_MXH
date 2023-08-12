package com.example.btl_mxh.data.remote.repository.post

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface IPostRepository {
    suspend fun createNewPost(caption: RequestBody, files: List<MultipartBody.Part>?): DataResult<BaseResponse<CreateNewPost>>
    suspend fun editPost(caption: RequestBody, images: List<MultipartBody.Part>?): DataResult<BaseResponse<CreateNewPost>>
    suspend fun postGetAll():DataResult<BaseResponse<List<Post>>>
    suspend fun getAllByUsername(userName:String):DataResult<BaseResponse<List<Post>>>
    suspend fun getAllByUserId(userId:String):DataResult<BaseResponse<List<Post>>>
    suspend fun deletePost(id:String):DataResult<BaseResponse<Delete>>
}