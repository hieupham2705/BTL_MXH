package com.example.btl_mxh.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.btl_mxh.databinding.ItemSearchUserBinding
import com.example.btl_mxh.model.Search

class SearchAdapter(
    private val context: Context,
    private val onclickFriend: () -> Unit
) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var listSearch = MutableLiveData<Search>()

    class ViewHolder(val binding: ItemSearchUserBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSearchUserBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvName.text = listSearch.value?.items?.get(position)?.login
        Glide.with(context).load(listSearch.value?.items?.get(position)?.avatarUrl).into(holder.binding.imvAvatar)
        holder.binding.root.setOnClickListener {
            onclickFriend.invoke()
        }
    }

    override fun getItemCount(): Int = listSearch.value?.items?.size ?: 0

    fun setlist(list: LiveData<Search>) {
        listSearch = list as MutableLiveData<Search>
        notifyDataSetChanged()
    }

}