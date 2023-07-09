package com.example.btl_mxh.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.btl_mxh.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {

    private val binding by lazy {FragmentNotificationBinding.inflate(layoutInflater)}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

}