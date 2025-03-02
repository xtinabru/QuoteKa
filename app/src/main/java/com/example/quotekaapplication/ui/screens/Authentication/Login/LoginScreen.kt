package com.example.quotekaapplication.ui.screens.Authentication.Login

import com.example.quotekaapplication.ui.viewmodels.AuthViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackButton(navController)
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Welcome Back \uD83D\uDC4B\uD83C\uDFFB",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Sign in to your account",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(32.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))


        TextButton(onClick = { /* Навигация на экран восстановления пароля */ }) {
            Text("Forgot Password?")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { authViewModel.login(email, password) }, modifier = Modifier.fillMaxWidth()) {
            Text("Sign in")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Don't have an account? ")
            TextButton(onClick = { navController.navigate("register") }) {
                Text("Register")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /* Логика для входа через Google */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Sign in with Google")
        }
    }
}