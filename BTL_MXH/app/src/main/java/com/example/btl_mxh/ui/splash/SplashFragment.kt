package com.example.btl_mxh.ui.splas

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentSplashBinding
import com.example.btl_mxh.ui.splash.SplashViewModel
import com.example.btl_mxh.utils.extension.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashFragment(
) : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override val viewModel by viewModel<SplashViewModel>()

    override fun initData() {
    }

    override fun handleEvent() {

        viewModel.auth()
    }

    override fun bindData() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (viewModel.stateAuth.value == null){
                findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
                showToast("Login unsuccessful")
                Log.e("xx","ddssa")
            }
            else{
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment,
                    bundleOf("auth" to viewModel.stateAuth.value!!.data)
                )
                showToast("Logged in successfully !")
            }

        }, DELAY_TIME) // magic number
    }

    companion object {
        const val DELAY_TIME = 2000L
    }

}