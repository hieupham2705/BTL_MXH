package com.example.btl_mxh.data.remote.repository.profile

import com.example.btl_mxh.base.BaseRepository
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.data.remote.datasource.profile.IProfileDataSource
import com.example.btl_mxh.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody

class ProfileRepositoryImpl(private val remote: IProfileDataSource.Remote) : BaseRepository(),
    IProfileRepository {
    override suspend fun updateProfile(
        birthday: RequestBody,
        gender: RequestBody,
        avatar: MultipartBody.Part,
        fullName: RequestBody,
        username: RequestBody,
        email: RequestBody
    ): DataResult<BaseResponse<UpdateProfiledata>> = getResult {
        remote.updateProfile(
            birthday,
            gender,
            avatar,
            fullName,
            username,
            email)
    }


}