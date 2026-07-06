package com.rroyops.quoteapp.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/rroyops/quoteapp/viewmodel/QuoteViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "repository", "Lcom/rroyops/quoteapp/data/QuoteRepository;", "<set-?>", "Lcom/rroyops/quoteapp/viewmodel/QuoteUiState;", "uiState", "getUiState", "()Lcom/rroyops/quoteapp/viewmodel/QuoteUiState;", "setUiState", "(Lcom/rroyops/quoteapp/viewmodel/QuoteUiState;)V", "uiState$delegate", "Landroidx/compose/runtime/MutableState;", "loadRandomQuote", "", "toggleFavoriteOnCurrentQuote", "app_debug"})
public final class QuoteViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.rroyops.quoteapp.data.QuoteRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState uiState$delegate = null;
    
    public QuoteViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rroyops.quoteapp.viewmodel.QuoteUiState getUiState() {
        return null;
    }
    
    private final void setUiState(com.rroyops.quoteapp.viewmodel.QuoteUiState p0) {
    }
    
    public final void loadRandomQuote() {
    }
    
    public final void toggleFavoriteOnCurrentQuote() {
    }
}