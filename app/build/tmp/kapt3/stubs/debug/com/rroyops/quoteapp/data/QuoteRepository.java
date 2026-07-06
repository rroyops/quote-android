package com.rroyops.quoteapp.data;

/**
 * The ViewModel never talks to Retrofit or Room directly — it goes through
 * this Repository. That indirection is what makes it possible to swap the
 * data source later (e.g. add an offline cache of the daily quote, or swap
 * the backend) without touching the ViewModel or UI at all.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00100\u000fJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001a"}, d2 = {"Lcom/rroyops/quoteapp/data/QuoteRepository;", "", "api", "Lcom/rroyops/quoteapp/network/QuoteApiService;", "favoriteDao", "Lcom/rroyops/quoteapp/data/FavoriteQuoteDao;", "(Lcom/rroyops/quoteapp/network/QuoteApiService;Lcom/rroyops/quoteapp/data/FavoriteQuoteDao;)V", "fetchRandomQuote", "Lkotlin/Result;", "Lcom/rroyops/quoteapp/model/Quote;", "category", "", "fetchRandomQuote-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavorites", "Lkotlinx/coroutines/flow/Flow;", "", "isFavorite", "", "quoteId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleFavorite", "", "quote", "(Lcom/rroyops/quoteapp/model/Quote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class QuoteRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.rroyops.quoteapp.network.QuoteApiService api = null;
    @org.jetbrains.annotations.NotNull()
    private final com.rroyops.quoteapp.data.FavoriteQuoteDao favoriteDao = null;
    
    public QuoteRepository(@org.jetbrains.annotations.NotNull()
    com.rroyops.quoteapp.network.QuoteApiService api, @org.jetbrains.annotations.NotNull()
    com.rroyops.quoteapp.data.FavoriteQuoteDao favoriteDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.rroyops.quoteapp.model.Quote>> getFavorites() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isFavorite(int quoteId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object toggleFavorite(@org.jetbrains.annotations.NotNull()
    com.rroyops.quoteapp.model.Quote quote, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}