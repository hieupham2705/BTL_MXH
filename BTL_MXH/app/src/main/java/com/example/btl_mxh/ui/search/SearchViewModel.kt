package com.example.btl_mxh.ui.search

<<<<<<< HEAD
import com.example.btl_mxh.base.BaseViewModel
=======
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.btl_mxh.base.BaseViewModel
import com.example.btl_mxh.data.remote.repository.account.IAccountRepository

private const val TAG = "SeachViewModel"

class SearchViewModel(

    private val loginRepo: IAccountRepository,
    private val sharedPreferences: SharedPreferences,
//    private val searchRepo: ISearchRepository
) : BaseViewModel() {


<<<<<<< HEAD
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
=======
>>>>>>> 5d9c199773c4c8868da2936495f681d6398018bb

}