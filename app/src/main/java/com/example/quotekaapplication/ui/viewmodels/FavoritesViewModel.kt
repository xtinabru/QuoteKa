package com.example.quotekaapplication.ui.viewmodels

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.quotekaapplication.data.models.Quote
import com.example.quotekaapplication.utils.FavoritesManager

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FavoritesViewModel(context: Context) : ViewModel() {
    private val favoritesManager = FavoritesManager(context)

    // Статический список избранных цитат
    private val _favoriteQuotes = MutableStateFlow<List<Quote>>(favoritesManager.getFavorites()) // Здесь использую StateFlow
    val favoriteQuotes: StateFlow<List<Quote>> get() = _favoriteQuotes // Подписка на изменения

    // Добавление цитаты в избранное
    fun addToFavorites(quote: Quote) {
        favoritesManager.addToFavorites(quote)
        _favoriteQuotes.value = favoritesManager.getFavorites() // Обновляем список
    }

    // Удаление цитаты из избранного
    fun removeFromFavorites(quote: Quote) {
        favoritesManager.removeFromFavorites(quote)
        _favoriteQuotes.value = favoritesManager.getFavorites() // Обновляем список
    }
}
