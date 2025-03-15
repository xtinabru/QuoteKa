package com.example.quotekaapplication.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.quotekaapplication.data.models.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Создаём DataStore в контексте
private val Context.dataStore by preferencesDataStore("favorites_prefs")

        class FavoritesRepository(private val context: Context) {
            private val gson = Gson()
            private val FAVORITES_KEY = stringPreferencesKey("favorites")

            // Получаем список избранных цитат
            val favoriteQuotesFlow: Flow<List<Quote>> = context.dataStore.data
                    .map { preferences ->
                    val json = preferences[FAVORITES_KEY] ?: "[]"
                gson.fromJson(json, object : TypeToken<List<Quote>>() {}.type) ?: emptyList()
            }

// Сохраняем с
