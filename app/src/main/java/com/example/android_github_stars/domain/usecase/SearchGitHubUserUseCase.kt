package com.example.android_github_stars.domain.usecase

import com.example.android_github_stars.domain.GithubUserRepository
import com.example.android_github_stars.domain.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

// 깃허브 API를 통해 유저를 검색하는 로직입니다.

class SearchGitHubUserUseCase(val repository: GithubUserRepository) : UseCase {
    operator fun invoke(searchText: String): Single<GithubUserModel> {
        return repository.searchUser(searchText = searchText)
    }
}