package com.example.btl_mxh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.btl_mxh.databinding.ActivityRegisterScreenBinding

class RegisterScreen : AppCompatActivity() {
    private val binding by lazy { ActivityRegisterScreenBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signInRegister.setOnClickListener { startActivity(Intent(this,SignInScreen::class.java)) }
        binding.create.setOnClickListener { startActivity(Intent(this,HomeScreen::class.java)) }
    }
}