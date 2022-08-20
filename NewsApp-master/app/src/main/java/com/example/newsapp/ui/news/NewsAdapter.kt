package com.example.newsapp.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.model.Article
import com.example.newsapp.model.News

class NewsAdapter(private val data: News) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(data.articles?.get(position))
    }

    override fun getItemCount(): Int = data.articles?.size ?: 0

    class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(get: Article?) {
            binding.imageNews.load(get?.urlToImage)
            binding.titleNews.text = get?.title
            binding.tvTime.text = get?.publishedAt
        }

    }

}
