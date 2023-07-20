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
        binding.apply {
            tbBack.setOnClickListener {
                navController.popBackStack()
            }
        }
    }

    override fun bindData() {
//        setupWithNavController(binding.navView, navController)
        setupWithNavController(binding.navView, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    setNavigationVisible(isVisiblenavView = true, name = "HIT Circle")
                    binding.tbBack.setNavigationIcon(null)
                }
                R.id.notificationFragment -> {
                    setNavigationVisible(isVisiblenavView = true, name = "Notification")
                    binding.tbBack.setNavigationIcon(null)
                }
                R.id.profileFragment -> {
                    setNavigationVisible(isVisiblenavView = true, name = "Profile")
                    binding.tbBack.setNavigationIcon(null)
                }
                R.id.settingFragment -> {
                    setNavigationVisible(name = "Setting")
                    binding.tbBack.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
                }
                R.id.changePasswordFragment -> {
                    setNavigationVisible(name = "Change Password")
                    binding.tbBack.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
                }
                R.id.notificationSettingFragment -> {
                    setNavigationVisible(name = "Notification")
                    binding.tbBack.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
                }
                R.id.listMessFragment -> {
                    setNavigationVisible(name = "Mess")
                    binding.tbBack.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
                }
                R.id.editProfileFragment -> {
                    setNavigationVisible(name = "Edit Profile")
                    binding.tbBack.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
                }
                R.id.friendFragment -> {
                    setNavigationVisible(name = "Friend")
                    binding.tbBack.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
                }
                R.id.addTextFragment -> {
                    setNavigationVisible(name = "Add Post")
                    binding.tbBack.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
                }
                R.id.searchFragment -> {
                    setNavigationVisible(name = "Search")
                    binding.tbBack.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
                }
                else -> {
                    setNavigationVisible(false, name = "")
                }
            }
        }
    }

    private fun setNavigationVisible(
        isVisibletbBackView: Boolean = true,
        isVisiblenavView: Boolean = false,
        name: String
    ) {
        binding.tbBack.isVisible = isVisibletbBackView
        binding.navView.isVisible = isVisiblenavView
        binding.textScreen.text = name
    }

}