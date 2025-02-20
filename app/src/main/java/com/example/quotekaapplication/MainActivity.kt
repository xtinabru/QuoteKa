package com.example.quotekaapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.quotekaapplication.ui.theme.screens.HomeScreen
import com.example.quotekaapplication.ui.theme.themes.QuotekaApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuotekaApplicationTheme {
                // What we see
                Scaffold(
                    topBar = { TopAppBar(title = { Text("Quote of the day") }) },
                    bottomBar = { BottomAppBar { /* btns */ } },
                    content = { paddingValues ->
                        HomeScreen(modifier = Modifier.padding(paddingValues))
                    }
                )
            }
        }
    }
}
