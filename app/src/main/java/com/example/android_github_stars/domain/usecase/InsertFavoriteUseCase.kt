package com.example.android_github_stars.domain.usecase

import com.example.android_github_stars.domain.FavoriteRepository
import com.example.android_github_stars.domain.model.FavoriteItemModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

// 즐겨찾기를 추가하는 로직을 담당합니다.

class InsertFavoriteUseCase(val repository: FavoriteRepository) : UseCase {
    operator fun invoke(itemModel: FavoriteItemModel): Completable {
        return repository.insert(itemModel)
    }
}