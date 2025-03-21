package com.example.quotekaapplication.ui.screens.Authentication

import com.example.quotekaapplication.ui.viewmodels.AuthViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quotekaapplication.R
import com.example.quotekaapplication.ui.composables.DifferentElements.CustomTextField
import com.example.quotekaapplication.ui.composables.onboarding.OnBoardingButton
import com.example.quotekaapplication.ui.screens.Authentication.Login.BackButton

@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel) {

    // Track the validation error message
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackButton(navController)
        Spacer(modifier = Modifier.height(32.dp))
        MainHeader(
            navController,
            text = stringResource(R.string.welcome_back),
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.Start),
        )
        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = stringResource(R.string.sign_in_to_your_account),
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

        // Display validation error message if any
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 0.4.sp
                ),
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        TextButton(onClick = { /* logic */ },
            modifier = Modifier.align(Alignment.Start)) {
            Text(
                stringResource(R.string.forgot_password),
                style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 18.sp,
                    letterSpacing = 0.4.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        OnBoardingButton(
            text = stringResource(R.string.login),
            onClick = {
                authViewModel.login(
                    onSuccess = {
                        navController.navigate("home")
                    },
                    onFailure = { error ->
                        errorMessage = error
                    }
                )
            },
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onSecondary
        )

        Spacer(modifier = Modifier.height(18.dp))

        OnBoardingButton(
            text = stringResource(R.string.sign_in_with_google),
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
                text = stringResource(R.string.don_t_have_an_account),
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 18.sp,
                    letterSpacing = 0.3.sp
                )
            )
            TextButton(onClick = { navController.navigate("register") }) {
                Text(
                    stringResource(R.string.sign_up),
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
