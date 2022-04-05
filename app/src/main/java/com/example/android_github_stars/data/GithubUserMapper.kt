package com.example.android_github_stars.data

import com.example.android_github_stars.domain.model.GithubUserModel
import com.example.android_github_stars.domain.model.ItemModel

object GithubUserMapper {

    fun itemResponse2Model(itemResponse: ItemResponse):ItemModel {
        return ItemModel(
            avatar_url = itemResponse.avatarUrl,
            events_url = itemResponse.eventsUrl,
            followers_url = itemResponse.followersUrl,
            following_url = itemResponse.followingUrl,
            gists_url = itemResponse.gistsUrl,
            gravatar_id = itemResponse.gravatarId,
            html_url = itemResponse.htmlUrl,
            id = itemResponse.id,
            login = itemResponse.login,
            node_id = itemResponse.nodeId,
            organizations_url = itemResponse.organizationsUrl,
            received_events_url = itemResponse.receivedEventsUrl,
            repos_url = itemResponse.reposUrl,
            score = itemResponse.score,
            site_admin = itemResponse.siteAdmin,
            starred_url = itemResponse.starredUrl,
            subscriptions_url = itemResponse.subscriptionsUrl,
            type = itemResponse.type,
            url = itemResponse.url,
        )

    }
    fun gitHubUser2Model(githubUser: GithubUser):GithubUserModel{
        return GithubUserModel(
            incomplete_results= githubUser.incompleteResults,
            items= itemResponses2Models(githubUser.items),
            total_count=githubUser.totalCount
        )
    }

    fun itemResponses2Models(list: List<ItemResponse>):ArrayList<ItemModel> {
        val arrayList: ArrayList<ItemModel> = arrayListOf()
        list.forEach {
            arrayList.add(
                itemResponse2Model(itemResponse = it)
            )
        }
        return arrayList
    }
}