package com.example.quotekaapplication.data.api

import retrofit2.http.GET

interface ApiService {
    @GET("/qod")
    suspend fun getQuoteOfTheDay(): QuoteResponse

}