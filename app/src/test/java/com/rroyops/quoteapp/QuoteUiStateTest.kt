package com.rroyops.quoteapp.viewmodel

import com.rroyops.quoteapp.model.Quote
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * These are intentionally small, framework-free tests of the state model
 * itself (no ViewModel instantiation, which would need Android + a real
 * database/network and is better covered by instrumented tests later).
 * The goal here is just to lock in the state transitions we rely on in
 * QuoteScreen's `when` block.
 */
class QuoteUiStateTest {

    private val sampleQuote = Quote(
        id = 1,
        text = "Test quote",
        author = "Test Author",
        category = "test"
    )

    @Test
    fun `success state holds the quote and favorite flag`() {
        val state = QuoteUiState.Success(sampleQuote, isFavorite = true)
        assertEquals(sampleQuote, state.quote)
        assertTrue(state.isFavorite)
    }

    @Test
    fun `copy on success state toggles favorite without changing quote`() {
        val original = QuoteUiState.Success(sampleQuote, isFavorite = false)
        val toggled = original.copy(isFavorite = true)

        assertEquals(original.quote, toggled.quote)
        assertTrue(toggled.isFavorite)
    }

    @Test
    fun `error state carries a message`() {
        val state = QuoteUiState.Error("network down")
        assertEquals("network down", state.message)
    }
}
