package com.example.btl_mxh.ui.sign_in

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.model.Auth
import com.example.btl_mxh.model.Login
import com.example.btl_mxh.model.LoginEntity
import com.example.btl_mxh.utils.extension.saveTokenLogin
import com.example.btl_mxh.utils.extension.saveUserId


private const val TAG = "SignInViewModel"

class SignInViewModel(
    private val accountRepo: IAccountRepository,
    private val sharedPreferences: SharedPreferences
) : BaseViewModel() {
    private val _stateLogin = MutableLiveData<Login>()
    val stateLogin: LiveData<Login>
        get() = _stateLogin

    fun logIn(email: String, password: String, checkSavePassword: Boolean) {
        executeTask(
            request = { accountRepo.login(LoginEntity(email, password)) },
            onSuccess = {
                if (it.status == "SUCCESS") {
                    it.data?.let { _login ->
                        if (checkSavePassword)
                            sharedPreferences.saveTokenLogin(_login.accessToken)
                        sharedPreferences.saveUserId(_login.id)
                        _stateLogin.value = _login
                    }
                } else {
                    Log.e(TAG, "logIn: ${it.message}")
                }
            },
            onError = {
                Log.e(TAG, "login:${it.message.toString()}")
            }, showLoading = true
        )
    }



}