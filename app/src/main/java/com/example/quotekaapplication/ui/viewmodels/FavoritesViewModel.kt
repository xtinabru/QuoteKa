package com.example.quotekaapplication.ui.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.quotekaapplication.data.models.Quote

class FavoritesViewModel : ViewModel() {
    private val _favoriteQuotes = mutableStateListOf<Quote>()
    val favoriteQuotes: List<Quote> get() = _favoriteQuotes

    // add a quote to the list
    fun addToFavorites(quote: Quote) {
        if (!_favoriteQuotes.contains(quote)) {
            _favoriteQuotes.add(quote)
        }
    }
    // delete the quote
    fun removeFromFavorites(quote: Quote) {
        _favoriteQuotes.remove(quote)
    }
}
