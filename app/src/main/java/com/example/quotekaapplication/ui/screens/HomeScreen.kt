package com.example.quotekaapplication.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quotekaapplication.ui.viewmodels.QuoteViewModel
import com.example.quotekaapplication.R


@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    val quoteViewModel: QuoteViewModel = viewModel()
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

        // Используем LazyColumn для плавной прокрутки
        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
                .padding(top = paddingValues.calculateTopPadding())
        ) {
            item {
                Text(
                    text = "Quote of the day:",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 30.sp
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(40.dp))
            }

            item {
                Text(
                    text = quote?.quote ?: "Loading...",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 26.sp,
                        lineHeight = 36.sp,
                    ),
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Justify
                )
                Spacer(modifier = Modifier.height(40.dp))
            }

            item {
                Text(
                    text = "By: ${quote?.author}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 30.sp,
                        lineHeight = 36.sp,
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            // Логирование для отслеживания цитаты
            Log.i("HomeScreen", "Quote of the day: ${quote?.quote}")

            // Показать сообщение об ошибке, если оно есть
            errorMessage?.let {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
