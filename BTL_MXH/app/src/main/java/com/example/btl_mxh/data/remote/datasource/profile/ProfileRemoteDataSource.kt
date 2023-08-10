package com.example.btl_mxh.data.remote.datasource.profile

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.data.service.ApiService
import com.example.btl_mxh.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody


class ProfileRemoteDataSource(private val service: ApiService.ProfileService) :
    IProfileDataSource.Remote {
    override suspend fun updateProfile(
        birthday: RequestBody,
        gender: RequestBody,
        avatar: MultipartBody.Part,
        fullName: RequestBody,
        username: RequestBody,
        email: RequestBody
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