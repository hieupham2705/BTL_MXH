package com.example.btl_mxh.ui.sign_in

import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentSignInBinding
import com.example.btl_mxh.utils.extension.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel


class SignInFragment : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {
    override val viewModel by viewModel<SignInViewModel>()
    override fun initData() {

    }

    override fun handleEvent() {
        binding.apply {
            signIn.setOnClickListener {
                if (email.text.toString().isEmpty() && password.text.toString().isEmpty()) {
                    showToast("Please enter full password information !")
                } else {
                    viewModel.logIn(
                        email.text.toString(),
                        password.text.toString(),
                        rememberMe.isChecked
                    )
                }
            }
            forgotPassword.setOnClickListener {
                findNavController().navigate(R.id.action_signInFragment_to_forgotPasswordFragment)
            }
            register.setOnClickListener {
                findNavController().navigate((R.id.action_signInFragment_to_registerFragment))
            }
        }
    }

    override fun bindData(){
        viewModel.stateLogin.observe(viewLifecycleOwner) {
//            viewModel.auth()
            findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
            showToast("Logged in successfully !")
        }
        viewModel.stateAuth.observe(viewLifecycleOwner){
        }
        viewModel.isError.observe(viewLifecycleOwner) {
            showToast(it)
        }
    }

}