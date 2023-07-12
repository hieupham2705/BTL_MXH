package com.example.btl_mxh.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.btl_mxh.databinding.ItemImageProfileBinding

class ProfileAdapter() : RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {
    private var listprofile = listOf<Int>()

    class ViewHolder(val binding: ItemImageProfileBinding) : RecyclerView.ViewHolder(binding.root) {
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemImageProfileBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listprofile.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.root.setImageResource(listprofile[position])
    }

    fun setList(list: List<Int>) {
        listprofile = list
    }
}