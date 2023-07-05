package com.example.btl_mxh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.example.btl_mxh.databinding.ActivitySignInScreenBinding

class SignInScreen : AppCompatActivity() {
    private val binding by lazy { ActivitySignInScreenBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signIn.setOnClickListener { startActivity(Intent(this, HomeScreen::class.java)) }
        binding.noRegisterFromSignInSceen.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    RegisterScreen::class.java
                )
            )
        }
        binding.forgotPasswordSignIn.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ForgotPasswordScreen::class.java
                )
            )
        }
        binding.visibility.setOnClickListener {
            binding.visibilityOff.visibility = View.VISIBLE
            binding.visibility.visibility = View.GONE
            binding.passwordSignIn.transformationMethod = HideReturnsTransformationMethod.getInstance()
        }
        binding.visibilityOff.setOnClickListener {
            binding.visibility.visibility = View.VISIBLE
            binding.visibilityOff.visibility = View.GONE
            binding.passwordSignIn.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }
}