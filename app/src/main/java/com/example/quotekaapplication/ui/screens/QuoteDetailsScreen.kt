package com.example.quotekaapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quotekaapplication.ui.composables.DifferentElements.BackgroundImage
import com.example.quotekaapplication.ui.composables.DifferentElements.SmallButton


@Composable
fun QuoteInfo(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        BackgroundImage()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "About app",
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 24.sp),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "This app shows you new quotes everyday.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Используем SmallButton
            SmallButton(
                text = "Visit our website",
                onClick = {
                    // Действие при нажатии на кнопку
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .widthIn(max = 250.dp) // Ограничение по максимальной ширине
                    .align(Alignment.CenterHorizontally) // выравнивание по центру
            )

            // Кнопка "Назад"
            SmallButton(
                text = "Back",
                onClick = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true } // Удаляем "home" и пересоздаем его
                        launchSingleTop = true // Не дублировать
                    }
                },
                modifier = Modifier
                    .padding(vertical = 8.dp) // Добавляет вертикальные отступы
                    .widthIn(max = 250.dp) // Ограничение по максимальной ширине
                    .align(Alignment.CenterHorizontally) // Выравнивает кнопку по центру
            )
        }
    }
}
