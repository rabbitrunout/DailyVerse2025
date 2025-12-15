package com.example.dailyverse2025.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyverse2025.R
import com.example.dailyverse2025.adapters.CategoryAdapter
import com.example.dailyverse2025.adapters.QuoteAdapter
import com.example.dailyverse2025.utils.QuoteRepository

class CategoriesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var backButton: Button
    private val categories = listOf("Wisdom", "Success", "Love", "Motivation")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_categories, container, false)

        recyclerView = view.findViewById(R.id.categories_recycler_view)
        backButton = view.findViewById(R.id.btn_back_to_categories)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        backButton.setOnClickListener {
            showCategories()
        }

        showCategories()
        return view
    }

    private fun showCategories() {
        backButton.visibility = View.GONE
        recyclerView.adapter = CategoryAdapter(categories) { selectedCategory ->
            showQuotesByCategory(selectedCategory)
        }
    }

    private fun showQuotesByCategory(category: String) {
        backButton.visibility = View.VISIBLE
        val quotes = QuoteRepository.getQuotesByCategory(requireContext(), category)
        recyclerView.adapter = QuoteAdapter(quotes)
    }
}