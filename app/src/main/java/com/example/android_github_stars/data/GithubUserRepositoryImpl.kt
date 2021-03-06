package com.example.android_github_stars.data

import com.example.android_github_stars.domain.GithubUserRepository
import com.example.android_github_stars.domain.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

// User를 검색한 결과를 가져오는 GithubUserRespository를 구현했습니다.

class GithubUserRepositoryImpl(val api: API) : GithubUserRepository {
    override fun searchUser(searchText: String): Single<GithubUserModel> {
        return api.getSearchUsers(searchText).map {
            GithubUserMapper.gitHubUser2Model(it)
        }
    }

}