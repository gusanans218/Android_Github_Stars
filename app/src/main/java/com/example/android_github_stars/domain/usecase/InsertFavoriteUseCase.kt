package com.example.android_github_stars.domain.usecase

import com.example.android_github_stars.domain.FavoriteRepository
import com.example.android_github_stars.domain.model.FavoriteItemModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class InsertFavoriteUseCase(val repository: FavoriteRepository) : UseCase {
    operator fun invoke(itemModel: FavoriteItemModel): Completable {
        return repository.insert(itemModel)
    }
}