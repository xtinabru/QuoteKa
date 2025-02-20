package com.example.quotekaapplication.ui.theme.screens

import TopAppBar
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
fun MainScreen(navController: NavController, paddingValues: PaddingValues) {
    Column(modifier = Modifier
        .padding(16.dp)
        .padding(top = paddingValues.calculateTopPadding())
    )
    {


        Text("Quote of the day", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(20.dp))

        // Placeholder for the quote
        Text("Here we will see the quote", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(20.dp))

        // Author placeholder
        Text("Here's the Author", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(20.dp))

        // Button to navigate to QuoteInfo screen
        Button(onClick = { navController.navigate("info") }) {
            Text("More details")
        }
    }
}
