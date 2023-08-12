package com.example.btl_mxh.ui.friend

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentFriendBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "FriendFragment"

class FriendFragment : BaseFragment<FragmentFriendBinding>(FragmentFriendBinding::inflate) {
    private val adapterFriend by lazy {
        FriendAdapter(
            requireContext(),
            onClickImage = {},
            onClickFollow = {viewModel.follow(viewModel.stageGetById.value?.id.toString())},
            onClickUnFollow = {viewModel.unFollow(viewModel.stageGetById.value?.id.toString())}
        )
    }

    override val viewModel by viewModel<FriendViewModel>()

    override fun initData() {
        val idUser = arguments?.getString("idUserPost")
        Log.e(TAG, "initData: $idUser")
        if (idUser != null) {
            viewModel.getUserById(idUser)
            viewModel.getFollowers(idUser)
        }
    }

    override fun handleEvent() {

    }

    override fun bindData() {
        viewModel.stageGetById.observe(viewLifecycleOwner) {
            viewModel.getAllUserById(it.id.toString())
        }
        viewModel.stageListPost.observe(viewLifecycleOwner) { _listPost ->
            viewModel.stageGetFollowers.observe(viewLifecycleOwner) {
                if (viewModel.checkUserId(it)) {
                    adapterFriend.setListFriend(viewModel.stageGetById.value!!, _listPost, true)
                } else {
                    adapterFriend.setListFriend(viewModel.stageGetById.value!!, _listPost)
                }

            }
        }

        binding.recyclerview.adapter = adapterFriend
    }

}