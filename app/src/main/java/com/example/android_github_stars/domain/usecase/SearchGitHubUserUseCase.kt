package com.example.android_github_stars.domain.usecase

import com.example.android_github_stars.domain.GithubUserRepository
import com.example.android_github_stars.domain.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

class SearchGitHubUserUseCase(val repository: GithubUserRepository) : UseCase {
    operator fun invoke(searchText: String): Single<GithubUserModel> {
        return repository.searchUser(searchText = searchText)
    }
}