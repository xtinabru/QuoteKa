package com.example.quotekaapplication.ui.theme.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
@OptIn (ExperimentalMaterial3Api::class)
fun CustomTopAppBar() {
    TopAppBar(
        title = { Text("Quote of the day") }
    )
}
