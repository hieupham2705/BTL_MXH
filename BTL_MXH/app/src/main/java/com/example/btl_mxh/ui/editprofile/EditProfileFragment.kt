package com.example.btl_mxh.ui.editprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentEditProfileBinding

class EditProfileFragment : BaseFragment<FragmentEditProfileBinding>(FragmentEditProfileBinding::inflate) {
    override val viewModel: EditProfileViewModel
        get() = ViewModelProvider(this)[EditProfileViewModel::class.java]

    override fun initData() {
        // khoong duoc viet binding
    }

    override fun handleEvent() {
        
    }

    override fun bindData() {
        
    }


}