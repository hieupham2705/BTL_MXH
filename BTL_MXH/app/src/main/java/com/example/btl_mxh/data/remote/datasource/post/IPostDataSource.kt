package com.example.btl_mxh.data.remote.datasource.post

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface IPostDataSource {
    interface Local {
    }

    interface Remote {
        suspend fun createNewPost(caption: String, files: List<MultipartBody.Part>): BaseResponse<CreateNewPost>
        suspend fun editPost(caption: RequestBody, files: List<MultipartBody.Part>?): BaseResponse<CreateNewPost>
        suspend fun postGetAll():BaseResponse<List<Post>>
        suspend fun getAllByUsername(userName:String):BaseResponse<List<Post>>
        suspend fun getAllByUserId(userId:String):BaseResponse<List<Post>>
        suspend fun deletePost(id:String):BaseResponse<Delete>
    }
}