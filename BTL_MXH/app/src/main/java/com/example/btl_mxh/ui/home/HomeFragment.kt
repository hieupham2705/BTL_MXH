package com.example.btl_mxh.ui.home

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.databinding.FragmentHomeBinding
import com.example.btl_mxh.model.Auth
import com.example.btl_mxh.model.RegisterEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "HomeFragment"

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val adapter by lazy {
        HomeAdapter(
            context = requireContext(),
            onClickPost = {
            },
            onClickSearch = {
                findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
            },
            onClickCreatePost = {
                findNavController().navigate(R.id.action_homeFragment_to_addTextFragment)
            },
            onClickMessage = {
                findNavController().navigate(R.id.action_homeFragment_to_listMessFragment)
            },
            onClickimvavatarpost = {
                findNavController().navigate(R.id.action_homeFragment_to_friendFragment)
            }
        )
    }
    override val viewModel by viewModel<HomeViewModel>()
    override fun initData() {
        viewModel.auth()
        viewModel.postGetAll()
    }

    override fun handleEvent() {
    }

    override fun bindData() {
        viewModel.stateAuth.observe(viewLifecycleOwner) { _auth ->
            viewModel.statePostGetAll.observe(viewLifecycleOwner) { postGetAll ->
                Log.e(TAG, postGetAll.toString())
                adapter.setAdapter(viewModel.stateAuth.value!!, postGetAll)
                binding.recyclerview.adapter = adapter
            }

        }
    }

}
