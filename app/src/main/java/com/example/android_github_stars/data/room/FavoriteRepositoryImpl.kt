package com.example.android_github_stars.data.room

import com.example.android_github_stars.domain.FavoriteRepository
import com.example.android_github_stars.domain.model.FavoriteItemModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class FavoriteRepositoryImpl(val dao: FavoriteDao):FavoriteRepository {

    override fun getAll(): Single<List<FavoriteItemModel>> {
       return dao.getAll().compose{ response ->
           response.map { list ->
               val returnList = arrayListOf<FavoriteItemModel>()
               var item : Char = 0.toChar()

               list.sortedBy { it.login.lowercase()[0].code }.forEach{ favoriteItem ->
                   if(item < favoriteItem.login.lowercase()[0]){
                       item = favoriteItem.login.lowercase()[0]
                       returnList.add(FavoriteItemModel(0, "", item.toString()))
                   }
                   returnList.add(FavoriteMapper.favoriteDomainData(favoriteItem))
               }
               returnList
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
                val returnList = arrayListOf<FavoriteItemModel>()
                var item : Char = 0.toChar()

                list.sortedBy { it.login.lowercase()[0].code }.forEach{ favoriteItem ->
                    if(item < favoriteItem.login.lowercase()[0]){
                        item = favoriteItem.login.lowercase()[0]
                        returnList.add(FavoriteItemModel(0, "", item.toString()))
                    }
                    returnList.add(FavoriteMapper.favoriteDomainData(favoriteItem))
                }
                returnList.filter{
                    it.login.contains(name)
                }
            }
        }
    }

}