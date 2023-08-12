package com.example.btl_mxh.ui.friend

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.data.remote.repository.follow.IFollowRepository
import com.example.btl_mxh.data.remote.repository.post.IPostRepository
import com.example.btl_mxh.model.*
import com.example.btl_mxh.utils.extension.getUserId

private const val TAG = "FriendViewModel"

class FriendViewModel(
    private val accountRepo: IAccountRepository,
    private val postRepo: IPostRepository,
    private val followRepo: IFollowRepository,
    private val sharedPreferences: SharedPreferences
) : BaseViewModel() {
    private val _stageGetById = MutableLiveData<GetById>()
    val stageGetById: LiveData<GetById> = _stageGetById

    private val _stageListPost = MutableLiveData<List<String>>()
    val stageListPost: LiveData<List<String>> = _stageListPost

    private val _stageGetFollowers = MutableLiveData<GetFollowers>()
    val stageGetFollowers: LiveData<GetFollowers> = _stageGetFollowers

    private val _stageUnFollow = MutableLiveData<Delete>()
    val stageUnFollow: LiveData<Delete> = _stageUnFollow

    private val _stageFollow = MutableLiveData<Follow>()
    val stageFollow: LiveData<Follow> = _stageFollow

    fun getUserById(userId: String) {
        executeTask(
            request = { accountRepo.getById(userId) },
            onSuccess = {
                if (it.status == "SUCCESS") {
                    it.data?.let { _getById ->
                        _stageGetById.value = _getById
                    }
                } else
                    Log.e(TAG, "getUserById: ${it.message}")
            },
            onError = {
                Log.e(TAG, "getUserById: ${it.message}")
            }, showLoading = true
        )
    }

    fun getAllUserById(userId: String) {
        executeTask(
            request = { postRepo.getAllByUserId(userId) },
            onSuccess = {
                if (it.status == "SUCCESS") {
                    it.data?.let { _listPost ->
                        _stageListPost.value = getListImagePost(_listPost)
                    }
                } else
                    Log.e(TAG, "getUserById: ${it.message}")
            },
            onError = {
                Log.e(TAG, "getUserById: ${it.message}")
            }, showLoading = true
        )
    }

    fun getFollowers(userId: String) {
        executeTask(
            request = { followRepo.getFollowers(userId) },
            onSuccess = {
                if (it.status == "SUCCESS") {
                    it.data?.let { _getFollowers ->
                        _stageGetFollowers.value = _getFollowers
                    }
                } else
                    Log.e(TAG, "getFollowers: ${it.message}")

            },
            onError = {
                Log.e(TAG, "getFollowers: ${it.message}")
            }
        )
    }

    fun unFollow(userId: String) {
        executeTask(
            request = { followRepo.unFollow(userId) },
            onSuccess = {
                if (it.status == "SUCCES") {
                    it.data?.let { _delete ->
                        _stageUnFollow.value = _delete
                    }
                } else
                    Log.e(TAG, "unFollow: ${it.message}")
            },
            onError = {
                Log.e(TAG, "unFollow: ${it.message}")
            }
        )
    }
    fun follow(userId: String) {
        executeTask(
            request = { followRepo.Follow(userId) },
            onSuccess = {
                if (it.status == "SUCCES") {
                    it.data?.let { _follow ->
                        _stageFollow.value = _follow
                    }
                } else
                    Log.e(TAG, "unFollow: ${it.message}")
            },
            onError = {
                Log.e(TAG, "unFollow: ${it.message}")
            }
        )
    }

    private fun getListImagePost(allPost: List<Post>): List<String> {
        val listAllImagePost = mutableListOf<String>()
        for (i in 0 until allPost.size) {
            allPost[i].mediaFiles?.let { listAllImagePost.addAll(it) }
        }
        return listAllImagePost
    }

    fun checkUserId(getFollowers: GetFollowers): Boolean {
        val userId = sharedPreferences.getUserId()
        Log.e(TAG, "checkUserId: $userId")
        getFollowers.items.forEach {
            if (it.id == userId)
                return true
        }
        return false
    }
}