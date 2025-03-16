package com.example.quotekaapplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quotekaapplication.R
import com.example.quotekaapplication.ui.viewmodels.QuoteViewModel
import com.example.quotekaapplication.ui.viewmodels.FavoritesViewModel
import com.example.quotekaapplication.ui.viewmodels.FavoritesViewModelFactory // Импортируем фабрику
import com.example.quotekaapplication.ui.composables.DifferentElements.FavoriteButton // Импортируем FavoriteButton
import androidx.compose.ui.platform.LocalContext
import com.example.quotekaapplication.ui.composables.DifferentElements.LoadingOrErrorState // Импортируем наш новый компонент

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    quoteViewModel: QuoteViewModel = viewModel(),
    favoritesViewModel: FavoritesViewModel = viewModel(
        factory = FavoritesViewModelFactory(LocalContext.current) // Используем фабрику для FavoritesViewModel
    )
) {
    val quote = quoteViewModel.quoteOfTheDay.value
    val isLoading = quoteViewModel.isLoading.value
    val errorMessage = quoteViewModel.errorMessage.value
    val isFavorite = quote != null && favoritesViewModel.favoriteQuotes.value.contains(quote) // Сравниваем объекты Quote

    // get context for showing Toast
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = 0.4f)
        )

        //LoadingOrErrorState
        LoadingOrErrorState(isLoading = isLoading, errorMessage = errorMessage)

        if (!isLoading && errorMessage == null) {
            LazyColumn(
                modifier = Modifier
                    .padding(20.dp)
                    .padding(top = paddingValues.calculateTopPadding())
            ) {
                item {
                    Text(
                        text = "Quote of the day for you:",
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }

                item { QuoteCard(quote) }

                item {
                    FavoriteButton(
                        isFavorite = isFavorite,
                        onClick = {
                            if (quote != null) {
                                if (isFavorite) {
                                    favoritesViewModel.removeFromFavorites(quote) // Работаем с объектом Quote
                                } else {
                                    favoritesViewModel.addToFavorites(quote) // Работаем с объектом Quote
                                    Toast.makeText(context, "Quote added to Favorites!", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
