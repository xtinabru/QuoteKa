package com.example.quotekaapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.quotekaapplication.ui.composables.DifferentElements.BackgroundImage
import com.example.quotekaapplication.ui.composables.DifferentElements.SmallButton
import com.example.quotekaapplication.ui.viewmodels.AuthViewModel


@Composable
fun ProfileScreen(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel()
) {

    val userEmail = authViewModel.email.value

    Box(

        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        BackgroundImage()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hello, $userEmail!",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(200.dp))

            // Кнопка "Change Password"
            SmallButton(
                text = "Change Password",
                onClick = {
                    // Действие при нажатии на кнопку для изменения пароля
                },
                modifier = Modifier
                    .padding(vertical = 8.dp) // вертикальные отступы
                    .padding(horizontal = 16.dp) // отступы по бокам
                    .wrapContentWidth() // кнопка будет занимать только необходимую ширину
                    .align(Alignment.CenterHorizontally) // выравнивание по центру
            )

            // Кнопка "Log Out"
            SmallButton(
                text = "Log Out",
                onClick = {
                    // Действие при нажатии на кнопку логаута
                },
                modifier = Modifier
                    .padding(vertical = 8.dp) // вертикальные отступы
                    .padding(horizontal = 16.dp) // отступы по бокам
                    .wrapContentWidth() // кнопка будет занимать только необходимую ширину
                    .align(Alignment.CenterHorizontally) // выравнивание по центру
            )
        }
    }
}
