package com.example.btl_mxh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.btl_mxh.databinding.ActivityForgotPasswordScreenBinding

class ForgotPasswordScreen : AppCompatActivity() {
    private val binding by lazy { ActivityForgotPasswordScreenBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.submitForgotPassword.setOnClickListener { startActivity(Intent(this,HomeScreen::class.java)) }
        binding.signInForgotPassword.setOnClickListener { startActivity(Intent(this,SignInScreen::class.java)) }
    }
}