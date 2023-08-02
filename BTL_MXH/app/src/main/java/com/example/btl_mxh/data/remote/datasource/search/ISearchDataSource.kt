package com.example.btl_mxh.data.remote.datasource.search

import com.example.btl_mxh.model.Search

interface ISearchDataSource {
    interface Local{
        suspend  fun searchByNameLocal(searchKey: String): Search
    }
    interface Remote{
      suspend  fun searchByName(searchKey: String): Search
    }
}