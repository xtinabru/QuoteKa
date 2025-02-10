package com.example.quotekaapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Main screen with the header")

        // Hardcoded list of quotes
        Text(text = "\"Do not worry if you have built your castles in the air\" — Henry David Thoreau")

    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    MainScreen()
}

