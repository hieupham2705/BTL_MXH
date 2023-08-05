package com.example.btl_mxh.data.remote.datasource.search

import Search
import com.example.btl_mxh.base.BaseResponse

interface ISearchDataSource {
    interface Local{

    }
    interface Remote{
        suspend fun searchUserId(id:String) : BaseResponse<Search>
    }
}