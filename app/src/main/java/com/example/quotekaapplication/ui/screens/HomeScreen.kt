package com.example.quotekaapplication.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quotekaapplication.ui.viewmodels.QuoteViewModel
import com.example.quotekaapplication.R
import com.example.quotekaapplication.ui.viewmodels.FavoritesViewModel

@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    val quoteViewModel: QuoteViewModel = viewModel()
    val favoritesViewModel: FavoritesViewModel = viewModel()
    val quote = quoteViewModel.quoteOfTheDay.value
    val errorMessage = quoteViewModel.errorMessage.value

    LaunchedEffect(Unit) {
        quoteViewModel.getQuoteOfTheDay()
    }

    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = 0.4f)
        )

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

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(360.dp)
                        .padding(10.dp)
                        .background(
                            MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.5f), // Добавляем прозрачность
                            shape = MaterialTheme.shapes.medium
                        )
                        .border(1.dp, MaterialTheme.colorScheme.secondary, shape = MaterialTheme.shapes.medium) // Обводка
                        .padding(16.dp)

                ) {

                    val scrollState = rememberScrollState()
                    Column(
                        modifier = Modifier
                            .verticalScroll(scrollState)
                            .fillMaxSize()
                    ) {
                        // scroll the text
                        Text(
                            text = quote?.quote ?: "Loading...",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 24.sp,
                                lineHeight = 34.sp,
                                letterSpacing = 0.3.sp,
                            ),
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Start,
                            softWrap = true,
                            overflow = TextOverflow.Visible,
                        )
                        Text(
                            text = "\n- ${quote?.author ?: "Unknown"}",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 20.sp,
                                lineHeight = 34.sp,
                            ),
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .fillMaxWidth(),

                            textAlign = TextAlign.End
                        )
                    }
                }

            }

            // button
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)

                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(50.dp)
                            .background(Color.White, shape = CircleShape)
                            .border(2.dp, Color.Red, shape = CircleShape)
                    ) {
                        IconButton(
                            onClick = { quote?.let { favoritesViewModel.addToFavorites(it) } },
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "Add to Favorites",
                                tint = Color.Red,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    Log.i("HomeScreen", "Quote of the day: ${quote?.quote}")

    errorMessage?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }
}
