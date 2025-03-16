package com.example.quotekaapplication.ui.composables.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quotekaapplication.R

@Composable
fun OnBoardingButtons(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        //  "Get Started"
        OnBoardingButton(
            text = stringResource(R.string.get_started),
            onClick = { navController.navigate("register") },
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onSecondary
        )
        //"Login"
        OnBoardingButton(
            text = stringResource(R.string.login),
            onClick = { navController.navigate("login") },
            backgroundColor = MaterialTheme.colorScheme.surface,
            textColor = MaterialTheme.colorScheme.primary
        )
    }
}
