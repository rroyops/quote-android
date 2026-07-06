package com.rroyops.quoteapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rroyops.quoteapp.viewmodel.QuoteUiState
import com.rroyops.quoteapp.viewmodel.QuoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteScreen(viewModel: QuoteViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Quote of the Day") }) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            when (val state = viewModel.uiState) {
                is QuoteUiState.Loading -> {
                    CircularProgressIndicator()
                }

                is QuoteUiState.Success -> {
                    QuoteContent(
                        text = state.quote.text,
                        author = state.quote.author,
                        isFavorite = state.isFavorite,
                        onRefresh = viewModel::loadRandomQuote,
                        onToggleFavorite = viewModel::toggleFavoriteOnCurrentQuote
                    )
                }

                is QuoteUiState.Error -> {
                    ErrorContent(
                        message = state.message,
                        onRetry = viewModel::loadRandomQuote
                    )
                }
            }
        }
    }
}

@Composable
private fun QuoteContent(
    text: String,
    author: String,
    isFavorite: Boolean,
    onRefresh: () -> Unit,
    onToggleFavorite: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card {
            Column(modifier = Modifier.padding(24.dp)) {
                Text(
                    "\u201C$text\u201D",
                    style = MaterialTheme.typography.headlineMedium,
                    fontStyle = FontStyle.Italic
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    "\u2014 $author",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(Modifier.height(24.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            OutlinedButton(onClick = onRefresh) {
                Icon(Icons.Filled.Refresh, contentDescription = "New quote")
                Spacer(Modifier.width(8.dp))
                Text("New Quote")
            }

            IconButton(onClick = onToggleFavorite) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites"
                )
            }
        }
    }
}

@Composable
private fun ErrorContent(message: String, onRetry: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.error
        )
        Spacer(Modifier.height(16.dp))
        Button(onClick = onRetry) {
            Text("Retry")
        }
    }
}
