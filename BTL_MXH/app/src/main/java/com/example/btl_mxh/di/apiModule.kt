package com.example.btl_mxh.di

import com.example.btl_mxh.data.service.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(ApiService.SearchService::class.java) }
    single { get<Retrofit>().create(ApiService.AccountService::class.java) }
    single { get<Retrofit>().create(ApiService.PostService::class.java) }
    single { get<Retrofit>().create(ApiService.ProfileService::class.java) }
    single { get<Retrofit>().create(ApiService.FollowService::class.java) }
}