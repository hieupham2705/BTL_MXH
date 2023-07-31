package com.example.btl_mxh.ui.search

import android.util.Log
import com.example.btl_mxh.BuildConfig
import androidx.navigation.fragment.findNavController
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    private val adapter by lazy {
        SearchAdapter(
            requireContext(),
            onclickFriend = {
                findNavController().navigate(R.id.action_searchFragment_to_friendFragment)
            }
        )
    }
    override val viewModel by viewModel<SearchViewModel>()

    override fun initData() {

    }

    override fun handleEvent() {
        binding.apply {
//            btnSearch.setOnClickListener {
//                viewModel.searchByName(edtSearch.text.toString())
//            }
        }
    }

    override fun bindData() {
        binding.apply {
            recyclerview.adapter = adapter
        }
//        viewModel.searchResult.observe(this) {
//            adapter.setlist(viewModel.searchResult)


//        }
    }

}