package com.example.btl_mxh.data.remote.repository.account

import com.example.btl_mxh.base.BaseRepository
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.data.remote.datasource.account.IAccountDataSource
import com.example.btl_mxh.model.*

class AccountRepositoryImpl(private val remote: IAccountDataSource.Remote) : BaseRepository(),
    IAccountRepository {
    override suspend fun login(loginEntity: LoginEntity): DataResult<BaseResponse<Login>> =
        getResult { remote.login(loginEntity) }

    override suspend fun authLogin(): DataResult<BaseResponse<Auth>> =
        getResult {
            remote.authLogin()
        }

    override suspend fun register(registerEntity: RegisterEntity): DataResult<BaseResponse<Register>> =
        getResult { remote.register(registerEntity) }

    override suspend fun logout(): DataResult<BaseResponse<Logout>> =
        getResult { remote.logout() }

    override suspend fun resetPassword(email: String): DataResult<BaseResponse<ResetPasword>> =
        getResult { remote.resetPasword(email) }

    override suspend fun changePassword(
        changePassword: ChangePassword
    ): DataResult<BaseResponse<ResetPasword>> = getResult {
        remote.changePassword(changePassword)
    }

    override suspend fun getById(userid: String): DataResult<BaseResponse<GetById>> = getResult {
        remote.getbyId(userid)
    }
}