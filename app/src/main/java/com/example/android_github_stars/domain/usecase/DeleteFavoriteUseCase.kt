package com.example.android_github_stars.domain.usecase

import com.example.android_github_stars.domain.FavoriteRepository
import io.reactivex.rxjava3.core.Completable

class DeleteFavoriteUseCase(val repository: FavoriteRepository):UseCase {
    operator fun invoke(id:Int): Completable {
        return repository.deleteById(id)
    }
}