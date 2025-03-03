package com.example.quotekaapplication.ui.screens.Authentication.Login

import com.example.quotekaapplication.ui.viewmodels.AuthViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.example.quotekaapplication.ui.composables.ElementsForAuth.CustomTextField
import com.example.quotekaapplication.ui.composables.onboarding.OnBoardingButton

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
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(32.dp))

        CustomTextField(
            value = authViewModel.email.value,
            onValueChange = authViewModel::onEmailChange,
            label = "Email",
        )
        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(
            value = authViewModel.password.value,
            onValueChange = authViewModel::onPasswordChange,
            label = "Password",
            isPassword = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        OnBoardingButton(
            text = "Log in",
            onClick = { navController.navigate("login") },
            backgroundColor = MaterialTheme.colorScheme.surface,
            textColor = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(18.dp))
        OnBoardingButton(
            text = "Log in with Google",
            onClick = { /* logic */ },
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier.height(6.dp))
        TextButton(onClick = { /* logic */ }) {
            Text("Forgot Password?",
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onBackground,

                    fontSize = 16.sp,
                    letterSpacing = 0.3.sp
                ))
        }
        Spacer(modifier = Modifier.height(160.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account? ",
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onBackground,

                    fontSize = 18.sp,
                    letterSpacing = 0.3.sp
                )
            )
            TextButton(onClick = { navController.navigate("register") }) {
                Text("Register",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.primary,

                        fontSize = 18.sp,
                        letterSpacing = 0.3.sp
                    ))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))


    }
}