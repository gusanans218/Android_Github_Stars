package com.example.android_github_stars.domain

import com.example.android_github_stars.domain.model.FavoriteItemModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface FavoriteRepository {
    fun getAll(): Single<List<FavoriteItemModel>>
    fun insert(insertone:FavoriteItemModel):Completable
    fun deleteById(id:Int):Completable
    fun getFavoriteByName(name:String): Single<List<FavoriteItemModel>>
}