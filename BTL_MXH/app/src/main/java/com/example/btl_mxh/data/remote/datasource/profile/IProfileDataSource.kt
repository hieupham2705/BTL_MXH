package com.example.btl_mxh.data.remote.datasource.profile

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.model.UpdateProfiledata
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface IProfileDataSource {
    interface Local {
    }

    interface Remote {
        suspend fun updateProfile(
            birthday : RequestBody,
            gender : RequestBody,
            avatar : MultipartBody.Part?,
            fullName : RequestBody,
            username : RequestBody,
            email : RequestBody
        ):BaseResponse<UpdateProfiledata>
    }
}