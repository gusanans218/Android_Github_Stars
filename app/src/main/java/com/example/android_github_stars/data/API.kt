package com.example.android_github_stars.data

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("search/users")
     fun getSearchUsers(
        @Query("q") username : String
    ): Single<GithubUser>
}