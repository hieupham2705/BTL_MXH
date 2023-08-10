package com.example.btl_mxh.ui.setting

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.model.Logout
import com.example.btl_mxh.utils.extension.saveTokenLogin

class SettingViewModel(
    private val accountRepo: IAccountRepository,
    private val sharedPreferences: SharedPreferences
) : BaseViewModel() {
    private val _logoutstage = MutableLiveData<Logout>()
    val logoutstage: LiveData<Logout> = _logoutstage

    fun logout() {
        executeTask(
            request = { accountRepo.logout() },
            onSuccess = {
                if (it.status == "SUCCESS") {
                    it.data?.let { _logout ->
                        _logoutstage.value = _logout
                    }
                    sharedPreferences.saveTokenLogin("")
                }
                else{
                    Log.e("logout :" , it.message.toString())
                }
            },
            onError = {
                Log.e("logout :" , it.message.toString())
            },showLoading = true
        )
    }
}