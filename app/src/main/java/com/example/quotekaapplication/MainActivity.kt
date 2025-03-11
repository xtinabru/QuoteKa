package com.example.quotekaapplication

import ScaffoldApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.quotekaapplication.ui.theme.QuotekaApplicationTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuotekaApplicationTheme {
                ScaffoldApp()
            }
        }
    }
}
