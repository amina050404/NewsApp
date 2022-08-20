package com.example.newsapp

import android.app.Application
import com.example.newsapp.data.network.networkModule
import com.example.newsapp.di.repoModule
import com.example.newsapp.di.viewModelModule
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(networkModule, repoModule, viewModelModule))
        }
    }
}