package com.example.btl_mxh.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                R.id.homeFragment -> setNavigationVisible(true)
                R.id.notificationFragment -> setNavigationVisible(true)
                R.id.profileFragment -> setNavigationVisible(true)
                else -> setNavigationVisible()
            }
        }
    }
    private fun setNavigationVisible(isVisible: Boolean = false) {
        binding.navView.isVisible = isVisible
    }

}