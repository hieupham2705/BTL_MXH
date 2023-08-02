package com.example.btl_mxh.data.remote.repository.search

import com.example.btl_mxh.base.BaseRepository
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.data.remote.datasource.search.ISearchDataSource
import com.example.btl_mxh.model.Search

class SearchRepositoryImpl(private val remote: ISearchDataSource.Remote) : BaseRepository(),
    ISearchRepository {

    override suspend fun searchByName(searchKey: String): DataResult<Search> =
        getResult { remote.searchByName(searchKey) }
}