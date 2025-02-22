package com.example.quotekaapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Purple,
    secondary = Grey,
    background = BackgroundDark,
    onBackground = Color.White, // text on dark
    surface = Color.Yellow,              // grey for surface
    onSurface = BlackFonts, // white for surface
    onSecondary = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = Purple,
    secondary = Grey,
    background = BackgroundLight,
    onBackground = Color.Black,  // text on fair
    surface = Color.Yellow,             // grey for surface
    onSurface = BlackFonts,    // black for surface
    onSecondary = Color.White,
)

@Composable
fun QuotekaApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,

        content = content
    )
}
