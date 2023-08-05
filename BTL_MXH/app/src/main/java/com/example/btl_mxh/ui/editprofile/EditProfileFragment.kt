package com.example.btl_mxh.ui.editprofile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentEditProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditProfileFragment :
    BaseFragment<FragmentEditProfileBinding>(FragmentEditProfileBinding::inflate) {
    override val viewModel by viewModel<EditProfileViewModel>()

    override fun initData() {
        // khoong duoc viet binding
    }

    override fun handleEvent() {
        binding.apply {
            imvCamera.setOnClickListener {
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.type = "image/*"
                galleryLauncher.launch(intent)
            }
        }
    }

    override fun bindData() {

    }

    fun check(): Boolean {
        binding.apply {
            val email = viewModel.checkEmail(edtEmail.text.toString())
            val gender = edtGender.text.toString()
            if (gender != "MALE" && gender != "FEMALE")
                textInputLayoutGender.error = "MALE OR FEMALE"
            if(!email)
                textInputLayoutEmail.error = "Please enter a valid email address !"
//            if (ed)
            return true
        }
    }

    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                if (data != null) {
                    val imageUri = data.data
                    if (imageUri != null) {
                        binding.imvAvatar.setImageURI(imageUri)
                    }
                }
            }
        }
}