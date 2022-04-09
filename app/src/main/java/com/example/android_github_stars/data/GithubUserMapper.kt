package com.example.android_github_stars.data

import com.example.android_github_stars.domain.model.GithubUserModel
import com.example.android_github_stars.domain.model.ItemModel

// Data의 Api Response를 Domain에 있는 DTO 형태로 변경하기 위해 만들어진 클래스입니다.

object GithubUserMapper {

    fun itemResponse2Model(itemResponse: ItemResponse): ItemModel {
        return ItemModel(
            avatar_url = itemResponse.avatarUrl,
            id = itemResponse.id,
            login = itemResponse.login,
        )

    }

    fun gitHubUser2Model(githubUser: GithubUser): GithubUserModel {
        return GithubUserModel(
            incomplete_results = githubUser.incompleteResults,
            items = itemResponses2Models(githubUser.items),
            total_count = githubUser.totalCount
        )
    }

    fun itemResponses2Models(list: List<ItemResponse>): ArrayList<ItemModel> {
        val arrayList: ArrayList<ItemModel> = arrayListOf()
        list.forEach {
            arrayList.add(
                itemResponse2Model(itemResponse = it)
            )
        }
        return arrayList
    }
}