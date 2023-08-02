package com.example.btl_mxh.ui.setting

import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.ui.notificationsetting.base.BaseFragment
import com.example.btl_mxh.ui.notificationsetting.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentSettingBinding

class SettingFragment : BaseFragment<FragmentSettingBinding>(FragmentSettingBinding::inflate) {
    override val viewModel: BaseViewModel
        get() = BaseViewModel()

    override fun initData() {
        
    }

    override fun handleEvent() {

    }

    override fun bindData() {
        binding.apply {
            changePassword.setOnClickListener {
                findNavController().navigate(R.id.action_settingFragment_to_changePasswordFragment)
            }
            notification.setOnClickListener {
                findNavController().navigate(R.id.action_settingFragment_to_notificationSettingFragment)
            }
            logOut.setOnClickListener {
            }
            editProfile.setOnClickListener {
                findNavController().navigate(R.id.action_settingFragment_to_editProfileFragment)
            }
            savePost.setOnClickListener {
                findNavController().navigate((R.id.action_settingFragment_to_savedPostsFragment))
            }

        }
    }

}