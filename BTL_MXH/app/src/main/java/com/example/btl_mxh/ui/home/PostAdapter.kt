package com.example.btl_mxh.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.databinding.ItemAddImageBinding
import com.example.btl_mxh.databinding.ItemImageProfileBinding
import com.example.btl_mxh.utils.extension.loadImageFromUrl

class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private val listImage = mutableListOf<String>()
    class ViewHolder(val binding: ItemAddImageBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAddImageBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listImage.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imvGalleryPhoto.loadImageFromUrl(listImage[position])
    }
    fun setListImage(list: List<String>){
        listImage.clear()
        listImage.addAll(list)
        notifyDataSetChanged()
    }
}