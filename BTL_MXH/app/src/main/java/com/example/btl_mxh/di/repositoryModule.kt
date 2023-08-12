package com.example.btl_mxh.di

import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.data.remote.repository.account.AccountRepositoryImpl
import com.example.btl_mxh.data.remote.repository.follow.FollowRepositoryImpl
import com.example.btl_mxh.data.remote.repository.follow.IFollowRepository
import com.example.btl_mxh.data.remote.repository.post.IPostRepository
import com.example.btl_mxh.data.remote.repository.profile.IProfileRepository
import com.example.btl_mxh.data.remote.repository.post.PostRepositoryImpl
import com.example.btl_mxh.data.remote.repository.profile.ProfileRepositoryImpl
import com.example.btl_mxh.data.remote.repository.search.ISearchRepository
import com.example.btl_mxh.data.remote.repository.search.SearchRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<ISearchRepository> { SearchRepositoryImpl(get()) }
    single<IAccountRepository> { AccountRepositoryImpl(get()) }
    single<IPostRepository> { PostRepositoryImpl(get()) }
    single<IProfileRepository> { ProfileRepositoryImpl(get()) }
    single<IFollowRepository> { FollowRepositoryImpl(get()) }
}
