package com.example.quotekaapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.quotekaapplication.screens.MainScreen
import com.example.quotekaapplication.ui.theme.themes.QuotekaApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuotekaApplicationTheme {
                MainScreen()


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    QuotekaApplicationTheme {
        MainScreen()


    }
}