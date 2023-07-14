package com.example.btl_mxh.ui.register

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentRegisterBinding


class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    override val viewModel: RegisterViewModel
        get() = ViewModelProvider(this)[RegisterViewModel::class.java]

    override fun initData() {
        
    }

    override fun handleEvent() {
        binding.apply {
            signIn.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_signInFragment)
            }
            next.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_registerPasswordFragment)
            }
        }
    }

    override fun bindData() {
        
    }

}