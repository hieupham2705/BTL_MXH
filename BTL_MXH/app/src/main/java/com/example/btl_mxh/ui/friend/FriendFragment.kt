
package com.example.btl_mxh.ui.friend

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentFriendBinding
import com.example.btl_mxh.ui.profile.ProfileAdapter

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
<<<<<<< HEAD
            recyclerviewFriend.adapter = adapterFriend
=======
//            recyclerviewFriend.adapter = adapterFriend
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb
        }
    }

    private fun onClickImage() {
<<<<<<< HEAD
        findNavController().navigate(R.id.action_friendFragment_to_friendPostsFragment)
=======
//        findNavController().navigate(R.id.action_friendFragment_to_friendPostsFragment)
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb
    }
}