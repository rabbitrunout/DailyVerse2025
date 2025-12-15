package com.example.dailyverse2025.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.dailyverse2025.R
import com.example.dailyverse2025.models.Quote
import com.example.dailyverse2025.utils.QuoteRepository

class HomeFragment : Fragment() {

    private lateinit var quote: Quote

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container,false)
        val quoteText = view.findViewById<TextView>(R.id.daily_quote_text)
        quoteText.text = QuoteRepository.getRandomQuote(requireContext()).text

        quote = QuoteRepository.getRandomQuote(requireContext())
        quoteText.text = "\"${quote.text}\"\n\n-${quote.author}"

        return view

    }


}