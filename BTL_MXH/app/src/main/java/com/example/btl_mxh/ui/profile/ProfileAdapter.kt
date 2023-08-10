package com.example.btl_mxh.ui.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.btl_mxh.databinding.ItemImageProfileBinding
import com.example.btl_mxh.databinding.ItemInfomationProfileBinding
import com.example.btl_mxh.model.Auth
import com.example.btl_mxh.model.profile
import com.example.btl_mxh.utils.extension.loadImageFromUrl

class ProfileAdapter(
    private val onclickSetting: () -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listAllImagePost = mutableListOf<String>()
    private var information: Auth? = null
    private val adapterListImagePostProfile by lazy { ImageProfileAdapter() }
    private val typeInformation = 0;
    private val typeImage = 1;


    class ViewHolderInformation(val binding: ItemInfomationProfileBinding) :
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
        val bindingInfomation = ItemInfomationProfileBinding.inflate(layoutInflater, parent, false)
        val bindingImage = ItemImageProfileBinding.inflate(layoutInflater, parent, false)
        return when (viewType) {
            typeInformation -> ViewHolderInformation(bindingInfomation)
            else -> ViewHolderImage(bindingImage)
        }
    }

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolderInformation) {
            holder.binding.apply {
                setting.setOnClickListener {
                    onclickSetting()
                }
                fullname.text = information?.fullName
                username.text = information?.username
                imvAvatar.loadImageFromUrl(information?.avatar.toString())
            }
        }
        if (holder is ViewHolderImage) {
            holder.binding.apply {
                recyclerview.layoutManager =
                    GridLayoutManager(holder.itemView.context, 3, RecyclerView.VERTICAL, false)
                recyclerview.adapter = adapterListImagePostProfile
            }
            adapterListImagePostProfile.setListImage(listAllImagePost)
        }
    }

    fun setData(auth: Auth? = null, list: List<String>? = emptyList()) {
        if (auth != null) {
            information = auth
        }
        if (list != null) {
            listAllImagePost.clear()
            listAllImagePost.addAll(list)
        }
        notifyDataSetChanged()
    }
}