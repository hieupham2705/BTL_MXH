package com.example.btl_mxh.ui.my_posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
<<<<<<< HEAD
import com.example.btl_mxh.databinding.ItemMyPostsBinding
=======
import com.example.btl_mxh.databinding.ItemPostBinding
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb

class MyPostsAdapter (

    private val onClickAvatarMe: () -> Unit

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listPost = mutableListOf<String>()

<<<<<<< HEAD
    class ViewHolder(val binding: ItemMyPostsBinding) : RecyclerView.ViewHolder(binding.root) {
=======
    class ViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
<<<<<<< HEAD
        val binding = ItemMyPostsBinding.inflate(layoutInflater, parent, false)
=======
        val binding = ItemPostBinding.inflate(layoutInflater, parent, false)
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder )
        {
            holder.binding.apply {
<<<<<<< HEAD
                imvAvatarMyPosts.setOnClickListener { onClickAvatarMe() }
=======
                imvAvatar.setOnClickListener { onClickAvatarMe() }
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb
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