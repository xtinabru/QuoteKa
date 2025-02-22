package com.example.quotekaapplication.ui.composables.onboarding

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun OnBoardingButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color,
    textColor: Color,

    shadowElevation: Dp = 8.dp

) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(30),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .shadow(shadowElevation, shape = RoundedCornerShape(30)), // Тень
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        )
    ) {
        Text(text, color = textColor)
    }
}
