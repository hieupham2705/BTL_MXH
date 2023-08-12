package com.example.btl_mxh.ui.friend

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.R
import com.example.btl_mxh.databinding.ItemFriendBinding
import com.example.btl_mxh.databinding.ItemImageProfileBinding
import com.example.btl_mxh.model.GetById
import com.example.btl_mxh.ui.profile.ImageProfileAdapter
import com.example.btl_mxh.utils.extension.loadImageFromUrl
import com.example.btl_mxh.utils.extension.showImage

private const val TAG = "FriendAdapter"

class FriendAdapter(
    private val context: Context,
    private val onClickImage: () -> Unit,
    private val onClickUnFollow: () -> Unit,
    private val onClickFollow: () -> Unit

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val adapterImage by lazy { ImageProfileAdapter(context) }
    private val listImage = mutableListOf<String>()
    private var checkFollow: Boolean? = false
    private var informationUser: GetById? = null
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
        val bindingInformation = ItemFriendBinding.inflate(layoutInflater, parent, false)
        val bindingImage = ItemImageProfileBinding.inflate(layoutInflater, parent, false)
        return when (viewType) {
            typeInformation -> ViewHolderInformation(bindingInformation)
            else -> ViewHolderImage(bindingImage)
        }
    }

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.e(TAG, "setListFriend: hieudeptrai")
        if (holder is ViewHolderInformation) {
            holder.binding.apply {
                fullname.text = informationUser?.fullName
                username.text = informationUser?.username
                imvAvatar.loadImageFromUrl(informationUser?.avatar.toString())
                if (checkFollow == true)
                    btnFollow.setBackgroundResource(R.drawable.border_follower)
                else
                    btnFollow.setBackgroundResource(R.drawable.border_follow_false)
                btnFollow.setOnClickListener {
                    if (checkFollow == false) {
                        checkFollow = true
                        onClickFollow.invoke()
                        btnFollow.setBackgroundResource(R.drawable.border_follower)
                    } else {
                        checkFollow = false
                        onClickUnFollow.invoke()
                        btnFollow.setBackgroundResource(R.drawable.border_follow_false)
                    }
                }
                imvAvatar.setOnClickListener {
                    context?.let {
                        val dialogShow = Dialog(it)
                        dialogShow.showImage(informationUser?.avatar.toString())
                    }
                }
            }
        }

        if (holder is ViewHolderImage) {
            adapterImage.setListImage(listImage)
            holder.binding.recyclerview.layoutManager =
                GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
            holder.binding.recyclerview.adapter = adapterImage
        }
    }

    fun setListFriend(getById: GetById, list: List<String>, check: Boolean? = false) {
        checkFollow = check
        informationUser = getById
        listImage.clear()
        listImage.addAll(list)
        notifyDataSetChanged()
    }

}