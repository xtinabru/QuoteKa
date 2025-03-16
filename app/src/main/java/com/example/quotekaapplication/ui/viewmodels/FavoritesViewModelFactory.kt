package com.example.quotekaapplication.ui.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Фабрика для создания FavoritesViewModel с контекстом
class FavoritesViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
            FavoritesViewModel(context) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
