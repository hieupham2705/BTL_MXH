package com.example.btl_mxh.ui.changepassword

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.model.ChangePassword
import com.example.btl_mxh.model.ResetPasword

private const val TAG = "ChangePasswordViewModel"

class ChangePasswordViewModel(
    private val accountRepo: IAccountRepository
) : BaseViewModel() {
    private val _stageChangePassword = MutableLiveData<ResetPasword>()
    val stageChangePassword: LiveData<ResetPasword> = _stageChangePassword

    fun changePassword(currentPassword: String, newPassword: String) {
        executeTask(
            request = { accountRepo.changePassword(ChangePassword(currentPassword,newPassword)) },
            onSuccess = {
                if (it.status == "SUCCESS") {
                    it.data?.let { _changePassword ->
                        _stageChangePassword.value = _changePassword
                    }
                }
                else Log.e(TAG, "changePassword: ${it.message}", )
            },
            onError = {
                Log.e(TAG, "changePassword: ${it.message}")
            },
            showLoading = true
)
}
}