package com.example.android_github_stars.data

import com.example.android_github_stars.domain.GithubUserRepository
import com.example.android_github_stars.domain.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

class GithubUserRepositoryImpl(val api:API):GithubUserRepository {
    override fun searchUser(searchText:String): Single<GithubUserModel> {
        return api.getSearchUsers(searchText).map {
            GithubUserMapper.gitHubUser2Model(it)
        }
    }

}