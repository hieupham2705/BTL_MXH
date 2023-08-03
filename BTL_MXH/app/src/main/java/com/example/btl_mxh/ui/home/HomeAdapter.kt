package com.example.btl_mxh.ui.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.databinding.ItemCreatePostBinding
import com.example.btl_mxh.databinding.ItemPostBinding
import com.example.btl_mxh.databinding.ItemSearchBinding
import com.example.btl_mxh.model.Auth
import com.example.btl_mxh.model.Post
import com.example.btl_mxh.model.PostGetAll
import com.example.btl_mxh.utils.extension.loadImageFromUrl

private const val TAG = "HomeAdapter"

class HomeAdapter(
    private val context: Context,
    private val onClickPost: () -> Unit,
    private val onClickSearch: () -> Unit,
    private val onClickCreatePost: () -> Unit,
    private val onClickMessage: () -> Unit,
    private val onClickimvavatarpost: () -> Unit

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val typeSearch = 13424832
    val typeCreatePost = 2509345
    val typePost = 34230843

    private lateinit var createPost: Auth
    private var listPost = mutableListOf<Post>()


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
                content.text = listPost[position].caption
                hour.text = listPost[position].createdDate
                when (listPost.size) {
                    0 -> {
                        recyclerview.isVisible = false
                    }
                    1 -> {
                        recyclerview.layoutManager = LinearLayoutManager(context)
                    }
                    2 -> {
                        recyclerview.layoutManager =
                            GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
                    }
                    else -> {
                        recyclerview.layoutManager =
                            GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
                    }
                }
                listPost[position].mediaFiles?.let {
                    PostAdapter().setListImage(it)
                }
                recyclerview.adapter = PostAdapter()
                Log.e(TAG, listPost[position].mediaFiles.toString())
            }

        }

    }

    fun setAdapter(auth: Auth, list: List<Post>) {
        createPost = auth
        listPost.clear()
        listPost.addAll(list)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = listPost.size
}