package com.example.btl_mxh.ui.my_posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.databinding.ItemMyPostsBinding

class MyPostsAdapter (

    private val onClickAvatarMe: () -> Unit

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listPost = mutableListOf<String>()

    class ViewHolder(val binding: ItemMyPostsBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMyPostsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder )
        {
            holder.binding.apply {
                imvAvatarMyPosts.setOnClickListener { onClickAvatarMe() }
            }
        }
    }

    fun setAdapter(list: List<String>) {
        listPost.clear()
        listPost.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = 20
}