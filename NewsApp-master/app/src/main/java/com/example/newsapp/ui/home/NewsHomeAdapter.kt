package com.example.newsapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsapp.databinding.ItemBreakingNewsBinding
import com.example.newsapp.model.Article
import com.example.newsapp.model.News

class NewsHomeAdapter(private val data: News) :
    RecyclerView.Adapter<NewsHomeAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(ItemBreakingNewsBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(data.articles?.get(position))
    }

    override fun getItemCount(): Int = data.articles?.size ?: 0

    class NewsViewHolder(private val binding: ItemBreakingNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(get: Article?) {
            binding.image.load(get?.urlToImage)
            binding.tvTitle.text = get?.title
            binding.tvTimeNews.text = get?.publishedAt
        }

    }

}
