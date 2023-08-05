package com.example.btl_mxh.ui.friend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.databinding.ItemFriendBinding
import com.example.btl_mxh.databinding.ItemImageProfileBinding
import com.example.btl_mxh.model.friend

class FriendAdapter (

    private val onClickImage: () -> Unit

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listfriend = listOf<friend>()
    private val typeInformation = 0;
    private val typeImage = 1;

    class ViewHolderInformation(val binding: ItemFriendBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    class ViewHolderImage(val binding: ItemImageProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun getItemViewType(position: Int): Int {
        val positionImformation = 0;
        return when (position) {
            positionImformation -> typeInformation
            else -> typeImage
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val bindingInfomation = ItemFriendBinding.inflate(layoutInflater, parent, false)
        val bindingImage = ItemImageProfileBinding.inflate(layoutInflater, parent, false)
        return when (viewType) {
            typeInformation -> ViewHolderInformation(bindingInfomation)
            else -> ViewHolderImage(bindingImage)
        }
    }

    override fun getItemCount(): Int = listfriend.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is ViewHolderImage) {
        }
    }

    fun setListFriend( list: List<friend> )
    {
        listfriend = list
    }

}