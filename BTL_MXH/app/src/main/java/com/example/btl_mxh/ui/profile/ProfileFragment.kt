package com.example.btl_mxh.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.util.Log
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentProfileBinding

private const val TAG = "ProfileFragment"

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val adapterProfile by lazy {
        ProfileAdapter(
            ::onclickSetting,
            :: onClickImage
        )
    }

    override val viewModel: ProfileViewModel
        get() = ViewModelProvider(this)[ProfileViewModel::class.java]
            onclickSetting = { findNavController().navigate(R.id.action_profileFragment_to_settingFragment) }
        )
    }
    override val viewModel by viewModel<ProfileViewModel>()

    override fun initData() {
        viewModel.auth()
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


        viewModel.stateAuth.observe(viewLifecycleOwner) {
            viewModel.getAllByUsername(it.username)
            adapterProfile.setData(it)
            Log.e(TAG, it.toString())
        }
        viewModel.stateAllPost.observe(viewLifecycleOwner) {
            adapterProfile.setData(list = it)
        }
        binding.recyclerviewProfile.adapter = adapterProfile
    }

}
