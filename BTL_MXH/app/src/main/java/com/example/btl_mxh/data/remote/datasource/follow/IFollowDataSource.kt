package com.example.btl_mxh.data.remote.datasource.follow

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.model.Delete
import com.example.btl_mxh.model.Follow
import com.example.btl_mxh.model.GetFollowers

interface IFollowDataSource {
    interface Local{
    }
    interface Remote{
        suspend fun getFollowers(userId:String): BaseResponse<GetFollowers>
        suspend fun unFollow(userId:String): BaseResponse<Delete>
        suspend fun Follow(userId:String): BaseResponse<Follow>
    }
}