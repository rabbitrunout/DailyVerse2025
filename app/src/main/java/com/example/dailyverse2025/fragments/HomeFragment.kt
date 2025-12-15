package com.example.dailyverse2025.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dailyverse2025.R
import com.example.dailyverse2025.models.Quote

class HomeFragment : Fragment() {

    private lateinit var quote: Quote

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container,false)
        return view
    }


}