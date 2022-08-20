package com.example.newsapp.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import com.example.newsapp.base.BaseViewModel
import com.example.newsapp.data.network.remote.repo.Repository

class NewsViewModel(private val repository: Repository) : BaseViewModel() {

    private val service = MutableLiveData<String>()

    val serviceNews = service.switchMap { search ->
        repository.getNews(search)
    }

    fun getNews(search: String) {
        service.value = search
    }
}