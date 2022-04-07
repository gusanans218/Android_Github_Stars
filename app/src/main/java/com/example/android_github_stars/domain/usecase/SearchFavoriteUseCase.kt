package com.example.android_github_stars.domain.usecase

import com.example.android_github_stars.domain.FavoriteRepository
import com.example.android_github_stars.domain.model.FavoriteItemModel
import io.reactivex.rxjava3.core.Single

class SearchFavoriteUseCase (val repository: FavoriteRepository):UseCase {
    operator fun invoke(name:String): Single<List<FavoriteItemModel>> {
        return repository.getFavoriteByName(name)
    }
}