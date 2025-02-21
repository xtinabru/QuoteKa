package com.example.quotekaapplication.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quotekaapplication.R
import com.example.quotekaapplication.ui.theme.composables.OnBoardingData
import com.example.quotekaapplication.ui.theme.composables.OnBoardingSlide

@Composable
fun OnBoardingScreen(navController: NavController) {
    val pagerState = rememberPagerState(pageCount = { 3 })

    // Данные для слайдов
    val onBoardingData = listOf(
        OnBoardingData("Welcome to QuoteKa", "Explore the best quotes", R.drawable.image1),
        OnBoardingData("Find Your Inspiration", "Discover new motivational quotes", R.drawable.image2),
        OnBoardingData("Share With Friends", "Share your favorite quotes with others", R.drawable.image3),

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        // Slides
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) { page ->
            val item = onBoardingData[page]
            OnBoardingSlide(item)
        }

        // DOTS
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(CenterHorizontally)
                .padding(top = 18.dp, bottom = 18.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.Magenta else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )
            }
        }

        // Buttons Get Started и Login
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    navController.navigate("register") // navigate to home page/screen
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Get Started")
            }

            Spacer(modifier = Modifier.width(16.dp))

            TextButton(
                onClick = {
                    navController.navigate("login") // navigate to login
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Login", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}
