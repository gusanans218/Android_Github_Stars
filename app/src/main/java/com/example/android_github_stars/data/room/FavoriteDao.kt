package com.example.android_github_stars.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface FavoriteDao {
    @Query("select * from FavoriteItem")
    fun getAll(): Single<List<FavoriteItem>>

    @Insert
    fun insert(item: FavoriteItem): Completable

    @Query("delete from FavoriteItem WHERE id=:id")
    fun deleteById(id: Int): Completable
}