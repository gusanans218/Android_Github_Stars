package com.example.android_github_stars.domain.usecase

import com.example.android_github_stars.domain.FavoriteRepository
import com.example.android_github_stars.domain.model.FavoriteItemModel
import io.reactivex.rxjava3.core.Single

// 즐겨찾기한 유저를 불러오는 로직을 담당합니다.

class GetFavoriteListUseCase(val repository: FavoriteRepository) : UseCase {
    operator fun invoke(): Single<List<FavoriteItemModel>> {
        return repository.getAll()
    }

}