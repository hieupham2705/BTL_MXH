package com.example.btl_mxh.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.ui.notificationsetting.base.BaseFragment
import com.example.btl_mxh.ui.notificationsetting.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    private val adapter by lazy { SearchAdapter(
        onclickFriend = {
            findNavController().navigate(R.id.action_searchFragment_to_friendFragment)
        }
    ) }
    override val viewModel: SearchViewModel
        get() = ViewModelProvider(this)[SearchViewModel::class.java]

    override fun initData() {

    }

    override fun handleEvent() {
        binding.apply {
            recyclerview.adapter = adapter
        }

    }

    override fun bindData() {

    }

}