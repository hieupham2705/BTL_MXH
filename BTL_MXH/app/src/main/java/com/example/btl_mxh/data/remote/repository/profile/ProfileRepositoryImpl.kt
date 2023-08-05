package com.example.btl_mxh.data.remote.repository.profile

import com.example.btl_mxh.base.BaseRepository
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.data.remote.datasource.profile.IProfileDataSource
import com.example.btl_mxh.model.*
import java.io.File

class ProfileRepositoryImpl(private val remote: IProfileDataSource.Remote) : BaseRepository(),
    IProfileRepository {
    override suspend fun updateProfile(
        birthday: String,
        gender: String,
        avatar: File,
        fullName: String,
        username: String,
        email: String
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