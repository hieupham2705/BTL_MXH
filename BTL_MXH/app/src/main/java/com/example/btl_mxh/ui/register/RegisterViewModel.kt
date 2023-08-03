package com.example.btl_mxh.ui.register

<<<<<<< HEAD
import com.example.btl_mxh.base.BaseViewModel
=======
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.model.Login
import com.example.btl_mxh.model.Register
import com.example.btl_mxh.model.RegisterEntity

class RegisterViewModel : BaseViewModel() {


    fun checkEmail(email: String): Boolean {
        if (email.contains("@gmail.com"))
            return true
        return false
    }

    fun checkPhone(phone: String): Boolean {
        if (phone.length == 10)
            return true
        return false
    }

}