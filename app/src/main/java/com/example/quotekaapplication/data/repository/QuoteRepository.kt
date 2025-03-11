package com.example.quotekaapplication.data.repository

import android.util.Log
import com.example.quotekaapplication.data.api.RetrofitInstance
import com.example.quotekaapplication.data.models.Quote
import com.example.quotekaapplication.BuildConfig


class QuoteRepository {

    suspend fun getQuoteOfTheDay(): List<Quote> {
        try {
            val apiKey = BuildConfig.API_KEY

            // Проверка на пустой API-ключ
            if (apiKey.isNullOrEmpty()) {
                Log.e("QuoteRepository", "API Key is missing!")
            } else {
                Log.d("QuoteRepository", "Using API Key: $apiKey")
            }

            val response = RetrofitInstance.api.getQuoteOfTheDay(
                apiKey = apiKey
            )

            Log.d("QuoteRepository", "Response Code: ${response.code()}")
            Log.d("QuoteRepository", "Response Body: ${response.body()}")

            if (response.isSuccessful) {
                Log.d("QuoteRepository", "Response: ${response.body()}")
            } else {
                Log.e("QuoteRepository", "Failed to fetch quote: ${response.message()}")
            }

            return response.body() ?: throw Exception("Empty response body")

        } catch (e: Exception) {
            Log.e("QuoteRepository", "Exception occurred: ${e.message}", e)
            throw e
        }
    }
}
