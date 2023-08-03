package com.example.btl_mxh.ui.changepassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentChangePasswordBinding

class ChangePasswordFragment : BaseFragment<FragmentChangePasswordBinding>(FragmentChangePasswordBinding::inflate) {
    override val viewModel: ChangePasswordViewModel
        get() = ViewModelProvider(this)[ChangePasswordViewModel::class.java]

    override fun initData() {
        
    }

    override fun handleEvent() {
        
    }

    override fun bindData() {
        
    }

}