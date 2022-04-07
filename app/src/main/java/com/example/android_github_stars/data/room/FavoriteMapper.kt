package com.example.android_github_stars.data.room

import com.example.android_github_stars.domain.model.FavoriteItemModel

object FavoriteMapper {

    fun favoriteDomainData(favoriteItem: FavoriteItem):FavoriteItemModel{
        return FavoriteItemModel(
            id = favoriteItem.id,
            avatarUrl = favoriteItem.avatarUrl,
            login = favoriteItem.login
        )

    }

    fun favoriteDataDomain(favoriteItemModel: FavoriteItemModel):FavoriteItem{
        return FavoriteItem(
            id = favoriteItemModel.id,
            avatarUrl = favoriteItemModel.avatarUrl,
            login = favoriteItemModel.login
        )
    }

}