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

    //  Use ordinary state vars to collect data
    private val _quoteOfTheDay = mutableStateOf<Quote?>(null)
    val quoteOfTheDay: State<Quote?> = _quoteOfTheDay

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    init {
        getQuoteOfTheDay()
    }

    fun getQuoteOfTheDay() {
        viewModelScope.launch {

            _isLoading.value = true
            _errorMessage.value = null // clean the error message
            try {
                // get the list of quotes through the repository
                val quotes = repository.getQuoteOfTheDay()

                // ЕIf the list of quotes is not empty, set the first quote as the quote of the day
                if (quotes.isNotEmpty()) {
                    _quoteOfTheDay.value = quotes[0] // set the first quote as the quote of the day

                } else {
                    _errorMessage.value = "No quotes found"
                    Log.e("QuoteViewModel", "No quotes found")
                }

            } catch (e: Exception) {
                _errorMessage.value = "Error while retrieving the data"
                Log.e("QuoteViewModel", "Error fetching quote", e)
            }finally {
                _isLoading.value = false
            }
        }
    }
}
