package com.example.btl_mxh.group

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.btl_mxh.databinding.ActivityRegisterPasswordScreenBinding

class RegisterPasswordScreen : AppCompatActivity() {
    private val binding by lazy { ActivityRegisterPasswordScreenBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.create.setOnClickListener {
            startActivity(Intent(this, HomeScreen::class.java))
            finish()
        }
    }
}