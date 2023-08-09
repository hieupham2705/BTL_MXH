package com.example.btl_mxh.data.service

import Search
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.model.*
import com.example.btl_mxh.utils.constant.ApiConstant
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*
import java.io.File

// chueyn doi giao thuc thanh code
interface ApiService {

    interface SearchService {
        @GET(ApiConstant.ENDPOINT.USER + "/{id}")
        suspend fun searchUserId(
            @retrofit2.http.Path("userId") userId: String,
            @Query("q") searchKey: String = "_h"
        ): BaseResponse<Search>
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
            @Part images: List<MultipartBody.Part>?
        ): BaseResponse<CreateNewPost>

        @GET(ApiConstant.ENDPOINT.GET_ALL_BY_USER_NAME + "/{user_name}")
        suspend fun getAllByUsername(
            @retrofit2.http.Path("user_name") userName : String,
        ): BaseResponse<List<Post>>
    }

    interface ProfileService {
        @PATCH(ApiConstant.ENDPOINT.USER)
        @FormUrlEncoded
        suspend fun updatePost(
            @Field("birthday") birthday: String,
            @Field("gender") gender: String,
            @Field("avatar") avatar: File,
            @Field("fullName") fullName: String,
            @Field("username") username: String,
            @Field("email") email: String,
        ): BaseResponse<UpdateProfiledata>
    }
}