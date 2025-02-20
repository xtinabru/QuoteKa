package com.example.quotekaapplication

import ScaffoldApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.rememberNavController

import com.example.quotekaapplication.ui.theme.themes.QuotekaApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuotekaApplicationTheme {
                val navController = rememberNavController()
                ScaffoldApp()
            }
        }
    }
}
