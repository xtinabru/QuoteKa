package com.example.quotekaapplication.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quotekaapplication.ui.theme.themes.QuotekaApplicationTheme

@Composable
fun InfoScreen(onBack: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Info Screen")

        Text(text = "This is a sample app showing quotes.")

        Button(onClick = onBack) {
            Text(text = "Go Back")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun InfoScreenPreview() {
    QuotekaApplicationTheme {
        InfoScreen(onBack = {})
    }
}