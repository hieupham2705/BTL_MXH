package com.example.btl_mxh.ui.home

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.view.Gravity
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentHomeBinding
import com.example.btl_mxh.model.EditPost
import com.example.btl_mxh.ui.home.adapter.HomeAdapter
import com.skydoves.powermenu.MenuAnimation
import com.skydoves.powermenu.PowerMenu
import com.skydoves.powermenu.PowerMenuItem
import org.koin.androidx.viewmodel.ext.android.viewModel


private const val TAG = "HomeFragment"

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private var imformationPost : EditPost ?= null
    override val viewModel by viewModel<HomeViewModel>()
    private val adapterHome by lazy {
        HomeAdapter(
            context = context!!,
            deletePost = {
                deletePost(it)
            },
            onClickSearch = {
                findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
            },
            onClickCreatePost = {
                findNavController().navigate(R.id.action_homeFragment_to_addTextFragment,
                    bundleOf("editpost" to imformationPost)
                )
            },
            onClickMessage = {
                findNavController().navigate(R.id.action_homeFragment_to_listMessFragment)
            },
            onClickimvavatarpost = {
                findNavController().navigate(R.id.action_homeFragment_to_friendFragment)
            }
        )
    }

    override fun initData() {
        viewModel.auth()
        viewModel.postGetAll()
    }

    override fun handleEvent() {
    }

    override fun bindData() {
        viewModel.stateAuth.observe(viewLifecycleOwner) { _auth ->
            viewModel.statePostGetAll.observe(viewLifecycleOwner) { _postGetAll ->
                Log.e(TAG, _postGetAll.toString())
                adapterHome.setDataAdapter(_auth, _postGetAll)
            }
        }
        viewModel.stateDeletePost.observe(viewLifecycleOwner) {
            viewModel.postGetAll()
            viewModel.statePostGetAll.observe(viewLifecycleOwner) {
                Log.e(TAG, "test")
                adapterHome.setDataAdapter(viewModel.stateAuth.value,it)
            }
        }
        binding.recyclerview.adapter = adapterHome
    }

    fun deletePost(it: String) {
        viewModel.deletePost(it)
        viewModel.deleteItem()
    }
}
