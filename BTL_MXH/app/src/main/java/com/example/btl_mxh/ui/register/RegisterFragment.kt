package com.example.btl_mxh.ui.register

import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentRegisterBinding
import com.example.btl_mxh.model.RegisterEntity
import com.example.btl_mxh.utils.extension.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    override val viewModel by viewModel<RegisterViewModel>()
    private lateinit var Email: String
    private lateinit var UserName: String
    private lateinit var Phone: String
    private lateinit var FullName: String
    override fun initData() {

    }

    override fun handleEvent() {
        binding.apply {
            signIn.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_signInFragment)
            }
            next.setOnClickListener {
                if(check()){
                    Email = email.text.toString()
                    UserName = username.text.toString()
                    Phone = phone.text.toString()
                    FullName = fullname.text.toString()
                    val registerEntity = RegisterEntity(Email, "", FullName, UserName, Phone)
                    if (Email.isEmpty() || UserName.isEmpty() || Phone.isEmpty() || FullName.isEmpty())
                        showToast("Vui lòng nhập đầy đủ thông tin")
                    else
                        findNavController().navigate(R.id.action_registerFragment_to_registerPasswordFragment,
                            bundleOf("register" to registerEntity))
                }
            }
        }
    }

    override fun bindData() {

    }
    fun check() : Boolean{
        binding.apply {
            val Email = viewModel.checkEmail(email.text.toString())
            val Phone = viewModel.checkPhone(phone.text.toString())
            if (!Email||!Phone){
                if(!Email)
                    textInputLayoutEmail.error = "Please enter a valid email address !"
                else
                    textInputLayoutEmail.error = null
                if(!Phone)
                    textInputLayoutPhone.error = "Phone number must be 10 digits !"
                else
                    textInputLayoutPhone.error = null
                return false
            }
            return true
        }
    }
}