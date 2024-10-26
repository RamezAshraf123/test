package com.kinsideapps.myapplication.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.kinsideapps.myapplication.adapters.ScreenSliderPagerAdapter
import com.kinsideapps.myapplication.databinding.ActivityByViewPagerBinding

class ByViewPagerActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityByViewPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityByViewPagerBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(_binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }
    private fun init() {
        _binding.viewPagerHolder.adapter = ScreenSliderPagerAdapter(this)
        //tabs
        TabLayoutMediator(_binding.tabLayout, _binding.viewPagerHolder) { tab, position ->
            tab.text = "Chapter  ${position+1}"
        }.attach()
    }
}