package com.example.btl_mxh.ui.forgotpassword

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.model.ResetPasword
private const val TAG = "FogotPasswordViewModel"
class FogotPasswordViewModel(
    private val accountRepo: IAccountRepository
) : BaseViewModel() {
    private val _resetPassword = MutableLiveData<ResetPasword>()
    val resetPassword: LiveData<ResetPasword>
        get() = _resetPassword

    fun fogotPassword(email: String) {
        executeTask(
            request = { accountRepo.resetPassword(email) },
            onSuccess = {
                if (it.status == "SUCCESS") {
                    it.data?.let { _reset ->
                        _resetPassword.value = _reset
                    }
                } else {
                    Log.e(TAG, "logIn: ${it.message}")
                }

            },
            showLoading = true
        )
    }
}