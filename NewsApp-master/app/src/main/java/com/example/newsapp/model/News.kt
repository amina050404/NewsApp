package com.example.newsapp.model

data class News(
    var articles: List<Article?>? = null,
    var status: String? = null, // ok
    var totalResults: Int? = null // 13885
)