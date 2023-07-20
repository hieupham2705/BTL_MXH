package com.example.btl_mxh.ui.setting

import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentSettingBinding

class SettingFragment : BaseFragment<FragmentSettingBinding>(FragmentSettingBinding::inflate) {
    override val viewModel: BaseViewModel
        get() = BaseViewModel()

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
            editSetting.setOnClickListener {
                findNavController().navigate( R.id.action_settingFragment_to_editProfileFragment)
            }

        }
    }

    override fun bindData() {
        
    }

}