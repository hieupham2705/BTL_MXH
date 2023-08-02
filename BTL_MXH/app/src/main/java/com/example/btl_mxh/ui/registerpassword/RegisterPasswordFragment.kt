package com.example.btl_mxh.ui.registerpassword

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentRegisterPasswordBinding
import com.example.btl_mxh.model.RegisterEntity
import com.example.btl_mxh.utils.extension.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegisterPasswordFragment :
    BaseFragment<FragmentRegisterPasswordBinding>(FragmentRegisterPasswordBinding::inflate) {
    override val viewModel by viewModel<RegisterPasswordViewModel>()

    override fun initData() {

    }

    override fun handleEvent() {
        binding.apply {
            signIn.setOnClickListener {
                findNavController().navigate(R.id.action_registerPasswordFragment_to_signInFragment)
            }
            create.setOnClickListener {
                tvErrorCondition.isVisible = false
                tvErrorJoint.isVisible = false
                val PassWord = password.text.toString()
                val PassWordAgain = passwordAgain.text.toString()
                var registerEntity = arguments?.getParcelable<RegisterEntity>("register")
                registerEntity?.password = PassWord
                if (!PassWord.isEmpty() || !PassWordAgain.isEmpty()) {
                    if (PassWord != PassWordAgain) {
                        tvErrorJoint.isVisible = true
                    } else if (!viewModel.checkPassword(PassWord)) {
                        tvErrorCondition.isVisible = true
                    } else {
                        if (registerEntity != null) {
                            viewModel.register(registerEntity)
                        }
                    }
                } else {
                    showToast("Please enter full information")
                }
            }
        }
    }

    override fun bindData() {
        viewModel.register.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_registerPasswordFragment_to_signInFragment)
            showToast("Successful registration, please login !")
        }
        viewModel.isError.observe(viewLifecycleOwner){
            showToast(it)
        }
    }

}