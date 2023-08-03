package com.example.btl_mxh.ui.addpost_text

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentAddTextBinding

class AddTextFragment : BaseFragment<FragmentAddTextBinding>(FragmentAddTextBinding :: inflate) {
    override val viewModel: AddTextViewModel
        get() = ViewModelProvider(this)[AddTextViewModel :: class.java]

    override fun initData() {

    }

    override fun handleEvent() {
        binding.apply {
            imvAddImage.setOnClickListener {
            }
        }
    }

    override fun bindData() {

    }

}