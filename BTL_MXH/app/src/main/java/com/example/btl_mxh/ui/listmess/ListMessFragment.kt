package com.example.btl_mxh.ui.listmess

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentListMessBinding

class ListMessFragment : BaseFragment<FragmentListMessBinding>(FragmentListMessBinding::inflate) {
    private val adapter by lazy { ListMessAdapter() }
    override val viewModel: ListMessViewModel
        get() = ViewModelProvider(this)[ListMessViewModel::class.java]

    override fun initData() {

    }

    override fun handleEvent() {

    }

    override fun bindData() {
        binding.apply {
            recyclerview.adapter = adapter
        }
    }


}