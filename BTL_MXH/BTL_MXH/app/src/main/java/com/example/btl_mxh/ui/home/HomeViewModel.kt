package com.example.btl_mxh.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.base.DataResult
import kotlinx.coroutines.delay

class HomeViewModel:BaseViewModel() {
    private val _stateLogin = MutableLiveData<List<String>>()
    val stateLogin: LiveData<List<String>> = _stateLogin

    fun logIn() {
        executeTask(
            request = { callApiLogin() },
            onSuccess = {
                _stateLogin.value = it
            },
            onError = {
//                _stateLogin.value = Pair(true, it.message.toString())
            }
        )
    }

    suspend fun callApiLogin(): DataResult<List<String>> {
        return DataResult.Success<List<String>>(listOf("Hung, Hieu"))

    }
}