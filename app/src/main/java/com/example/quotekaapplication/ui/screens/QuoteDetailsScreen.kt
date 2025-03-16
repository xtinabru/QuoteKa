package com.example.quotekaapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quotekaapplication.R
import com.example.quotekaapplication.ui.composables.DifferentElements.BackgroundImage
import com.example.quotekaapplication.ui.composables.DifferentElements.SmallButton


@Composable
fun QuoteInfo(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        BackgroundImage()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.about_app),
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 24.sp),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.this_app_shows_you_new_quotes_everyday),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))

            //
            SmallButton(
                text = stringResource(R.string.visit_our_website),
                onClick = {
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .widthIn(max = 250.dp)
                    .align(Alignment.CenterHorizontally)
            )

            SmallButton(
                text = stringResource(R.string.back),
                onClick = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                        launchSingleTop = true
                    }
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .widthIn(max = 250.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}
