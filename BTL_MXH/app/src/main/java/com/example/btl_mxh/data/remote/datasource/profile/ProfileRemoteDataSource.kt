package com.example.btl_mxh.data.remote.datasource.profile

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.data.service.ApiService
import com.example.btl_mxh.model.*
import java.io.File


class ProfileRemoteDataSource(private val service: ApiService.ProfileService) :
    IProfileDataSource.Remote {
    override suspend fun updateProfile(
        birthday: String,
        gender: String,
        avatar: File,
        fullName: String,
        username: String,
        email: String
    ): BaseResponse<UpdateProfiledata> {
        return service.updatePost(
            birthday,
            gender,
            avatar,
            fullName,
            username,
            email
        )
    }
}