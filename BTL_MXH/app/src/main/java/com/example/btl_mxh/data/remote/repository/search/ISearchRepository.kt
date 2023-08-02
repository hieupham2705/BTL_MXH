package com.example.btl_mxh.data.remote.repository.search

import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.model.Search

interface ISearchRepository {
    suspend fun searchByName(searchKey: String): DataResult<Search>

}