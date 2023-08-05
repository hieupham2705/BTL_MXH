package com.example.btl_mxh.ui.editprofile

import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.profile.IProfileRepository

class EditProfileViewModel(
    private val profilerepo : IProfileRepository
) : BaseViewModel() {







    fun checkEmail(email: String): Boolean {
        if (email.contains("@gmail.com")&&email.length>15)
            return true
        return false
    }

    fun checkPhone(phone: String): Boolean {
        if (phone.length == 10)
            return true
        return false
    }

}