package com.example.btl_mxh.ui.home.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
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
import com.skydoves.powermenu.MenuAnimation
import com.skydoves.powermenu.OnMenuItemClickListener
import com.skydoves.powermenu.PowerMenu
import com.skydoves.powermenu.PowerMenuItem

class HomeAdapter(
    private val context: Context,
    private val deletePost: (String) -> Unit,
    private val onClickSearch: () -> Unit,
    private val onClickCreatePost: () -> Unit,
    private val onClickMessage: () -> Unit,
    private val onClickimvavatarpost: () -> Unit

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var idPost: String? = ""
    private var createPost: Auth? = null
    private val listPost = mutableListOf<Post>()
    val powerMenu = PowerMenu.Builder(context)
        .addItemList(
            listOf(
                PowerMenuItem("Delete"),
                PowerMenuItem("Edit")
            )
        ) // list has "Novel", "Poetry", "Art"
        .setAnimation(MenuAnimation.SHOWUP_TOP_RIGHT) // Animation start point (TOP | LEFT).
        .setMenuRadius(10f) // sets the corner radius.
        .setMenuShadow(10f) // sets the shadow.
        .setTextColor(ContextCompat.getColor(context, com.example.btl_mxh.R.color.white))
        .setTextGravity(Gravity.CENTER)
        .setTextTypeface(Typeface.create("sans-serif-medium", Typeface.BOLD))
        .setSelectedTextColor(Color.WHITE)
        .setMenuColor(Color.parseColor("#FFA767"))
        .setSelectedMenuColor(ContextCompat.getColor(context!!, com.example.btl_mxh.R.color.Red))
        .build()
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
            holder.binding.imvAvatar.loadImageFromUrl(createPost?.avatar.toString())
            holder.binding.edtCreactPost.setOnClickListener {
                onClickCreatePost.invoke()
            }
        }
        if (holder is ViewHolder) {
            holder.binding.apply {
                imvAvatar.setOnClickListener { onClickimvavatarpost.invoke() }
                imvAvatar.loadImageFromUrl(listPost[position-2].avatar.toString())
                username.text = listPost[position-2].username
                content.text = listPost[position - 2].caption
                hour.text = listPost[position - 2].createdDate
                when (listPost[position - 2].mediaFiles!!.size) {
                    0 -> {
                    }
                    1 -> {
                        recyclerview.layoutManager = LinearLayoutManager(holder.itemView.context)
                    }
                    2 -> {
                        recyclerview.layoutManager =
                            GridLayoutManager(
                                holder.itemView.context,
                                2,
                                RecyclerView.VERTICAL,
                                false
                            )
                    }
                    else -> {
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
                    idPost = listPost[position - 2].id.toString()
                    onClickMoreVert(holder.itemView)
                }
            }

        }

    }


    override fun getItemCount(): Int = listPost.size + 2
    fun setDataAdapter(auth: Auth ?= null, list: List<Post>) {
        createPost = auth
        listPost.clear()
        listPost.addAll(list)
        notifyDataSetChanged()
    }

    private fun onClickMoreVert(view: View) {
        powerMenu.showAsAnchorRightTop(view)
        powerMenu.setOnMenuItemClickListener(onMenuItemClickListener)
    }

    private val onMenuItemClickListener = object : OnMenuItemClickListener<PowerMenuItem> {
        override fun onItemClick(position: Int, item: PowerMenuItem) {
            Log.e("hiih", "hi")
            if (item.title == "Delete") {
                deletePost(idPost.toString())

            } else {
                onClickCreatePost.invoke()
            }
            powerMenu.setSelectedPosition(position) // change selected item
            powerMenu.dismiss()
        }
    }

}