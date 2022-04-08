package com.example.android_github_stars.data


import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String
)