package com.example.btl_mxh.ui.home.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.R
import com.example.btl_mxh.databinding.ItemCreatePostBinding
import com.example.btl_mxh.databinding.ItemPostBinding
import com.example.btl_mxh.databinding.ItemSearchBinding
import com.example.btl_mxh.model.Auth
import com.example.btl_mxh.model.Post
import com.example.btl_mxh.utils.extension.loadImageFromUrl

class HomeAdapter(
    private val createPost: Auth,
    private val listPost: List<Post>,
    private val onClickMoreVert: () -> Unit,
    private val onClickSearch: () -> Unit,
    private val onClickCreatePost: () -> Unit,
    private val onClickMessage: () -> Unit,
    private val onClickimvavatarpost: () -> Unit

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val typeSearch = 13424832
    val typeCreatePost = 2509345
    val typePost = 34230843

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
            holder.binding.imvAvatar.loadImageFromUrl(createPost.avatar.toString())
            holder.binding.edtCreactPost.setOnClickListener {
                onClickCreatePost.invoke()
            }
        }
        if (holder is ViewHolder) {
            holder.binding.apply {
                imvAvatar.setOnClickListener { onClickimvavatarpost.invoke() }
                imvAvatar.loadImageFromUrl(createPost.avatar.toString())
                content.text = listPost[position - 2].caption
                content.visibility = View.GONE
                content.visibility = View.VISIBLE
                hour.text = listPost[position - 2].createdDate
                when (listPost[position - 2].mediaFiles!!.size) {
                    0 -> {
                        content.visibility = View.GONE
                        content.visibility = View.VISIBLE
                    }
                    1 -> {
                        content.visibility = View.GONE
                        content.visibility = View.VISIBLE
                        recyclerview.layoutManager = LinearLayoutManager(holder.itemView.context)
                    }
                    2 -> {
                        content.visibility = View.GONE
                        content.visibility = View.VISIBLE
                        recyclerview.layoutManager =
                            GridLayoutManager(
                                holder.itemView.context,
                                2,
                                RecyclerView.VERTICAL,
                                false
                            )
                    }
                    else -> {
                        content.visibility = View.GONE
                        content.visibility = View.VISIBLE
                        recyclerview.layoutManager =
                            GridLayoutManager(
                                holder.itemView.context,
                                3,
                                RecyclerView.VERTICAL,
                                false
                            )
                    }
                }
                recyclerview.adapter = PostImageAdapter(listPost[position - 2].mediaFiles!!)
                tvLove.setOnClickListener {
                    if (tvLove.currentTextColor != Color.RED)
                        tvLove.setTextColor(Color.RED)
                    else
                        tvLove.setTextColor(Color.parseColor("#908e8e"))
                }
                moreVert.setOnClickListener {
                    onClickMoreVert.invoke()
                }
            }

        }

    }


    override fun getItemCount(): Int = listPost.size + 2
}