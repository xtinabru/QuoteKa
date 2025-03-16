package com.example.quotekaapplication.ui.screens

import com.example.quotekaapplication.ui.viewmodels.AuthViewModel
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
import com.example.quotekaapplication.ui.screens.Authentication.MainHeader

@Composable
fun RegisterScreen(navController: NavController, authViewModel: AuthViewModel) {
    val context = LocalContext.current

    // display validation error if there are any
    val validationError = authViewModel.validationError.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackButton(navController)
        Spacer(modifier = Modifier.height(32.dp))
        MainHeader(navController,
            text = stringResource(R.string.sign_up),
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.Start),
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = stringResource(R.string.create_account),
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
            isPassword = true,
        )
        Spacer(modifier = Modifier.height(2.dp))

        CustomTextField(
            value = authViewModel.confirmPassword.value,
            onValueChange = authViewModel::onConfirmPasswordChange,
            label = "Confirm Password",
            isPassword = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        OnBoardingButton(
            text = stringResource(R.string.register),
            onClick = {
                // Calling register method from AuthViewModel
                authViewModel.register(
                    onSuccess = {
                        // If success
                        Toast.makeText(context,
                            context.getString(R.string.registration_successful), Toast.LENGTH_SHORT).show()
                        navController.navigate("home")  // Go home
                    },
                    onFailure = { errorMessage ->
                        // If registration fails
                        Toast.makeText(context, "Registration failed: $errorMessage", Toast.LENGTH_SHORT).show()
                    }
                )
            },
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onSecondary
        )

        // Display validation error message if any
        validationError?.let {
            Text(
                text = it,
                style = TextStyle(color = MaterialTheme.colorScheme.error),
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Navigation to login screen
        TextButton(
            onClick = { navController.navigate("login") }
        ) {
            Text(
                stringResource(R.string.already_have_an_account_login),
                style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 18.sp,
                    letterSpacing = 0.4.sp,
                    fontWeight = FontWeight.SemiBold)
            )
        }
        Spacer(modifier = Modifier.height(60.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.by_clicking_register_you_agree_to_our),
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 18.sp,
                    letterSpacing = 0.3.sp
                )
            )
            TextButton(onClick = { navController.navigate("register") }) {
                Text(
                    stringResource(R.string.terms_data_policy),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 18.sp,
                        letterSpacing = 0.3.sp
                    )
                )
            }
        }
    }
}
