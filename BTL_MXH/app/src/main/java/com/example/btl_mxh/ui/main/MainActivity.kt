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
        setupWithNavController(binding.navView, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    setNavigationVisible(true)
                    setNameScreen("Home")
                }
                R.id.notificationFragment -> {
                    setNavigationVisible(true)
                    setNameScreen("Notification")
                }
                R.id.profileFragment -> {
                    setNavigationVisible(true)
                    setNameScreen("Profile")
                }
                else -> {
                    setNavigationVisible()
                }
            }
        }
    }

    private fun setNameScreen(name: String) {
        binding.textScreen.text = name
//        binding.textScreen.visibility = View.VISIBLE
    }

    private fun setNavigationVisible(isVisible: Boolean = false) {
        binding.navView.isVisible = isVisible
    }

}