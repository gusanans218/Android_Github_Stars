package com.example.android_github_stars.data


import com.google.gson.annotations.SerializedName

data class GithubUser(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<ItemResponse>,
    @SerializedName("total_count")
    val totalCount: Int
)