package com.example.quotekaapplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.quotekaapplication.R
import com.example.quotekaapplication.ui.composables.DifferentElements.BackgroundImage
import com.example.quotekaapplication.ui.composables.DifferentElements.DeleteButton
import com.example.quotekaapplication.ui.viewmodels.FavoritesViewModelFactory

@Composable
fun FavoritesScreen(
    paddingValues: PaddingValues,
    favoritesViewModel: FavoritesViewModel = viewModel(
        factory = FavoritesViewModelFactory(context = LocalContext.current)
    )
) {
    // get data through collectAsState() to work with StateFlow
    val favoriteQuotes by favoritesViewModel.favoriteQuotes.collectAsState(initial = emptyList()) // Инициализация пустым списком, если нет данных
    val context = LocalContext.current
    val backgroundColor = if (isSystemInDarkTheme()) {
        MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
    } else {
        MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
    }

    Box(modifier = Modifier.fillMaxWidth()) {
        BackgroundImage()
        Column(modifier = Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = stringResource(R.string.your_favorite_quotes),
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(24.dp))

            if (favoriteQuotes.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                        .padding(top = paddingValues.calculateTopPadding())
                ) {
                    items(favoriteQuotes) { quote -> // use function items to show the elements
                        Spacer(modifier = Modifier.height(30.dp))

                        // each quote in a sep container
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(backgroundColor, shape = MaterialTheme.shapes.medium)
                                .border(
                                    1.dp,
                                    MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f),
                                    shape = MaterialTheme.shapes.medium
                                )
                                .padding(16.dp)
                        ) {
                            Column {
                                Text(
                                    text = "\"${quote.quote}\" - ${quote.author}",
                                    style = MaterialTheme.typography.titleLarge,
                                    color = MaterialTheme.colorScheme.onBackground
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                DeleteButton(
                                    onClick = {
                                        favoritesViewModel.removeFromFavorites(quote)
                                        Toast.makeText(context,
                                            context.getString(R.string.quote_removed_from_favorites), Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        }
                    }
                }
            } else {
                Text(
                    text = stringResource(R.string.no_favorite_quotes_yet),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

