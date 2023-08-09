package com.example.btl_mxh.data.remote.repository.profile

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.model.*
import java.io.File

interface IProfileRepository {
    suspend fun updateProfile(
        birthday : String,
        gender : String,
        avatar : File,
        fullName : String,
        username : String,
        email : String
    ):DataResult<BaseResponse<UpdateProfiledata>>
}