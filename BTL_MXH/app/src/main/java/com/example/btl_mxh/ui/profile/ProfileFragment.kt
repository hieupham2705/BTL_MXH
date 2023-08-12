package com.example.btl_mxh.ui.profile

import android.util.Log
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "ProfileFragment"

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    private val adapterProfile by lazy {
        ProfileAdapter(
            requireContext(),
            onclickSetting = { findNavController().navigate(R.id.action_profileFragment_to_settingFragment)},
            onClickFollower = {},
            onClickFollowing = {}
        )
    }
    override val viewModel by viewModel<ProfileViewModel>()

    override fun initData() {
        viewModel.auth()
    }

    override fun handleEvent() {

    }

    override fun bindData() {
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
