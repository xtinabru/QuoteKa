package com.example.quotekaapplication.ui.composables.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun OnBoardingButtons(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { navController.navigate("register") },
            modifier = Modifier.weight(1f)
        ) {
            Text("Get Started")
        }

        Spacer(modifier = Modifier.width(16.dp))

        TextButton(
            onClick = { navController.navigate("login") },
            modifier = Modifier.weight(1f)
        ) {
            Text("Login", color = MaterialTheme.colorScheme.primary)
        }
    }
}
