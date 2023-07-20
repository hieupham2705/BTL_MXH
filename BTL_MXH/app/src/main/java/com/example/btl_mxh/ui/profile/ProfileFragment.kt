package com.example.btl_mxh.ui.profile

import android.app.Dialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentProfileBinding
import com.example.btl_mxh.utils.extension.start

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    private val adapterProfile by lazy {
        ProfileAdapter(
            ::onclickSetting
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
            adapterProfile.setList(viewModel.list)
            recyclerviewProfile.adapter = adapterProfile
        }
    }

    fun onclickSetting() {
        findNavController().navigate(R.id.action_profileFragment_to_settingFragment)
    }

}
