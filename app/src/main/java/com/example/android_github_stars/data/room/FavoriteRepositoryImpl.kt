package com.example.android_github_stars.data.room

import com.example.android_github_stars.domain.FavoriteRepository
import com.example.android_github_stars.domain.model.FavoriteItemModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class FavoriteRepositoryImpl(val dao: FavoriteDao):FavoriteRepository {

    override fun getAll(): Single<List<FavoriteItemModel>> {
       return dao.getAll().compose{ response ->
           response.map { list ->
               list.map {
                   FavoriteMapper.favoriteDomainData(it)
               }
           }
       }
    }

    override fun insert(insertone: FavoriteItemModel): Completable {
        return dao.insert(FavoriteMapper.favoriteDataDomain(insertone))
    }

    override fun deleteById(id: Int): Completable {
        return dao.deleteById(id)
    }

    override fun getFavoriteByName(name: String): Single<List<FavoriteItemModel>> {
        return dao.getAll().compose{ response ->
            response.map { list ->
                list.map {
                    FavoriteMapper.favoriteDomainData(it)
                }.filter {
                    it.login.contains(name)
                }
            }
        }
    }

}