package com.example.btl_mxh.ui.addpost_image

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.btl_mxh.R
import com.example.btl_mxh.ui.notificationsetting.base.BaseFragment
import com.example.btl_mxh.ui.notificationsetting.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentAddImageBinding
import com.example.btl_mxh.databinding.FragmentAddTextBinding

class AddImageFragment : BaseFragment<FragmentAddImageBinding>(FragmentAddImageBinding :: inflate) {
    override val viewModel: AddImageViewModel
        get() = ViewModelProvider(this)[AddImageViewModel :: class.java]

    override fun initData() {

    }

    override fun handleEvent() {

    }

    override fun bindData() {

    }

}