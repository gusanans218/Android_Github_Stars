package com.example.android_github_stars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.android_github_stars.databinding.ActivityMainBinding
import com.example.android_github_stars.presentation.adapter.ApiRecyclerViewAdapter
import com.example.android_github_stars.presentation.adapter.PagerFragmentStateAdapter
import com.example.android_github_stars.presentation.view.ApiFragment
import com.example.android_github_stars.presentation.view.LocalFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // binding SetUp
        val binding = (DataBindingUtil.setContentView(
            this, R.layout.activity_main
        ) as ActivityMainBinding)
            .apply {
                lifecycleOwner = this@MainActivity
            }

        // 1.FragmentStateAdapter 초기화
        val pagerAdapter = PagerFragmentStateAdapter(this)
            .apply {
                addFragment(ApiFragment())
                addFragment(LocalFragment())

            }

        // 2.ViewPager2의 Adapter 설정
        val viewPager: ViewPager2 = binding.pager.apply {
            adapter = pagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Log.d("ViewPagerFragment", "Page ${position + 1}")
                }
            })
        }

        // 3.TabLayout과 ViewPager 연결
        val tabTitles = listOf<String>("API", "로컬")
        TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}