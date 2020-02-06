package com.example.mvi.ghenamd.api

import androidx.lifecycle.LiveData
import com.example.mvi.ghenamd.model.BlogPost
import com.example.mvi.ghenamd.model.User
import com.example.mvi.ghenamd.util.GenericApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("placeholder/user/{userId}")
    fun getUser(@Path("userId") userId:String):LiveData<GenericApiResponse<User>>

    @GET("placeholder/blogs")
    fun getBlogs():LiveData<GenericApiResponse<List<BlogPost>>>

}