package com.rroyops.quoteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rroyops.quoteapp.model.Quote
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteQuoteDao {

    @Query("SELECT * FROM favorite_quotes ORDER BY id DESC")
    fun getAllFavorites(): Flow<List<Quote>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_quotes WHERE id = :quoteId)")
    suspend fun isFavorite(quoteId: Int): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(quote: Quote)

    @Delete
    suspend fun removeFavorite(quote: Quote)
}
