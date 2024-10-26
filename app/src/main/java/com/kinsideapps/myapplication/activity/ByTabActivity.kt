package com.kinsideapps.myapplication.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.kinsideapps.myapplication.databinding.ActivityByTabBinding
import com.kinsideapps.myapplication.fragments.Chapter1Fragment
import com.kinsideapps.myapplication.fragments.Chapter2Fragment
import com.kinsideapps.myapplication.fragments.Chapter3Fragment
import com.kinsideapps.myapplication.fragments.Chapter4Fragment

class ByTabActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityByTabBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityByTabBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(_binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    private fun init() {
        replaceFragmentTo(Chapter1Fragment()) //set default fragment
        setEvents()
    }

    private fun setEvents() {
        _binding.chapter1Btn.setOnClickListener {
            replaceFragmentTo(Chapter1Fragment())
            changeSelectedColor(0)
        }
        _binding.chapter2Btn.setOnClickListener {
            replaceFragmentTo(Chapter2Fragment())
            changeSelectedColor(1)
        }
        _binding.chapter3Btn.setOnClickListener {
            replaceFragmentTo(Chapter3Fragment())
            changeSelectedColor(2)
        }
        _binding.chapter4Btn.setOnClickListener {
            replaceFragmentTo(Chapter4Fragment())
            changeSelectedColor(3)
        }
    }

    private fun replaceFragmentTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(_binding.fragmentContainer.id, fragment).commit()
    }

    private fun changeSelectedColor(position: Int) {
        val selectedColor = 0xFF0000FF.toInt()
        val unSelectedColor = 0xFF4D4D4D.toInt()
        val buttons = arrayOf(
            _binding.chapter1Btn,
            _binding.chapter2Btn,
            _binding.chapter3Btn,
            _binding.chapter4Btn,
        )
        for (i in buttons.indices) {
            if (i == position)
                buttons[i].setBackgroundColor(selectedColor)
            else
                buttons[i].setBackgroundColor(unSelectedColor)
        }
    }
}