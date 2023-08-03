package com.example.btl_mxh.data.service

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.model.*
import com.example.btl_mxh.utils.constant.ApiConstant
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

// chueyn doi giao thuc thanh code
interface ApiService {

    interface SearchService {
        @GET(ApiConstant.ENDPOINT.SEARCH_USER)
        suspend fun searchByName(@Query("q") searchKey: String): Search
    }

    interface AccountService {
        @POST(ApiConstant.ENDPOINT.AUTH_LOGIN)
        suspend fun login(@Body loginEntity: LoginEntity): BaseResponse<Login>

        @GET(ApiConstant.ENDPOINT.USER_CURRENT)
        suspend fun authLogin(): BaseResponse<Auth>

        @POST(ApiConstant.ENDPOINT.AUTH_REGISTER)
        suspend fun authRegister(@Body registerEntity: RegisterEntity): BaseResponse<Register>

        @GET(ApiConstant.ENDPOINT.AUTH_LOGOUT)
        suspend fun logout(): BaseResponse<Logout>

        @POST(ApiConstant.ENDPOINT.AUTH_RESET_PASSWORD)
        suspend fun resetPassword(@Body email: String): BaseResponse<ResetPasword>
    }

    interface PostService {
        @GET(ApiConstant.ENDPOINT.POST_GET_ALL)
        suspend fun postGetAll(): BaseResponse<List<Post>>

        @Multipart
        @POST(ApiConstant.ENDPOINT.POST_CREATE_NEW_POST)
        suspend fun createNewPost(
            @Part(ApiConstant.FILED.CAPTION) caption: RequestBody,
            @Part files: Array<MultipartBody.Part>
        ): BaseResponse<CreateNewPost>

    }
}