package com.example.quotekaapplication.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun QuoteInfo(navController: NavController,paddingValues: PaddingValues) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Quote Detail", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(20.dp))

        // Full quote text
        Text("Full quote text goes here.", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(20.dp))

        // Author and additional info
        Text("- Author", style = MaterialTheme.typography.bodyMedium)
        Text("Added on: 01/01/2025", style = MaterialTheme.typography.bodySmall)

        Spacer(modifier = Modifier.height(20.dp))

        // Button to navigate back to HomeScreen
        Button(onClick = {
            navController.navigate("home") {
                popUpTo("home") { inclusive = true } // delete "home" and recreate it
                launchSingleTop = true // doesn't duplicate
            }
        }) {
            Text("Back")
        }

        Button(onClick = { navController.popBackStack() }) {
            Text("Share")
        }
        Button(onClick = { navController.popBackStack() }) {
            Text("Add to favourites")
        }
    }
}
