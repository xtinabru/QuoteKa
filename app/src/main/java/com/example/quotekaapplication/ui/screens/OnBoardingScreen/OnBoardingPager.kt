package com.example.quotekaapplication.ui.screens.OnBoardingScreen

import OnBoardingSlide
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.quotekaapplication.ui.models.OnBoardingData

@Composable
fun OnBoardingPager(
    pagerState: androidx.compose.foundation.pager.PagerState,
    onBoardingData: List<OnBoardingData>
) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        val item = onBoardingData[page]
        OnBoardingSlide(item)
    }
}
