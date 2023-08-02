package com.example.btl_mxh.ui.splash

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.model.Auth

private const val TAG = "SplashViewModel"

class SplashViewModel(
    private val accountRepo: IAccountRepository,
    private val sharedPreferences: SharedPreferences
) : BaseViewModel() {

    private val _stateAuth = MutableLiveData<BaseResponse<Auth>>()
    val stateAuth: LiveData<BaseResponse<Auth>> = _stateAuth
    fun auth() {
        executeTask(
            request = { accountRepo.authLogin() },
            onSuccess = {
                Log.e(TAG, it.toString())
                _stateAuth.value = it
                Log.e(TAG, it.toString())
            },
            onError = {
                Log.e(TAG, "login:${it.message.toString()}")

            }
        )
    }
}