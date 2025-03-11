package com.example.quotekaapplication.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotekaapplication.data.models.Quote
import com.example.quotekaapplication.data.repository.QuoteRepository
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    private val repository = QuoteRepository()

    // Используем обычные переменные состояния для хранения данных
    private val _quoteOfTheDay = mutableStateOf<Quote?>(null)
    val quoteOfTheDay: State<Quote?> = _quoteOfTheDay

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    // Получение цитаты дня
    fun getQuoteOfTheDay() {
        viewModelScope.launch {
            try {
                // Получаем список цитат через репозиторий
                val quotes = repository.getQuoteOfTheDay()

                // Если список не пустой, присваиваем первую цитату
                if (quotes.isNotEmpty()) {
                    _quoteOfTheDay.value = quotes[0] // Присваиваем первую цитату

                } else {
                    _errorMessage.value = "No quotes found"
                    Log.e("QuoteViewModel", "No quotes found")
                }

            } catch (e: Exception) {
                _errorMessage.value = "Error while retrieving the data"
                Log.e("QuoteViewModel", "Error fetching quote", e)
            }
        }
    }
}
