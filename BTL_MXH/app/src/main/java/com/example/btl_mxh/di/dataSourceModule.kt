package com.example.btl_mxh.di

import com.example.btl_mxh.data.remote.datasource.account.IAccountDataSource
import com.example.btl_mxh.data.remote.datasource.account.AccountRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
//    single<ISearchDataSource.Remote> { SearchRemoteDataSource(get()) }
    single<IAccountDataSource.Remote> { AccountRemoteDataSource(get()) }
}