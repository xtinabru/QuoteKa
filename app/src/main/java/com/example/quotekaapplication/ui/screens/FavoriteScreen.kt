package com.example.quotekaapplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // Импортируем items для работы с LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quotekaapplication.ui.viewmodels.FavoritesViewModel
import com.example.quotekaapplication.ui.composables.DifferentElements.FavoriteButton
import androidx.compose.ui.platform.LocalContext
import com.example.quotekaapplication.ui.viewmodels.FavoritesViewModelFactory

@Composable
fun FavoritesScreen(
    paddingValues: PaddingValues,
    favoritesViewModel: FavoritesViewModel = viewModel(
        factory = FavoritesViewModelFactory(context = LocalContext.current) // Используем фабрику для FavoritesViewModel
    )
) {
    // Получаем данные через collectAsState() для работы с StateFlow
    val favoriteQuotes by favoritesViewModel.favoriteQuotes.collectAsState(initial = emptyList()) // Инициализация пустым списком, если нет данных

    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Your Favorite Quotes",
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (favoriteQuotes.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                        .padding(top = paddingValues.calculateTopPadding())
                ) {
                    items(favoriteQuotes) { quote -> // Используем функцию items для отображения элементов
                        Text(
                            text = "\"${quote.quote}\" - ${quote.author}\n", // Доступ к полям объекта Quote
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        FavoriteButton(
                            isFavorite = true,
                            onClick = {
                                favoritesViewModel.removeFromFavorites(quote) // Передаем объект Quote
                                Toast.makeText(context, "Quote removed from Favorites!", Toast.LENGTH_SHORT).show()
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            } else {
                Text(
                    text = "No favorite quotes yet.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}
