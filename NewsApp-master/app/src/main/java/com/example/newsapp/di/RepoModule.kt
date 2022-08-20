package com.example.newsapp.di

import com.example.newsapp.data.network.remote.repo.Repository
import org.koin.dsl.module

val repoModule = module {
    single { Repository(get()) }
}