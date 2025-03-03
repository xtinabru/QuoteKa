package com.example.quotekaapplication.ui.screens.Authentication

import com.example.quotekaapplication.ui.viewmodels.AuthViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quotekaapplication.R

import com.example.quotekaapplication.ui.composables.ElementsForAuth.CustomTextField
import com.example.quotekaapplication.ui.composables.onboarding.OnBoardingButton
import com.example.quotekaapplication.ui.screens.Authentication.Login.BackButton

@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel) {

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackButton(navController)
        Spacer(modifier = Modifier.height(32.dp))
        MainHeader(navController,
            text = "Welcome back\uD83D\uDC4B\uD83C\uDFFB",
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.Start),
            )
        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Sign in to your account",
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.Start),
            style = TextStyle(
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.4.sp
            )
        )

        CustomTextField(
            value = authViewModel.email.value,
            onValueChange = authViewModel::onEmailChange,
            label = "Email",
        )
        Spacer(modifier = Modifier.height(2.dp))

        CustomTextField(
            value = authViewModel.password.value,
            onValueChange = authViewModel::onPasswordChange,
            label = "Password",
            isPassword = true
        )
        TextButton(onClick = { /* logic */ },
            modifier = Modifier.align(Alignment.Start)) {
            Text("Forgot Password?",
                style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 18   .sp,
                    letterSpacing = 0.4.sp,
                    fontWeight = FontWeight.SemiBold,

                )

            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        OnBoardingButton(
            text = "Login",
            onClick = { navController.navigate("login") },
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier.height(18.dp))
        OnBoardingButton(
            text = "Sign in with Google",
            onClick = { /* logic */ },
            backgroundColor = MaterialTheme.colorScheme.background,
            textColor = MaterialTheme.colorScheme.onSurface,
            icon = painterResource(id = R.drawable.google_logo)
        )
        Spacer(modifier = Modifier.height(6.dp))

        Spacer(modifier = Modifier.height(30.dp))

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
                Text("Sign up",
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