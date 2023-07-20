package com.example.btl_mxh.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseActivity
import com.example.btl_mxh.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val navController by lazy { findNavController(R.id.nav_host_fragment_activity_main) }

    override fun initData() {

    }

    override fun handleEvent() {

    }

    override fun bindData() {
//        setupWithNavController(binding.navView, navController)
        setupWithNavController(binding.navView,navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    setNavigationVisible(isVisiblenavView = true)
                    setNameScreen("HIT Circle")
                }
                R.id.notificationFragment -> {
                    setNavigationVisible(isVisiblenavView = true)
                    setNameScreen("Notification")
                }
                R.id.profileFragment -> {
                    setNavigationVisible(isVisiblenavView = true)
                    setNameScreen("Profile")
                }
                R.id.settingFragment -> {
                    setNavigationVisible()
                    setNameScreen("Setting")
                    binding.tbBack.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
                }
                R.id.changePasswordFragment -> {
                    setNavigationVisible()
                    setNameScreen("Change Password")
                    binding.tbBack.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
                }
                R.id.notificationSettingFragment -> {
                    setNavigationVisible()
                    setNameScreen("Notifications")
                    binding.tbBack.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
                }
                R.id.listMessFragment -> {
                    setNavigationVisible()
                    setNameScreen("Chat")
                    binding.tbBack.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
                }
                else -> {
                    setNavigationVisible(false)
                }
            }
        }
    }

    private fun setNameScreen(name: String) {
        binding.textScreen.text = name
    }

    private fun setNavigationVisible(isVisibletbBackView: Boolean = true,isVisiblenavView: Boolean = false) {
        binding.tbBack.isVisible = isVisibletbBackView
        binding.navView.isVisible = isVisiblenavView
    }

}