package com.example.btl_mxh.ui.friend_post

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentFriendPostsBinding
import com.example.btl_mxh.ui.home.adapter.HomeAdapter


class FriendPostsFragment : BaseFragment<FragmentFriendPostsBinding>(FragmentFriendPostsBinding :: inflate) {
    private val adapterPost by lazy {
        FriendPostsAdapter(
            ::onClickAvatarFriend
        )
    }

    private fun onClickAvatarFriend() {
        findNavController().navigate(R.id.action_friendPostsFragment_to_friendFragment)
    }

    override val viewModel: FriendPostsViewModel
        get() = ViewModelProvider(this)[FriendPostsViewModel::class.java]

    override fun initData() {

    }

    override fun handleEvent() {

    }

    override fun bindData() {
        binding.recyclerviewFriendPosts.adapter = adapterPost
    }


}