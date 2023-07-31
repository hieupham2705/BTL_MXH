package com.example.btl_mxh.ui.home

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentHomeBinding
import com.example.btl_mxh.model.Auth
import com.example.btl_mxh.model.RegisterEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "HomeFragment"

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val adapter by lazy {
        HomeAdapter(
            onClickPost = {
            },
            onClickSearch = {
                findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
            },
            onClickCreatePost = {
                findNavController().navigate(R.id.action_homeFragment_to_addTextFragment)
            },
            onClickMessage = {
                findNavController().navigate(R.id.action_homeFragment_to_listMessFragment)
            },
            onClickimvavatarpost = {
                findNavController().navigate(R.id.action_homeFragment_to_friendFragment)
            }
        )
    }
    override val viewModel by viewModel<HomeViewModel>()
    override fun initData() {
    }

    override fun handleEvent() {
    }

    override fun bindData() {
        val auth = arguments?.getParcelable<Auth>("auth")
        Log.e(TAG,auth.toString())
        if (auth != null) {
            adapter.setAdapter(auth)
        }
        binding.recyclerview.adapter = adapter
    }

}
