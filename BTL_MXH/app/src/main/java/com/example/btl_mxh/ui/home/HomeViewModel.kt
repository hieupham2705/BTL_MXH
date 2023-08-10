package com.example.btl_mxh.ui.home

import Search
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.data.remote.repository.post.IPostRepository
import com.example.btl_mxh.data.remote.repository.profile.IProfileRepository
import com.example.btl_mxh.data.remote.repository.search.ISearchRepository
import com.example.btl_mxh.model.Auth
import com.example.btl_mxh.model.Post

private const val TAG = "HomeViewModel"

class HomeViewModel(
    private val accountRepo: IAccountRepository,
    private val postRepo: IPostRepository,
    private val searchRepo: ISearchRepository
) : BaseViewModel() {
    private val _stateAuth = MutableLiveData<Auth>()
    val stateAuth: LiveData<Auth> = _stateAuth

    private val _statePostGetAll = MutableLiveData<List<Post>>()
    val statePostGetAll: LiveData<List<Post>> = _statePostGetAll

    private val _stateSearchUserId = MutableLiveData<Search>()
    val stateSearchUserId: LiveData<Search> = _stateSearchUserId
    fun auth() {
        executeTask(
            request = { accountRepo.authLogin() },
            onSuccess = {
                _stateAuth.value = it.data!!
            },
            onError = {
                Log.e(TAG, "login:${it.message.toString()}")

            }
        )
    }

    fun postGetAll() {
        executeTask(
            request = { postRepo.postGetAll() },
            onSuccess = {
                _statePostGetAll.value = it.data!!
                Log.e(TAG, it.data.toString())
            },
            onError = {
                Log.e(TAG, "login:${it.message.toString()}")
            },
            showLoading = true
        )
    }

    fun searchUserId(id: String) {
        executeTask(
            request = { searchRepo.searchUserId(id) },
            onSuccess = {
                if (it.status == "SUCCESS") {
                    it.data?.let { _search ->
                        _stateSearchUserId.value = _search
                    }
                } else
                    Log.e(TAG, "login:${it.message.toString()}")
            },
            onError = {
                Log.e(TAG, "login:${it.message.toString()}")
            }
        )
    }
}