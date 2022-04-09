package com.example.android_github_stars.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteItem(

    @PrimaryKey
    val id: Int,
    val avatarUrl: String,
    val login: String
)
