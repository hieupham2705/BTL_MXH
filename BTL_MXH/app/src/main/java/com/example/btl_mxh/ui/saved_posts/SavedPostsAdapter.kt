package com.example.btl_mxh.ui.saved_posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
<<<<<<< HEAD
import com.example.btl_mxh.databinding.ItemSavedPostsBinding
=======
import com.example.btl_mxh.databinding.ItemPostBinding
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb

class SavedPostsAdapter(

    private val onCLickAvatar:() -> Unit

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

<<<<<<< HEAD
    class ViewHolder(val binding: ItemSavedPostsBinding) : RecyclerView.ViewHolder(binding.root) {
=======
    class ViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
<<<<<<< HEAD
        val binding = ItemSavedPostsBinding.inflate(layoutInflater, parent, false)
=======
        val binding = ItemPostBinding.inflate(layoutInflater, parent, false)
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb
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