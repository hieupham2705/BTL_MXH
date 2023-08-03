package com.example.btl_mxh.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.R
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.model.Auth
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.model.profile
private const val TAG = "ProfileViewModel"
class ProfileViewModel : BaseViewModel() {
    val list = listOf<profile>(
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
    )


class ProfileViewModel(
    private val accountRepo: IAccountRepository
) : BaseViewModel() {
    private val _stateAuth = MutableLiveData<Auth>()
    val stateAuth: LiveData<Auth> = _stateAuth
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
}