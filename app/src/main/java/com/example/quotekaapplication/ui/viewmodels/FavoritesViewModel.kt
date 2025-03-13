package com.example.quotekaapplication.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.quotekaapplication.data.models.Quote


class FavoritesViewModel : ViewModel() {
    // here's the list of favourites
    private val _favoriteQuotes = mutableStateOf<List<Quote>>(emptyList())
    val favoriteQuotes = _favoriteQuotes

    // add to the list
    fun addToFavorites(quote: Quote) {
        _favoriteQuotes.value = _favoriteQuotes.value + quote
    }

    // delete
    fun removeFromFavorites(quote: Quote) {
        _favoriteQuotes.value = _favoriteQuotes.value.filter { it != quote }
    }
}
