package com.example.btl_mxh.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

private const val TAG = "BaseViewModel"
open class BaseViewModel : ViewModel() {

    private val loading: MutableLiveData<Boolean> = MutableLiveData(false)
    private val error = MutableLiveData<String>()

    val isLoading: LiveData<Boolean>
        get() = loading
    val isError: LiveData<String>
        get() = error

    protected fun <T> executeTask(
        request: suspend CoroutineScope.() -> DataResult<T>,
        onSuccess: (T) -> Unit,
        onError: (Exception) -> Unit = {},
        showLoading: Boolean = false
    ) {
        if (showLoading)
            showLoading()
        viewModelScope.launch {
            when (val response = request(this)) {
                is DataResult.Success -> {
                    onSuccess(response.data)
                    hideLoading()
                }
                is DataResult.Error -> {
                    if (response.exception is HttpException) {
                        try {
                            val errorBody = response.exception.response()?.errorBody()?.string()
                            val gson = Gson()
                            val errorResponse = gson.fromJson(errorBody, BaseResponse::class.java)
                            val errorMessage = errorResponse.message
                            error.postValue(errorMessage.toString())
                            // Xử lý thông báo lỗi (errorMessage) tại đây
                            Log.e(TAG,"hihi")
                        } catch (e: Exception) {
                            // Xử lý nếu có lỗi khi phân tích dữ liệu phản hồi JSON
                            error.postValue(response.exception.toString())
                        }
                        hideLoading()
                    }
                    onError(response.exception)
                }
            }
        }


    }

    private fun showLoading() {
        loading.postValue(true)
    }

    private fun hideLoading() {
        loading.postValue(false)
    }
}