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
    // В этом примере isFavorite передается как пропс, но мы можем управлять этим состоянием в родительском экране.
    // Поэтому, для этого примера предполагаем, что состояние "избранное" контролируется выше (например, в HomeScreen).

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
                .border(2.dp, if (isFavorite) Color.Red else Purple, shape = CircleShape) // Меняем цвет рамки
        ) {
            IconButton(
                onClick = {
                    onClick() // Вызываем onClick, чтобы обработать добавление/удаление из избранного
                },
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Add to Favorites",
                    tint = if (isFavorite) Color.Red else Purple, // Цвет иконки
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}
