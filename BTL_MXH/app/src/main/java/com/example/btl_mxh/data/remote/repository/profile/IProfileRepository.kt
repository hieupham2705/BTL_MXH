package com.example.btl_mxh.data.remote.repository.profile

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface IProfileRepository {
    suspend fun updateProfile(
        birthday : RequestBody,
        gender : RequestBody,
        avatar : MultipartBody.Part,
        fullName : RequestBody,
        username : RequestBody,
        email : RequestBody
    ):DataResult<BaseResponse<UpdateProfiledata>>
}