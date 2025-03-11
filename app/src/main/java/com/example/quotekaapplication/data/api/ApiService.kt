package com.example.quotekaapplication.data.api

import com.example.quotekaapplication.data.models.Quote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ApiService {
    @GET("v1/quotes")
    suspend fun getQuoteOfTheDay(
        @Header("X-Api-Key") apiKey: String
    ): Response<List<Quote>>
}