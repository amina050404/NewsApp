package com.example.newsapp.data.network

import com.example.newsapp.BuildConfig
import com.example.newsapp.data.network.remote.NewsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule= module {
    single { provideApi(get()) }
    single { provideRetrofit(get()) }
    single { provideClient() }
}

fun provideApi(retrofit: Retrofit):NewsApi{
    return retrofit.create(NewsApi::class.java)
}

fun provideRetrofit(okkHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okkHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideClient(): OkHttpClient {

    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient.Builder().writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS).connectTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(interceptor).build()
}