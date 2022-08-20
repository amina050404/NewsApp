package com.example.newsapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentHomeBinding
import com.example.newsapp.ui.news.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: NewsViewModel by sharedViewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }


    override fun initListener() {

    }

    override fun initView() {
        viewModel.getNews("USA")
        viewModel.serviceNews.observe(viewLifecycleOwner) {
            val adapter = NewsHomeAdapter(it)
            binding.recyclerview.adapter = adapter
            binding.image.load(it.articles?.get(0)?.urlToImage)
            binding.title.text = it.articles?.get(0)?.title
        }
    }
}