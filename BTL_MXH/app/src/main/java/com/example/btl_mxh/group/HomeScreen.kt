package com.example.btl_mxh.group

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.btl_mxh.R
import com.example.btl_mxh.databinding.ActivityHomeScreenBinding
import com.example.btl_mxh.ui.home.HomeFragment
import com.example.btl_mxh.ui.notification.NotificationFragment
import com.example.btl_mxh.ui.profile.ProfileFragment

class HomeScreen : AppCompatActivity() {
    private val binding by lazy { ActivityHomeScreenBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        replaceFragments(HomeFragment())
//        binding.bottomNavigationView.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.home ->replaceFragments(HomeFragment())
//                R.id.notifications ->replaceFragments(NotificationFragment())
//                R.id.profile ->replaceFragments(ProfileFragment(this))
//
//            }
//            true
//        }
    }

    private fun replaceFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.framelayout,fragment).commit()
    }
}