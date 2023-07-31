package com.example.btl_mxh.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.base.DataResult
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.data.remote.repository.search.ISearchRepository
import com.example.btl_mxh.model.Auth
import kotlinx.coroutines.delay

private const val TAG = "HomeViewModel"

class HomeViewModel(
    private val accountRepo: IAccountRepository
) : BaseViewModel() {

}