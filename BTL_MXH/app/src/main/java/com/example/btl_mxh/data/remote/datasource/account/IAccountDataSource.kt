package com.example.btl_mxh.data.remote.datasource.account

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.model.*

interface IAccountDataSource {
    interface Local{
    }
    interface Remote{
        suspend  fun login(loginEntity: LoginEntity): BaseResponse<Login>
        suspend  fun authLogin(): BaseResponse<Auth>
        suspend  fun register(reisterEntity: RegisterEntity): BaseResponse<Register>
        suspend fun logout():BaseResponse<Logout>
        suspend fun resetPasword(email:String):BaseResponse<ResetPasword>

        suspend fun changePassword(changePassword: ChangePassword ): BaseResponse<ResetPasword>
        suspend fun getbyId(userId : String) : BaseResponse<GetById>

    }
}