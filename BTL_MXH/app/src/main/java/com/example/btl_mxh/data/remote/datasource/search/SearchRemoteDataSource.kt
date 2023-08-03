package com.example.btl_mxh.data.remote.datasource.search

import com.example.btl_mxh.data.service.ApiService
import com.example.btl_mxh.model.Search

class SearchRemoteDataSource(private val service: ApiService.SearchService) :
    ISearchDataSource.Remote {


    override suspend fun searchByName(searchKey: String): Search {
        return service.searchByName(searchKey)
    }


}