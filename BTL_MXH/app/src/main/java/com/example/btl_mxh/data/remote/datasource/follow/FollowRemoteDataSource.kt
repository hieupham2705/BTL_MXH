package com.example.btl_mxh.data.remote.datasource.follow

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.data.service.ApiService
import com.example.btl_mxh.model.Delete
import com.example.btl_mxh.model.Follow
import com.example.btl_mxh.model.GetFollowers

class FollowRemoteDataSource(private val service : ApiService.FollowService):IFollowDataSource.Remote {
    override suspend fun getFollowers(userId: String): BaseResponse<GetFollowers> {
        return service.getFolowers(userId)
    }

    override suspend fun unFollow(userId: String): BaseResponse<Delete> {
        return service.unFollow(userId)
    }

    override suspend fun Follow(userId: String): BaseResponse<Follow> {
        return service.follow(userId)
    }
}