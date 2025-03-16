package com.example.quotekaapplication.ui.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.quotekaapplication.data.models.Quote
import com.example.quotekaapplication.utils.FavoritesManager

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FavoritesViewModel(context: Context) : ViewModel() {
    private val favoritesManager = FavoritesManager(context)

    // static list of quotes
    private val _favoriteQuotes = MutableStateFlow<List<Quote>>(favoritesManager.getFavorites())
    val favoriteQuotes: StateFlow<List<Quote>> get() = _favoriteQuotes

    fun addToFavorites(quote: Quote) {
        favoritesManager.addToFavorites(quote)
        _favoriteQuotes.value = favoritesManager.getFavorites() // renew the list
    }

    fun removeFromFavorites(quote: Quote) {
        favoritesManager.removeFromFavorites(quote)
        _favoriteQuotes.value = favoritesManager.getFavorites() // renew the list
    }
}
