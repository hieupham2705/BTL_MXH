package com.example.btl_mxh.ui.saved_posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.databinding.ItemSavedPostsBinding

class SavedPostsAdapter(

    private val onCLickAvatar:() -> Unit

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder(val binding: ItemSavedPostsBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSavedPostsBinding.inflate(layoutInflater, parent, false)
        return SavedPostsAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if ( holder is ViewHolder )
        {
            holder.binding.apply {
                imvAvatar.setOnClickListener { onCLickAvatar() }
            }
        }

    }


    override fun getItemCount(): Int = 20
}