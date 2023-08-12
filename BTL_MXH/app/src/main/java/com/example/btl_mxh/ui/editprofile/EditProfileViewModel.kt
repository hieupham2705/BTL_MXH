package com.example.btl_mxh.ui.editprofile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.data.remote.repository.profile.IProfileRepository
import com.example.btl_mxh.model.Auth
import com.example.btl_mxh.model.UpdateProfiledata
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

private const val TAG = "EditProfileViewModel"

class EditProfileViewModel(
    private val profilerepo: IProfileRepository,
    private val accountRepo : IAccountRepository
) : BaseViewModel() {
    private val _stateUpdateProfile = MutableLiveData<UpdateProfiledata>()
    val stateUpdateProfile: LiveData<UpdateProfiledata>
        get() = _stateUpdateProfile

    private val _stateAuth = MutableLiveData<Auth>()
    val stateAuth: LiveData<Auth> = _stateAuth

    fun updateProfile(
        birthday: RequestBody,
        gender: RequestBody,
        image: File?,
        fullName: RequestBody,
        username: RequestBody,
        email: RequestBody
    ) {
        val imageRequestBody = image?.asRequestBody("image/*".toMediaType())
        val imagePart = imageRequestBody?.let {
            MultipartBody.Part.createFormData(
                "avatar",
                image?.name,
                it
            )
        }
        executeTask(
            request = {
                profilerepo.updateProfile(
                    birthday,
                    gender,
                    imagePart,
                    fullName,
                    username,
                    email
                )
            },
            onSuccess = {
                if (it.status == "SUCCESS") {
                    it.data?.let { _updateProfile ->
                        _stateUpdateProfile.value = _updateProfile
                    }
                } else {
                    Log.e(TAG, "update : ${it.message}")
                }
            },

            onError = { Log.e(TAG, "update : ${it.message}") },
            showLoading = true
        )
    }
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

    fun checkEmail(email: String): Boolean {
        if (email.contains("@gmail.com") && email.length > 15)
            return true
        return false
    }

    fun checkPhone(phone: String): Boolean {
        if (phone.length == 10)
            return true
        return false
    }

}