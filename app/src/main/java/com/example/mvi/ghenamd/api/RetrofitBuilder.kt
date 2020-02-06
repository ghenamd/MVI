package com.example.mvi.ghenamd.api

import com.example.mvi.ghenamd.util.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://open-api.xyz"
object RetrofitBuilder {
   private val retrofitBuilder:Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
    }

    val apiService:ApiService by lazy {
        retrofitBuilder
            .build()
            .create(ApiService::class.java)
    }
}