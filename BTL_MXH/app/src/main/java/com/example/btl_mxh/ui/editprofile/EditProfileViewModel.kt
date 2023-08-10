package com.example.btl_mxh.ui.editprofile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.profile.IProfileRepository
import com.example.btl_mxh.model.UpdateProfiledata
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

private const val TAG = "EditProfileViewModel"

class EditProfileViewModel(
    private val profilerepo: IProfileRepository
) : BaseViewModel() {
    private val _stateUpdateProfile = MutableLiveData<UpdateProfiledata>()
    val stateUpdateProfile: LiveData<UpdateProfiledata>
        get() = _stateUpdateProfile

    fun updateProfile(
        birthday: RequestBody,
        gender: RequestBody,
        avatar: MultipartBody.Part,
        fullName: RequestBody,
        username: RequestBody,
        email: RequestBody
    ) {
        executeTask(
            request = {
                profilerepo.updateProfile(
                    birthday,
                    gender,
                    avatar,
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

<<<<<<< HEAD
class EditProfileViewModel: BaseViewModel() {
=======
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb
}