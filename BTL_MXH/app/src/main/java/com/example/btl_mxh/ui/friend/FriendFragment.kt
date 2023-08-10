
package com.example.btl_mxh.ui.friend

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentFriendBinding

class FriendFragment : BaseFragment<FragmentFriendBinding>(FragmentFriendBinding :: inflate){

    private val adapterFriend by lazy {
        FriendAdapter(
            :: onClickImage
        )
    }

    override val viewModel: FriendViewModel
        get() = ViewModelProvider (this) [FriendViewModel :: class.java ]

    override fun initData() {

    }

    override fun handleEvent() {

    }

    override fun bindData() {
        binding.apply {
            adapterFriend.setListFriend(viewModel.list)
//            recyclerviewFriend.adapter = adapterFriend
        }
    }

    private fun onClickImage() {
//        findNavController().navigate(R.id.action_friendFragment_to_friendPostsFragment)
    }
}