package com.example.quotekaapplication.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quotekaapplication.ui.viewmodels.QuoteViewModel
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController, paddingValues: PaddingValues) {
    // Получаем ViewModel
    val quoteViewModel: QuoteViewModel = viewModel()

    // Получаем данные из State
    val quote = quoteViewModel.quoteOfTheDay.value
    val errorMessage = quoteViewModel.errorMessage.value

    // Запрос цитаты при первом рендере экрана
    LaunchedEffect(Unit) {
        quoteViewModel.getQuoteOfTheDay()
    }

    // Получаем текущий контекст
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(20.dp)
            .padding(top = paddingValues.calculateTopPadding())

    ) {

        Text(
            text = "Quote of the day:",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp)) // Отступ между строками
        Text(
            text = quote?.quote ?: "Loading...",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("By: ${quote?.author}", style = MaterialTheme.typography.bodyMedium)
        Log.i("HomeScreen", "Quote of the day: ${quote?.quote}")

        // Показать сообщение об ошибке, если оно есть
        errorMessage?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

        // Показать цитату, если она есть
//        quote?.let {
//            Text("Quote of the day: ${it.quote}", style = MaterialTheme.typography.bodyMedium) // Используем content
//            Spacer(modifier = Modifier.height(10.dp))
//            Text("By: ${it.author}", style = MaterialTheme.typography.bodyMedium)  // Используем author
//        }

        Spacer(modifier = Modifier.height(20.dp))

        // Кнопка для перехода на экран подробностей цитаты
        Button(onClick = { navController.navigate("info") }) {
            Text("More details")
        }
    }
}
