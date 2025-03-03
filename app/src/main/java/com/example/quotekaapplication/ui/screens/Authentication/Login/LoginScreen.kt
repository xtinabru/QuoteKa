package com.example.quotekaapplication.ui.screens.Authentication.Login

import com.example.quotekaapplication.ui.viewmodels.AuthViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quotekaapplication.ui.composables.ElementsForAuth.CustomTextField

@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel) {

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackButton(navController)
        Spacer(modifier = Modifier.height(32.dp))
        WelcomeBackTitle(navController)
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Sign in to your account",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(32.dp))

        CustomTextField(
            value = authViewModel.email.value,
            onValueChange = authViewModel::onEmailChange,
            label = "Email"
        )
        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(
            value = authViewModel.password.value,
            onValueChange = authViewModel::onPasswordChange,
            label = "Password",
            isPassword = true
        )
        Spacer(modifier = Modifier.height(16.dp))


        TextButton(onClick = { /* logic */ }) {
            Text("Forgot Password?")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { authViewModel.login() }, modifier = Modifier.fillMaxWidth()) {
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

        Button(onClick = { /* logic maybe one day */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Sign in with Google")
        }
    }
}