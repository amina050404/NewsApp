package com.example.newsapp.ui.search.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapp.ui.news.NewsFragment

class CategoryViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val categories = arrayListOf("Health", "Politics", "Tesla", "Food", "Apple")

    override fun getItemCount(): Int {
        return categories.size
    }

    fun getTitle(position: Int): String {
        return categories[position]
    }

    override fun createFragment(position: Int): Fragment {
        return NewsFragment.newInstance(categories[position])
    }
}