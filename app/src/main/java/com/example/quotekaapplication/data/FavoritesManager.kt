package com.example.quotekaapplication.utils

import android.content.Context
import com.example.quotekaapplication.data.models.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// Менеджер для работы с избранными цитатами (сохранение и загрузка)
class FavoritesManager(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)
    private val gson = Gson()

    // Получаем список избранных цитат
    fun getFavorites(): List<Quote> {
        val json = sharedPreferences.getString("favorites_list", null)
        return if (json != null) {
            val type = object : TypeToken<List<Quote>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }

    // Добавление цитаты в избранное
    fun addToFavorites(quote: Quote) {
        val currentFavorites = getFavorites().toMutableList()
        currentFavorites.add(quote)
        saveFavorites(currentFavorites)
    }

    // Удаление цитаты из избранного
    fun removeFromFavorites(quote: Quote) {
        val currentFavorites = getFavorites().toMutableList()
        currentFavorites.remove(quote)
        saveFavorites(currentFavorites)
    }

    // Сохраняем список избранных цитат
    private fun saveFavorites(favorites: List<Quote>) {
        val json = gson.toJson(favorites)
        sharedPreferences.edit().putString("favorites_list", json).apply()
    }
}
