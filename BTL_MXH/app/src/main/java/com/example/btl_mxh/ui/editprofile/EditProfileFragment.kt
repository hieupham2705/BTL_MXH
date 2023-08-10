package com.example.btl_mxh.ui.editprofile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentEditProfileBinding
import com.example.btl_mxh.utils.extension.FileUtils
import com.example.btl_mxh.utils.extension.showToast
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File

private const val TAG = "EditProfileFragment"
class EditProfileFragment :
    BaseFragment<FragmentEditProfileBinding>(FragmentEditProfileBinding::inflate) {
    private var image: String? = null
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
            btnUpdate.setOnClickListener {
                if (check() && checkInput()) {
                    if (image == null)
                        showToast("Please choose a profile picture !")
                    else {
                        val imageFile = File(image)
                        val imageRequestBody = imageFile.asRequestBody("image/*".toMediaType())
                        val imagePart = MultipartBody.Part.createFormData(
                            "avatar",
                            imageFile.name,
                            imageRequestBody
                        )
                        viewModel.updateProfile(
                            RequestBody.create(
                                "birthday/plain".toMediaTypeOrNull(),
                                edtBirthday.text.toString()
                            ),
                            RequestBody.create(
                                "gender/plain".toMediaTypeOrNull(),
                                edtGender.text.toString()
                            ),
                            imagePart,
                            RequestBody.create(
                                "fullName/plain".toMediaTypeOrNull(),
                                edtFullName.text.toString()
                            ),
                            RequestBody.create(
                                "username/plain".toMediaTypeOrNull(),
                                edtUserName.text.toString()
                            ),
                            RequestBody.create(
                                "email/plain".toMediaTypeOrNull(),
                                edtEmail.text.toString()
                            )
                        )
                    }

                }


            }
        }
    }

    override fun bindData() {
        if (!checkInput())
            showToast("Please enter full information !")
        viewModel.stateUpdateProfile.observe(viewLifecycleOwner) {
            findNavController().popBackStack()
            showToast("success !")
        }
        viewModel.isError.observe(viewLifecycleOwner) {
            showToast(it)
        }
    }

    fun check(): Boolean {
        binding.apply {
            val email = viewModel.checkEmail(edtEmail.text.toString())
            val gender = edtGender.text.toString()
            if (gender != "MALE" && gender != "FEMALE") {
                textInputLayoutGender.error = "MALE OR FEMALE"
            }
            if (!email) {
                textInputLayoutEmail.error = "Please enter a valid email address !"
                return false
            }


        }
        return true
    }

    fun checkInput(): Boolean {
        binding.apply {
            if (edtEmail.text.toString().isEmpty() || edtBirthday.text.toString()
                    .isEmpty() || edtGender.text.toString().isEmpty() || edtFullName.text.toString()
                    .isEmpty() || edtUserName.text.toString().isEmpty()
            )
                return false
        }
        return true
    }

    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            Log.e(TAG,"hiu")
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                Log.e(TAG,image.toString())
                if (data != null) {
                    val imageUri = data.data
                    if (imageUri != null) {
                        binding.imvAvatar.setImageURI(imageUri)
                        image = FileUtils.uriToJpg(context!!.contentResolver,imageUri,requireContext())
                        Log.e(TAG,image.toString())
                    }
                }
            }
        }
}