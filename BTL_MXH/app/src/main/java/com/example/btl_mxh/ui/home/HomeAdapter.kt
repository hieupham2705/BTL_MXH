package com.example.btl_mxh.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.databinding.ItemCreatePostBinding
import com.example.btl_mxh.databinding.ItemPostBinding
import com.example.btl_mxh.databinding.ItemSearchBinding

class HomeAdapter(
    private val onClickPost: () -> Unit,
    private val onClickSearch: () -> Unit,
    private val onClickCreatePost: () -> Unit,
    private val onClickMessage: () -> Unit,
    private val onClickimvavatarpost: () -> Unit

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val typeSearch = 13424832
    val typeCreatePost = 2509345
    val typePost = 34230843

    private val listPost = mutableListOf<String>()

    class ViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    class ViewHolderSearch(val binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    class ViewHolderCreatePost(val binding: ItemCreatePostBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun getItemViewType(position: Int): Int {
        val positionSearch = 0
        val positionCratePost = 1
        return when (position) {
            positionSearch -> typeSearch
            positionCratePost -> typeCreatePost
            else -> typePost
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(layoutInflater, parent, false)
        val bindingSearch = ItemSearchBinding.inflate(layoutInflater, parent, false)
        val bindingCreatePost = ItemCreatePostBinding.inflate(layoutInflater, parent, false)
        return when (viewType) {
            typeSearch -> ViewHolderSearch(bindingSearch)
            typeCreatePost -> ViewHolderCreatePost(bindingCreatePost)
            else -> ViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolderSearch) {
            holder.binding.edtSearch.setOnClickListener {
                onClickSearch.invoke()
            }
            holder.binding.imageViewMessage.setOnClickListener {
                onClickMessage.invoke()
            }
        }
        if (holder is ViewHolderCreatePost) {
            holder.binding.edtCreactPost.setOnClickListener {
                onClickCreatePost.invoke()
            }
        }
        if(holder is ViewHolder){
            holder.binding.imvAvatar.setOnClickListener {
                onClickimvavatarpost.invoke()
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