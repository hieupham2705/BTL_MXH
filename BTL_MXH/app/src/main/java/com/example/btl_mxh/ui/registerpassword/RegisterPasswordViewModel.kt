package com.example.btl_mxh.ui.registerpassword

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.model.Register
import com.example.btl_mxh.model.RegisterEntity

private const val TAG = "RegisterViewModel"

class RegisterPasswordViewModel(
    private val accountRepo: IAccountRepository
) : BaseViewModel() {
    private val _register = MutableLiveData<Register>()
    val register: LiveData<Register> = _register


    fun register(registerEntity: RegisterEntity) {
        executeTask(
            request = { accountRepo.register(registerEntity) },
            onSuccess = {
                if (it.status == "SUCCESS") {
                    it.data?.let {
                        _register.value = it
                    }
                } else {
                    Log.e(TAG, "Registerr: ${it.message.toString()}")
                }

            },
            onError = {
                Log.e(TAG, "Register: ${it.message.toString()}")
            }, showLoading = true
        )
    }

    fun checkPassword(password: String): Boolean {
        if (password.length >= 8 && !hasSpecialCharacters(password))
            return true
        return false
    }

    fun hasSpecialCharacters(input: String): Boolean {
        val regex = Regex("[^A-Za-z0-9 ]")
        return regex.containsMatchIn(input)
    }
}