package com.example.btl_mxh.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.ui.notificationsetting.base.BaseFragment
import com.example.btl_mxh.ui.notificationsetting.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentSplashBinding


class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override val viewModel: BaseViewModel
        get() = BaseViewModel()

    override fun initData() {
        // khong duoc dung binding o ham nay
    }

    override fun handleEvent() {

    }

    override fun bindData() {
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
        }, DELAY_TIME) // magic number
    }

    companion object {
        const val DELAY_TIME = 2000L
    }
}