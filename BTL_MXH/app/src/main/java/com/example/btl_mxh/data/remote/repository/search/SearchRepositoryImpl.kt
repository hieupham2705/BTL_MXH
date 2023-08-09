package com.example.btl_mxh.data.remote.repository.search

import Search
import com.example.btl_mxh.base.BaseRepository
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.data.remote.datasource.search.ISearchDataSource

class SearchRepositoryImpl(private val remote: ISearchDataSource.Remote) : BaseRepository(),
    ISearchRepository {
    override suspend fun searchUserId(id: String): DataResult<BaseResponse<Search>> = getResult {
        remote.searchUserId(id)
    }


}