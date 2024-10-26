package com.kinsideapps.myapplication.adapters

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kinsideapps.myapplication.fragments.Chapter1Fragment
import com.kinsideapps.myapplication.fragments.Chapter2Fragment
import com.kinsideapps.myapplication.fragments.Chapter3Fragment
import com.kinsideapps.myapplication.fragments.Chapter4Fragment

class ScreenSliderPagerAdapter(val fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount() = 4

    override fun createFragment(position: Int) = when (position) {
        0 -> Chapter1Fragment()
        1 -> Chapter2Fragment()
        2 -> Chapter3Fragment()
        else -> Chapter4Fragment()
    }
}