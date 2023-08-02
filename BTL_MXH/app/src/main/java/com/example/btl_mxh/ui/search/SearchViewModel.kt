package com.example.btl_mxh.ui.search

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository
import com.example.btl_mxh.model.Search

private const val TAG = "SeachViewModel"

class SearchViewModel(

    private val loginRepo: IAccountRepository,
    private val sharedPreferences: SharedPreferences,
//    private val searchRepo: ISearchRepository
) : BaseViewModel() {
    private val _searchResult = MutableLiveData<Search>()
    val searchResult: LiveData<Search> = _searchResult


//    fun searchByName(searchKey: String) {
//        executeTask(
//            request = { searchRepo.searchByName(searchKey) },
//            onSuccess = {
//                _searchResult.value = it
//                Log.e(TAG, "searchByName: ${it.toString()}")
//            },
//            onError = {
//                Log.e(TAG, "searchByName: ${it.toString()}")
//            }
//        )
//    }


}