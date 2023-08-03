package com.example.btl_mxh.ui.home


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.base.DataResult
import kotlinx.coroutines.delay
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.data.remote.repository.post.IPostRepository
import com.example.btl_mxh.data.remote.repository.search.ISearchRepository
import com.example.btl_mxh.model.Auth
import com.example.btl_mxh.model.PostGetAll
import kotlinx.coroutines.delay
private const val TAG = "HomeViewModel"

class HomeViewModel: BaseViewModel() {
    private val _stateLogin = MutableLiveData<List<String>>()
    val stateLogin: LiveData<List<String>> = _stateLogin




class HomeViewModel(
    private val accountRepo: IAccountRepository,
    private val postRepo: IPostRepository
) : BaseViewModel() {
    private val _stateAuth = MutableLiveData<Auth>()
    val stateAuth: LiveData<Auth> = _stateAuth

    private val _statePostGetAll = MutableLiveData<PostGetAll>()
    val statePostGetAll: LiveData<PostGetAll> = _statePostGetAll
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
                Log.e(TAG,it.data.toString())
            },
            onError = {
                Log.e(TAG, "login:${it.message.toString()}")
            }
        )
    }
}