package com.example.quotekaapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quotekaapplication.ui.composables.DifferentElements.BackgroundImage
import com.example.quotekaapplication.ui.composables.DifferentElements.SmallButton
import com.example.quotekaapplication.ui.screens.Authentication.Login.BackButton

@Composable
fun SettingsScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        BackgroundImage()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Используем BackButton для навигации назад
            BackButton(navController = navController, modifier = Modifier.padding(top = 16.dp))

            Text(
                text = "Settings",
                fontSize = 24.sp,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(top = 40.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Кнопка для изменения пароля
            SmallButton(
                text = "Change Password",
                onClick = {
                    // Действие при нажатии на кнопку
                    // Переход на экран изменения пароля
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .widthIn(max = 250.dp) // Ограничение по максимальной ширине
                    .align(Alignment.CenterHorizontally)
            )



            // Кнопка для включения/выключения темной темы
            SmallButton(
                text = "Toggle Dark Mode",
                onClick = {
                    // Действие для переключения темы
                    // Можно использовать ViewModel для сохранения состояния
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .widthIn(max = 250.dp) // Ограничение по максимальной ширине
                    .align(Alignment.CenterHorizontally)
            )

            // Кнопка для управления уведомлениями
            SmallButton(
                text = "Notifications Settings",
                onClick = {
                    // Действие для управления уведомлениями
                    // Например, открытие экрана уведомлений
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .widthIn(max = 250.dp) // Ограничение по максимальной ширине
                    .align(Alignment.CenterHorizontally)
            )




            // Кнопка для перехода к юридическим документам
            SmallButton(
                text = "Privacy Policy",
                onClick = {
                    // Открыть политику конфиденциальности
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .widthIn(max = 250.dp) // Ограничение по максимальной ширине
                    .align(Alignment.CenterHorizontally)
            )

            SmallButton(
                text = "Terms of Service",
                onClick = {
                    // Открыть условия использования
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .widthIn(max = 250.dp) // Ограничение по максимальной ширине
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}
