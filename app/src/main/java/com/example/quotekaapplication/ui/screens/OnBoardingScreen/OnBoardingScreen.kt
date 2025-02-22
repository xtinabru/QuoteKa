package com.example.quotekaapplication.ui.screens.OnBoardingScreen

import OnBoardingDots
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quotekaapplication.ui.composables.onboarding.OnBoardingButtons
import com.example.quotekaapplication.ui.viewmodels.OnBoardingViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun OnBoardingScreen(navController: NavController, viewModel: OnBoardingViewModel) {

    val pagerState = rememberPagerState(pageCount = { viewModel.onBoardingData.size })
    var currentPage by remember { mutableStateOf(0) } // 1st page

    LaunchedEffect(pagerState) { // function in JC which helps with async
        // when the pager state changes, it creates a flow to renew the page
        snapshotFlow { pagerState.currentPage }.collectLatest { page ->
            currentPage = page
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()

            .padding(top = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),

            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // make it beautiful
            ) {
                OnBoardingPager(pagerState, viewModel.onBoardingData)
            }
            OnBoardingDots(currentPage = currentPage, pageCount = viewModel.onBoardingData.size)

            Spacer(modifier = Modifier.height(24.dp))

            OnBoardingButtons(navController)
            Spacer(modifier = Modifier.height(44.dp))
        }
    }
}
