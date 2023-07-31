package com.example.btl_mxh.data.service

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.model.*
import com.example.btl_mxh.utils.constant.ApiConstant
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

// chueyn doi giao thuc thanh code
interface ApiService {

    interface SearchService {
        @GET(ApiConstant.ENDPOINT.SEARCH_USER)
        suspend fun searchByName(@Query("q") searchKey: String): Search
    }
    interface AccountService{
        @POST(ApiConstant.ENDPOINT.AUTH_LOGIN)
        suspend fun login(@Body loginEntity: LoginEntity) : BaseResponse<Login>
        @GET(ApiConstant.ENDPOINT.USER_CURRENT)
        suspend fun authLogin(): BaseResponse<Auth>
        @POST(ApiConstant.ENDPOINT.AUTH_REGISTER)
        suspend fun authRegister(@Body registerEntity: RegisterEntity):BaseResponse<Register>
        @GET(ApiConstant.ENDPOINT.AUTH_LOGOUT)
        suspend fun logout(): BaseResponse<Logout>
        @POST(ApiConstant.ENDPOINT.AUTH_RESET_PASSWORD)
        suspend fun resetPassword(@Body email:String):BaseResponse<ResetPasword>
    }
}