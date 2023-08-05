package com.example.btl_mxh.di

import com.example.btl_mxh.data.remote.datasource.account.IAccountDataSource
import com.example.btl_mxh.data.remote.datasource.account.AccountRemoteDataSource
import com.example.btl_mxh.data.remote.datasource.post.IPostDataSource
import com.example.btl_mxh.data.remote.datasource.post.PostRemoteDataSource
import com.example.btl_mxh.data.remote.datasource.profile.IProfileDataSource
import com.example.btl_mxh.data.remote.datasource.profile.ProfileRemoteDataSource
import com.example.btl_mxh.data.remote.datasource.search.ISearchDataSource
import com.example.btl_mxh.data.remote.datasource.search.SearchRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<ISearchDataSource.Remote> { SearchRemoteDataSource(get()) }
    single<IAccountDataSource.Remote> { AccountRemoteDataSource(get()) }
    single<IPostDataSource.Remote> { PostRemoteDataSource(get()) }
    single<IProfileDataSource.Remote> { ProfileRemoteDataSource(get()) }
}