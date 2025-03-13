package com.example.quotekaapplication.ui.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.quotekaapplication.data.models.Quote

class FavoritesViewModel : ViewModel() {
    private val _favoriteQuotes = mutableStateListOf<Quote>()
    val favoriteQuotes: List<Quote> get() = _favoriteQuotes

    fun addToFavorites(quote: Quote) {
        if (_favoriteQuotes.any { it.quote == quote.quote }) {
            return // already in favourites
        }
        _favoriteQuotes.add(quote)
    }

    fun removeFromFavorites(quote: Quote) {
        _favoriteQuotes.removeAll { it.quote == quote.quote }
    }
}