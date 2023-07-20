package com.example.btl_mxh.ui.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.btl_mxh.databinding.ItemImageProfileBinding
import com.example.btl_mxh.databinding.ItemInfomationProfileBinding
import com.example.btl_mxh.model.profile

class ProfileAdapter(
    private val onclickSetting: () -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listprofile = listOf<profile>()
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

    override fun getItemCount(): Int = listprofile.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolderInformation) {
            holder.binding.setting.setOnClickListener {
                onclickSetting()
            }
        }
        if (holder is ViewHolderImage) {
            listprofile[position].image1?.let { holder.binding.imageView1.setImageResource(it) }
            listprofile[position].image2?.let { holder.binding.imageView2.setImageResource(it) }
            listprofile[position].image3?.let { holder.binding.imageView3.setImageResource(it) }
        }
    }

    fun setList(list: List<profile>) {
        listprofile = list
    }
}