package com.example.btl_mxh.ui.addpost_image

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentAddImageBinding
import com.example.btl_mxh.databinding.FragmentAddTextBinding

class AddImageFragment : BaseFragment<FragmentAddImageBinding>(FragmentAddImageBinding::inflate) {
    private val adapter by lazy { AddImageAdapter() }
    override val viewModel: AddImageViewModel
        get() = ViewModelProvider(this)[AddImageViewModel::class.java]

    override fun initData() {

    }

    override fun handleEvent() {

    }

    override fun bindData() {
        binding.apply {
            recyclerview.layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
            recyclerview.adapter = adapter
        }
    }

}