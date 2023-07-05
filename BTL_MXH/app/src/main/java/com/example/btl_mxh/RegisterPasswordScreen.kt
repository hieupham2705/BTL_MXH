package com.example.btl_mxh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.example.btl_mxh.databinding.ActivityRegisterPasswordScreenBinding

class RegisterPasswordScreen : AppCompatActivity() {
    private val binding by lazy { ActivityRegisterPasswordScreenBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.visibilityPassword.setOnClickListener {
            binding.visibilityOffPassword.visibility = View.VISIBLE
            binding.visibilityPassword.visibility = View.GONE
            binding.passwordRegister.transformationMethod = HideReturnsTransformationMethod.getInstance()
        }
        binding.visibilityPasswordAgain.setOnClickListener {
            binding.visibilityOffPasswordAgain.visibility = View.VISIBLE
            binding.visibilityPasswordAgain.visibility = View.GONE
            binding.passwordAgainRegister.transformationMethod = HideReturnsTransformationMethod.getInstance()
        }
        binding.visibilityOffPassword.setOnClickListener {
            binding.visibilityPassword.visibility = View.VISIBLE
            binding.visibilityOffPassword.visibility = View.GONE
            binding.passwordRegister.transformationMethod = PasswordTransformationMethod.getInstance()
        }
        binding.visibilityOffPasswordAgain.setOnClickListener {
            binding.visibilityPasswordAgain.visibility = View.VISIBLE
            binding.visibilityOffPasswordAgain.visibility = View.GONE
            binding.passwordAgainRegister.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }
}