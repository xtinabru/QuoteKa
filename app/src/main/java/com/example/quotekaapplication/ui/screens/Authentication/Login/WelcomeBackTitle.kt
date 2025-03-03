package com.example.quotekaapplication.ui.screens.Authentication.Login
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun WelcomeBackTitle(navController: NavController, modifier: Modifier = Modifier) {
        Text(
            text = "Welcome Back \uD83D\uDC4B\uD83C\uDFFB",
            style = MaterialTheme.typography.headlineLarge
        )
    }
