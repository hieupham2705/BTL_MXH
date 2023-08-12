package com.example.btl_mxh.ui.changepassword

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
import com.example.btl_mxh.databinding.FragmentChangePasswordBinding
import com.example.btl_mxh.utils.extension.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChangePasswordFragment :
    BaseFragment<FragmentChangePasswordBinding>(FragmentChangePasswordBinding::inflate) {
    override val viewModel by viewModel<ChangePasswordViewModel>()

    override fun initData() {

    }

    override fun handleEvent() {
        binding.apply {
            update.setOnClickListener {
                val newPassWord = edtNewpassword.text.toString()
                val newPassWordAgain = edtNewpasswordAgain.text.toString()
                if(newPassWord.isEmpty()||newPassWordAgain.isEmpty()||currentPassword.text.toString().isEmpty())
                    showToast("Please enter all information !")
                else if (newPassWord == newPassWordAgain) {
                    viewModel.changePassword(
                        currentPassword.text.toString(),
                        edtNewpasswordAgain.text.toString()
                    )
                }
                else{
                    textInputLayout9.error="password incorrect"
                    textInputLayout9.focusedChild
                }
            }
        }
    }

    override fun bindData() {
        viewModel.stageChangePassword.observe(viewLifecycleOwner){
            showToast("Success !")
            findNavController().popBackStack()
        }
        viewModel.isError.observe(viewLifecycleOwner){
            showToast(it)
        }
    }

}