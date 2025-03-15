package com.example.quotekaapplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quotekaapplication.ui.viewmodels.FavoritesViewModel

import com.example.quotekaapplication.ui.composables.DifferentElements.FavoriteButton
import androidx.compose.ui.platform.LocalContext

@Composable
fun FavoritesScreen(
    paddingValues: PaddingValues,
    favoritesViewModel: FavoritesViewModel = viewModel()
) {
    val favoriteQuotes = favoritesViewModel.favoriteQuotes.value
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        // screen title
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Your Favorite Quotes",
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            // THE LIST
            if (favoriteQuotes.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                        .padding(top = paddingValues.calculateTopPadding())
                ) {
                    items(favoriteQuotes) { quote ->
                        QuoteCard(quote)
                        Spacer(modifier = Modifier.height(8.dp))

                        FavoriteButton(
                            isFavorite = true,
                            onClick = {
                                favoritesViewModel.removeFromFavorites(quote)
                                Toast.makeText(context, "Quote removed from Favorites!", Toast.LENGTH_SHORT).show()
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            } else {
                // if empty
                Text(
                    text = "No favorite quotes yet.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}
