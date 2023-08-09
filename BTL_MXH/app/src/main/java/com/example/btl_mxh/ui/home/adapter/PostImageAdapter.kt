package com.example.btl_mxh.ui.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.databinding.ItemAddImageBinding
import com.example.btl_mxh.utils.extension.loadImageFromUrl

private const val TAG = "PostImageAdapter"

class PostImageAdapter(
    private val listImage: List<String> = listOf<String>()
) : RecyclerView.Adapter<PostImageAdapter.ViewHolder>() {


    class ViewHolder(val binding: ItemAddImageBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAddImageBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listImage.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e(TAG, listImage.toString() + position.toString())
        holder.binding.imvGalleryPhoto.loadImageFromUrl(listImage[position])
    }
}