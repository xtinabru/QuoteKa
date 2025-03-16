package com.example.quotekaapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quotekaapplication.R
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

            BackButton(navController = navController, modifier = Modifier.padding(top = 16.dp))

            Text(
                text = stringResource(R.string.settings),
                fontSize = 24.sp,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(top = 40.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            SmallButton(
                text = stringResource(R.string.change_password),
                onClick = {
                // logic
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .widthIn(max = 250.dp)
                    .align(Alignment.CenterHorizontally)
            )

            SmallButton(
                text = stringResource(R.string.toggle_dark_mode),
                onClick = {
                   // logic
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .widthIn(max = 250.dp)
                    .align(Alignment.CenterHorizontally)
            )

            SmallButton(
                text = stringResource(R.string.notifications_settings),
                onClick = {
                    // logic
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .widthIn(max = 250.dp)
                    .align(Alignment.CenterHorizontally)
            )

            SmallButton(
                text = stringResource(R.string.privacy_policy),
                onClick = {
                    // logic
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .widthIn(max = 250.dp)
                    .align(Alignment.CenterHorizontally)
            )

            SmallButton(
                text = stringResource(R.string.terms_of_service),
                onClick = {
                    // logic
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .widthIn(max = 250.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}
