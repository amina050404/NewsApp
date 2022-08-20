package com.example.newsapp.ui.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.model.Article
import com.example.newsapp.model.News

class SearchAdapter(private var data : News): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(data.articles?.get(position))
    }

    override fun getItemCount(): Int {
        return data.articles?.size ?: 0

    }
    inner class SearchViewHolder(private var binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: Article?) {
            binding.tvTime.text = news?.publishedAt
            binding.titleNews.text = news?.title
            binding.imageNews.load(news?.urlToImage)
        }
    }

}