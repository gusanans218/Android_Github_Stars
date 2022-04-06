package com.example.android_github_stars.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_github_stars.domain.usecase.SearchGitHubUserUseCase
import com.example.android_github_stars.presentation.adapter.ApiRecyclerViewAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchUserViewModel(val searchGitHubUserUseCase: SearchGitHubUserUseCase):ViewModel() {
    val text = MutableLiveData<String>("")
    val dispose = CompositeDisposable()
    val adapter = ApiRecyclerViewAdapter(listOf())


    override fun onCleared() {
        super.onCleared()
        dispose.dispose()
    }
    fun searchGithubUser(searchText:String){
        searchGitHubUserUseCase(searchText = searchText)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("Name = Response",it.toString())
                adapter.setItem(it.items)
            },{
                it.printStackTrace()
            }).addTo(dispose)

    }
}