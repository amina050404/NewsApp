package com.example.newsapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentSearchBinding
import com.example.newsapp.ui.news.NewsViewModel
import com.example.newsapp.ui.search.adapter.CategoryViewPagerAdapter
import com.example.newsapp.ui.search.adapter.SearchAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    private val viewModel: NewsViewModel by sharedViewModel()


    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(inflater, container, false)
    }

    override fun initListener() {

    }

    override fun initView() {
        val adapter = CategoryViewPagerAdapter(this)
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewpager
        ) { tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.isNotEmpty()) {
                    viewModel.getNews(query)
                    binding.tabLayout.visibility = View.GONE
                    binding.viewpager.visibility = View.GONE
                    binding.recyclerview.visibility = View.VISIBLE
                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    binding.tabLayout.visibility = View.VISIBLE
                    binding.viewpager.visibility = View.VISIBLE
                    binding.recyclerview.visibility = View.GONE
                }
                return false
            }
        })
        viewModel.serviceNews.observe(viewLifecycleOwner) {
            val adapterSearch = SearchAdapter(it)
            binding.recyclerview.adapter = adapterSearch
        }
    }
}
