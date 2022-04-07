package com.example.android_github_stars.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class FavoriteItem(

    @PrimaryKey
    val id: Int,
    val avatarUrl: String,
    val login: String
)
