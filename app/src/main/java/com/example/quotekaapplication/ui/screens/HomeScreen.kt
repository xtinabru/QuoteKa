package com.example.quotekaapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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


@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    quoteViewModel: QuoteViewModel = viewModel(),
    favoritesViewModel: FavoritesViewModel = viewModel()
) {
    val quote = quoteViewModel.quoteOfTheDay.value
    val isLoading = quoteViewModel.isLoading.value
    val errorMessage = quoteViewModel.errorMessage.value


    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = 0.4f)
        )

        when {
            isLoading -> {
                Text(
                    text = "Loading...",
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            errorMessage != null -> {
                Text(
                    text = errorMessage,
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            else -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(20.dp)
                        .padding(top = paddingValues.calculateTopPadding())
                ) {
                    item {
                        Text(
                            text = "Quote of the day:",
                            style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }

                    item { QuoteCard(quote) }

                    item {
                        FavoriteButton {
                            quote?.let { favoritesViewModel.addToFavorites(it) }
                        }
                    }
                }
            }
        }
    }
}



