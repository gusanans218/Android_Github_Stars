package com.example.android_github_stars.data.room

import com.example.android_github_stars.domain.model.FavoriteItemModel

// Data의 Entity를 Domain에 있는 DTO 형태로 변경하기 위해 또는 그 반대로 변경하기 위해 만들어진 클래스입니다.

object FavoriteMapper {

    fun favoriteDomainData(favoriteItem: FavoriteItem): FavoriteItemModel {
        return FavoriteItemModel(
            id = favoriteItem.id,
            avatarUrl = favoriteItem.avatarUrl,
            login = favoriteItem.login
        )

    }

    fun favoriteDataDomain(favoriteItemModel: FavoriteItemModel): FavoriteItem {
        return FavoriteItem(
            id = favoriteItemModel.id,
            avatarUrl = favoriteItemModel.avatarUrl,
            login = favoriteItemModel.login
        )
    }

}