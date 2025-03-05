package com.example.quotekaapplication.ui.composables.BottomAppBar

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quotekaapplication.ui.viewmodels.BottomBarViewModel

@Composable
fun BottomNavItem(
    navController: NavController,
    item: BottomNavItemData
) {
    // get ViewModel inside Composable
    val viewModel: BottomBarViewModel = viewModel()

    // get the curr route ViewModel
    val currentRoute = viewModel.currentRoute
    val isActive = currentRoute == item.route

    val iconTint = if (isActive) Color.Blue else Color.White

    IconButton(
        onClick = {
            // firstly - send the route to ViewModel , then navigation
            viewModel.onNavItemClicked(navController, item.route)
        }
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.contentDescription,
            tint = iconTint
        )
    }
}
