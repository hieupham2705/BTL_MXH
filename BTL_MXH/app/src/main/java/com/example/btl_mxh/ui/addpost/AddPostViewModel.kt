package com.example.btl_mxh.ui.addpost

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.post.IPostRepository
import com.example.btl_mxh.model.CreateNewPost
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

private const val TAG = "AddTextViewModel"

class AddPostViewModel(
    private val postRepo: IPostRepository
) : BaseViewModel() {
    private val _stageCreateNewPost = MutableLiveData<CreateNewPost>()
    val stageCreateNewPost: LiveData<CreateNewPost> = _stageCreateNewPost
    fun createNewPost(
        caption: String,
        files: List<File>
    ) {
        val file = files.map {
            MultipartBody.Part.createFormData(
                "file", it.name,
                it.asRequestBody("multipart/form-data".toMediaType())
            )
        }
        Log.e(TAG, files.toString())
        executeTask(
            request = {
                Log.e(TAG, "request")
                postRepo.createNewPost(
                    caption, file
                )
            },
            onSuccess = {
                if (it.status == "SUCCESS") {
                    it.data?.let { _createNewPost ->
                        _stageCreateNewPost.value = _createNewPost
                    }
                } else {
                    Log.e("logout :", it.message.toString())
                }
            },
            onError = {
                Log.e("logout :", it.message.toString())
            }
        )
    }
}