package com.example.newsapp.data.network.remote

import com.example.newsapp.BuildConfig
import com.example.newsapp.model.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("q") search: String,
        @Query("pageSize") pageSize: Int = 10,
        @Query("page") page: Int = 1,
    ): Response<News>
}