package com.example.btl_mxh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.btl_mxh.databinding.ActivityRegisterSignInScreenBinding

class RegisterSignInScreen : AppCompatActivity() {
    private val binding by lazy { ActivityRegisterSignInScreenBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signIn.setOnClickListener { startActivity(Intent(this,SignInScreen::class.java)) }
        binding.register.setOnClickListener { startActivity(Intent(this,RegisterScreen::class.java)) }
    }
}