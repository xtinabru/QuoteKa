package com.example.quotekaapplication.ui.composables.DifferentElements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.quotekaapplication.R

@Composable
fun LoadingOrErrorState(isLoading: Boolean, errorMessage: String?) {
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            isLoading -> {
                Text(
                    text = stringResource(R.string.loading),
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            errorMessage != null -> {
                Text(
                    text = errorMessage,
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
