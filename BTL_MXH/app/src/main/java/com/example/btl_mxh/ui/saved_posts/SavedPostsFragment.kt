package com.example.btl_mxh.ui.saved_posts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.databinding.FragmentSavedPostsBinding
import com.example.btl_mxh.ui.friend_posts.FriendPostsAdapter
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel

class SavedPostsFragment : BaseFragment<FragmentSavedPostsBinding>(FragmentSavedPostsBinding :: inflate) {

    private val adapterPost by lazy {
        SavedPostsAdapter(
            ::onClickAvatar
        )
    }

    private fun onClickAvatar() {
        findNavController().navigate(R.id.action_savedPostsFragment_to_friendFragment)
    }

    override val viewModel: SavedPostsViewModel
        get() = ViewModelProvider(this)[SavedPostsViewModel :: class.java]

    override fun initData() {

    }

    override fun handleEvent() {

    }

    override fun bindData() {
        binding.recyclerviewSavedPosts.adapter = adapterPost
    }

}