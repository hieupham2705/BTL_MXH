package com.example.btl_mxh.ui.notification

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentNotificationBinding

class NotificationFragment :
    BaseFragment<FragmentNotificationBinding>(FragmentNotificationBinding::inflate) {

    private var listnotification = listOf<Int>(
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
        R.drawable.hit,
    )

    private val adapternotification by lazy { NotificationAdapter(
        onclickavartarNotification = {
            findNavController().navigate(R.id.action_notificationFragment_to_friendFragment)
        }
    ) }

    override val viewModel: NotificationViewModel
        get() = ViewModelProvider(this)[NotificationViewModel::class.java]

    override fun initData() {

    }

    override fun handleEvent() {

    }

    override fun bindData() {
        adapternotification.setList(listnotification)
        binding.recyclerviewNotification.adapter = adapternotification
    }




}