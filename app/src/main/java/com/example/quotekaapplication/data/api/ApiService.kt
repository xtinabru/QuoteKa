package com.example.quotekaapplication.data.api

import com.example.quotekaapplication.data.models.QuoteResponse
import retrofit2.http.GET

interface ApiService {
    @GET("/qod")
    suspend fun getQuoteOfTheDay(): QuoteResponse

}