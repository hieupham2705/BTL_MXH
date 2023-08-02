package com.example.btl_mxh.ui.forgotpassword

import android.app.Dialog
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentForgotPasswordBinding
import com.example.btl_mxh.ui.sign_in.SignInViewModel
import com.example.btl_mxh.utils.extension.openDialogNotification
import com.example.btl_mxh.utils.extension.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForgotPasswordFragment :
    BaseFragment<FragmentForgotPasswordBinding>(FragmentForgotPasswordBinding::inflate) {
    override val viewModel by viewModel<FogotPasswordViewModel>()

    override fun initData() {

    }

    override fun handleEvent() {
        binding.apply {
            signIn.setOnClickListener {
                findNavController().navigate(R.id.action_forgotPasswordFragment_to_signInFragment)
            }
            submit.setOnClickListener {
                viewModel.fogotPassword(email.text.toString())
            }
        }
    }

    override fun bindData() {
        viewModel.resetPassword.observe(viewLifecycleOwner) {
            context?.let {
                val dialogQuestion = Dialog(it)
                dialogQuestion.openDialogNotification()
            }
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_signInFragment)
        }
        viewModel.isError.observe(viewLifecycleOwner) {
            showToast(it)
        }
    }

}