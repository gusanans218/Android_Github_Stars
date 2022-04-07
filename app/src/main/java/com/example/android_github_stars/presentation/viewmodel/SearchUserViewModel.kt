package com.example.android_github_stars.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_github_stars.domain.model.FavoriteItemModel
import com.example.android_github_stars.domain.usecase.DeleteFavoriteUseCase
import com.example.android_github_stars.domain.usecase.GetFavoriteListUseCase
import com.example.android_github_stars.domain.usecase.InsertFavoriteUseCase
import com.example.android_github_stars.domain.usecase.SearchGitHubUserUseCase
import com.example.android_github_stars.presentation.adapter.ApiRecyclerViewAdapter
import com.example.android_github_stars.presentation.adapter.OnClickFavorite
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchUserViewModel(
    val searchGitHubUserUseCase: SearchGitHubUserUseCase,
    val insertFavoriteUseCase: InsertFavoriteUseCase,
    val deleteFavoriteUseCase: DeleteFavoriteUseCase,
    val getFavoriteListUseCase: GetFavoriteListUseCase
):ViewModel() {
    val text = MutableLiveData<String>("")
    val dispose = CompositeDisposable()
    val adapter = ApiRecyclerViewAdapter(listOf(),onClickFavorite = object : OnClickFavorite{
        override fun onClickStar(itemModel: FavoriteItemModel, type: Int) {
            if (type == 1){
                insertFavorite(itemModel)
            }
            else{
                deleteFavorite(itemModel.id)
            }
        }

    })


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
                getFavorite()
            },{
                it.printStackTrace()
            }).addTo(dispose)

    }

    fun deleteFavorite(id:Int){
        deleteFavoriteUseCase(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            },{
                it.printStackTrace()
            }).addTo(dispose)

    }

    fun insertFavorite(itemModel: FavoriteItemModel){
        insertFavoriteUseCase(itemModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            },{
                it.printStackTrace()
            }).addTo(dispose)

    }

    fun getFavorite(){
        getFavoriteListUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       adapter.getFavorite(it)
            },{
                it.printStackTrace()
            }).addTo(dispose)

    }
}