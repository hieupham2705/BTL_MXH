package com.example.btl_mxh.ui.saved_posts

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentSavedPostsBinding

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