package com.example.btl_mxh.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    private val loading: MutableLiveData<Boolean> = MutableLiveData(false)
    private val error: MutableLiveData<String> = MutableLiveData("")

    val isLoading: LiveData<Boolean>
        get() = loading
    val isError: LiveData<String>
        get() = error

    protected fun <T> executeTask(
        request: suspend CoroutineScope.() -> DataResult<T>,
        onSuccess: (T) -> Unit,
        onError: (Exception) -> Unit = {},
        showLoading: Boolean = true
    ) {
        showLoading()

        viewModelScope.launch {
            when (val response = request(this)) {
                is DataResult.Success -> {
                    hideLoading()
                    onSuccess(response.data)
                }
                is DataResult.Error -> {
                    hideLoading()
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