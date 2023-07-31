package com.example.btl_mxh.di

import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.data.remote.repository.account.AccountRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
//    single<ISearchRepository> { SearchRepositoryImpl(get()) }
    single<IAccountRepository> { AccountRepositoryImpl(get()) }
}
