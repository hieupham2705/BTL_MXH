package com.example.btl_mxh.data.remote.datasource.post

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.data.service.ApiService
import com.example.btl_mxh.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody


class PostRemoteDataSource(private val service: ApiService.PostService) :
    IPostDataSource.Remote {
    override suspend fun createNewPost(caption: String, files: List<MultipartBody.Part>): BaseResponse<CreateNewPost> {
        return service.createNewPost(caption,files)
    }

    override suspend fun editPost(
        caption: RequestBody,
        images: List<MultipartBody.Part>?
    ): BaseResponse<CreateNewPost> {
        return service.editPost(caption,images)
    }

    override suspend fun postGetAll(): BaseResponse<List<Post>> {
        return service.postGetAll()
    }

    override suspend fun getAllByUsername(userName: String): BaseResponse<List<Post>> {
        return service.getAllByUsername(userName)
    }

    override suspend fun getAllByUserId(userId: String): BaseResponse<List<Post>> {
        return service.getAllByUserid(userId)
    }

    override suspend fun deletePost(id: String): BaseResponse<Delete> {
        return service.deletePost(id)
    }


}