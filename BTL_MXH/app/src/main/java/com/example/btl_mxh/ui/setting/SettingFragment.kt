package com.example.btl_mxh.ui.setting

import android.app.Dialog
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentSettingBinding
import com.example.btl_mxh.ui.profile.viewModel
import com.example.btl_mxh.utils.extension.openDialogQuestion
import com.example.btl_mxh.utils.extension.showToast
class SettingFragment : BaseFragment<FragmentSettingBinding>(FragmentSettingBinding::inflate) {
    override val viewModel by viewModel<SettingViewModel>()

    override fun initData() {

    }

    override fun handleEvent() {
        binding.apply {
            changePassword.setOnClickListener {
                findNavController().navigate(R.id.action_settingFragment_to_changePasswordFragment)
            }
            notification.setOnClickListener {
                findNavController().navigate(R.id.action_settingFragment_to_notificationSettingFragment)
            }
            logOut.setOnClickListener {
                context?.let {
                    val dialogQuestion = Dialog(it)
                    dialogQuestion.openDialogQuestion(
                    ) {
                        viewModel.logout()
                        dialogQuestion.dismiss()
                        viewModel.logoutstage.observe(viewLifecycleOwner) {
                            findNavController().navigate(R.id.action_settingFragment_to_signInFragment)
                            showToast("Sign out successful !")
                        }
                        viewModel.isError.observe(viewLifecycleOwner) {
                            showToast(viewModel.isError.toString())
                        }
                    }
                }
            }
            editProfile.setOnClickListener {
                findNavController().navigate(R.id.action_settingFragment_to_editProfileFragment)

            }
            savePost.setOnClickListener {
                findNavController().navigate((R.id.action_settingFragment_to_savedPostsFragment))
            }

        }
    }

    override fun bindData() {
    }

}