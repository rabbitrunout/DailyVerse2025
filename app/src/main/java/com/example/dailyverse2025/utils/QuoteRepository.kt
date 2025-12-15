package com.example.dailyverse2025.utils

import android.content.Context
import com.example.dailyverse2025.models.Quote
import org.json.JSONArray
import java.io.InputStream
import kotlin.random.Random

object QuoteRepository {
    private var cachedQuotes: List<Quote>? = null

    fun getRandomQuote(context: Context): Quote {
        if (cachedQuotes == null) loadQuotes(context)
        return cachedQuotes!!.random()
    }

    fun loadQuotes(context: Context) {
        val inputStream = context.resources.openRawResource(
            context.resources.getIdentifier("quotes", "raw", context.packageName)
        )
        val json = inputStream.bufferedReader().use { it.readText() }

        val array = JSONArray(json)
        val list = mutableListOf<Quote>()

        for (i in 0 until array.length()) {
            val obj = array.getJSONObject(i)
            list.add(
                Quote(
                    id = i,
                    text = obj.getString("text"),
                    author = obj.optString("author", "Unknown"),
                    category = obj.optString("category", "General")
                )
            )
        }

        cachedQuotes = list
    }


    fun getQuotesByCategory(context: Context, category: String): List<Quote> {
        if (cachedQuotes == null) loadQuotes(context)
        return cachedQuotes!!.filter { it.category.equals(category, ignoreCase = true) }
    }
}
