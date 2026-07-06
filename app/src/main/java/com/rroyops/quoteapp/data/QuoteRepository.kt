package com.rroyops.quoteapp.data

import com.rroyops.quoteapp.model.Quote
import com.rroyops.quoteapp.network.QuoteApiService
import kotlinx.coroutines.flow.Flow

/**
 * The ViewModel never talks to Retrofit or Room directly — it goes through
 * this Repository. That indirection is what makes it possible to swap the
 * data source later (e.g. add an offline cache of the daily quote, or swap
 * the backend) without touching the ViewModel or UI at all.
 */
class QuoteRepository(
    private val api: QuoteApiService,
    private val favoriteDao: FavoriteQuoteDao
) {

    suspend fun fetchRandomQuote(category: String? = null): Result<Quote> {
        return try {
            Result.success(api.getRandomQuote(category))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun getFavorites(): Flow<List<Quote>> = favoriteDao.getAllFavorites()

    suspend fun isFavorite(quoteId: Int): Boolean = favoriteDao.isFavorite(quoteId)

    suspend fun toggleFavorite(quote: Quote) {
        if (favoriteDao.isFavorite(quote.id)) {
            favoriteDao.removeFavorite(quote)
        } else {
            favoriteDao.addFavorite(quote)
        }
    }
}
