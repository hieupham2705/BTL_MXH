package com.example.btl_mxh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.btl_mxh.databinding.ActivitySignInScreenBinding

class SignInScreen : AppCompatActivity() {
    private val binding by lazy { ActivitySignInScreenBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signIn.setOnClickListener { startActivity(Intent(this,HomeScreen::class.java)) }
        binding.noRegisterFromSignInSceen.setOnClickListener { startActivity(Intent(this,RegisterScreen::class.java)) }
        binding.forgotPasswordSignIn.setOnClickListener { startActivity(Intent(this,ForgotPasswordScreen::class.java)) }
    }
}