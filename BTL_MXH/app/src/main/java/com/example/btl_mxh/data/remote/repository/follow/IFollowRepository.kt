package com.example.btl_mxh.data.remote.repository.follow

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.model.Delete
import com.example.btl_mxh.model.Follow
import com.example.btl_mxh.model.GetFollowers

interface IFollowRepository {
    suspend fun getFollowers(userId:String):DataResult<BaseResponse<GetFollowers>>
    suspend fun unFollow(userId: String): DataResult<BaseResponse<Delete>>
    suspend fun Follow(userId: String): DataResult<BaseResponse<Follow>>
}