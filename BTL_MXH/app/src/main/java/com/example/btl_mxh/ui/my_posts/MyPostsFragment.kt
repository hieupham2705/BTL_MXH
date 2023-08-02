package com.example.btl_mxh.ui.my_posts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.ui.notificationsetting.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentMyPostsBinding
import com.example.btl_mxh.ui.friend_posts.FriendPostsAdapter
import com.example.btl_mxh.ui.home.HomeViewModel

class MyPostsFragment : BaseFragment<FragmentMyPostsBinding>(FragmentMyPostsBinding :: inflate) {

    private val adapterPost by lazy {
        MyPostsAdapter(
            ::onClickAvatarMe
        )

    }

    private fun onClickAvatarMe() {
        findNavController().navigate(R.id.action_myPostsFragment_to_profileFragment)
    }

    override val viewModel: MyPostsViewModel
        get() = ViewModelProvider(this)[MyPostsViewModel :: class.java]

    override fun initData() {

    }

    override fun handleEvent() {

    }

    override fun bindData() {
        binding.recyclerviewMyPosts.adapter = adapterPost
    }

}