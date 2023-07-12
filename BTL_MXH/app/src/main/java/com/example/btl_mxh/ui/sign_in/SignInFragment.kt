package com.example.btl_mxh.ui.sign_in

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentSignInBinding
import com.example.btl_mxh.utils.extension.showToast


class SignInFragment : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {
    override val viewModel: SignInViewModel
        get() = ViewModelProvider(this)[SignInViewModel::class.java]

    override fun initData() {

    }

    override fun handleEvent() {
        binding.apply {
            signIn.setOnClickListener {
                viewModel.logIn(
                    binding.email.text.toString(),
                    binding.password.text.toString()
                )
            }
            forgotPassword.setOnClickListener {
                findNavController().navigate(R.id.action_signInFragment_to_forgotPasswordFragment)
            }
            register.setOnClickListener {
                findNavController().navigate((R.id.action_signInFragment_to_registerFragment))
            }
        }
    }

    override fun bindData() {
        viewModel.stateLogin.observe(this) { _state ->
            if (_state.first) {
                findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
            } else {
                showToast(_state.second)
            }
        }
    }

}