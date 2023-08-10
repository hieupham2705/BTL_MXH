package com.example.btl_mxh.ui.friend_posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.databinding.ItemFriendPostsBinding

class FriendPostsAdapter (

    private val onClickAvatarFriend: () -> Unit

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder(val binding: ItemFriendPostsBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFriendPostsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if ( holder is ViewHolder )
        {
            holder.binding.apply {
                imvAvatarFriend.setOnClickListener { onClickAvatarFriend() }
            }
        }
    }


    override fun getItemCount(): Int = 20
}