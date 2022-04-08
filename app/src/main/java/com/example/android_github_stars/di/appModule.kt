package com.example.android_github_stars.di

import android.app.Application
import androidx.room.Room
import androidx.viewbinding.BuildConfig
import com.example.android_github_stars.data.API
import com.example.android_github_stars.data.GithubUserRepositoryImpl
import com.example.android_github_stars.data.room.FavoriteDao
import com.example.android_github_stars.data.room.FavoriteDatabase
import com.example.android_github_stars.data.room.FavoriteRepositoryImpl
import com.example.android_github_stars.domain.FavoriteRepository
import com.example.android_github_stars.domain.GithubUserRepository
import com.example.android_github_stars.domain.usecase.*
import com.example.android_github_stars.presentation.viewmodel.ApiFragmentItemViewModel
import com.example.android_github_stars.presentation.viewmodel.LocalViewModel
import com.example.android_github_stars.presentation.viewmodel.SearchUserViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        GsonConverterFactory.create() as Converter.Factory
    }

    single {
        SearchFavoriteUseCase(get())
    }
    single {
        SearchGitHubUserUseCase(get())
    }
    single {
        InsertFavoriteUseCase(get())
    }
    single {
        DeleteFavoriteUseCase(get())
    }
    single {
        GetFavoriteListUseCase(get())
    }

    single {
        val repository: GithubUserRepository = GithubUserRepositoryImpl(get())
        repository
    }

    single {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        };


        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                chain.proceed(request.build())
            }.build()
    }


    single { RxJava3CallAdapterFactory.create() as CallAdapter.Factory }
    viewModel { ApiFragmentItemViewModel() }
    viewModel { SearchUserViewModel(get(), get(), get(), get()) }
    viewModel { LocalViewModel(get(), get(), get()) }

    single {
        Retrofit.Builder()
            .addCallAdapterFactory(get())
            .addConverterFactory(get())
            .client(get())
            .baseUrl("https://api.github.com/")
            .build()
            .create(API::class.java)

    }


    fun getAppDatabase(application: Application): FavoriteDatabase {
        return application.let {
            Room.databaseBuilder(it, FavoriteDatabase::class.java, "chatData.db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    fun getDao(dataBase: FavoriteDatabase): FavoriteDao {
        return dataBase.favoriteDao()
    }

    single { getAppDatabase(androidApplication()) }
    single { getDao(get()) }
    single {
        val repository: FavoriteRepository = FavoriteRepositoryImpl(get())
        repository
    }

}