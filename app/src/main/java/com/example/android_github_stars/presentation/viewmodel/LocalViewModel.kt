package com.example.android_github_stars.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_github_stars.domain.model.FavoriteItemModel
import com.example.android_github_stars.domain.usecase.*
import com.example.android_github_stars.presentation.adapter.ApiRecyclerViewAdapter
import com.example.android_github_stars.presentation.adapter.LocalAdapter
import com.example.android_github_stars.presentation.adapter.OnClickFavorite
import com.example.android_github_stars.presentation.adapter.OnClickLocalFavorite
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class LocalViewModel(
    val searchFavoriteUseCase: SearchFavoriteUseCase,
    val insertFavoriteUseCase: InsertFavoriteUseCase,
    val deleteFavoriteUseCase: DeleteFavoriteUseCase,
) : ViewModel() {
    val text = MutableLiveData<String>("")
    val dispose = CompositeDisposable()
    val adapter = LocalAdapter(listOf(), onClickLocalFavorite = object : OnClickLocalFavorite {
        override fun onClickStar(itemModel: FavoriteItemModel, type: Int) {
            if (type == 1) {
                insertFavorite(itemModel)
            } else {
                deleteFavorite(itemModel.id)
            }
        }

    })


    override fun onCleared() {
        super.onCleared()
        dispose.dispose()
    }

    fun searchGithubUser(searchText: String) {
        searchFavoriteUseCase(searchText)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                adapter.setItem(it)
            }, {
                it.printStackTrace()
            }).addTo(dispose)

    }

    fun deleteFavorite(id: Int) {
        deleteFavoriteUseCase(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, {
                it.printStackTrace()
            }).addTo(dispose)

    }

    fun insertFavorite(itemModel: FavoriteItemModel) {
        insertFavoriteUseCase(itemModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, {
                it.printStackTrace()
            }).addTo(dispose)

    }


}