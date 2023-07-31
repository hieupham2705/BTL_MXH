package com.example.btl_mxh.data.remote.repository.account

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.model.*

interface IAccountRepository {
    suspend fun login(loginEntity: LoginEntity): DataResult<BaseResponse<Login>>
    suspend fun authLogin(): DataResult<BaseResponse<Auth>>
    suspend fun register(registerEntity: RegisterEntity): DataResult<BaseResponse<Register>>
    suspend fun logout(): DataResult<BaseResponse<Logout>>
    suspend fun resetPassword(email: String): DataResult<BaseResponse<ResetPasword>>
}