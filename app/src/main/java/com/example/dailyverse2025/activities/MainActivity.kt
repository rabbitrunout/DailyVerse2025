package com.example.dailyverse2025.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.dailyverse2025.fragments.CategoriesFragment
import com.example.dailyverse2025.fragments.FavoritesFragment
import com.example.dailyverse2025.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.dailyverse2025.R



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        nav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> switchFragment(HomeFragment())
                R.id.nav_categories -> switchFragment(CategoriesFragment())
                R.id.nav_favorites -> switchFragment(FavoritesFragment())
            }
            true
        }

        switchFragment(HomeFragment())

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun switchFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

