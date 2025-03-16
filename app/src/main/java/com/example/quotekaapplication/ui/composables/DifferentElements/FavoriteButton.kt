package com.example.quotekaapplication.ui.composables.DifferentElements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quotekaapplication.ui.theme.Purple

@Composable
fun FavoriteButton(isFavorite: Boolean, onClick: () -> Unit) {
    // In this example, isFavorite is passed as a prop,
    // but the favorite state is managed in the parent screen - HomeScreen

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(50.dp)
                .background(Color.White, shape = CircleShape)
                .border(2.dp, if (isFavorite) Color.Red else Purple, shape = CircleShape)
        ) {
            IconButton(
                onClick = {
                    onClick()
                },
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Add to Favorites",
                    tint = if (isFavorite) Color.Red else Purple,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}
