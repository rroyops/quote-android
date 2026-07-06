package com.rroyops.quoteapp.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.rroyops.quoteapp.data.AppDatabase
import com.rroyops.quoteapp.data.QuoteRepository
import com.rroyops.quoteapp.model.Quote
import com.rroyops.quoteapp.network.RetrofitInstance
import kotlinx.coroutines.launch

sealed class QuoteUiState {
    object Loading : QuoteUiState()
    data class Success(val quote: Quote, val isFavorite: Boolean) : QuoteUiState()
    data class Error(val message: String) : QuoteUiState()
}

class QuoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = QuoteRepository(
        api = RetrofitInstance.api,
        favoriteDao = AppDatabase.getInstance(application).favoriteQuoteDao()
    )

    var uiState: QuoteUiState by mutableStateOf(QuoteUiState.Loading)
        private set

    init {
        loadRandomQuote()
    }

    fun loadRandomQuote() {
        uiState = QuoteUiState.Loading
        viewModelScope.launch {
            val result = repository.fetchRandomQuote()
            uiState = result.fold(
                onSuccess = { quote ->
                    val isFav = repository.isFavorite(quote.id)
                    QuoteUiState.Success(quote, isFav)
                },
                onFailure = { error ->
                    QuoteUiState.Error(
                        error.message ?: "Couldn't reach the server. Check that quote-api is running."
                    )
                }
            )
        }
    }

    fun toggleFavoriteOnCurrentQuote() {
        val currentState = uiState
        if (currentState !is QuoteUiState.Success) return

        viewModelScope.launch {
            repository.toggleFavorite(currentState.quote)
            val nowFavorite = repository.isFavorite(currentState.quote.id)
            uiState = currentState.copy(isFavorite = nowFavorite)
        }
    }
}
