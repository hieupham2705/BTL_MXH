package com.example.btl_mxh.data.remote.datasource.post

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface IPostDataSource {
    interface Local {
    }

    interface Remote {
        suspend fun createNewPost(caption: RequestBody, files: Array<MultipartBody.Part>): BaseResponse<CreateNewPost>
        suspend fun postGetAll():BaseResponse<PostGetAll>
    }
}