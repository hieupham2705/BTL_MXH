package com.example.btl_mxh.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
<<<<<<< HEAD
import com.example.btl_mxh.R
=======
import com.example.btl_mxh.base.BaseViewModel
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.data.remote.repository.post.IPostRepository
import com.example.btl_mxh.model.AllPostByUserName
import com.example.btl_mxh.model.Auth
<<<<<<< HEAD
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.model.profile
private const val TAG = "ProfileViewModel"
class ProfileViewModel : BaseViewModel() {
    val list = listOf<profile>(
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
        profile(R.drawable.hit, R.drawable.hit, R.drawable.hit),
    )

=======
import com.example.btl_mxh.model.Post

private const val TAG = "ProfileViewModel"
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb

class ProfileViewModel(
    private val accountRepo: IAccountRepository,
    private val postRepo: IPostRepository
) : BaseViewModel() {
    private val _stateAuth = MutableLiveData<Auth>()
    val stateAuth: LiveData<Auth> = _stateAuth

    private val _stateAllPost = MutableLiveData<List<String>>()
    val stateAllPost: LiveData<List<String>> = _stateAllPost
    fun auth() {
        executeTask(
            request = { accountRepo.authLogin() },
            onSuccess = {
                _stateAuth.value = it.data!!
            },
            onError = {
                Log.e(TAG, "login:${it.message.toString()}")

            }
        )
    }

    fun getAllByUsername(userName:String) {
        executeTask(
            request = { postRepo.getAllByUsername(userName) },
            onSuccess = {
                if (it.status == "SUCCESS") {
                    it.data?.let { _allPost ->
                        _stateAllPost.value = getListImagePost(_allPost)
                    }
                } else
                    Log.e(TAG, "login:${it.message.toString()}")
            },
            onError = {
                Log.e(TAG, "login:${it.message.toString()}")

            }
        )
    }
    private fun getListImagePost(allPost : List<Post>) : List<String>{
        val listAllImagePost = mutableListOf<String>()
        for(i in 0 until allPost.size){
            allPost[i].mediaFiles?.let { listAllImagePost.addAll(it) }
        }
        return listAllImagePost
    }
}