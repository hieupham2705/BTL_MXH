package com.example.btl_mxh.ui.home

import android.util.Log
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentHomeBinding
<<<<<<< HEAD
import com.example.btl_mxh.model.Auth
import com.example.btl_mxh.model.RegisterEntity
import com.example.btl_mxh.ui.profile.viewModel

=======
import com.example.btl_mxh.ui.home.adapter.HomeAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb

private const val TAG = "HomeFragment"

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override val viewModel by viewModel<HomeViewModel>()
    override fun initData() {
        viewModel.auth()
        viewModel.postGetAll()
    }

    override fun handleEvent() {
    }

    override fun bindData() {
<<<<<<< HEAD

        viewModel.stateLogin.observe(this) {
            adapterPost.setAdapter(it)
        }
        binding.recyclerviewHome.adapter = adapterPost

//        viewModel.stateAuth.observe(viewLifecycleOwner) { _auth ->
//            viewModel.statePostGetAll.observe(viewLifecycleOwner) { postGetAll ->
//                Log.e(TAG,postGetAll.toString())
//                adapter.setAdapter(viewModel.stateAuth.value!!, postGetAll)
                binding.recyclerview.adapter = adapter
//            }

//        }

=======
        viewModel.stateAuth.observe(viewLifecycleOwner) { _auth ->
            viewModel.statePostGetAll.observe(viewLifecycleOwner) { _postGetAll ->
                Log.e(TAG, _postGetAll.toString())
                binding.recyclerview.adapter = HomeAdapter(
                    createPost = _auth,
                    listPost = _postGetAll,
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

        }
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb
    }

}
