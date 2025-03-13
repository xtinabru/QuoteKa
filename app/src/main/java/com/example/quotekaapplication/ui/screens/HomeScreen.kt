package com.example.quotekaapplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quotekaapplication.R
import com.example.quotekaapplication.ui.viewmodels.QuoteViewModel
import com.example.quotekaapplication.ui.composables.DifferentElements.FavoriteButton
import com.example.quotekaapplication.ui.viewmodels.FavoritesViewModel
import androidx.compose.ui.platform.LocalContext
import com.example.quotekaapplication.ui.composables.DifferentElements.LoadingOrErrorState // Импортируем наш новый компонент

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    quoteViewModel: QuoteViewModel = viewModel(),
    favoritesViewModel: FavoritesViewModel = viewModel()
) {
    val quote = quoteViewModel.quoteOfTheDay.value
    val isLoading = quoteViewModel.isLoading.value
    val errorMessage = quoteViewModel.errorMessage.value
    val isFavorite = quote != null && favoritesViewModel.favoriteQuotes.value.contains(quote)

    // Получаем контекст для отображения Toast
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

        // Заменяем код с Text на вызов нашего компонента LoadingOrErrorState
        LoadingOrErrorState(isLoading = isLoading, errorMessage = errorMessage)

        // Если не загрузка и нет ошибки, продолжаем рендерить контент
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
                        isFavorite = isFavorite, // Передаем isFavorite для изменения цвета кнопки
                        onClick = {
                            if (quote != null) {
                                if (isFavorite) {
                                    favoritesViewModel.removeFromFavorites(quote)
                                } else {
                                    favoritesViewModel.addToFavorites(quote)
                                    // Показать всплывающее сообщение
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
