package com.example.btl_mxh.ui.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.btl_mxh.databinding.ItemImageProfileBinding
import kotlinx.coroutines.currentCoroutineContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class ProfileAdapter(
    private val context: Context
) : RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {
    private var listprofile = listOf<Int>()

    class ViewHolder(val binding: ItemImageProfileBinding) : RecyclerView.ViewHolder(binding.root) {
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemImageProfileBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = 20

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.binding.root.setImageResource(listprofile[position])
        Glide.with(context)
            .load("https://kuesports.net/wp-content/uploads/2023/06/yua-mikami-6.jpg")
            .into(holder.binding.root)
    }


    fun setList(list: List<Int>) {
        listprofile = list
    }
}