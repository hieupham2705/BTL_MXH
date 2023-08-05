package com.example.btl_mxh.data.remote.repository.post

import com.example.btl_mxh.base.BaseRepository
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.data.remote.datasource.post.IPostDataSource
import com.example.btl_mxh.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody

class PostRepositoryImpl(private val remote: IPostDataSource.Remote) : BaseRepository(),
    IPostRepository {
    override suspend fun createNewPost(
        caption: RequestBody,
        images: List<MultipartBody.Part>?
    ): DataResult<BaseResponse<CreateNewPost>> =
        getResult {
            remote.createNewPost(
                caption,
                images
            )
        }

    override suspend fun postGetAll(): DataResult<BaseResponse<List<Post>>> =
        getResult { remote.postGetAll() }

    override suspend fun getAllByUsername(userName: String): DataResult<BaseResponse<List<Post>>> = getResult {
        remote.getAllByUsername(userName)
    }


}