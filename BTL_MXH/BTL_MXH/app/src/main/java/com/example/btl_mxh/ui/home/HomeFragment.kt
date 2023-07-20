package com.example.btl_mxh.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentHomeBinding

private const val TAG = "HomeFragment"
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val adapterPost by lazy { HomeAdapter(
        onClickPost = {},
        onClickSearch = {text ->
            Log.e(TAG, ": click search ${text}", )
        },
        ::onClickCreatePost
    ) }
    override val viewModel: HomeViewModel
        get() = ViewModelProvider(this)[HomeViewModel::class.java]

    override fun initData() {
            viewModel.logIn()
    }

    override fun handleEvent() {

    }

    override fun bindData() {
        viewModel.stateLogin.observe(this){
            adapterPost.setAdapter(it)
        }
        binding.recyclerview.adapter = adapterPost
    }

    fun onClickSearch()
    {
        findNavController().navigate(R.id.action_homeFragment_to_searchFragment)

    }

    fun onClickCreatePost()
    {
        findNavController().navigate(R.id.action_homeFragment_to_addTextFragment)
    }


}