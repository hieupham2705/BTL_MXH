package com.example.btl_mxh.di

import com.example.btl_mxh.ui.addpost.AddPostViewModel
import com.example.btl_mxh.ui.editprofile.EditProfileViewModel
import com.example.btl_mxh.ui.forgotpassword.FogotPasswordViewModel
import com.example.btl_mxh.ui.home.HomeViewModel
import com.example.btl_mxh.ui.messenger.MessengerViewModel
import com.example.btl_mxh.ui.profile.ProfileViewModel
import com.example.btl_mxh.ui.register.RegisterViewModel
import com.example.btl_mxh.ui.registerpassword.RegisterPasswordViewModel
import com.example.btl_mxh.ui.search.SearchViewModel
import com.example.btl_mxh.ui.setting.SettingViewModel
import com.example.btl_mxh.ui.sign_in.SignInViewModel
import com.example.btl_mxh.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(),get(),get()) }
    viewModel { SearchViewModel(get(),get()) }
    viewModel { SignInViewModel(get(),get()) }
    viewModel { SplashViewModel(get(),get()) }
    viewModel { RegisterViewModel() }
    viewModel { RegisterPasswordViewModel(get()) }
    viewModel { SettingViewModel(get(),get()) }
    viewModel { MessengerViewModel() }
    viewModel { FogotPasswordViewModel(get()) }
    viewModel { ProfileViewModel(get(),get()) }
    viewModel { AddPostViewModel(get()) }
    viewModel { EditProfileViewModel(get()) }
}