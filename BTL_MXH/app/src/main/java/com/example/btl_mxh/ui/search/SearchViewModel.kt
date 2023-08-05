package com.example.btl_mxh.ui.search

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository

private const val TAG = "SeachViewModel"

class SearchViewModel(

    private val loginRepo: IAccountRepository,
    private val sharedPreferences: SharedPreferences,
//    private val searchRepo: ISearchRepository
) : BaseViewModel() {



}