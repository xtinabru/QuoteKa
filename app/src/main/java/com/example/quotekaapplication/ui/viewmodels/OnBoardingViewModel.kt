package com.example.quotekaapplication.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.quotekaapplication.R
import com.example.quotekaapplication.ui.models.OnBoardingData

class OnBoardingViewModel : ViewModel() {

    var pagerState by mutableStateOf(0) // current page
        private set

    // Data for each onboarding slide
    val onBoardingData = listOf(
        OnBoardingData("Welcome to QuoteKa", "Explore the best quotes", R.drawable.image1),
        OnBoardingData("Find Your Inspiration", "Discover new motivational quotes", R.drawable.image2),
        OnBoardingData("Share With Friends", "Share your favorite quotes with others", R.drawable.image3)
    )

    // Method to update the current page index
    fun updatePage(page: Int) {
        pagerState = page
    }
}
