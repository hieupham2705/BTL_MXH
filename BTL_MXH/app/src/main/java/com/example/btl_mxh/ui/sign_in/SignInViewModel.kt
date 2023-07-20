package com.example.btl_mxh.ui.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.base.DataResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SignInViewModel : BaseViewModel() {

    private val emailTrue = "123"
    private val passTrue = "456"
    private val _stateLogin = MutableLiveData<Pair<Boolean, String>>()
    val stateLogin: LiveData<Pair<Boolean, String>> = _stateLogin

    fun logIn(email: String, pass: String) {
        executeTask(
            request = { callApiLogin(email, pass) },
            onSuccess = {
                _stateLogin.value = Pair(true, it)
            },
            onError = {
                _stateLogin.value = Pair(true, it.message.toString())
            }
        )
    }

    suspend fun callApiLogin(email: String, pass: String): DataResult<String> {
        delay(3000)
        if (email == emailTrue && passTrue == pass)
            return DataResult.Success<String>("Thành công")
        return DataResult.Error(Exception("Tài khoản sai !"))
    }
}