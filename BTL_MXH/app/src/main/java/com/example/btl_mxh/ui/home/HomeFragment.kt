package com.example.btl_mxh.ui.home

import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.view.Gravity
import androidx.core.content.ContextCompat
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
import com.skydoves.powermenu.MenuAnimation
import com.skydoves.powermenu.PowerMenu
import com.skydoves.powermenu.PowerMenuItem
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
                    onClickMoreVert = { onClickMoreVert() },
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

    private fun onClickMoreVert() {
        val list = listOf(PowerMenuItem("Travel"),PowerMenuItem("Travel"),PowerMenuItem("Travel"))
        val powerMenu = PowerMenu.Builder(context!!)
            .addItemList(list) // list has "Novel", "Poetry", "Art"
            .addItem(PowerMenuItem("Journals", false)) // add an item.
            .addItem(PowerMenuItem("Travel", false)) // aad an item list.
            .setAnimation(MenuAnimation.SHOWUP_TOP_LEFT) // Animation start point (TOP | LEFT).
            .setMenuRadius(10f) // sets the corner radius.
            .setMenuShadow(10f) // sets the shadow.
            .setTextColor(ContextCompat.getColor(context!!, com.example.btl_mxh.R.color.Blue1))
            .setTextGravity(Gravity.CENTER)
            .setTextTypeface(Typeface.create("sans-serif-medium", Typeface.BOLD))
            .setSelectedTextColor(Color.WHITE)
            .setMenuColor(Color.WHITE)
            .setSelectedMenuColor(ContextCompat.getColor(context!!, com.example.btl_mxh.R.color.Red))
            .build()
        powerMenu.showAsDropDown(view)
    }

}
