package com.example.btl_mxh.ui.profile

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.ui.notificationsetting.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentProfileBinding


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val adapterProfile by lazy {
        ProfileAdapter(
            ::onclickSetting,
            :: onClickImage
        )
    }

    override val viewModel: ProfileViewModel
        get() = ViewModelProvider(this)[ProfileViewModel::class.java]

    override fun initData() {

    }

    override fun handleEvent() {

    }

    override fun bindData() {
        binding.apply {
            adapterProfile.setListProfile(viewModel.list)
            recyclerviewProfile.adapter = adapterProfile
        }
    }

    fun onclickSetting() {
        findNavController().navigate(R.id.action_profileFragment_to_settingFragment)
    }

    private fun onClickImage() {
        findNavController().navigate(R.id.action_profileFragment_to_myPostsFragment)
    }


}
