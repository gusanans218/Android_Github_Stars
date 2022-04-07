package com.example.android_github_stars.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteItem::class],version = 1)
abstract class FavoriteDatabase:RoomDatabase() {

    abstract fun favoriteDao():FavoriteDao





}