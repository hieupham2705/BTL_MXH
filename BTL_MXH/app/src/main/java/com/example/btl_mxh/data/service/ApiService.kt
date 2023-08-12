package com.example.btl_mxh.data.service

import GetFollowing
import Search
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.model.*
import com.example.btl_mxh.utils.constant.ApiConstant
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

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

        @POST(ApiConstant.ENDPOINT.CHANGE_PASSWORD)
        suspend fun changePassword(@Body changePassword: ChangePassword): BaseResponse<ResetPasword>
        @GET(ApiConstant.ENDPOINT.USER + "/{userId}")
        suspend fun getById(@Path("userId") userId: String):BaseResponse<GetById>
    }

    interface PostService {
        @GET(ApiConstant.ENDPOINT.POST_GET_ALL)
        suspend fun postGetAll(): BaseResponse<List<Post>>

        @Multipart
        @POST(ApiConstant.ENDPOINT.POST_CREATE_NEW_POST)
        suspend fun createNewPost(
            @Part(ApiConstant.FILED.CAPTION) caption: RequestBody,
            @Part files: List<MultipartBody.Part>?
        ): BaseResponse<CreateNewPost>

        @GET(ApiConstant.ENDPOINT.GET_ALL_BY_USER_NAME + "/{user_name}")
        suspend fun getAllByUsername(
            @retrofit2.http.Path("user_name") userName: String,
        ): BaseResponse<List<Post>>
        @GET(ApiConstant.ENDPOINT.GET_ALL_BY_USER_ID + "/{userId}")
        suspend fun getAllByUserid(
            @retrofit2.http.Path("userId") userId: String,
        ): BaseResponse<List<Post>>

        @DELETE(ApiConstant.ENDPOINT.POST + "/{id}")
        suspend fun deletePost(@Path("id") id: String): BaseResponse<Delete>

        @Multipart
        @PATCH(ApiConstant.ENDPOINT.GET_ALL_BY_USER_NAME + "/{user_name}")
        suspend fun editPost(
            @Part(ApiConstant.FILED.CAPTION) caption: RequestBody,
            @Part files: List<MultipartBody.Part>?
        ):BaseResponse<CreateNewPost>
    }

    interface ProfileService {
        @PATCH(ApiConstant.ENDPOINT.USER)
        @Multipart
        suspend fun updatePost(
            @Part("birthday") birthday: RequestBody,
            @Part("gender") gender: RequestBody,
            @Part avatar: MultipartBody.Part?,
            @Part("fullName") fullName: RequestBody,
            @Part("username") username: RequestBody,
            @Part("email") email: RequestBody,
        ): BaseResponse<UpdateProfiledata>
    }
    interface FollowService{
        @GET(ApiConstant.ENDPOINT.USER+"/{userId}/followers")
        suspend fun getFolowers(
            @Path("userId") userId: String
        ):BaseResponse<GetFollowers>
        @DELETE(ApiConstant.ENDPOINT.FOLLOW+"/{userId}")
        suspend fun unFollow(
            @Path("userId") userId: String
        ):BaseResponse<Delete>
        @POST(ApiConstant.ENDPOINT.FOLLOW+"/{userId}")
        suspend fun follow(
            @Path("userId") userId: String
        ):BaseResponse<Follow>
        @GET(ApiConstant.ENDPOINT.USER+"/{userId}"+"followers")
        suspend fun getFollowing(@Path("userId") userId: String):BaseResponse<GetFollowing>
    }
}