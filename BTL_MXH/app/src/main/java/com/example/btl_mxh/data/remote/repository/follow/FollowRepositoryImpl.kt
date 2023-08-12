package com.example.btl_mxh.data.remote.repository.follow

import com.example.btl_mxh.base.BaseRepository
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.data.remote.datasource.follow.IFollowDataSource
import com.example.btl_mxh.data.remote.datasource.post.IPostDataSource
import com.example.btl_mxh.model.*

class FollowRepositoryImpl(private val remote: IFollowDataSource.Remote) : BaseRepository(),
    IFollowRepository {
    override suspend fun getFollowers(userId: String): DataResult<BaseResponse<GetFollowers>> =
        getResult { remote.getFollowers(userId)}

    override suspend fun unFollow(userId: String): DataResult<BaseResponse<Delete>> = getResult {
        remote.unFollow(userId)
    }

    override suspend fun Follow(userId: String): DataResult<BaseResponse<Follow>> = getResult {
        remote.Follow(userId)
    }


}