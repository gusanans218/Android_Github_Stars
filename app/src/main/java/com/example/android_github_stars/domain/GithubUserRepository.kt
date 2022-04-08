package com.example.android_github_stars.domain

import com.example.android_github_stars.domain.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface GithubUserRepository {
    fun searchUser(searchText: String): Single<GithubUserModel>
}
