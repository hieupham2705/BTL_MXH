package com.example.btl_mxh.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.btl_mxh.R
import com.example.btl_mxh.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var list = listOf<Int>(
        R.drawable.hit, R.drawable.hit,
        R.drawable.hit, R.drawable.hit,
        R.drawable.hit, R.drawable.hit,
        R.drawable.hit, R.drawable.hit,
        R.drawable.hit, R.drawable.hit,
        R.drawable.hit, R.drawable.hit,
        R.drawable.hit, R.drawable.hit,
        R.drawable.hit, R.drawable.hit
    )
    private val binding by lazy { FragmentProfileBinding.inflate(layoutInflater) }
    private val adapterProfile by lazy {
        ProfileAdapter(
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.recyclerviewProfile.layoutManager=GridLayoutManager(context,3,RecyclerView.VERTICAL,false)
        adapterProfile.setList(list)
        binding.recyclerviewProfile.adapter=adapterProfile
        binding.settingProfile.setOnClickListener { startActivity(Intent(requireContext(), SettingProfileScreen::class.java)) }
        return binding.root
    }


}