package com.example.btl_mxh.ui.addpost_image

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.databinding.ItemAddImageBinding

class AddImageAdapter : RecyclerView.Adapter<AddImageAdapter.ViewHoldel>() {
    class ViewHoldel(val binding: ItemAddImageBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldel {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAddImageBinding.inflate(layoutInflater, parent, false)
        return ViewHoldel(binding)
    }

    override fun getItemCount(): Int = 20

    override fun onBindViewHolder(holder: ViewHoldel, position: Int) {

    }

}