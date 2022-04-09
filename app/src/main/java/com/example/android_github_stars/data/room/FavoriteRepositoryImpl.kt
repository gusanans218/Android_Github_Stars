package com.example.android_github_stars.data.room

import com.example.android_github_stars.domain.FavoriteRepository
import com.example.android_github_stars.domain.model.FavoriteItemModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

//1. FavoriteRepository를 구현했습니다.
//2. DAO를 통해 Room의 저장된 즐겨찾기 유저를 불러오고 즐겨찾기 추가,해제를 담당합니다.
//3. 초성에 따라 헤더를 나누고 정렬합니다. (20~25번째 줄)

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

                list.filter{
                    it.login.contains(name)
                }.sortedBy { it.login.lowercase()[0].code }.forEach{ favoriteItem ->
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

}