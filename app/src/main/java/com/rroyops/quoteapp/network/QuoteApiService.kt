package com.rroyops.quoteapp.network

import com.rroyops.quoteapp.model.Quote
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApiService {

    @GET("api/quotes/random")
    suspend fun getRandomQuote(@Query("category") category: String? = null): Quote

    @GET("api/quotes")
    suspend fun getAllQuotes(@Query("category") category: String? = null): List<Quote>
}
