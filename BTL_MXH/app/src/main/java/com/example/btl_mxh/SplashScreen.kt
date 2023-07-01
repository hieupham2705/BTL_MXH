package com.example.btl_mxh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.btl_mxh.databinding.ActivityMainBinding
import com.example.btl_mxh.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private val binding by lazy { ActivitySplashScreenBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Handler().postDelayed(
                {
                    startActivity(Intent(this,RegisterSignInScreen::class.java))
                },
        2000
        )
    }
}