package com.example.btl_mxh.ui.forgotpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : BaseFragment<FragmentForgotPasswordBinding>(FragmentForgotPasswordBinding::inflate) {
    override val viewModel: FogotPasswordViewModel
        get() = ViewModelProvider(this)[FogotPasswordViewModel::class.java]

    override fun initData() {
        
    }

    override fun handleEvent() {
        binding.apply {
            signIn.setOnClickListener {
                findNavController().navigate(R.id.action_forgotPasswordFragment_to_signInFragment)
            }
        }
    }

    override fun bindData() {
        
    }

}