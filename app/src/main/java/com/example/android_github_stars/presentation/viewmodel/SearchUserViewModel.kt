package com.example.android_github_stars.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.android_github_stars.domain.usecase.SearchGitHubUserUseCase
import com.example.android_github_stars.domain.usecase.UseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchUserViewModel(val searchGitHubUserUseCase: SearchGitHubUserUseCase):ViewModel() {
    val dispose = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        dispose.dispose()
    }
    fun searchGithubUser(searchText:String){
        searchGitHubUserUseCase(searchText = searchText)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },{
                it.printStackTrace()
            }).addTo(dispose)
    }
}