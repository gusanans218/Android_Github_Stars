package com.example.android_github_stars.domain.model

data class GithubUserModel(
    val incomplete_results: Boolean,
    val items: List<ItemModel>,
    val total_count: Int
)