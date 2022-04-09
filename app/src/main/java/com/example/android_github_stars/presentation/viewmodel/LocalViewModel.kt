package com.example.android_github_stars.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_github_stars.domain.model.FavoriteItemModel
import com.example.android_github_stars.domain.usecase.DeleteFavoriteUseCase
import com.example.android_github_stars.domain.usecase.InsertFavoriteUseCase
import com.example.android_github_stars.domain.usecase.SearchFavoriteUseCase
import com.example.android_github_stars.presentation.adapter.LocalAdapter
import com.example.android_github_stars.presentation.adapter.OnClickLocalFavorite
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

// UseCase로부터 검색 결과값을 받아 View에 데이터를 바인딩해주고
// View의 이벤트에 따라 즐겨찾기 유저를 추가 및 삭제 기능을 가지고 있습니다.

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