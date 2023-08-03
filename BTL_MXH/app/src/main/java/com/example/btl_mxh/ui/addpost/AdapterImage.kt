package com.example.btl_mxh.ui.addpost

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.databinding.ItemAddImageBinding
import com.example.btl_mxh.utils.extension.loadImageFromUrl

class AdapterImage : RecyclerView.Adapter<AdapterImage.ViewHoder>() {
    private var listImage = mutableListOf<Uri>()
    class ViewHoder(val binding:ItemAddImageBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAddImageBinding.inflate(layoutInflater,parent,false)
        return ViewHoder(binding)
    }

    override fun getItemCount(): Int = listImage.size

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
        holder.binding.imvGalleryPhoto.loadImageFromUrl(listImage[position].toString())
    }
    fun setAdapter(list : List<Uri>){
        listImage.clear()
        listImage.addAll(list)
        notifyDataSetChanged()
    }
}