package com.example.quotekaapplication.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.quotekaapplication.data.models.Quote

class FavoritesViewModel : ViewModel() {
    // Список любимых цитат
    private val _favoriteQuotes = mutableStateOf<List<Quote>>(emptyList())
    val favoriteQuotes: State<List<Quote>> = _favoriteQuotes

    // Добавление в избранное
    fun addToFavorites(quote: Quote) {
        // Избегаем дублирования цитат
        if (!favoriteQuotes.value.contains(quote)) {
            _favoriteQuotes.value = _favoriteQuotes.value + quote
        }
    }

    // Удаление из избранного
    fun removeFromFavorites(quote: Quote) {
        _favoriteQuotes.value = _favoriteQuotes.value.filter { it != quote }
    }
}
