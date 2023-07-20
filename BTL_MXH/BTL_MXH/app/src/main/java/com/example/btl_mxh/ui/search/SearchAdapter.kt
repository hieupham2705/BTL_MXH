package com.example.btl_mxh.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.databinding.ItemNotificationBinding
import com.example.btl_mxh.databinding.ItemSearchBinding
import com.example.btl_mxh.ui.notification.NotificationAdapter

class SearchAdapter() : RecyclerView.Adapter<SearchAdapter.ViewHolder>(){

    private var listsearch = listOf<Int>()

    class ViewHolder (val binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSearchBinding.inflate(layoutInflater, parent, false)
        return SearchAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {
//        holder.binding.avatarSearch.setImageResource(listsearch[position])
//        holder.binding.textNameSearch.text = listsearch[position].toString()

    }

    override fun getItemCount(): Int = listsearch.size



}