package com.example.quotekaapplication.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quotekaapplication.ui.viewmodels.QuoteViewModel
import androidx.navigation.NavController
import com.example.quotekaapplication.R
import com.example.quotekaapplication.ui.theme.BlackFonts
import com.example.quotekaapplication.ui.theme.Purple

@Composable
fun HomeScreen(navController: NavController, paddingValues: PaddingValues) {
    val quoteViewModel: QuoteViewModel = viewModel()
    val quote = quoteViewModel.quoteOfTheDay.value
    val errorMessage = quoteViewModel.errorMessage.value

    LaunchedEffect(Unit) {
        quoteViewModel.getQuoteOfTheDay()
    }

    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = 0.4f)
        )

        Column(
            modifier = Modifier
                .padding(20.dp)
                .padding(top = paddingValues.calculateTopPadding())
        ) {
            Text(
                text = "Quote of the day:",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 30.sp
                ),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = quote?.quote ?: "Loading...",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 26.sp,
                    lineHeight = 36.sp,
                ),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),

                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "By: ${quote?.author}",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 30.sp,
                    lineHeight = 36.sp,

                ),
                color = MaterialTheme.colorScheme.onBackground
            )

            Log.i("HomeScreen", "Quote of the day: ${quote?.quote}")

            errorMessage?.let {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

