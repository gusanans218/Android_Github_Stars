package com.example.android_github_stars.di

import com.example.android_github_stars.data.API
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module{
    single{
        GsonConverterFactory.create() as Converter.Factory
    }

    single { RxJava3CallAdapterFactory.create() as CallAdapter.Factory }

    single {
        Retrofit.Builder()
            .addCallAdapterFactory(get())
            .addConverterFactory(get())
            .baseUrl("https://api.github.com/")
            .build()
            .create(API::class.java)
    }
}