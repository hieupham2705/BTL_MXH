package com.example.btl_mxh.data.remote.datasource.post

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.data.service.ApiService
import com.example.btl_mxh.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody


class PostRemoteDataSource(private val service: ApiService.PostService) :
    IPostDataSource.Remote {
    override suspend fun createNewPost(caption: RequestBody,  files: Array<MultipartBody.Part>): BaseResponse<CreateNewPost> {
        return service.createNewPost(caption,files)
    }

    override suspend fun postGetAll(): BaseResponse<PostGetAll> {
        return service.postGetAll()
    }


}