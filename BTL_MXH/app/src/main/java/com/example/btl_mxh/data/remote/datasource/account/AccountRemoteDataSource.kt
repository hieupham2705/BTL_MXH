package com.example.btl_mxh.data.remote.datasource.account

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.data.service.ApiService
import com.example.btl_mxh.model.*

class AccountRemoteDataSource(private val service: ApiService.AccountService) :
    IAccountDataSource.Remote {
    override suspend fun login(loginEntity: LoginEntity): BaseResponse<Login> {
        return service.login(loginEntity)
    }

    override suspend fun authLogin(): BaseResponse<Auth> {
        return service.authLogin()
    }
    override suspend fun register(reisterEntity: RegisterEntity): BaseResponse<Register> {
        return service.authRegister(reisterEntity)
    }

    override suspend fun logout(): BaseResponse<Logout> {
        return service.logout()
    }

    override suspend fun resetPasword(email: String): BaseResponse<ResetPasword> {
        return service.resetPassword(email)
    }

}