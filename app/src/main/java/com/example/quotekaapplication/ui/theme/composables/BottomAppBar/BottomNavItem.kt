package com.example.quotekaapplication.ui.theme.composables.BottomAppBar

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavItem(
    navController: NavController,
    item: BottomNavItemData
) {
    // Get the current screen
    val navBackStackEntry = navController.currentBackStackEntryAsState()

    // Check if the current route matches the item's route to determine if it's active
    val isActive = navBackStackEntry.value?.destination?.route == item.route

    val iconTint = if (isActive) Color.Blue else Color.White // Active - Blue, Inactive - White

    IconButton(
        onClick = {
            if (navBackStackEntry.value?.destination?.route != item.route) { // Check in case not to go the same route
                navController.navigate(item.route) {
                    // Optionally use a popUpTo to clear back stack when needed
                    // popUpTo(navController.graph.startDestinationId) { inclusive = true }
                }
            }
        }
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.contentDescription,
            tint = iconTint // Apply the color based on the active state
        )
    }
}
