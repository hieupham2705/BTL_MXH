package com.example.btl_mxh.data.remote.datasource.search

import Search
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.data.service.ApiService

class SearchRemoteDataSource(private val service: ApiService.SearchService) : ISearchDataSource.Remote {
    override suspend fun searchUserId(id: String): BaseResponse<Search> {
        return service.searchUserId(id)
    }

}